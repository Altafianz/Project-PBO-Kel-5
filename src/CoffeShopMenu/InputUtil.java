package CoffeShopMenu;

import java.util.Scanner;

public class InputUtil {
    private Scanner sc = new Scanner(System.in);

    public String bacaTeks(String pesan) {
        System.out.print(pesan);
        return sc.nextLine().trim();
    }

    public int bacaInt(String pesan) {
        while (true) {
            String s = bacaTeks(pesan);
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka bulat.");
            }
        }
    }

    public double bacaHarga(String pesan) {
        while (true) {
            String s = bacaTeks(pesan);
            try {
                double h = Double.parseDouble(s);
                if (h >= 0) return h;
                System.out.println("Harga tidak boleh negatif.");
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka.");
            }
        }
    }

    public char bacaUkuran(String pesan) {
        while (true) {
            String s = bacaTeks(pesan).toUpperCase();
            if (s.equals("S") || s.equals("M") || s.equals("L")) {
                return s.charAt(0);
            }
            System.out.println("Ukuran harus S, M, atau L.");
        }
    }

    public String bacaPilihan(String pesan, String... opsi) {
        while (true) {
            String s = bacaTeks(pesan).toLowerCase();
            for (String o : opsi) {
                if (s.equals(o.toLowerCase())) return o;
            }
            System.out.println("Pilihan tidak valid.");
        }
    }

    public boolean bacaYaTidak(String pesan) {
        while (true) {
            String s = bacaTeks(pesan + " (y/n): ").toLowerCase();
            if (s.equals("y")) return true;
            if (s.equals("n")) return false;
            System.out.println("Ketik y atau n.");
        }
    }
}
