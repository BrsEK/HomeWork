package com.kbr.homework.homework6;

import java.util.Arrays;
import java.util.Objects;

public class Group {
    private Climber[] climbers;
    private Mountain mountain;
    private String isRecruiting = " Набор открыт";

    public Group(int maxQuantityOfPersons, Mountain mountain){
        climbers = new Climber[maxQuantityOfPersons];
        setMountain(mountain);
    }
    
    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }
    
    public void Group(){}


    public void addClimber(Climber climber){
        for (int i = 0; i < climbers.length; i++){
            if(Objects.isNull(climbers[i])){
                climbers[i] = climber;
                return;
            }
        }
    }


    @Override
    public String toString() {
        return "Group{" +
                "climbers=" + Arrays.toString(climbers) +
                ", mountain=" + mountain + 
                '}';
    }
}
