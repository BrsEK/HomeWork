package com.kbe.homework.exams.fitnes;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Abonement {
    private LocalTime dateStart;
    private LocalTime dateEnd;
    private LocalDateTime currentDate;
    private Client client;
    private Access access;


    public Abonement(Client client, LocalTime startTime, LocalTime endTime, Access access) {
        this.client = client;
        this.dateStart = startTime;
        this.dateEnd = endTime;
        this.access = access;
    }


    public Access getAccess() {
        return access;
    }


    public Client getClient() {
        return client;
    }


    public LocalTime getDateStart() {
        return dateStart;
    }


    public LocalTime getDateEnd() {
        return dateEnd;
    }


    public LocalDateTime getCurrentDate() {
        return currentDate;
    }


    public void setAccess(Access access) {
        this.access = access;
    }


    public void setTimePeriod(LocalTime timeStart, LocalTime timeEnd) {
        this.dateStart = timeStart;
        this.dateEnd = timeEnd;
    }


    public void fixCurrentDate() {
        this.currentDate = LocalDateTime.now(); //LocalDateTime.of(12, Month.APRIL, 2, 15, 0);
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "currentDate=" + currentDate +
                ", client=" + client +
                '}';
    }
}
