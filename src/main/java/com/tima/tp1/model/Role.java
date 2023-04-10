package com.tima.tp1.model;

public enum Role {
	Admin("Admin"),
	Visiteur("Visiteur");
    
    private final String value;
    
    Role(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
