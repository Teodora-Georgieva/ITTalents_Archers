package main.archers;

public class Stats {
    private int totalPoints;
    private int numberOfTens;
    private int numOfMisses;

    public void increaseNumberOfTens(){
        this.numberOfTens++;
    }

    public void increaseNumberOfMisses(){
        this.numOfMisses++;
    }

    public void setTotalPoints(int points){
        this.totalPoints = points;
    }

    public int getTotalPoints(){
        return this.totalPoints;
    }

    public int getNumberOfTens() {
        return numberOfTens;
    }

    public int getNumOfMisses() {
        return numOfMisses;
    }
}