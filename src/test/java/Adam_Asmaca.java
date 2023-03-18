import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adam_Asmaca {
    private static final String[] KELIMELER = {"JAVADERSLERI", "PROGRAMLAMA", "BILGISAYAR", "ALGORITMA", "KODLAMA"};
    private static final int MAX_HAK = 6;
    private static final String RESIMLER = "-------\n" +
            "|     |\n" +
            "|     O\n" +
            "|    /|\\\n" +
            "|    / \\\n" +
            "|\n" +
            "|\n" +
            "|\n" +
            "-------\n";
    private static final String YANITLAR = "abcdefghijklmnopqrstuvwxyzçğıöü";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String kelime = KELIMELER[(int) (Math.random() * KELIMELER.length)];
        char[] kelimeDizisi = new char[kelime.length()];
        boolean[] tahminEdilen = new boolean[26];
        int kalanHak = MAX_HAK;
        List<Character> yanlisHarfler = new ArrayList<>();

        for (int i = 0; i < kelimeDizisi.length; i++) {
            kelimeDizisi[i] = '_';
        }

        while (kalanHak > 0 && kelime.contains("_")) {
            System.out.println("Kelime: " + String.valueOf(kelimeDizisi));
            System.out.println("Kalan Hak: " + kalanHak);
            System.out.println("Yanlış Tahminler: " + yanlisHarfler);

            System.out.print("Bir harf girin: ");
            String str = input.nextLine().toLowerCase();
            char harf = str.charAt(0);

            if (!YANITLAR.contains(String.valueOf(harf))) {
                System.out.println("Geçersiz giriş! Lütfen harf veya Türkçe karakter giriniz.");
                continue;
            }

            if (tahminEdilen[harf - 'a']) {
                System.out.println("Bu harfi zaten girdiniz!");
                continue;
            }

            tahminEdilen[harf - 'a'] = true;

            if (kelime.indexOf(harf) == -1) {
                kalanHak--;
                yanlisHarfler.add(harf);
                System.out.println(harf + " harfi kelime içinde bulunamadı.");

                if (kalanHak == 0) {
                    System.out.println("Oyun bitti, kelime: " + kelime);
                    System.out.println(RESIMLER);
                    break;
                }
            } else {
                for (int i = 0; i < kelime.length(); i++) {
                    if (kelime.charAt(i) == harf) {
                        kelimeDizisi[i] = harf;
                    }
                }

                if (!String.valueOf(kelimeDizisi).contains("_")) {
                    System.out.println("Tebrikler, kelimeyi buldunuz: " + kelime);
                    System.out.println(RESIMLER);
                    break;
                }
            }

            System.out.println(RESIMLER.split("\n")[MAX_HAK - kalanHak]);
        }
    }
}

