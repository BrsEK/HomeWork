package com.kbe.homework.exams.clientserver;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;


/**
 * class Client
 *
 * @author Boris Krinitsky
 * @version 1.1
 */
public class Client {
    private String name;
    private BufferedReader reader;
    private Connection connection;
    private Properties connectionProperties;



    public Client(String name, Properties connectionProperties) {
        Objects.requireNonNull(connectionProperties, "connectionProperties is not be null");
        this.connectionProperties = connectionProperties;
        setName(name);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }



    private void setName(String name) {
        Objects.requireNonNull(name, "name is not be null");
        if (name.length() > 10)
            throw new IllegalArgumentException("name is not be > 10 characters");
        this.name = name.trim();
    }

    /**
     * Подключаемся к серверу с помощью сокета
     */
    private void connectToServer() {
        try(FileInputStream fileInputStream = new FileInputStream("source/networkSettings.properties")){
            connectionProperties.load(fileInputStream);
            Socket socket = new Socket(
                    connectionProperties.getProperty("ip"),
                    Integer.parseInt(connectionProperties.getProperty("port")));
            connection = new Connection(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Внутри создается поток который читает с командной строки
     * и отправляет эти данные на сервер, поток зациклен
     * поэтому снова можно вводить данные при каждой отправке.
     * Выходим из потока и рвем соединение если введено слово /exit
     */
    private void readMessageFromCommandLineAndSend() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SimpleMessage message = new SimpleMessage(reader.readLine(), name);
                    ObjectOutputStream out = connection.getOutputStream();
                    out.writeObject(message);
                    out.flush();
                    closeIfExit(message,connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void closeIfExit(SimpleMessage message, Connection connection) throws Exception {
        if (message.getText().equalsIgnoreCase(CheckIf.COMMAND_SHUTDOWN)){
            connection.close();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Внутри создается поток который читает данные с сервера
     * и выводит их в командной строке
     */
    void readAndPrintMessageFromServer() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println((SimpleMessage) connection.getInputStream().readObject());
                } catch (IOException | ClassNotFoundException e) {
                    //e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }



    private void start() throws InterruptedException {
        connectToServer();
        readMessageFromCommandLineAndSend();
        readAndPrintMessageFromServer();
        //Thread.currentThread().join();
    }


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите свое имя: ");
            String name = reader.readLine();
            Client client = new Client(name, new Properties());
            System.out.println("Можете писать сообщение");
            client.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
