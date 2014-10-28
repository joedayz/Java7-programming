package com.example.localization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class SampleUI {
    PrintWriter pw = new PrintWriter(System.out, true);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
    public static void main(String[] args){
        SampleUI ui = new SampleUI();
        ui.run();
    }
    
    public void run(){
        String line = "";
        
        while (!(line.equals("q"))){
            this.printMenu();
            try { line = this.br.readLine(); } 
            catch (Exception e){ e.printStackTrace(); }
            
            switch (line){
                case "1": setEnglish(); break;
                case "2": setFrench(); break;
                case "3": setChinese(); break;
                case "4": setRussian(); break;
                case "5": showDate(); break;
                case "6": showMoney(); break;
            }
        }
        
        
    }
    
    public void printMenu(){
        pw.println("=== Localization App ===");
        pw.println("1. Set to English");
        pw.println("2. Set to French");
        pw.println("3. Set to Chinese");
        pw.println("4. Set to Russian");
        pw.println("5. Show me the date");
        pw.println("6. Show me the money!");
        pw.println("q. Enter q to quit");
        System.out.print("Enter a command: ");        
    }
    
    public void setEnglish(){
        
    }
    
    public void setFrench(){

    }
    
    public void setChinese(){
        
    }
    
    public void setRussian(){
        
    }
    
    public void showDate(){
        
    }
    
    public void showMoney(){
        
    }
}
