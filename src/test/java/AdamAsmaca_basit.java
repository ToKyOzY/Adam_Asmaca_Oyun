import java.util.Random;
import java.util.Scanner;

public class AdamAsmaca_basit {
    public static void main(String[] args) {

        String[] kelimeler = {"Java", "Python", "Kotlin", "Javascript", "Csharp"};
        Random rastgele = new Random();
        int kelimeIndex = rastgele.nextInt(kelimeler.length);
        String kelime = kelimeler[kelimeIndex].toLowerCase();
        String gizliKelime = kelime.replaceAll(".", "_ ");
        int hak = 6;
        Scanner input = new Scanner(System.in);

        while (hak > 0 && gizliKelime.contains("_")) {
            System.out.println(gizliKelime);
            System.out.println("Kalan Hak: " + hak);
            System.out.print("Harf tahmininizi girin: ");
            String harf = input.next().toLowerCase();
            if (kelime.contains(harf)) {
                for (int i = 0; i < kelime.length(); i++) {
                    if (kelime.charAt(i) == harf.charAt(0)) {
                        gizliKelime = gizliKelime.substring(0, 2 * i) + harf.charAt(0) + gizliKelime.substring(2 * i + 1);
                    }
                }
            } else {
                hak--;
                System.out.println("Yanlış tahmin!");
            }
        }

        if (hak == 0) {
            System.out.println("Oyun bitti! Kelime: " + kelime);
        } else {
            System.out.println("Tebrikler, kelimeyi doğru tahmin ettiniz: " + kelime);
        }
    }
}
