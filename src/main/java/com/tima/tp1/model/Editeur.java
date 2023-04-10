package com.tima.tp1.model;

public enum Editeur {
	ENI("ENI"),
	FIRST("FIRST"),
	DUNOD("DUNOD");
	
    
    private final String value;
    
    Editeur(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
	
}
