package com.model.data;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Optional.ofNullable;

public class Check {

    public static String isNotNullString(String value, String type){
        return Optional
                  .ofNullable(value)
                  .orElseThrow(()-> new IllegalStateException("don't keep "+ type +" feild empty"));
    }

     public static String isAlpha(String value, String type){
         return Optional
                 .ofNullable(value)
                 .filter(t -> isLetters(t))
                 .orElseThrow(()-> new IllegalStateException("don't keep "+ type +" feild empty or have numbers or symbols"));
     }

    public static String isValidPhoneNumer(String value){
        return Optional
                .ofNullable(value)
                .filter(t -> isValidPhoneNum(t))
                .orElseThrow(()-> new IllegalStateException("don't keep phone feild empty and be sure to be in pattern of 0700 0000 000"));
    }

    public static String isValidEmail(String value){
        return Optional
                .ofNullable(value)
                .filter(t -> checkEmail(t))
                .orElseThrow(()-> new IllegalStateException("don't keep email feild empty and check again if you writed correctely"));
    }

    public static Double isNumber(String num){
        double resault = Optional
                .ofNullable(num)
                .filter(t->Check.isNumeric(t))
                .map(t->Double.parseDouble(t)).orElseThrow(()->new IllegalStateException("in field price be aware of not input except numbers")
                );
        return  resault;
    }

    private static boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

      private static boolean isLetters(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }


    private static boolean checkEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        //Iterate emails array list
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }



    private static boolean isValidPhoneNum(String phoneNum) {
        String regex = "07\\d{2}[- .]\\d{4}[- .]\\d{3}|07\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    //    public default boolean isAlpha(String name) {
    //        return name.matches("[a-zA-Z]+");
   //    }
   //  public default boolean isAlpha(String name) {
  //    return name.chars().allMatch(Character::isLetter);
  //  }
}