package com.kbe.homework.exams.game.events;

import com.kbe.homework.exams.game.menu.Save;

import java.util.HashMap;
import java.util.Scanner;

public class Situation implements SituationAction {
    private Descriptions responseZero;
    private Descriptions responseOne;
    private Descriptions description;
    private Descriptions[] responses;

    public Situation(Descriptions description, Descriptions responseZero, Descriptions responseOne) {
        this.responseZero = responseZero;
        this.responseOne = responseOne;
        this.description = description;

        responses = new Descriptions[]{responseZero, responseOne, Descriptions.SAVE};
    }

    @Override
    public void execute(HashMap<Descriptions, Situation> events) {
        System.out.println(description.getDescription());
        if (!(responseZero.equals(Descriptions.STOP) || responseOne.equals(Descriptions.STOP))) {
            Descriptions response = getResponseFromCommandLine();
            while (response.equals(Descriptions.SAVE)) {
                Save.save(description);
                System.out.println("Сохранено");
                response = getResponseFromCommandLine();
            }

            events.get(response).execute(events);
        }
    }

    private Descriptions getResponseFromCommandLine() {
        Scanner scanner = new Scanner(System.in);
        return responses[Integer.parseInt(scanner.nextLine())];
    }


}
