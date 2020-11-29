package com.kbe.homework.homework26;

public class Order {
    private int numberOfOrder;

    public Order(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        if (numberOfOrder == 0)
            throw new IllegalArgumentException("Order is not be 0");
        this.numberOfOrder = numberOfOrder;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

}
