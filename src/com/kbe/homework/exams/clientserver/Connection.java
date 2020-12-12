package com.kbe.homework.exams.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class Connection implements AutoCloseable {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private static int countConnections;
    private int id;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.id = id;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
        countConnections++;
        id = countConnections;
    }


    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }


    public int getId() {
        return id;
    }


    public Socket getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                '}';
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return id == that.id &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(outputStream, that.outputStream) &&
                Objects.equals(inputStream, that.inputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, outputStream, inputStream, id);
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
