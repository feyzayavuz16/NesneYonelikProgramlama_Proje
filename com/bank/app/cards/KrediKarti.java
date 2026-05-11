package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
	private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;
    
    public KrediKarti(double limit, double guncelBorc) {
        this.kartNumarasi = String.valueOf(new Random().nextLong(9000000000L) + 1000000000L);//rastgele kart numarısı oluşturur
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit - guncelBorc;
    }
    // setter-getter
    public double getGuncelBorc() {
    	return guncelBorc;
    	}
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        this.kullanilabilirLimit = this.limit - this.guncelBorc;
    }
    public String getKartNumarasi() { 
    	return kartNumarasi; }
    
    @Override
    public String toString() {
        return "kredi karti numarasi:"+ kartNumarasi +" \n limit:" + limit + "\n Güncel borc:" + guncelBorc +
        		"\n Kullanılabilir limit" + kullanilabilirLimit ;
    } 
}
