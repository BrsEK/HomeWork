package com.kbe.homework.homework15;

import javafx.scene.layout.Priority;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int quantityOfPriorityLow = 0;
        int quantityOfPriorityMedium = 0;
        int quantityOfPriorityHigh = 0;
        int quantityOfPriorityUrgent = 0;
        for (Message message : messageList) {
            switch (message.getPriority()){
                case LOW:
                    quantityOfPriorityLow++;
                    break;
                case HIGH:
                    quantityOfPriorityHigh++;
                    break;
                case MEDIUM:
                    quantityOfPriorityMedium++;
                    break;
                case URGENT:
                    quantityOfPriorityUrgent++;
                    break;
            }
        }
        System.out.println();
        System.out.println("Quantity of message for: \n"
        + MessagePriority.LOW.toString() + " = " + quantityOfPriorityLow + "\n"
        + MessagePriority.MEDIUM.toString() + " = " + quantityOfPriorityMedium + "\n"
        + MessagePriority.HIGH.toString() + " = " + quantityOfPriorityHigh + "\n"
        + MessagePriority.URGENT.toString() + " = " + quantityOfPriorityUrgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        System.out.println();
        Comparator<Message> comparatorMessage = new MessageGenerator.PriorityComparator().thenComparing(new MessageGenerator.CodeComparator());
        Set<Message> uniqueMessages = new TreeSet<>(comparatorMessage);
        for (Message message : messageList) {
            uniqueMessages.add(message);
        }
        System.out.print("Unique messages: ");
        System.out.println(uniqueMessages.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println();
        System.out.println("До удаления:");
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority().equals(priority))
                iterator.remove();
        }
        System.out.println("После удаления: ");
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println();
        System.out.println("До удаления:");
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (!(iterator.next().getPriority().equals(priority)))
                iterator.remove();
        }
        System.out.println("После удаления: ");
        System.out.println(messageList);
    }


    public static void main(String[] args) {
        ArrayList<Message> messages = new ArrayList<>(MessageGenerator.generate(20));
        System.out.println(messages);
        countEachPriority(messages);

        uniqueMessageCount(messages);
        removeEach(messages, MessagePriority.HIGH);
        //removeOther(messages, MessagePriority.HIGH);


    }
}