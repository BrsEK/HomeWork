package com.kbe.homework.exams.fitnes;

import java.util.Arrays;
import java.util.Objects;

public class Zone {

    final int maxAbonements = 20;
    private String NameOfZone;
    private Abonement[] abonements;


    public Zone(String nameOfZone) {
        setNameOfZone(nameOfZone);
        abonements = new Abonement[maxAbonements];
    }


    public Abonement[] getAbonements() {
        return abonements;
    }


    public String getNameOfZone() {
        return NameOfZone;
    }


    public void setNameOfZone(String nameOfZone) {
        if (Objects.isNull(nameOfZone))
            throw new IllegalArgumentException(InfoMessage.OBJECT_IS_NULL);
        this.NameOfZone = nameOfZone.trim();
    }


    public void addAbonement(Abonement abonement){
        for (int i = 0; i < abonements.length; i++){
            if (Objects.isNull(abonements[i])){
                abonements[i] = abonement;
                return;
            }
        }
        System.out.println(abonement.getClient().getName() + " " + getNameOfZone() + " " + InfoMessage.FOOL_ZONE);
    }


    public void closeZone(){
        Arrays.fill(abonements, null);
    }
}
