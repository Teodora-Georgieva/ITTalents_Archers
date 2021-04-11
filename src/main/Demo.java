package main;

import main.archers.JuniorArcher;
import main.archers.SeniorArcher;
import main.archers.VeteranArcher;
import main.bows.AluminiumBow;
import main.bows.CarbonBow;
import main.bows.ISeniorBow;
import main.bows.WoodenBow;
import main.utils.Constants;
import main.utils.Randomizer;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Club itArcher = new Club("IT Archer", "Sofia", "Ivan Ivanov");
        for (int i = 0; i < 40; i++) {
            Random r = new Random();
            char sex = r.nextBoolean() ? Constants.MALE_GENDER : Constants.FEMALE_GENDER;
            String name = (sex == Constants.FEMALE_GENDER) ? (Randomizer.getRandomFemaleName() + i) :
                                                             (Randomizer.getRandomMaleName() + i);
            int age = Randomizer.getRandomNumber(1, 52);
            int num = Randomizer.getRandomNumber(1, 3);
            switch (num){
                case 1: itArcher.addArcher(new JuniorArcher(name, sex, age,
                                                             new WoodenBow("", 2, 100), 1));
                        break;

                case 2:
                    ISeniorBow bow = r.nextBoolean() ? new CarbonBow("", 2, 100) :
                                                       new AluminiumBow("", 2, 100);
                    itArcher.addArcher(new SeniorArcher(name, sex, age, bow, 20));
                    break;

                default: itArcher.addArcher(new VeteranArcher(name, sex, age,
                                                              new CarbonBow("", 2, 100), 25));
            }
        }

        itArcher.organizeContest();
    }
}