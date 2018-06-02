package testproje;

/**
 *
 * @author Recep Çetinkaya 171513010
 *  Kutuphane Yonetim Projesi
 * 
 * Bu classta kitap icin gerekli degiskenler tanımlanmştır. Set-Get metodlarıyla degiskenlere veri aktarılması saglanmıstır.
 * Kitap classında yazar,kitapismi,tur,ISBN adında 4 farklı degisken contructor icinde tanımlanmıstır.
 * 
 * 
 */
class Kitap {
//degiskenler private olarak tanımlanmıstır
    private String yazar;
    private String kitapIsmi;
    private String ISBN;
    private String tur;
//Kitap clası adıla nesne olusturuldugunda nesnenin parametresiz de calısabilmesi icin ayrıca no-parameter constructor 
    //tanımlanmıstır.
    public Kitap() {

    }
//4 parametleri constructor tanımlanmıstır.
    public Kitap(String yazar, String kitapIsmi, String tur, String ISBN) {
        this.yazar = yazar;
        this.kitapIsmi = kitapIsmi;
        this.tur = tur;
        this.ISBN = ISBN;

    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getKitapIsmi() {
        return kitapIsmi;
    }

    public void setKitapIsmi(String kitapIsmi) {
        this.kitapIsmi = kitapIsmi;
    }

    public String getTur() {
        return tur;

    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
