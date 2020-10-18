package com.kbe.homework.homework8;

public class SchoolBoy extends Human implements AbleStudy {

    private String subjectUnderStudy;
    private int knowledgeLevel;


    public String getSubjectUnderStudy() {
        return subjectUnderStudy;
    }

    public void setSubjectUnderStudy(String subjectUnderStudy) {
        this.subjectUnderStudy = subjectUnderStudy.strip();
    }



    public SchoolBoy(String name, int age, String subjectUnderStudy) {
        super(name, age);
        setSubjectUnderStudy(subjectUnderStudy);
    }


    @Override
    public void study() {
        knowledgeLevel++;
    }

    @Override
    public String toString() {
        return "SchoolBoy{" +
                "subjectUnderStudy='" + subjectUnderStudy + '\'' +
                ", knowledgeLevel=" + knowledgeLevel +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
