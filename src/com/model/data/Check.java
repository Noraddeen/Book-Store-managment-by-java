package com.model.data;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Check {

    public default boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public default String isNotNull(String value, String type){
        return Optional.ofNullable(value).orElseThrow(()-> new IllegalStateException("don't keep "+ type +" name empty or have numbers or symbols"));
    }

     public default String isLetters(String value, String type){
         return Optional.ofNullable(value).filter(t -> isAlpha(t)).orElseThrow(()-> new IllegalStateException("don't keep "+ type +" name empty or have numbers or symbols"));
     }

    public default boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }


    public default boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        //Iterate emails array list
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public default boolean isValidPassword(String password)
    {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    //    public default boolean isAlpha(String name) {
    //        return name.matches("[a-zA-Z]+");
   //    }
   //  public default boolean issAlpha(String name) {
  //    return name.chars().allMatch(Character::isLetter);
  //  }
}