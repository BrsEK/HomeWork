package com.kbe.homework.homework15;



import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int low = 0;
        int medium = 0;

        int[] counts = new int[MessagePriority.values().length];
        for (Message message : messageList) {
            counts[message.getPriority().ordinal()]++;
        }
        System.out.println("Quantity of message for: \n"
                + MessagePriority.LOW.toString() + " = " + counts[MessagePriority.LOW.ordinal()] + "\n"
                + MessagePriority.MEDIUM.toString() + " = " + counts[MessagePriority.MEDIUM.ordinal()] + "\n"
                + MessagePriority.HIGH.toString() + " = " + counts[MessagePriority.HIGH.ordinal()] + "\n"
                + MessagePriority.URGENT.toString() + " = " + counts[MessagePriority.URGENT.ordinal()]);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        HashMap<Integer, Integer> messagesAndCodes = new HashMap<>();

        for (Message message : messageList ) {
            messagesAndCodes.put(message.getCode(), messagesAndCodes.getOrDefault(message.getCode(), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : messagesAndCodes.entrySet()) {
            System.out.print("Code -----> " + entry.getKey() + " - ");
            System.out.println(entry.getValue() + " <----- Messages");
        }
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        System.out.print("Unique messages: ");
        System.out.println(new HashSet<Message>(messageList).size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> uniqueSet = new LinkedHashSet<>(messageList);
        return new ArrayList<>(uniqueSet);
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("До удаления:");
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority().equals(priority))
                iterator.remove();
        }
        System.out.println("После удаления: ");
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("До удаления:");
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()) {
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