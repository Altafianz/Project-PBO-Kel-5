package CoffeShopMenu;

public class Minuman extends Menu {
    private char ukuran;
    private String jenisPenyajian;

    public Minuman(String namaMenu, double harga, char ukuran, String jenisPenyajian) {
        super(namaMenu, harga);
        this.ukuran = ukuran;
        this.jenisPenyajian = jenisPenyajian;
    }

    public String getJenisPenyajian() {
        return jenisPenyajian;
    }

    public char getUkuran() {
        return ukuran;
    }

    @Override
    public String getJenis() {
        return "Minuman";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        IO.println("Ukuran: " + ukuran + " | " + jenisPenyajian);
    }

    @Override
    public double hitungHargaAkhir() {
        double dasar = super.hitungHargaAkhir();
        if (ukuran == 'L') return dasar + 5000;
        if (ukuran == 'S') return dasar - 3000;
        return dasar;
    }
}
