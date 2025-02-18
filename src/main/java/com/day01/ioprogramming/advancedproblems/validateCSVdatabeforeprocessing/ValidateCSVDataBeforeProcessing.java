package com.day01.ioprogramming.advancedproblems.validateCSVdatabeforeprocessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSVDataBeforeProcessing {
    public static void validateCSVDataBeforeProcessing(String filename){
        try {
            FileReader fileReader=new FileReader(filename);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            String emailRegex="^[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+$";
            String numberRegex="^[6,9]\\d{9}$";
            while ((line=bufferedReader.readLine())!=null){
                String[] columns=line.split(",");
                String email=columns[1];
                String phone=columns[2];
                if (!isValidateEmail(email,emailRegex)){
                    System.out.println("Invalid email: "+line);
                }
                if (!isValidatePhoneNUmber(phone,numberRegex)){
                    System.out.println("Invalid phone number: "+line);
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e){
            System.out.println("Error in reading file");
        }
    }
    private static boolean isValidateEmail(String email,String emailRegex){
        Pattern pattern=Pattern.compile(emailRegex);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isValidatePhoneNUmber(String phone,String numberRegex){
        Pattern pattern=Pattern.compile(numberRegex);
        Matcher matcher=pattern.matcher(phone);
        return matcher.matches();
    }
}
