package com.example.collections;

public enum Location {  
    CzechRepublic("cs", "CZ"),
    Madagascar("fr", "MG"),
    Russia("ru", "RU");
    
    private final String language;
    private final String country;
    
    private Location(String language, String country){
        this.language = language;
        this.country = country;
    }
    public String getLanguage(){ return this.language; }
    public String getCountry(){ return this.country; }
}
