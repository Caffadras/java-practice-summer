package application.util;


import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class ValidatorUtil {

    public static boolean isLong(String number){
        try{
            Long.valueOf(number);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isDouble(String number){
        try{
            Double.valueOf(number);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isDate(String date){
        try{
            LocalDate.parse(date);
        }catch(DateTimeParseException e){
            return false;
        }
        return true;
    }

    public static boolean isNullOrEmpty(JTextField object){
        return object == null ||object.getText() == null || object.getText().isEmpty();
    }
    public static boolean isPhoneFormat(String phone){
        return Pattern.matches("[+]?-?\\d+", phone.replaceAll("\\s",""));
    }


}
