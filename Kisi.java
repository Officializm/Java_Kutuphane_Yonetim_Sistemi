package testproje;

/**
 * @author Recep Çetinkaya 171513010
 *  Kutuphane Yonetim Projesi
 * 
 * Kutuphane yonetim projesi Kisi.java, Kitap.java, Ogrenci.java, Kutuphane.java ve KutuphaneTest.java 
 * adlı classlardan oluşmaktadır. Amaç kitap kişi ögrenci verilerinin bir veritabanında saklanması ve yonetilmesidir.
 * Bu classta  Kisi icin degiskenler tanımlanmış olup set ve get metodları ile deger atanması saglanmıştır.
 * 
 */
class Kisi {

    String ad;

    public Kisi() {    //no parameter constructer tanımlandı.

    }
 // kişibilgisi adında kutuphanedeki verilerin ekranda gosterilirken basında yazılacak olan baslık oluşturuldu.
    void kisiBilgisi() {  
        System.out.println("---------------------------------------------Kisi Bilgileri-----------------------------------------------------");
        System.out.println("");
    }

    public Kisi(String ad) { //parametreli constructor tanımlandı
        this.ad = ad;

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String name) {
        this.ad = ad;
    }

}
