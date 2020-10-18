package com.kbe.homework.exams.fitnes;

import java.time.LocalTime;
import java.util.Objects;

public class FitnesClub {
    Zone gym = new Zone(InfoMessage.GYM);
    Zone pool = new Zone(InfoMessage.POOL);
    Zone group = new Zone(InfoMessage.GROUP);


    public void addAbonement(Abonement abonement) {
        abonement.fixCurrentDate();
        if (isNoValidTime(abonement)) {
            System.out.println(abonement.getClient().getName() + " " + InfoMessage.NO_TIME);
            return;
        }
        if (isNoValidZone(abonement)) {
            System.out.println(abonement.getClient().getName() + " " + InfoMessage.NO_VALID_ACCESS);
            return;
        }
        if (abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.GYM)) {
            detectClient(abonement, gym);
            gym.addAbonement(abonement);
        } else if (abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.GROUP)) {
            detectClient(abonement, group);
            group.addAbonement(abonement);
        } else if (abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.POOL)) {
            detectClient(abonement, pool);
            pool.addAbonement(abonement);
        }
    }


    private boolean isNoValidTime(Abonement abonement) {
        if (abonement.getDateEnd().getHour() < abonement.getCurrentDate().getHour() ||
                abonement.getDateStart().getHour() > abonement.getCurrentDate().getHour()) {
            return true;
        }
        return false;
    }


    private boolean isNoValidZone(Abonement abonement) {
        if (abonement.getAccess() == Access.EVENING && abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.POOL)) {
            return true;
        } else if (abonement.getAccess() == Access.ONE_TIME && abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.GROUP)) {
            return true;
        }
        return false;
    }

    public void closeFitnessClub() {
        group.closeZone();
        gym.closeZone();
        pool.closeZone();
        System.out.println(InfoMessage.CLOSE);
    }


    public Abonement createAbonement(Client client, LocalTime startTime, LocalTime endTime, Access access) {
        Abonement abonement = new Abonement(client, startTime, endTime, access);
        return abonement;
    }


    public void printInfoAboutClients() {
        printClientsZone(gym);
        printClientsZone(pool);
        printClientsZone(group);
    }

    public void detectClient(Abonement abonement, Zone zone) {
        System.out.println(InfoMessage.FIX_CLIENT);
        System.out.println("   Фамилия: " + abonement.getClient().getSurName()
                + "\n   Имя: " + abonement.getClient().getName()
                + "\n   Дата посещения фитнесс зала: " + abonement.getCurrentDate()
                + "\n   Зона: " + zone.getNameOfZone());
    }


    private void printClientsZone(Zone zone) {
        for (int i = 0; i < zone.getAbonements().length; i++) {
            if (Objects.nonNull(zone.getAbonements()[i])) {
                System.out.println("Посетитель фитнес клуба------------------");
                System.out.println(zone.getAbonements()[i].toString());
                System.out.println();
            }
        }
    }
}
