package com.kbr.homework.homework8;

public class Director extends Human implements AbleStudy{
    private int qualification;


    public Director(String name, int age) {
        super(name, age);
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public void announceStartOfLessons(){
        System.out.println("Дорогие ученики объявляю начало занятий!");
    }

    public void announceEndOfLessons(){
        System.out.println("Дорогие ученики объявляю окончание занятий!");
    }

    @Override
    public void study() {
        qualification++;
    }

    @Override
    public String toString() {
        return "Director{" +
                "qualification=" + qualification +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
