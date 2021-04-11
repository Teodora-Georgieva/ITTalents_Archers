package main;

import main.archers.Archer;
import main.utils.Constants;
import main.utils.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Club {
    private String name;
    private String address;
    private String trainer;
    private HashSet<Archer> archers;
    private HashMap<String, HashMap<String, Integer>> diary;

    Club(String name, String address, String trainer){
        if(Validator.isValidString(name)){
            this.name = name;
        }
        else{
            this.name = "IT Archer";
        }

        if(Validator.isValidString(address)){
            this.address = address;
        }
        else{
            this.address = "Sofia";
        }

        if(Validator.isValidString(trainer)){
            this.trainer = trainer;
        }
        else{
            this.trainer = "Ivan Ivanov";
        }

        this.archers = new HashSet<Archer>();

        diary = new HashMap<String, HashMap<String, Integer>>();
        diary.put("Junior", new HashMap<String, Integer>());
        diary.put("Senior", new HashMap<String, Integer>());
        diary.put("Veteran", new HashMap<String, Integer>());
    }

    void addArcher(Archer a){
        this.archers.add(a);
    }

    void organizeContest(){
        System.out.println("Printing all archers alphabetically:");
        this.printArchersAlphabetically();

        for(Archer a : this.archers){
            a.attendContest();
            a.shootArrows();
            HashMap<String, Integer> hashMap = diary.get(a.getTypeOfArcher());
            hashMap.put(a.getName(), a.getStats().getTotalPoints());
        }

        System.out.println("Showing diary");
        for(String typeOfArcher : diary.keySet()){
            System.out.println(typeOfArcher + ":");

            HashMap<String, Integer> archers = diary.get(typeOfArcher);
            for(Map.Entry<String, Integer> a : archers.entrySet()){
                System.out.println(a.getKey() + ": " + a.getValue());
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("Juniors winner: ");
        printJuniorsWinnerName();
        System.out.println();

        System.out.print("Seniors winner: ");
        printSeniorsWinnerName();
        System.out.println();

        System.out.print("Veterans winner: ");
        printVeteransWinnerName();
        System.out.println();

        System.out.print("Juniors averageResult: ");
        printJuniorsAvgRes();
        System.out.println();

        System.out.print("Seniors averageResult: ");
        printSeniorsAvgRes();
        System.out.println();

        System.out.print("Veterans averageResult: ");
        printVeteransAvgRes();
        System.out.println();

        System.out.println("The most accurate archer: ");
        printMostAccurateArcher();
        System.out.println();

        System.out.println("The most incompetent archer: ");
        printMostIncompetentArcher();
        System.out.println();

        System.out.println("Printing all women sorted by accuracy: ");
        //TODO

        System.out.println("Print all carbon men: ");
        printAllCarbonMen();
        System.out.println();
    }

    private void printArchersAlphabetically(){
        ArrayList<Archer> listOfArchers = new ArrayList<>();
        listOfArchers.addAll(this.archers);
        listOfArchers.sort((a1, a2) -> a1.getName().compareTo(a2.getName()));
        for(Archer a : listOfArchers){
            System.out.println(a);
        }
    }

    void printAllCarbonMen(){
        ArrayList<Archer> carbonMen = new ArrayList<>();
        for(Archer a : this.archers){
            if(a.getSex() == Constants.MALE_GENDER && a.getBow().getTypeOfBow().equals("Carbon")){
                carbonMen.add(a);
            }
        }

        carbonMen.sort((a1, a2) -> a1.getExperience().compareTo(a2.getExperience()));
        for (int i = 0; i < carbonMen.size(); i++) {
            System.out.print(carbonMen.get(i));
            System.out.println(", EXPERIENCE: " + carbonMen.get(i).getExperience());
        }
    }

    private void printMostAccurateArcher(){
        ArrayList<Archer> listOfArchers = new ArrayList<>();
        listOfArchers.addAll(this.archers);
        listOfArchers.sort((a1, a2) -> ((Double)(a1.getPercentOfTens())).compareTo((Double)(a2.getPercentOfTens())));
        Archer mostAccurate = listOfArchers.get(archers.size() - 1);
        System.out.println(mostAccurate.getName() + " - " + mostAccurate.getPercentOfTens() + " % tens");
    }

    private void printMostIncompetentArcher(){
        ArrayList<Archer> listOfArchers = new ArrayList<>();
        listOfArchers.addAll(this.archers);
        listOfArchers.sort((a1, a2) -> ((Integer)(a1.getNumOfMissedArrows())).compareTo((Integer)(a2.getNumOfMissedArrows())));
        Archer mostIncompetent = listOfArchers.get(archers.size() - 1);
        System.out.println(mostIncompetent.getName() + " - " + mostIncompetent.getNumOfMissedArrows() + " missed arrows");
    }

    private void printJuniorsWinnerName(){
        String winnerName = null;
        int maxPoints = 0;

        HashMap<String, Integer> hashMap = diary.get("Junior");
        for(String name : hashMap.keySet()) {
            int points = hashMap.get(name);
            if(points > maxPoints){
                maxPoints = points;
                winnerName = name;
            }
        }

        System.out.println("name: " + winnerName + ", total points: " + maxPoints);
    }

    private void printSeniorsWinnerName(){
        String winnerName = null;
        int maxPoints = 0;

        HashMap<String, Integer> hashMap = diary.get("Senior");
        for(String name : hashMap.keySet()) {
            int points = hashMap.get(name);
            if(points > maxPoints){
                maxPoints = points;
                winnerName = name;
            }
        }

        System.out.println("name: " + winnerName + ", total points: " + maxPoints);
    }

    private void printVeteransWinnerName(){
        String winnerName = null;
        int maxPoints = 0;

        HashMap<String, Integer> hashMap = diary.get("Veteran");
        for(String name : hashMap.keySet()) {
            int points = hashMap.get(name);
            if(points > maxPoints){
                maxPoints = points;
                winnerName = name;
            }
        }

        System.out.println("name: " + winnerName + ", total points: " + maxPoints);
    }

    void printJuniorsAvgRes(){
        double totalPoints = 0;

        HashMap<String, Integer> hashMap = diary.get("Junior");
        for(String name : hashMap.keySet()) {
            int points = hashMap.get(name);
            totalPoints += points;
        }

        System.out.println(totalPoints/hashMap.size());
    }

    void printSeniorsAvgRes(){
        double totalPoints = 0;

        HashMap<String, Integer> hashMap = diary.get("Senior");
        for(String name : hashMap.keySet()) {
            int points = hashMap.get(name);
            totalPoints += points;
        }

        System.out.println(totalPoints/hashMap.size());
    }

    void printVeteransAvgRes(){
        double totalPoints = 0;

        HashMap<String, Integer> hashMap = diary.get("Veteran");
        for(String name : hashMap.keySet()) {
            int points = hashMap.get(name);
            totalPoints += points;
        }

        System.out.println(totalPoints/hashMap.size());
    }
}