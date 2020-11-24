package com.kbe.homework.homework25.task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 1000);
        Account account3 = new Account(3, 1000);

        System.out.println("Account id: " + account1.getId() + " до перевода: " + account1.getBalance());
        System.out.println("Account id: " + account2.getId() + " до перевода: " + account2.getBalance());
        System.out.println("Account id: " + account3.getId() + " до перевода: " + account3.getBalance());

        bank.transferMoney(account1,account2, 300);
        bank.transferMoney(account3,account1, 100);

        System.out.println("Account id: " + account1.getId() + " после перевода: " + account1.getBalance());
        System.out.println("Account id: " + account2.getId() + " после перевода: " + account2.getBalance());
        System.out.println("Account id: " + account3.getId() + " после перевода: " + account3.getBalance());
    }
}
