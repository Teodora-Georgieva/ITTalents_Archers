package main.archers;

import main.bows.ISeniorBow;
import main.utils.Randomizer;

public class SeniorArcher extends Archer{
    public SeniorArcher(String name, char sex, int age, ISeniorBow bow, int experience){
        super(name, sex, age, bow, experience);
    }

    @Override
    int getNumberOfArrows() {
        return 60;
    }

    @Override
    int getArrowHitChance() {
        return Randomizer.getRandomNumber(6, 10);
    }

    @Override
    int getMissChancePercent() {
        return 5;
    }

    @Override
    int setDefaultExperience() {
        return Randomizer.getRandomNumber(3, 10);
    }

    @Override
    boolean validateExperience(int experience) {
        return experience >= 3 && experience <= 10;
    }

    @Override
    public String getTypeOfArcher() {
        return "Senior";
    }
}