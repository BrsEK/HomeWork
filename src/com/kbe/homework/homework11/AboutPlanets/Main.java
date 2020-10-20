package com.kbe.homework.homework11.AboutPlanets;

public class Main {
    public static void main(String[] args) {

        Planets[] planets = Planets.values();
        for (Planets planet : planets) {
            System.out.println(
                    "---------" + planet.name() + "----------" + "\n"
                            + "Масса: " + planet.getMass() + "\n"
                            + "Радиус: " + planet.getRadius() + "\n"
                            + "Радиус орбиты: " + planet.getRadiusOfOrbit() + "\n"
            );
        }
    }
}
