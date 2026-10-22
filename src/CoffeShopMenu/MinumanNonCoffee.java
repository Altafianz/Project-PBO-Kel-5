package CoffeShopMenu;

public class MinumanNonCoffee extends Minuman {
    private boolean isSoda; // true = iya, false = tidak

    public MinumanNonCoffee(String nama, double harga, char ukuran, String jenisPenyajian, boolean isSoda) {
        super(nama, harga, ukuran, jenisPenyajian);
        this.isSoda = isSoda;
    }

    public boolean getIsSoda() {
        return isSoda;
    }

    @Override
    public String getJenis() {
        return "Minuman Non-Coffe";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Soda: " + (isSoda ? "Ya" : "Tidak"));
    }
}