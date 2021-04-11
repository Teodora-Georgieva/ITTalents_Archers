package main.utils;

import java.util.Random;

public abstract class Randomizer {
    private static final String[] FEMALE_NAMES = {"Maria", "Iva", "Ivana", "Petq", "Sonq", "Qna", "Teodora", "Elena"};
    private static final String[] MALE_NAMES = {"Mario", "Ivan", "Iordan", "Petar", "Stefan", "Qnek", "Todor", "Evgeni"};

    public static String getRandomMaleName(){
        Random r = new Random();
        return MALE_NAMES[r.nextInt(MALE_NAMES.length)];
    }

    public static String getRandomFemaleName(){
        Random r = new Random();
        return FEMALE_NAMES[r.nextInt(FEMALE_NAMES.length)];
    }

    public static int getRandomNumber(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}