package CoffeShopMenu;

public class Makanan extends Menu {
    private String kategoriRasa;
    private String porsi;

    public Makanan (String namaMenu, double harga, String kategoriRasa, String porsi) {
        super(namaMenu, harga);
        this.kategoriRasa = kategoriRasa;
        this.porsi = porsi;
    }

    public String getKategoriRasa() {
        return kategoriRasa;
    }

    public String getPorsi() {
        return porsi;
    }

    @Override 
    public String getJenis() {
        return "Makanan";
    }

    @Override 
    public void tampilkanInfo() {
        super.tampilkanInfo();
        IO.println("Rasa: " + kategoriRasa + " | Porsi " + porsi);
    }
}
