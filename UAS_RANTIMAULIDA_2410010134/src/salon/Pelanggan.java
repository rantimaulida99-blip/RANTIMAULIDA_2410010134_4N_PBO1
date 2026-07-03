package salon;

// 1. Class Pelanggan
public class Pelanggan {
    // 3. Atribut (7. Encapsulation: menggunakan akses private)
    private String nama;
    private String jenisTreatment;
    protected double hargaDasar; // protected agar bisa diakses child class

    // 4. Constructor
    public Pelanggan(String nama, String jenisTreatment, double hargaDasar) {
        this.nama = nama;
        this.jenisTreatment = jenisTreatment;
        this.hargaDasar = hargaDasar;
    }

    // 5. Mutator (Setter)
    public void setNama(String nama) {
        this.nama = nama;
    }

    // 6. Accessor (Getter)
    public String getNama() {
        return nama;
    }

    public String getJenisTreatment() {
        return jenisTreatment;
    }

    // 9. Polymorphism (Method awal yang akan di-override di child class)
    public double hitungTotalBiaya() {
        return hargaDasar;
    }
}