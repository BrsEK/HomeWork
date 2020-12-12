package com.kbe.homework.exams.clientserver;


import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;


public class Reader implements Runnable, CheckIf {

    private Connection connection;
    private SynchronousQueue<SimpleMessage> queue;
    private ConcurrentHashMap<Integer, Connection> connections;


    public Reader(Connection connection, SynchronousQueue<SimpleMessage> queue, ConcurrentHashMap<Integer, Connection> connections) {
        this.connection = connection;
        this.queue = queue;
        this.connections = connections;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // Блокируемся пока не придет сообщение
                SimpleMessage message = (SimpleMessage) connection.getInputStream().readObject();
                // проверяем сообщение на выход
                closeIfExit(message);
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean closeIfExit(SimpleMessage message) {
        if (message.getText().equalsIgnoreCase(CheckIf.COMMAND_SHUTDOWN)) {
            try {
                Thread.currentThread().interrupt();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

