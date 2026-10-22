package CoffeShopMenu;

import java.util.LinkedHashMap;

public class KelolaPesanan {
    private LinkedHashMap<String, Pesanan> daftar = new LinkedHashMap<>();

    // dipanggil sebelum objek Pesanan dibuat
    public String buatKodeBaru() {
        return String.format("P%03d", Pesanan.getJumlahPesanan() + 1);
    }

    public void simpan(String kode, Pesanan pesanan) {
        daftar.put(kode, pesanan);
    }

    public Pesanan cari(String kode) {
        return daftar.get(kode.toUpperCase());
    }
}
