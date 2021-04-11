package main.bows;

import main.utils.Validator;

public abstract class Bow implements IBow{
    private String manufacturer;
    private double weight;
    private int strength;

    Bow(String manufacturer, double weight, int strength){
        if(Validator.isValidString(manufacturer)){
            this.manufacturer = manufacturer;
        }
        else{
            this.manufacturer = "Hoyt";
        }

        if(weight > 0){
            this.weight = weight;
        }
        else{
            this.weight = 2;
        }

        if(validateStrength(strength)) {
            this.strength = strength;
        }
        else{
            this.strength = setDefaultStrength();
        }
    }

    abstract boolean validateStrength(int strength);
    abstract int setDefaultStrength();
}
