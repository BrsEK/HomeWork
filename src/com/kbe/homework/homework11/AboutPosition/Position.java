package com.kbe.homework.homework11.AboutPosition;

public enum Position {
    JAVA_DEVELOPER(0), PYTHON_DEVELOPER(1), C_DEVELOPER(2);

    private int positionJava;
    private int positionPython;
    private int positionC;

    Position(int numberBase) {

    }

    public int getPositionJava() {
        return positionJava;
    }

    public int getPositionPython() {
        return positionPython;
    }

    public int getPositionC() {
        return positionC;
    }

}
