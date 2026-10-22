package CoffeShopMenu;

import java.util.ArrayList;

public class KelolaMenu {
    private ArrayList<Menu> daftar = new ArrayList<>();

    public void tambah(Menu menu) {
        daftar.add(menu);
    }

    public int ukuran() {
        return daftar.size();
    }

    // nomor mulai dari 1
    public Menu getMenu(int nomor) {
        if (nomor < 1 || nomor > daftar.size()) return null;
        return daftar.get(nomor - 1);
    }

    public boolean ubah(int nomor, Menu baru) {
        if (nomor < 1 || nomor > daftar.size()) return false;
        daftar.set(nomor - 1, baru);
        return true;
    }

    public boolean hapus(int nomor) {
        if (nomor < 1 || nomor > daftar.size()) return false;
        daftar.remove(nomor - 1);
        return true;
    }

    public void tampilkanSemua() {
        System.out.println("=== Daftar Menu ===");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada menu.");
            return;
        }
        int no = 1;
        for (Menu m : daftar) {
            System.out.println(no + ". [" + m.getJenis() + "]");
            m.tampilkanInfo();
            no++;
        }
    }

    public ArrayList<Makanan> getDaftarMakanan() {
        ArrayList<Makanan> hasil = new ArrayList<>();
        for (Menu m : daftar) {
            if (m instanceof Makanan) hasil.add((Makanan) m);
        }
        return hasil;
    }

    public ArrayList<Minuman> getDaftarMinuman() {
        ArrayList<Minuman> hasil = new ArrayList<>();
        for (Menu m : daftar) {
            if (m instanceof Minuman) hasil.add((Minuman) m);
        }
        return hasil;
    }
}
