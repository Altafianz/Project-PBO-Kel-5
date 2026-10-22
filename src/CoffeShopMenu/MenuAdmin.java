package CoffeShopMenu;

public class MenuAdmin {
    private InputUtil in;
    private KelolaMenu kelolaMenu;

    public MenuAdmin(InputUtil in, KelolaMenu kelolaMenu) {
        this.in = in;
        this.kelolaMenu = kelolaMenu;
    }

    public void jalankan() {
        while (true) {
            System.out.println();
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Tambah menu");
            System.out.println("2. Lihat menu");
            System.out.println("3. Ubah menu");
            System.out.println("4. Hapus menu");
            System.out.println("0. Kembali");
            int pilih = in.bacaInt("Pilih: ");

            if (pilih == 1) tambahMenu();
            else if (pilih == 2) kelolaMenu.tampilkanSemua();
            else if (pilih == 3) ubahMenu();
            else if (pilih == 4) hapusMenu();
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid.");
        }
    }

    private Menu buatMenuBaru() {
        System.out.println("Jenis menu:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman Coffee");
        System.out.println("3. Minuman Non-Coffee");
        int jenis = in.bacaInt("Pilih jenis: ");
        while (jenis < 1 || jenis > 3) {
            System.out.println("Pilihan tidak valid.");
            jenis = in.bacaInt("Pilih jenis: ");
        }

        String nama = in.bacaTeks("Nama menu: ");
        double harga = in.bacaHarga("Harga: ");

        if (jenis == 1) {
            String rasa = in.bacaTeks("Kategori rasa: ");
            String porsi = in.bacaTeks("Porsi: ");
            return new Makanan(nama, harga, rasa, porsi);
        }

        char ukuran = in.bacaUkuran("Ukuran (S/M/L): ");
        String penyajian = in.bacaPilihan("Penyajian (Panas/Dingin): ", "Panas", "Dingin");

        if (jenis == 2) {
            String gula = in.bacaPilihan("Gula (non/less/normal): ", "non", "less", "normal");
            return new MinumanCoffee(nama, harga, ukuran, penyajian, gula);
        }

        boolean soda = in.bacaYaTidak("Mengandung soda");
        return new MinumanNonCoffee(nama, harga, ukuran, penyajian, soda);
    }

    private void tambahMenu() {
        Menu baru = buatMenuBaru();
        kelolaMenu.tambah(baru);
        System.out.println("Menu berhasil ditambah.");
    }

    private void ubahMenu() {
        if (kelolaMenu.ukuran() == 0) {
            System.out.println("Belum ada menu.");
            return;
        }
        kelolaMenu.tampilkanSemua();
        int nomor = in.bacaInt("Nomor menu yang diubah: ");
        Menu lama = kelolaMenu.getMenu(nomor);
        if (lama == null) {
            System.out.println("Nomor tidak ditemukan.");
            return;
        }

        System.out.println("1. Ubah harga saja");
        System.out.println("2. Ganti seluruh data");
        int pilih = in.bacaInt("Pilih: ");

        if (pilih == 1) {
            double hargaBaru = in.bacaHarga("Harga baru: ");
            lama.setHarga(hargaBaru);
            System.out.println("Harga berhasil diubah.");
        } else if (pilih == 2) {
            Menu baru = buatMenuBaru();
            kelolaMenu.ubah(nomor, baru);
            System.out.println("Menu berhasil diganti.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private void hapusMenu() {
        if (kelolaMenu.ukuran() == 0) {
            System.out.println("Belum ada menu.");
            return;
        }
        kelolaMenu.tampilkanSemua();
        int nomor = in.bacaInt("Nomor menu yang dihapus: ");
        Menu m = kelolaMenu.getMenu(nomor);
        if (m == null) {
            System.out.println("Nomor tidak ditemukan.");
            return;
        }
        if (in.bacaYaTidak("Hapus " + m.getNamaMenu() + "?")) {
            kelolaMenu.hapus(nomor);
            System.out.println("Menu berhasil dihapus.");
        }
    }
}
