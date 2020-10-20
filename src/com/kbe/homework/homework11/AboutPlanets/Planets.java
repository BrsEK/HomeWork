package com.kbe.homework.homework11.AboutPlanets;

public enum Planets {
    MERCURY(100, 200,300), VENUS(500,200,100), EARTH(489, 324, 323), MARS(857, 323, 434), JUPITER(324, 323, 324), SATURN(900, 500, 322), URANUS(343,432,433), PLUTO(333,444,555);
    private int mass;
    private int radius;
    private int radiusOfOrbit;

    Planets(int mass, int radius, int radiusOfOrbit) {
        this.mass = mass;
        this.radius = radius;
        this.radiusOfOrbit = radiusOfOrbit;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadiusOfOrbit() {
        return radiusOfOrbit;
    }

    public void setRadiusOfOrbit(int radiusOfOrbit) {
        this.radiusOfOrbit = radiusOfOrbit;
    }
}
