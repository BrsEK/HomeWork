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
        System.out.println("Quantity of message for: \n"
        + MessagePriority.LOW.toString() + " = " + quantityOfPriorityLow + "\n"
        + MessagePriority.MEDIUM.toString() + " = " + quantityOfPriorityMedium + "\n"
        + MessagePriority.HIGH.toString() + " = " + quantityOfPriorityHigh + "\n"
        + MessagePriority.URGENT.toString() + " = " + quantityOfPriorityUrgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        ArrayList<Integer> codes = new ArrayList<>();
        for (Message message : messageList) {
            codes.add(message.getCode());
        }
        int[] countMessage = new int[codes.size()];


        for (int i = 0; i < messageList.size(); i++) {
            int count = 1;
            for (int j = 0; j < codes.size(); j++) {
                if (messageList.get(i).getCode() == codes.get(j))
                    countMessage[i] = count++;
            }
        }
        System.out.print(codes + "   <------- Codes");
        System.out.println();
        System.out.println(Arrays.toString(countMessage) + "   <--------- messages");
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> uniqueMessages = new HashSet<>(messageList);
        System.out.print("Unique messages: ");
        System.out.println(uniqueMessages.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> uniqueSet = new LinkedHashSet<>(messageList);
        List<Message> copyList = new ArrayList<>(uniqueSet);
        return copyList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
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
        System.out.println("============= Работа метода countEachPriority =============");
        countEachPriority(messages);
        System.out.println();
        System.out.println("============= Работа метода countEachCode =============");
        countEachCode(messages);
        System.out.println();
        System.out.println("============= Работа метода uniqueMessageCount =============");
        uniqueMessageCount(messages);
        System.out.println();
        System.out.println("============= Работа метода uniqueMessagesInOriginalOrder =============");
        System.out.println(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        System.out.println();
        System.out.println("============= Работа метода removeEach =============");
        removeEach(messages, MessagePriority.HIGH);
        System.out.println();
        System.out.println("============= Работа метода removeOther =============");
        removeOther(messages, MessagePriority.MEDIUM);
        System.out.println();
    }
}