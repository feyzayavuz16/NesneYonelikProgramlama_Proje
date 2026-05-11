package com.bank.app.people;

import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;
import java.util.Random;

public class Musteri extends Kisi{

	private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar; // UML'de BankaHesabi tipinde
    private ArrayList<KrediKarti> krediKartlari;

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.musteriNumarasi = String.valueOf(new Random().nextInt(900000) + 100000);
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // Hesap türüne göre nesne oluşturma [cite: 25]
    public void hesapEkle(String hesapTuru, double bakiye) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            hesaplar.add(new VadesizHesap(bakiye));
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            hesaplar.add(new YatirimHesabi(bakiye));
        }
    }
    
    
    public void krediKartiEkle(double limit, double guncelBorc) {
        krediKartlari.add(new KrediKarti(limit, guncelBorc)); // [cite: 26]
    }

    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız."); // [cite: 27]
        } else {
            hesaplar.remove(hesap);
        }
    }
    
    
    public void krediKartiSil(KrediKarti kart) {
        if (kart.getGuncelBorc() == 0) {
            krediKartlari.remove(kart);
        } else {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız."); // 
        }
    }

    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }
    public String getMusteriNumarasi() { return musteriNumarasi; }
     
    @Override
    public String toString() {
        return "musteriNumarasi" + musteriNumarasi +" ad" + this.getAd() + "soyad" + this.getSoyad() ;
    }
    
}
