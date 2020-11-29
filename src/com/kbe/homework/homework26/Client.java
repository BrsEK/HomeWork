package com.kbe.homework.homework26;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Client implements Runnable {
    private ArrayBlockingQueue<Order> fromOrders;
    private ArrayBlockingQueue<Order> toOrders;
    private int numberOfOrder;
    private String name;


    public Client(String name, ArrayBlockingQueue<Order> fromOrders, ArrayBlockingQueue<Order> toOrders, int numberOfOrder) {
        this.fromOrders = Objects.requireNonNull(fromOrders);
        this.toOrders = Objects.requireNonNull(toOrders);
        this.name = Objects.requireNonNull(name);
        this.numberOfOrder = numberOfOrder;
    }


    @Override
    public void run() {
        Order order = new Order(numberOfOrder);
            try {
                System.out.println("Клиент " + name + " делает заказ номер " + order.getNumberOfOrder());
                toOrders.put(order);
                Order orderFrom = fromOrders.take();
                System.out.println("Клиент " + name + " получил заказ номер " + order.getNumberOfOrder());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
    }
}
