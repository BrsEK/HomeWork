package com.kbe.homework.homework11.AboutPosition;

public class WorkerBase {

    private final int maxLenth;
    private User[] usersJavaDev;
    private User[] usersPythonDev;
    private User[] usersCDev;

    public WorkerBase(int maxLenth) {
        this.maxLenth = maxLenth;
        this.usersJavaDev = new User[maxLenth];
        this.usersPythonDev = new User[maxLenth];
        this.usersCDev = new User[maxLenth];
    }

    public User[] getUsersJavaDev() {
        return usersJavaDev;
    }

    public User[] getUsersPythonDev() {
        return usersPythonDev;
    }

    public User[] getUsersCDev() {
        return usersCDev;
    }

    public void addUserInBase(User user, Position position){
        switch (user.getPosition()){
            case C_DEVELOPER:
                usersCDev[position.getPositionC()] = user;
                break;
            case JAVA_DEVELOPER:
                usersJavaDev[position.getPositionJava()] = user;
                break;
            case PYTHON_DEVELOPER:
                usersPythonDev[position.getPositionPython()] = user;
                break;
        }
    }
}
