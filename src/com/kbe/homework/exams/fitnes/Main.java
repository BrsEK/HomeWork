package com.kbe.homework.exams.fitnes;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Client ivan = new Client("Иван","Иванов", InfoMessage.POOL);
        Client oleg = new Client("Олег","Сидоров", InfoMessage.GYM);
        Client alex = new Client("Александр","Петров", InfoMessage.GYM);

        FitnesClub fitnesClub = new FitnesClub();
        Abonement abonementOneTime = fitnesClub.createAbonement(ivan, LocalTime.of(8,0),LocalTime.of(22,0), Access.ONE_TIME);
        Abonement abonementEvening = fitnesClub.createAbonement(oleg, LocalTime.of(8,0),LocalTime.of(16,0), Access.EVENING);
        Abonement abonementFull = fitnesClub.createAbonement(alex, LocalTime.of(8,0),LocalTime.of(22,0), Access.FULL);


        fitnesClub.addAbonement(abonementOneTime);
        fitnesClub.addAbonement(abonementEvening);
        fitnesClub.addAbonement(abonementFull);

        fitnesClub.printInfoAboutClients();

    }
}
