package com.kbe.homework.exams.fitnes;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class FitnesClub {
    //    Zone gym = new Zone(InfoMessage.GYM);
    //    Zone pool = new Zone(InfoMessage.POOL);
    //    Zone group = new Zone(InfoMessage.GROUP);
    private Zone[] zones = new Zone[]{
            new Zone(InfoMessage.GYM),
            new Zone(InfoMessage.POOL),
            new Zone(InfoMessage.GROUP
    )};


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
        if (isDoubleAdd(abonement))
            return;
        for (Zone zone : zones) {
            if (abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.GYM) && zone.getNameOfZone().equalsIgnoreCase(InfoMessage.GYM)) {
                detectClient(abonement, zone);
                zone.addAbonement(abonement);
            } else if (abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.GROUP) && zone.getNameOfZone().equalsIgnoreCase(InfoMessage.GROUP)) {
                detectClient(abonement, zone);
                zone.addAbonement(abonement);
            } else if (abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.POOL) && zone.getNameOfZone().equalsIgnoreCase(InfoMessage.POOL)) {
                detectClient(abonement, zone);
                zone.addAbonement(abonement);
            }
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
//        group.closeZone();
//        gym.closeZone();
//        pool.closeZone();
//        System.out.println(InfoMessage.CLOSE);
        for (Zone zone : zones) {
            zone.closeZone();
        }
    }


    public Abonement createAbonement(Client client, LocalTime startTime, LocalTime endTime, Access access) {
        Abonement abonement = new Abonement(client, startTime, endTime, access);
        return abonement;
    }


    public void printInfoAboutClients() {
        printClientsZone(zones[0]);
        printClientsZone(zones[1]);
        printClientsZone(zones[2]);
    }

    public void detectClient(Abonement abonement, Zone zone) {
        System.out.println(InfoMessage.FIX_CLIENT);
        System.out.println("   Фамилия: " + abonement.getClient().getSurName()
                + "\n   Имя: " + abonement.getClient().getName()
                + "\n   Дата посещения фитнесс зала: " + abonement.getCurrentDate()
                + "\n   Зона: " + zone.getNameOfZone());
    }

    private boolean isDoubleAdd(Abonement abonement){
        int countClients = 0;
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].getAbonements().length; j++) {
                if (abonement.equals(zones[i].getAbonements()[j])){
                    countClients++;
                }
            }
        }
        if (countClients > 0)
            return true;
        else return false;
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
