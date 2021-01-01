package com.kbe.homework.exams.game.events;

import java.util.HashMap;

public interface SituationAction {

    void execute(HashMap<Descriptions, Situation> events);

}
