package com.bank.app.accounts;
import com.bank.app.cards.KrediKarti;


public class VadesizHesap extends BankaHesabi {
private String hesapTuru = "vadesiz";

public VadesizHesap(double bakiye) { super(bakiye);
}

public void paraTransferi(BankaHesabi alici, BankaHesabi gonderen, double miktar) {
    if (gonderen.getBakiye() >= miktar) {
        gonderen.setBakiye(gonderen.getBakiye() - miktar); 
        alici.setBakiye(alici.getBakiye() + miktar);
    }
}

public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
    if (this.bakiye >= miktar) {
        this.bakiye -= miktar;
        kart.setGuncelBorc(kart.getGuncelBorc() - miktar); 
    }
}
@Override
public String toString() {
	return "\n Hesap Türü:"+ hesapTuru +"\n Bakiye:" +
this.bakiye ; 
}

}
