package com.kbe.homework.homework8;

public class Teacher extends Human implements AbleTeach {
    private String subjectTaught;


    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught.strip();
    }


    public Teacher(String name, int age, String subjectTaught) {
        super(name, age);
        setSubjectTaught(subjectTaught);
    }


    public void teach(AbleStudy apprentice) {
        apprentice.study();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subjectTaught='" + subjectTaught + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
