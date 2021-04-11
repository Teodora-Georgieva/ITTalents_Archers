package main.bows;

import main.utils.Randomizer;

public class AluminiumBow extends Bow implements ISeniorBow{
    private int sight;

    public AluminiumBow(String manufacturer, double weight, int strength){
        super(manufacturer, weight, strength);
        this.sight = 1;
    }

    @Override
    boolean validateStrength(int strength) {
        return strength >= 25 && strength <= 40;
    }

    @Override
    int setDefaultStrength() {
        return Randomizer.getRandomNumber(25, 40);
    }

    @Override
    public int getSight() {
        return this.sight;
    }

    @Override
    public int getStabilization() {
        return 0;
    }

    @Override
    public String getTypeOfBow() {
        return "Aluminium";
    }
}