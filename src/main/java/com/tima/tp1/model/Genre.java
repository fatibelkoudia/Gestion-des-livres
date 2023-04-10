package com.tima.tp1.model;

public enum Genre {
	Masculin("Masculin"),
    Feminin("Feminin");
    
    private final String value;
    
    Genre(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
