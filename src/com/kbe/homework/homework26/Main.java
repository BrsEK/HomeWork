package com.kbe.homework.homework26;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> orders1 = new ArrayBlockingQueue<>(10, true);
        ArrayBlockingQueue<Order> orders2 = new ArrayBlockingQueue<>(10, true);
        ArrayBlockingQueue<Order> orders3 = new ArrayBlockingQueue<>(10, true);


        new Thread(new Client("Алексей", orders1, orders3, 1)).start();
        new Thread(new Client("Иван", orders1, orders3, 2)).start();
        new Thread(new Client("Олег", orders1, orders3, 3)).start();


        new Thread(new Waiter("Илья", orders3, orders2)).start();
        new Thread(new Waiter("Владимир", orders3, orders2)).start();
        new Thread(new Waiter("Василий", orders3, orders2)).start();


        new Thread(new Cook("Дмитрий", orders2, orders1)).start();
        new Thread(new Cook("Денис", orders2, orders1)).start();
        new Thread(new Cook("Влад", orders2, orders1)).start();

    }
}
