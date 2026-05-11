package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {
	private String iban;
    protected double bakiye;
    
    
    public BankaHesabi(double bakiye) {
        this.iban = "TR" + (new Random().nextInt(90000000) + 10000000); // rastgele iban oluşturur
        this.bakiye = bakiye;
    }
    
    //setter-getter metodlar
    public String getIban() { return iban; }
    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }
    
    

@Override
public String toString() {
    return "Bakiye:"+ bakiye +" iban: " + iban;
}}	
	