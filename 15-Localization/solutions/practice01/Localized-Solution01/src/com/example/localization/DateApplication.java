package com.example.localization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class DateApplication {
    PrintWriter pw = new PrintWriter(System.out, true);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
    Locale ruLocale = new Locale("ru", "RU");
    Locale currentLocale = Locale.US;
        
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", Locale.US);
    
        
    Date today = new Date();
    DateFormat df;
    SimpleDateFormat sdf;

    public static void main(String[] args){
        DateApplication dateApp = new DateApplication();
        dateApp.run();        
    }
    
    public void run(){
        String line = "";
        
        while (!(line.equals("q"))){
            this.printMenu();
            try { line = this.br.readLine(); } 
            catch (Exception e){ e.printStackTrace(); }
            
            switch (line){
                case "1": this.setEnglish(); break;
                case "2": this.setFrench(); break;
                case "3": this.setChinese(); break;
                case "4": this.setRussian(); break;
            }
        }       
    }
    
    public void printMenu(){
        pw.println("=== Date App ===");
        df = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);        
        pw.println(messages.getString("date1") + " " + df.format(today));
        df = DateFormat.getDateInstance(DateFormat.LONG, currentLocale);        
        pw.println(messages.getString("date2") + " " + df.format(today));
        df = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);        
        pw.println(messages.getString("date3") + " " + df.format(today));
        df = DateFormat.getDateInstance(DateFormat.FULL, currentLocale);        
        pw.println(messages.getString("date4") + " " + df.format(today));
        df = DateFormat.getTimeInstance(DateFormat.FULL, currentLocale);        
        pw.println(messages.getString("date5") + " " + df.format(today));
        sdf = new SimpleDateFormat("EEEE", currentLocale);        
        pw.println(messages.getString("date6")  + " " + sdf.format(today));
        sdf = new SimpleDateFormat("EEEE MMMM d, y G kk:mm:ss zzzz", currentLocale);        
        pw.println(messages.getString("date7") + " " + sdf.format(today));
        pw.println("\n--- Choose Language Option ---");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("q. " + messages.getString("menuq"));
        System.out.print(messages.getString("menucommand") + " ");        
    }
    
    public void setEnglish(){
        currentLocale = Locale.US;    
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);        
    }
    
    public void setFrench(){
        currentLocale = Locale.FRANCE;    
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }
    
    public void setChinese(){
        currentLocale = Locale.SIMPLIFIED_CHINESE;    
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);  
    }
    
    public void setRussian(){
        currentLocale = ruLocale;    
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);        
    }
}
