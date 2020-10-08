package com.kbr.homework.homework6;

public class Climber {
    private String name;
    private String address;

    public Climber(String name, String address) {
        setName(name);
        setAddress(address);
    }


    public void setName(String name) {
        if (name.trim().length() < 3)
            throw new IllegalArgumentException("Имя не должно быть короче 3 символов");
        this.name = name;
    }


    public void setAddress(String address) {
        if (address.trim().length() < 5)
            throw new IllegalArgumentException("Адресс не должен быть меньше 5 символов");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
