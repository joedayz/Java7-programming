package com.example.localization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class SampleApp {

    PrintWriter pw = new PrintWriter(System.out, true);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Locale usLocale = Locale.US;
    Locale frLocale = Locale.FRANCE;
    Locale zhLocale = new Locale("zh", "CN");
    Locale ruLocale = new Locale("ru", "RU");
    Locale currentLocale = Locale.getDefault();
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    NumberFormat currency;
    Double money = new Double(1000000.00);
    Date today = new Date();
    DateFormat df;

    public static void main(String[] args) {
        SampleApp ui = new SampleApp();
        ui.run();
    }

    public void run() {
        String line = "";

        while (!(line.equals("q"))) {
            this.printMenu();
            try {
                line = this.br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            switch (line) {
                case "1": setEnglish(); break;
                case "2": setFrench(); break;
                case "3": setChinese(); break;
                case "4": setRussian(); break;
                case "5": showDate();  break;
                case "6": showMoney(); break;
            }
        }
    }

    public void printMenu() {
        pw.println("=== Localization App ===");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("5. " + messages.getString("menu5"));
        pw.println("6. " + messages.getString("menu6"));
        pw.println("q. " + messages.getString("menuq"));
        System.out.print(messages.getString("menucommand")+" ");
    }

    public void setEnglish() {
        currentLocale = usLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setFrench() {
        currentLocale = frLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setChinese() {
        currentLocale = zhLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setRussian() {
        currentLocale = ruLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void showDate() {
        df = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
        pw.println(df.format(today) + " " + currentLocale.toString());

    }

    public void showMoney() {
        currency = NumberFormat.getCurrencyInstance(currentLocale);
        pw.println(currency.format(money) + " " + currentLocale.toString());
    }
}
