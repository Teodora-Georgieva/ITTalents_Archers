package main.archers;

import main.bows.WoodenBow;
import main.utils.Randomizer;

public class JuniorArcher extends Archer {

    public JuniorArcher(String name, char sex, int age, WoodenBow bow, int experience){
        super(name, sex, age, bow, experience);
    }

    @Override
    int getNumberOfArrows() {
        return 30;
    }

    @Override
    int getArrowHitChance() {
        return Randomizer.getRandomNumber(1, 10);
    }

    @Override
    int getMissChancePercent() {
        return 10;
    }

    @Override
    public String getTypeOfArcher() {
        return "Junior";
    }

    @Override
    int setDefaultExperience() {
        return 1;
    }

    @Override
    boolean validateExperience(int experience) {
        return experience == 1;
    }
}