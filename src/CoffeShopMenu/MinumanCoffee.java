package CoffeShopMenu;

public class MinumanCoffee extends Minuman {
    private String gula; // non / less / normal

    public MinumanCoffee(String nama, double harga, char ukuran, String jenisPenyajian, String gula) {
        super(nama, harga, ukuran, jenisPenyajian);
        this.gula = gula;
    }

    public String getGula() {
        return gula;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Gula: " + gula);
    }
}
