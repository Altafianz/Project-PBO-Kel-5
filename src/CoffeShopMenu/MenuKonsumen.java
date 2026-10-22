package CoffeShopMenu;

import java.util.ArrayList;

public class MenuKonsumen {
    private InputUtil in;
    private KelolaMenu kelolaMenu;
    private KelolaPesanan kelolaPesanan;

    public MenuKonsumen(InputUtil in, KelolaMenu kelolaMenu, KelolaPesanan kelolaPesanan) {
        this.in = in;
        this.kelolaMenu = kelolaMenu;
        this.kelolaPesanan = kelolaPesanan;
    }

    public void jalankan() {
        while (true) {
            System.out.println();
            System.out.println("=== Menu Konsumen ===");
            System.out.println("1. Lihat menu");
            System.out.println("2. Pesan");
            System.out.println("3. Cek kode pesanan");
            System.out.println("0. Kembali");
            int pilih = in.bacaInt("Pilih: ");

            if (pilih == 1) kelolaMenu.tampilkanSemua();
            else if (pilih == 2) buatPesanan();
            else if (pilih == 3) cekPesanan();
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid.");
        }
    }

    private void buatPesanan() {
        ArrayList<Makanan> listMakanan = kelolaMenu.getDaftarMakanan();
        ArrayList<Minuman> listMinuman = kelolaMenu.getDaftarMinuman();

        if (listMakanan.isEmpty() && listMinuman.isEmpty()) {
            System.out.println("Belum ada menu yang bisa dipesan.");
            return;
        }

        Makanan makanan = null;
        int jmlMakanan = 0;
        Minuman minuman = null;
        int jmlMinuman = 0;

        // pilih makanan
        if (!listMakanan.isEmpty()) {
            System.out.println("--- Makanan ---");
            for (int i = 0; i < listMakanan.size(); i++) {
                System.out.println((i + 1) + ".");
                listMakanan.get(i).tampilkanInfo();
            }
            int no = in.bacaInt("Nomor makanan (0 = lewati): ");
            while (no < 0 || no > listMakanan.size()) {
                System.out.println("Nomor tidak valid.");
                no = in.bacaInt("Nomor makanan (0 = lewati): ");
            }
            if (no > 0) {
                makanan = listMakanan.get(no - 1);
                jmlMakanan = bacaJumlah("Jumlah makanan: ");
            }
        }

        // pilih minuman
        if (!listMinuman.isEmpty()) {
            System.out.println("--- Minuman ---");
            for (int i = 0; i < listMinuman.size(); i++) {
                System.out.println((i + 1) + ". [" + listMinuman.get(i).getJenis() + "]");
                listMinuman.get(i).tampilkanInfo();
            }
            int no = in.bacaInt("Nomor minuman (0 = lewati): ");
            while (no < 0 || no > listMinuman.size()) {
                System.out.println("Nomor tidak valid.");
                no = in.bacaInt("Nomor minuman (0 = lewati): ");
            }
            if (no > 0) {
                minuman = listMinuman.get(no - 1);
                jmlMinuman = bacaJumlah("Jumlah minuman: ");
            }
        }

        if (makanan == null && minuman == null) {
            System.out.println("Pesanan dibatalkan. Tidak ada item dipilih.");
            return;
        }

        String kode = kelolaPesanan.buatKodeBaru();
        Pesanan pesanan;
        if (makanan != null && minuman != null) {
            pesanan = new Pesanan(kode, makanan, jmlMakanan, minuman, jmlMinuman);
        } else if (makanan != null) {
            pesanan = new Pesanan(kode, makanan, jmlMakanan);
        } else {
            pesanan = new Pesanan(kode, minuman, jmlMinuman);
        }

        kelolaPesanan.simpan(kode, pesanan);
        System.out.println();
        System.out.println("Pesanan berhasil. Kode pesanan Anda: " + kode);
        pesanan.tampilkanInfo();
    }

    private int bacaJumlah(String pesan) {
        int jml = in.bacaInt(pesan);
        while (jml <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            jml = in.bacaInt(pesan);
        }
        return jml;
    }

    private void cekPesanan() {
        String kode = in.bacaTeks("Masukkan kode pesanan: ");
        Pesanan p = kelolaPesanan.cari(kode);
        if (p == null) {
            System.out.println("Kode pesanan tidak ditemukan.");
            return;
        }
        p.tampilkanInfo();
    }
}
