package com.kbe.homework.homework26;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Waiter implements  Runnable {
    private String name;
    private ArrayBlockingQueue<Order> ordersFrom;
    private ArrayBlockingQueue<Order>ordersTo;


    public Waiter(String name, ArrayBlockingQueue<Order> ordersFrom, ArrayBlockingQueue<Order> ordersTo) {
        this.ordersFrom = Objects.requireNonNull(ordersFrom);
        this.ordersTo = Objects.requireNonNull(ordersTo);
        this.name = Objects.requireNonNull(name);
    }


    @Override
    public void run() {
            Order orderFrom = null;
            try {
                orderFrom = ordersFrom.take();
                System.out.println("Официант " + name + " отдает заказ повару");
                ordersTo.put(orderFrom);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
