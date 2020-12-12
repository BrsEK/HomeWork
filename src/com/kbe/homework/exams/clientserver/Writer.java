package com.kbe.homework.exams.clientserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

public class Writer implements Runnable, CheckIf {

    private Connection connection;
    private ConcurrentHashMap<Integer, Connection> connections;
    private SynchronousQueue<SimpleMessage> queueOfMessages;


    public Writer(Connection connection, SynchronousQueue<SimpleMessage> queueOfMessages,
                  ConcurrentHashMap<Integer, Connection> connections) {
        this.connection = connection;
        this.queueOfMessages = queueOfMessages;
        this.connections = connections;

    }


    @Override
    public void run() {
        while (!Thread.currentThread().interrupted()) {
            try {
                // блокируемся пока в очереди не появится сообщение
                SimpleMessage message = queueOfMessages.take();

                // Проверяем на слово Exit и на
                // факт одинаковых соединений, чтобы не отправлять сообщение
                // клиенту отправившего его
                if (closeIfExit(message)){
                    queueOfMessages.remove(message);
                    connections.remove(connection.getId());
                    System.out.println("------------------------------------------" +
                            "\n" + "Произошло отключение: " + connection +
                            "\n" + "Всего соединений: " + connections.size() +
                            "\n");
                }else {
                    for (Connection fromMap : connections.values()) {
                        if (!connection.equals(fromMap)) {
                            ObjectOutputStream out = fromMap.getOutputStream();
                            out.writeObject(message);
                            out.flush();
                        }
                    }
                }
            }catch (InterruptedException e){
              Thread.currentThread().interrupt();
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean closeIfExit(SimpleMessage message) {
        if (message.getText().equalsIgnoreCase(CheckIf.COMMAND_SHUTDOWN)){
            Thread.currentThread().interrupt();
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}

