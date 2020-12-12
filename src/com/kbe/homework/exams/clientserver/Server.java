package com.kbe.homework.exams.clientserver;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.*;

public class Server {

    private final static String SERVER_GREETING = "Server start";
    private ConcurrentHashMap<Integer, Connection> connections;
    private int countConnections;
    SynchronousQueue<SimpleMessage> queueMessages;
    

    public Server() {
        connections =  new ConcurrentHashMap<>();
    }


    public void start() throws IOException {

        try(ServerSocket serverSocket = new ServerSocket(8090)){
            System.out.println(SERVER_GREETING);


            while (true){
                // ждем подключения
                Socket socket = serverSocket.accept();

                Connection connection = new Connection(socket);

                // как только подключились, записываем  в Map подключение
                connections.put(++countConnections, connection);

                // Уведомляем о подключении
                printAboutConnection(connection);

                // Создаем очередь для сообщений, для каждого клиента будет своя очередь
                queueMessages = new SynchronousQueue<>();

                // Создаем потоки. Один читает второй пишет.
                // Поток Reader читает и блокируется, пока не придет новое сообщение
                // Поток Writer также блокируется, пока Reader не положит сообщение в очередь
                // при этом основной поток идет дальше на accept() для ожидания новых подключений
                new Thread(new Writer(connections.get(countConnections), queueMessages, connections)).start();
                new Thread(new Reader(connections.get(countConnections), queueMessages, connections)).start();
            }
        }
    }

    private void printAboutConnection(Connection connection){
        System.out.println("------------------------------------------" +
                "\n" + "Произошло подключение: " + connection +
                "\n" + "Всего соединений: " + connections.size() +
                "\n");
    }


    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
