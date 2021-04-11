package main.archers;

import main.bows.CarbonBow;
import main.utils.Randomizer;

public class VeteranArcher extends SeniorArcher{
    public VeteranArcher(String name, char sex, int age, CarbonBow bow, int experience){
        super(name, sex, age, bow, experience);
    }

    int setDefaultExperience() {
        return Randomizer.getRandomNumber(10, 30);
    }

    int getMissChancePercent() {
        return 0;
    }

    boolean validateExperience(int experience) {
        return experience > 10;
    }

    @Override
    public String getTypeOfArcher() {
        return "Veteran";
    }
}