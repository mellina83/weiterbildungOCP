package ml.Bekci.Datum_1907;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Aufg1 {
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String datumString = "22.05.1990"; 
        
        Date datum = df.parse(datumString);
        Date heute = new Date();
        long ms = heute.getTime()-datum.getTime();
        long sek= ms/1000;
        long min = sek/60;
        long std = min/60;
        long tage = std/24;
        long monate = tage/30;
        long jahre = tage/365;
        System.out.println("Sie sind " + jahre + " Jahre alt");
        System.out.println("Sie sind " + monate + " Monate alt");
        System.out.println("Sie sind " + tage + " Tage alt");
        
        
    }

}