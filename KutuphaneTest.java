package testproje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Recep ÇETINKAYA   171513010
 *    Kutuphane Yönetim Projesi
 * 
 * Kutuphane clasında  olusturulan metodlar KutuphaneTest.java clasında calıstırılmaktadır.
 * Sistemin arayuz kısmı burada olusturulmaktadır.
 * Sistemde ayrıca Hata kontrolu de vardır. yanlıs deger girildiginde yada bos deger girildiginde ekrana hata gosterilmektedir. 
 * Yapılan islem sonunda islem basarıyla gerceklesmisse basarıyla tamamlandı islem basarıyla gerceklesemeimsse 
 * basarıyla taamamlanamadı seklinde ekranda System.err.println(); ile yazı yazdırılmaktadır.
 *
 * 
 */
public class KutuphaneTest {

    public static void main(String[] args) throws IOException {//Ana metod

        Kutuphane kutuphane = new Kutuphane();//Kutuphane clasında olusturulan metodları burada cagırmak icin
        //kutuphane adında nesne olusturulmustur.

        System.out.println("=====================================");
        System.out.println("       KÜTÜPHANEYE HOŞGELDİNİZ!");
        System.out.println("=====================================");

        String ad = "";
        String ogrNo = "";
        String sinif = "";

        InputStreamReader converter = new InputStreamReader(System.in);//Klavyeden girilen degerin klavye degiskenin atıllması.
        BufferedReader klavye = new BufferedReader(converter);

        while (true) {//Bos bir deger girildiginde sistemin dongu ile tekrar adını istemektedir.
            System.out.println("Lutfen Adınızı Giriniz:");
            ad = klavye.readLine();
            if (ad.length() == 0) {
                System.err.println("Boş giremezsiniz.");
            } else {
                break;
            }
        }


        
        System.out.println("Lütfen Klavyeden  Yöneticiyseniz (1)'i Kitap Ödünç Alıcaksanız (2)'i Giriniz");
        Boolean cevapBirmi = false;//Olusturulan boolean degerler 1 veya 2 nin dısındaki degerler girildiginde 
        Boolean cevapIkimi = false;//dongu ile tekrar kullanıcıdan deger girilmesi istenmektedir.
        while (cevapBirmi == false && cevapIkimi == false) {
            String cevap = klavye.readLine();
            cevapBirmi = cevap.toUpperCase().equals("1");
            cevapIkimi = cevap.toUpperCase().equals("2");
            if (cevapBirmi == true || cevapIkimi == true) {
                break;
            } else {
                System.err.println("Yanlıs Sayı Girdiniz:");
            }
        }
        if (cevapBirmi) {
            System.out.println("");
            System.out.println("Lutfen Yapmak İstediğiniz İşlemi Seçiniz");
            while (true) {

                System.out.println("A)Kitap Ekle, B)Kitap Sil,C)Tür Ekle,  D)Kişileri Göster E)Ögrencileri Göster F)Quit ");
                String rpl = klavye.readLine();
                if ((rpl.toUpperCase()).equals("A")) {
                    System.out.println("Lutfen Yazar İsmi Giriniz:");
                    String yazar = klavye.readLine();
                    System.out.println("Lutfen Kitap İsmi Giriniz:");
                    String kitapIsmi = klavye.readLine();
                    System.out.println("Lutfen Tür Giriniz:");
                    String tur = klavye.readLine();
                    System.out.println("Lutfen ISBN no Giriniz:");
                    String ISBN = klavye.readLine();

                    kutuphane.ekleKitap(yazar, kitapIsmi, tur, ISBN);
                    System.err.println("Kitap Eklendi.");
                    kutuphane.gosterKitaplar();//Kitapplar ekrana gosterilmektedir

                } else if ((rpl.toUpperCase()).equals("B")) {
                    System.out.println("Lutfen Silmek İstediğiniz Kitabın İsmini Giriniz");
                    String sil = klavye.readLine();
                    System.err.println("Kitap Silindi.");
                    kutuphane.silKitap(sil);//İstenilen bir kitap sistemden silinmektedir.

                } else if ((rpl.toUpperCase()).equals("C")) {
                    System.out.println("Lutfen Kitap Türünün Adını Giriniz");

                    String tur = klavye.readLine();
                    kutuphane.turEkle(tur);
                    System.err.println("Tür eklendi: " + kutuphane.turSay());
                } else if ((rpl.toUpperCase()).equals("D")) {
                    System.err.println("Veritabanında Bulunan  Kişiler");
                    kutuphane.gosterKisiOdunc();
                } else if ((rpl.toUpperCase()).equals("E")) {
                    System.err.println("Veritabanında Bulunan  Kişiler");
                    kutuphane.gosterOgrenciOdunc();
                } else if ((rpl.toUpperCase()).equals("F")) {
                    System.err.println("Program Sonlandırıldı.");
                    break;
                }
               System.gc(); //Sistemde daha once olusturulan nesnelerin silşnmesne yarayan garbage collector
            }
        }  else if (cevapIkimi) {
            System.out.println("Ögrenci Misiniz? (E)/(H)");
            String rpl = klavye.readLine();
            if ((rpl.toUpperCase()).equals("E")) {
                System.out.println("Lütfen Öğrenci Numaranızı Giriniz:");
                ogrNo = klavye.readLine();

                System.out.println("Lütfen Sınıf Giriniz:");
                sinif = klavye.readLine();

                while (true) {
                    System.out.println("");
                    System.out.println("Lutfen Yapmak İstediğiniz İşlemi Giriniz: :>  ");
                    System.out.println(" A)Gözat, B)Kitap Ödünç Al, C)Kitap Kontrol Et D)Quit ");
                    String cvp = klavye.readLine();
                    if ((cvp.toUpperCase()).equals("A")) {

                        System.out.println("Lütfen Kitap Türü Giriniz:(" + kutuphane.turSay() + ")");
                        String turBak = klavye.readLine();
                        System.err.println("Kitaplar Bulundu.");
                        kutuphane.gosterKitaplar(turBak);

                    } else if ((cvp.toUpperCase()).equals("B")) {
                        kutuphane.ekleOgrenciOdunc(ad, ogrNo, sinif);
                        System.out.println("Lütfen Ödünç Almak İstediğiniz Kitap ismi Giriniz:");
                        String turBak = klavye.readLine();
                        System.err.println("Kitap Ödünç Alındı.");
                        kutuphane.oduncAlKitap(turBak);

                    } else if ((cvp.toUpperCase()).equals("C")) {
                        System.out.println("Lütfen  Kitap ismi Giriniz:");
                        String turBak = klavye.readLine();
                        
                       if( "".equals(kutuphane.gozatKitaplar(turBak)))
                       {
                           System.err.println("Kitap BULUNAMADI");
                       }
                       else
                       {
                           System.err.println("Kitap BULUNDU.");
                           
                       }

                    } else if ((cvp.toUpperCase()).equals("D")) {
                        System.err.println("Program Sonlandırıldı.");
                        break;
                    }
                System.gc();
                }
                
            }  else if ((rpl.toUpperCase()).equals("H")) {
                while (true) {
                    System.out.println("");
                    System.out.println("Lutfen Yapmak İstediğiniz İşlemi Giriniz: :>  ");
                    System.out.println(" A)Gözat, B)Kitap Ödünç Al, C)Kitap Kontrol Et  D)Quit ");
                    String reply = klavye.readLine();
                    if ((reply.toUpperCase()).equals("A")) {
                        System.out.println("Lütfen Kitap Türü Giriniz:");
                        String turBak = klavye.readLine();
                        kutuphane.gosterKitaplar(turBak);
                    } else if ((reply.toUpperCase()).equals("B")) {
                        kutuphane.ekleKisiOdunc(ad);
                        System.out.println("Lütfen Ödünç Almak İstediğiniz Kitap ismi Giriniz:");
                        String odnc = klavye.readLine();
                        kutuphane.oduncAlKitap(odnc);
                        System.err.println("Kitap Ödünç Alındı.");
                    } else if ((reply.toUpperCase()).equals("C")) {
                        System.out.println("Lütfen  Kitap ismi Giriniz:");
                        String turBak = klavye.readLine();
                        kutuphane.gozatKitaplar(turBak);
                    } else if ((reply.toUpperCase()).equals("D")) {
                        System.err.println("Program Sonlandırıldı.");
                        break;
                    }
                System.gc();
                }
            }
        } else {
            System.err.println("Yanlıs Sayı Girdiniz:");
        }
System.gc();
    }
}
