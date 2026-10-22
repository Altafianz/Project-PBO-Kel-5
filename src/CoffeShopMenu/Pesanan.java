package CoffeShopMenu;

public class Pesanan {
    private Makanan makanan;
    private Minuman minuman;
    private String kodePesanan;
    private int jumlahMakanan;
    private int jumlahMinuman;

    private static int jumlahPesanan = 0;
    public static final double PAJAK = 0.2;

    public Pesanan(String kode, Makanan makanan, int jmlMakanan, Minuman minuman, int jmlMinuman) {
        this.kodePesanan = kode;
        this.makanan = makanan;
        setJumlahMakanan(jmlMakanan);
        this.minuman = minuman;
        setJumlahMinuman(jmlMinuman);
        jumlahPesanan++;
    }

    public Pesanan(String kode, Makanan makanan, int jmlMakanan) {
        this.kodePesanan = kode;
        this.makanan = makanan;
        setJumlahMakanan(jmlMakanan);
        jumlahPesanan++;
    }

    public Pesanan(String kode, Minuman minuman, int jmlMinuman) {
        this.kodePesanan = kode;
        this.minuman = minuman;
        setJumlahMinuman(jmlMinuman);
        jumlahPesanan++;
    }

    public static int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahMakanan(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah Tidak Valid!");
            return;
        }
        this.jumlahMakanan = jumlah;
    }

    public void setJumlahMinuman(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah Tidak Valid!");
            return;
        }
        this.jumlahMinuman = jumlah;
    }

    public void tampilkanInfo() {
        double subtotal = 0;

        System.out.println("=== Pesanan " + kodePesanan + " ===");
        if (makanan != null) {
            double total = makanan.hitungHargaAkhir() * jumlahMakanan;
            subtotal += total;
            System.out.println("Makanan : " + makanan.getNamaMenu()
                    + " (" + makanan.getKategoriRasa() + ", " + makanan.getPorsi() + ")"
                    + " x" + jumlahMakanan + " = " + total);
        }
        if (minuman != null) {
            double total = minuman.hitungHargaAkhir() * jumlahMinuman;
            subtotal += total;
            System.out.println("Minuman : " + minuman.getNamaMenu()
                    + " (" + minuman.getUkuran() + ", " + minuman.getJenisPenyajian() + ")"
                    + " x" + jumlahMinuman + " = " + total);
        }

        double pajak = subtotal * PAJAK;
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Pajak   : " + pajak);
        System.out.println("Total   : " + (subtotal + pajak));
    }
}