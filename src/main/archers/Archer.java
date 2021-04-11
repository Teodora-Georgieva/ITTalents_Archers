package main.archers;

import main.bows.IBow;
import main.utils.Constants;
import main.utils.Randomizer;
import main.utils.Validator;

import java.util.Objects;

public abstract class Archer {
    private String name;
    private char sex;
    private int age;
    private IBow bow;
    private int experience;
    private int numOfContests;
    private Stats stats;

    Archer(String name, char sex, int age, IBow bow, int experience){
        if(Validator.isValidSex(sex)){
            this.sex = sex;
        }
        else{
            this.sex = Constants.MALE_GENDER;
        }

        if(Validator.isValidString(name)){
            this.name = name;
        }
        else{
            if(this.sex == Constants.MALE_GENDER){
                this.name = Randomizer.getRandomMaleName();
            }
            else{
                this.name = Randomizer.getRandomFemaleName();
            }
        }

        if(Validator.isValidAge(age)){
            this.age = age;
        }
        else{
            this.age = 35;
        }

        this.bow = bow;
        this.numOfContests = 0;
        if(validateExperience(experience)) {
            this.experience = experience;
        }
        else{
            this.experience = setDefaultExperience();
        }
    }

    abstract int getNumberOfArrows();
    abstract int getArrowHitChance();
    abstract int getMissChancePercent();
    abstract int setDefaultExperience();
    abstract boolean validateExperience(int experience);
    public abstract String getTypeOfArcher();

    public double getPercentOfTens(){
        return this.stats.getNumberOfTens() / (double)(getNumberOfArrows()) * 100;
    }

    public int getNumOfMissedArrows(){
        return this.stats.getNumOfMisses();
    }

    public char getSex() {
        return sex;
    }

    public Integer getExperience(){
        return this.experience;
    }

    public Stats getStats(){
        return this.stats;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + " years old, sex: " + this.sex + ", total points from the contest: " +
                (this.stats != null ? this.stats.getTotalPoints() : 0) + ", type of archer: " + getTypeOfArcher();
    }

    public String getName() {
        return this.name;
    }

    public void attendContest(){
        this.numOfContests++;
        this.stats = new Stats();
    }

    private boolean missedArrow() {
        if(Randomizer.getRandomNumber(1, 100) <= getMissChancePercent()){
            return true;
        }

        return false;
    }

    public void shootArrows(){
        int totalPoints = 0;

        for (int i = 0; i < getNumberOfArrows(); i++) {
            int crrPoints;
            if(missedArrow()){
                crrPoints = 0;
                this.stats.increaseNumberOfMisses();
            }
            else{
                crrPoints = getArrowHitChance();
                if(crrPoints < 10){
                    crrPoints += this.bow.getSight() + this.bow.getStabilization();
                    if(crrPoints > 10){
                        crrPoints = 10;
                    }
                }

                if(crrPoints == 10){
                    this.stats.increaseNumberOfTens();
                }
            }

            totalPoints+=crrPoints;
        }

        this.stats.setTotalPoints(totalPoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archer archer = (Archer) o;
        return age == archer.age &&
                experience == archer.experience &&
                Objects.equals(name, archer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, experience);
    }

    public IBow getBow() {
        return bow;
    }
}