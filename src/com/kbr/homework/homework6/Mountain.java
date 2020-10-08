package com.kbr.homework.homework6;

public class Mountain {
    private String name;
    private String land;
    private int mountainHeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 4)
            throw new IllegalArgumentException("Имя не должно быть короче 4 символов");
        this.name = name;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        if (land.length() < 4)
            throw new IllegalArgumentException("Название страны не должна быть короче 4 символов");
        this.land = land;
    }

    public int getMountainHeight() {
        return mountainHeight;
    }

    public void setMountainHeight(int mountainHeight) {
        if (mountainHeight < 100)
            throw new IllegalArgumentException("Высота горы не должна быть меньше 100");
        this.mountainHeight = mountainHeight;
    }

    public Mountain(String name, String land, int mountainHeight) {
        this.name = name;
        this.land = land;
        this.mountainHeight = mountainHeight;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", land='" + land + '\'' +
                ", mountainHeight=" + mountainHeight +
                '}';
    }
}
