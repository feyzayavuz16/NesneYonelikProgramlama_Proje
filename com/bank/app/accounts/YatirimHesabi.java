package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
private String hesapTuru = "yatirim";

public YatirimHesabi(double bakiye) { 
	super(bakiye);
	}

public void paraEkle(double miktar) {
    this.bakiye += miktar;
}

public void paraCek(double miktar) {
    if (this.bakiye >= miktar) {
        this.bakiye -= miktar;
    }
}
@Override
public String toString() {
    return "Hesap Türü:\n"+ hesapTuru + "Bakiye:\n" + bakiye;
} 

}
