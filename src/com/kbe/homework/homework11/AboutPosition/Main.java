package com.kbe.homework.homework11.AboutPosition;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fullName;
        String position = null;
        int salary;
        WorkerBase  workerBase = new WorkerBase(3);

        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите свое имя и фамилию: ");
            fullName = scanner.nextLine();
            System.out.println("ведите первые буквы желаемой должности:");
            position = scanner.nextLine();
            System.out.println("ведите зарплату:");
            salary = scanner.nextInt();
            User user = UsersFactory.createUser(fullName, salary);
            findPositionForUser(position, user);
            workerBase.addUserInBase(user,user.getPosition());
        }

        System.out.println(Arrays.toString(workerBase.getUsersPythonDev()));
        System.out.println(Arrays.toString(workerBase.getUsersJavaDev()));
        System.out.println(Arrays.toString(workerBase.getUsersCDev()));


        }

    private static void findPositionForUser (String position, User user) {
        if (Position.JAVA_DEVELOPER.name().startsWith(position.toUpperCase())) ;
            user.setPosition(Position.JAVA_DEVELOPER);
        if (Position.PYTHON_DEVELOPER.name().contains(position.toUpperCase()))
            user.setPosition(Position.PYTHON_DEVELOPER);
        if (Position.C_DEVELOPER.name().contains(position.toUpperCase()))
            user.setPosition(Position.C_DEVELOPER);
    }
}
