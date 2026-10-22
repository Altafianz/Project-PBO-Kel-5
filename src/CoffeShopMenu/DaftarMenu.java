package CoffeShopMenu;

import java.util.ArrayList;

public class DaftarMenu {
    private ArrayList<Menu> daftar = new ArrayList<>();

    public void tambahMenu(Menu menu) {
        daftar.add(menu);
    }

    public void tampilkanDaftarMenu() {
        System.out.println("=== Daftar Menu ===");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada menu.");
            return;
        }
        int no = 1;
        for (Menu m : daftar) {
            System.out.println(no + ". [" + m.getJenis() + "]");
            m.tampilkanInfo();   // versi yang dipanggil menyesuaikan jenis objeknya
            no++;
        }
    }
}
