package main.bows;

import main.utils.Randomizer;

public class WoodenBow extends Bow{
    public WoodenBow(String manufacturer, double weight, int strength){
        super(manufacturer, weight, strength);
    }

    @Override
    boolean validateStrength(int strength) {
        return strength >= 20 && strength <= 30;
    }

    @Override
    int setDefaultStrength() {
        return Randomizer.getRandomNumber(20, 30);
    }

    @Override
    public int getSight() {
        return 0;
    }

    @Override
    public int getStabilization() {
        return 0;
    }

    @Override
    public String getTypeOfBow() {
        return "Wooden";
    }
}