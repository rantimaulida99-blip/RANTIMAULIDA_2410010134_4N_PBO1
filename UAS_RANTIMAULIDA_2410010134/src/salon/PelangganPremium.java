package salon;

// 8. Inheritance: PelangganPremium mewarisi Pelanggan
public class PelangganPremium extends Pelanggan {
    private double diskonMember = 0.15; // Diskon 15% untuk member premium

    // Constructor Child Class
    public PelangganPremium(String nama, String jenisTreatment, double hargaDasar) {
        super(nama, jenisTreatment, hargaDasar);
    }

    // 9. Polymorphism: Override method dari parent class untuk menghitung diskon
    @Override
    public double hitungTotalBiaya() {
        return hargaDasar - (hargaDasar * diskonMember);
    }
}