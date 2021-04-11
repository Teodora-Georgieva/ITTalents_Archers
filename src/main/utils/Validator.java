package main.utils;

public abstract class Validator {
    public static boolean isValidString(String s){
        return s != null && s.length() > 0;
    }

    public static boolean isValidSex(char sex){
        return sex == Constants.FEMALE_GENDER || sex == Constants.MALE_GENDER;
    }

    public static boolean isValidAge(int age){
        return age >= 12 && age <= 52;
    }
}