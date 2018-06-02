package testproje;

/**
 *
 * @author Recep ÇETİNKAYA 171513010
 * Kutuphane Yonetim Projesi
 * 
 */
public class Ogrenci extends Kisi {//extends kullanılarak polimorfizm ozelligi kullanılmıstır.
//degiskenler private olarak tanımlanmıstır
    private String ogrNo;
    private String sinif;
//4 parametreli constructor tanmllanmıstır.
    public Ogrenci(String ad, String ogrNo, String sinif) {
        // super(ad);
        super.ad = ad;// super komutuyla superclasstaki ad degiskenine veri atanmıstır.
        this.ogrNo = ogrNo;
        this.sinif = sinif;
    }
//Override ozelligi kisiBilgisi meetodunda  icerik ozellestirilerek tekrar baska yerlerde kullanılmsıtır.
    @Override
    void kisiBilgisi() {
        System.out.println("------------------------------------------Ogrenci Bilgileri-----------------------------------------------------");
        System.out.println("");
    }
//set-get metodları
    public String getogrNo() {
        return ogrNo;
    }

    public void setogrNo(String ogrNo) {
        this.ogrNo = ogrNo;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

}
