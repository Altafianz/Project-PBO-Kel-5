package CoffeShopMenu;

public class Menu {
    private String namaMenu;
    private double harga;

    public Menu(String namaMenu, double harga) {
        this.namaMenu = namaMenu;
        setHarga(harga);
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public double getHarga() {
        return harga;
    }

    public String getJenis() {
        return "Menu";
    }

    public void setHarga(double hargaMenu) {
        if (hargaMenu >= 0) {
            this.harga = hargaMenu;
        } else {
            System.out.println("Harga Tidak Valid!");
        }
    }
    
    public double hitungHargaAkhir() {
        return harga;
    }

    public void tampilkanInfo() {
        IO.println(namaMenu + " | Harga: " + harga);
    }
}


