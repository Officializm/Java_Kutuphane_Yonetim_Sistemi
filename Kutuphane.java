package testproje;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Recep Çetinkaya 171513010
 *  Kutuphane Yonetim Projesi
 * 
 * Kutuphane adlı classta oluşturulan Arraylistlerde sistemin nasıl çalıştıgını gözlemlemek için önceden hazır veriler 
 * girilmiştir. Bu veriler hem kitap hem kisi hem de ögrenci icin oluşturulmustur. KutupaneTest.java sınıfında çağrılmış olan
 * butun metodlar burada oluşturulmustur.Ayrıca her classta no-parameter constructorlar tanımlanmış  boylece nesne tanımlandıgı zaman 
 * parametresiz çalısabilmesi saglanmstır.
 */
final class Kutuphane {
// Arraylistler tanımlanmıştır
    private ArrayList<Kitap> kitapVeritabani = new ArrayList<Kitap>();
    private ArrayList<Kisi> kisiVeritabani = new ArrayList<Kisi>();
    private ArrayList<Ogrenci> ogrenciVeritabani = new ArrayList<Ogrenci>();
    public String[] kitapTurleri = new String[1];

    public Kutuphane() { //constructor oluşturulmustur.
        kitapTurleri = new String[5];
        kitapTurleri[0] = "GIZEM";
        kitapTurleri[1] = "KORKU";
        kitapTurleri[2] = "FANTAZI";
        kitapTurleri[3] = "POLISIYE";
        kitapTurleri[4] = "GERILIM";
//Constructor cagılrıldıgı zaman asagıdaki metotlar calışmaya baslayacak ve arraylistlere verileri yukleyecktir.
         
        yukleKisiOdunc();
        yukleOgrenciOdunc();
        yukleKitaplar();
    }

    public void yukleKisiOdunc() {//veritabanında hazır veriler olusturuldu.

        kisiVeritabani.add(new Kisi("Ali Sönmez"));
        kisiVeritabani.add(new Kisi("Emre Kaya"));
        kisiVeritabani.add(new Kisi("Cetin Silen"));
        kisiVeritabani.add(new Kisi("Cem Yaslı"));
        kisiVeritabani.add(new Kisi("Onur Özkan"));
        kisiVeritabani.add(new Kisi("Abdulkerim Azvermez"));

    }

    public void yukleOgrenciOdunc() {//veritabanında hazır veriler olusturuldu.

        ogrenciVeritabani.add(new Ogrenci("Abdullah Hancioglu", "171513010", "2"));
        ogrenciVeritabani.add(new Ogrenci("Metehan Kaygili", "171513011", "1"));
        ogrenciVeritabani.add(new Ogrenci("Ayse Aysel", "171513008", "2"));
        ogrenciVeritabani.add(new Ogrenci("Belgin Ceylan", "171513009", "3"));
        ogrenciVeritabani.add(new Ogrenci("Cihan Derin", "171513012", "4"));
        ogrenciVeritabani.add(new Ogrenci("Deniz Desen", "171513013", "4"));

    }

    public void yukleKitaplar() {//veritabanında hazır veriler olusturuldu.

        kitapVeritabani.add(new Kitap("Resat Nuri Guntekin", "calikusu", kitapTurleri[0], "357951"));
        kitapVeritabani.add(new Kitap("Peyami Safa", "hariciye", kitapTurleri[1], "963369"));
        kitapVeritabani.add(new Kitap("Goethe", "faust", kitapTurleri[2], "572275"));
        kitapVeritabani.add(new Kitap("Tolstoy", "savas", kitapTurleri[3], "158794"));
        kitapVeritabani.add(new Kitap("Gogol", "canlar", kitapTurleri[0], "465420"));
        kitapVeritabani.add(new Kitap("Charles Dickens", "iki", kitapTurleri[4], "654236"));
    }

    public void gosterKisiOdunc() {//Kitap  odunc alan kişilerin arraylistlerden verisi alınarak ekrana gostermesini saglayan metod.
        Kisi k = new Kisi();
        k.kisiBilgisi();
        for (int j = 0; j < kisiVeritabani.size(); j++) {
            Kisi info = kisiVeritabani.get(j);//Get medotu ile kisiveritabanindan veri alınması  saglandı.

            System.out.println(info.getAd());//Cekilen verilerin ekranda gosterilmesi saglandı.
            System.out.println("---------------------------------------------OduncALanKişi : " + (j + 1) + "-----------------------------------------------------");

        }
    }

    public void gosterOgrenciOdunc() {//Kitap  odunc alan ögrencilerin arraylistlerden verisi alınarak ekrana gostermesini saglayan metod.

        for (int j = 0; j < ogrenciVeritabani.size(); j++) {
            Ogrenci info = ogrenciVeritabani.get(j);

            System.out.println(info.getAd() + ", " + info.getogrNo() + ", " + info.getSinif());//Cekilen verilerin ekranda gosterilmesi saglandı.
            System.out.println("---------------------------------------------OduncAlanOgrenci : " + (j + 1) + "-----------------------------------------------------");

        }
    }

    public void ekleOgrenciOdunc(String ad, String ogrNo, String sinif) {//Kitap odunc alacak olan ogrencinin verisi 
        //bu  metod ile  ogrenciVeritabanina eklenmektedir.
        ogrenciVeritabani.add(new Ogrenci(ad, ogrNo, sinif));
    }

