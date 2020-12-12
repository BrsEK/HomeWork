package com.kbe.homework.exams.clientserver;

public interface CheckIf {
    final static String COMMAND_SHUTDOWN = "/exit";


    public boolean closeIfExit(SimpleMessage message);
}
