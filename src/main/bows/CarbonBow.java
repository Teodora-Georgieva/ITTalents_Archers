package main.bows;

import main.utils.Randomizer;

public class CarbonBow extends Bow implements ISeniorBow{
    private int sight;
    private int stabilization;

    public CarbonBow(String manufacturer, double weight, int strength){
        super(manufacturer, weight, strength);
        this.sight = 2;
        this.stabilization = 1;
    }

    @Override
    boolean validateStrength(int strength) {
        return strength >= 28 && strength <= 48;
    }

    @Override
    int setDefaultStrength() {
        return Randomizer.getRandomNumber(28, 48);
    }

    @Override
    public int getSight() {
        return this.sight;
    }

    @Override
    public int getStabilization() {
        return this.stabilization;
    }

    @Override
    public String getTypeOfBow() {
        return "Carbon";
    }
}