    public void ekleKisiOdunc(String ad) {//Kitap odunc alacak olan kisinin verisi 
        //bu  metod ile  ogrenciVeritabanina eklenmektedir.
        kisiVeritabani.add(new Kisi(ad));
    }

    public void ekleKitap(String yazar, String KitapIsmi, String tur, String ISBN) {// Yeni kitabın verisinin kitapveritabani arrraylistine 
        //eklenmesini saglayan metod.
        kitapVeritabani.add(new Kitap(yazar, tur, KitapIsmi, ISBN));
    }

    public void silKitap(String delbook) {//Yonetici bir kitabi silmek istediginde istenilen kitabın silinmesini saglayan metod.
        
        for (int j = 0; j < kitapVeritabani.size(); j++) {
            Kitap info = kitapVeritabani.get(j);
            if (delbook == null ? info.getKitapIsmi() == null : delbook.equals(info.getKitapIsmi())) {
                kitapVeritabani.remove(j);
            }

        }
        

    }

    public void gosterKitaplar() {//kitapveritabani adli arraylist icindeki kitap verilerinin ekranda gosterilmesini saglayan metod.

        for (int j = 0; j < kitapVeritabani.size(); j++) {
            Kitap info = kitapVeritabani.get(j);

            System.out.println(info.getYazar() + ", " + info.getKitapIsmi() + ", " + info.getTur() + ", " + info.getISBN());//Cekilen verilerin ekranda gosterilmesi saglandı.
            System.out.println("---------------------------------------------Book : " + (j+1)  + "-----------------------------------------------------");

        }
    }
    //Overlload
    public void gosterKitaplar(String tur) {//kitapveritabani adli arraylist icindeki kitap verilerinin turlerine gore
        //ekranda gosterilmesini saglayan metod.

        for (int j = 0; j < kitapVeritabani.size(); j++) {
            Kitap info = kitapVeritabani.get(j);
            if (tur == null ? info.getTur() == null : tur.equals(info.getTur())) {

                System.out.println(info.getYazar() + ", " + info.getKitapIsmi() + ", " + info.getTur() + ", " + info.getISBN());//Cekilen verilerin ekranda gosterilmesi saglandı.
                System.out.println("---------------------------------------------Books : " + "-----------------------------------------------------");

            }
        }

    }

    public String gozatKitaplar(String tur) {//istenilen bir kitabın sistemde olup olmadgını kontol eden metod.
        String kitapVarmi = "";

        for (int j = 0; j < kitapVeritabani.size(); j++) {
            Kitap info = kitapVeritabani.get(j);
            if (tur == null ? info.getKitapIsmi() == null : tur.equals(info.getKitapIsmi())) {

                System.out.println(info.getYazar() + ", " + info.getKitapIsmi() + ", " + info.getTur() + ", " + info.getISBN());//Cekilen verilerin ekranda gosterilmesi saglandı.
                System.out.println("---------------------------------------------Books : " + "-----------------------------------------------------");
                kitapVarmi = info.getKitapIsmi();
            }

        }
        return kitapVarmi;// eger si

    }

    public void oduncAlKitap(String kitapIsmi) {//Kitap odunc alındıgında arraylisten kitabın silinmesini saaglayan metod.

        for (int j = 0; j < kitapVeritabani.size(); j++) {
            Kitap info = kitapVeritabani.get(j);
            if (kitapIsmi == null ? info.getKitapIsmi() == null : kitapIsmi.equals(info.getKitapIsmi())) {
                kitapVeritabani.remove(j);// remove metodu ile kitabın arraylisten silinmesi saglandı.
            }

        }
        for (int j = 0; j < kitapVeritabani.size(); j++) {
            Kitap info = kitapVeritabani.get(j);
            
            System.out.println(info.getYazar() + ", " + info.getKitapIsmi() + ", " + info.getTur() + ", " + info.getISBN());//Cekilen verilerin ekranda gosterilmesi saglandı.
            System.out.println("---------------------------------------------Books : " + (j + 1) + "-----------------------------------------------------");

        }

    }

    public void turEkle(String gelenTurAdi) {//Eklenmesi istenen kitap turunun eklenmesini saglayan metod.
        String[] temp_kitapTurleri = new String[kitapTurleri.length + 1];
        int i = 0;
        for (i = 0; i < kitapTurleri.length; i++) {//Yukarıda tanımlanan tur dizinin verilerini gosterdiketn sonra en son eklenmesi
            //istenen turun girmesi saglanmstır.
            temp_kitapTurleri[i] = kitapTurleri[i];
        }
        temp_kitapTurleri[i] = gelenTurAdi;

        kitapTurleri = new String[temp_kitapTurleri.length];
        kitapTurleri = temp_kitapTurleri;
    }

    public String turSay() {//Dizi icerisindeki verilerin ekranda gosterilmesini saglayan metod.
        String tempTurleri = "";
        for (int i = 0; i < kitapTurleri.length; i++) {
            tempTurleri += kitapTurleri[i] + "/";
        }
        tempTurleri += kitapTurleri.length + " adet tür vardır)";
        return tempTurleri;
    }

}
