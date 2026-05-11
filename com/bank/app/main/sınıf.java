package com.bank.app.main;

import com.bank.app.people.Musteri;
import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;

public class sınıf {
    public static void main(String[] args) {
        // 1. Müşteri Oluşturma [cite: 47]
        Musteri m1 = new Musteri("Feyza", "Yavuz", "feyza@btu.edu.tr", 5551234);
        System.out.println("--- Müşteri Oluşturuldu ---");
        System.out.println(m1.toString());

        // 2. Müşteri adına hesap açma [cite: 48]
        m1.hesapEkle("Vadesiz", 1000.0);
        m1.hesapEkle("Yatirim", 500.0);
        
        VadesizHesap vadesiz = (VadesizHesap) m1.getHesaplar().get(0);
        YatirimHesabi yatirim = (YatirimHesabi) m1.getHesaplar().get(1);
        System.out.println("\n--- Hesaplar Açıldı ---");
        System.out.println("Vadesiz " + vadesiz.toString());
        System.out.println("Yatırım " + yatirim.toString());

        // 3. Hesaba para yatırma [cite: 49]
        yatirim.paraEkle(250.0);
        System.out.println("\n--- Yatırım Hesabına Para Eklendi ---");
        System.out.println("Yeni Bakiye: " + yatirim.getBakiye());

        // 4. Hesaplar arasında para transferi [cite: 50]
        // Not: Dokümana göre transfer vadesiz hesap üzerinden yapılmalıdır [cite: 29]
        m1.hesapEkle("Vadesiz", 0.0);
        VadesizHesap aliciHesap = (VadesizHesap) m1.getHesaplar().get(2);
        
        System.out.println("\n--- Para Transferi Başlatılıyor ---");
        vadesiz.paraTransferi(aliciHesap, vadesiz, 300.0);
        System.out.println("Gönderen Bakiye: " + vadesiz.getBakiye());
        System.out.println("Alıcı Bakiye: " + aliciHesap.getBakiye());

        // 5. Müşteriye kredi kartı tanımlama [cite: 51]
        m1.krediKartiEkle(5000.0, 200.0); // 200 TL borçlu kart
        KrediKarti kart = m1.getKrediKartlari().get(0);
        System.out.println("\n--- Kredi Kartı Tanımlandı ---");
        System.out.println(kart.toString());

        // 6. Kredi kartı borcu ödeme [cite: 52]
        System.out.println("\n--- Borç Ödeme İşlemi ---");
        vadesiz.krediKartiBorcOdeme(kart, 100.0);
        System.out.println("Ödeme sonrası kart borcu: " + kart.getGuncelBorc());
        System.out.println("Ödeme sonrası hesap bakiyesi: " + vadesiz.getBakiye());

        // 7. Hesap silme işlemi [cite: 53]
        System.out.println("\n--- Hesap Silme Testi ---");
        System.out.print("Bakiye varken silme: ");
        m1.hesapSil(vadesiz); // Uyarı vermeli [cite: 27]
        
        aliciHesap.setBakiye(0.0);
        System.out.print("Bakiye 0 iken silme: ");
        m1.hesapSil(aliciHesap); // Silmeli
    }
}
