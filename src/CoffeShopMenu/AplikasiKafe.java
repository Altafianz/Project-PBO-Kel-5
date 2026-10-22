package CoffeShopMenu;

public class AplikasiKafe {
    public static void main(String[] args) {
        InputUtil in = new InputUtil();
        KelolaMenu kelolaMenu = new KelolaMenu();
        KelolaPesanan kelolaPesanan = new KelolaPesanan();

        // data awal untuk demo
        kelolaMenu.tambah(new Makanan("Nasi Goreng", 25000, "Gurih", "Sedang"));
        kelolaMenu.tambah(new Makanan("Roti Bakar", 15000, "Manis", "Kecil"));
        kelolaMenu.tambah(new MinumanCoffee("Latte", 22000, 'M', "Dingin", "normal"));
        kelolaMenu.tambah(new MinumanNonCoffee("Lemon Soda", 18000, 'M', "Dingin", true));

        MenuAdmin admin = new MenuAdmin(in, kelolaMenu);
        MenuKonsumen konsumen = new MenuKonsumen(in, kelolaMenu, kelolaPesanan);

        while (true) {
            System.out.println();
            System.out.println("=== Coffee Shop Kel 5 ===");
            System.out.println("1. Admin");
            System.out.println("2. Konsumen");
            System.out.println("0. Keluar");
            int pilih = in.bacaInt("Masuk sebagai: ");

            if (pilih == 1) admin.jalankan();
            else if (pilih == 2) konsumen.jalankan();
            else if (pilih == 0) {
                System.out.println("Terima kasih.");
                return;
            } else System.out.println("Pilihan tidak valid.");
        }
    }
}
