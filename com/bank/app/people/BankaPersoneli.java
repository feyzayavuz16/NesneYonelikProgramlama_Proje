package com.bank.app.people;
import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
	private String personelID;
    private ArrayList<Musteri> musteriler; // Personelin sorumlu olduğu müşteriler 

    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.personelID = String.valueOf(new Random().nextInt(9000) + 1000); // Id üretimi 
        this.musteriler = new ArrayList<>();// müşterilerin tutulduğu arraylist
}
//getter metodlar
    public String getPersonelID() {
    	return personelID;
    	}
    public ArrayList<Musteri> getMusteriler() {
    	return musteriler; 
    	}

    @Override
    public String toString() {
        return super.toString() + ", PersonelID: " + personelID;
    }}