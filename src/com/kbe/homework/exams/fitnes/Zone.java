package com.kbe.homework.exams.fitnes;

import java.util.Arrays;
import java.util.Objects;

public class Zone {

    final int maxAbonements = 2;
    private String NameOfZone;
    private Abonement[] abonements;


    public Zone(String nameOfZone) {
        NameOfZone = nameOfZone;
        abonements = new Abonement[maxAbonements];
    }


    public Abonement[] getAbonements() {
        return abonements;
    }


    public String getNameOfZone() {
        return NameOfZone;
    }


    public void addAbonement(Abonement abonement){
        for (int i = 0; i < abonements.length; i++){
            if (Objects.isNull(abonements[i])){
                abonements[i] = abonement;
                return;
            }
        }
        System.out.println(getNameOfZone() + " " + InfoMesage.FOOL_ZONE);
    }


    public void closeZone(){
        Arrays.fill(abonements, null);
    }
}
