package salon;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainSalon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 13. Array untuk menyimpan daftar treatment yang tersedia
        String[] daftarTreatment = {"1. Hair Cut & Wash (Rp 50.000)", "2. Hair Spa & Vitamin (Rp 120.000)", "3. Coloring Premium (Rp 250.000)"};
        double[] hargaTreatment = {50000, 120000, 250000};

        System.out.println("=== GLOWCARE SALON BOOKING SYSTEM ===");
        
        // 14. Error Handling: Mengantisipasi kesalahan input dari user
        try {
            System.out.print("Masukkan Nama Pelanggan: ");
            String nama = input.nextLine();

            System.out.println("\nPilihan Treatment:");
            // 11. Perulangan: Menampilkan daftar menu dari Array
            for (int i = 0; i < daftarTreatment.length; i++) {
                System.out.println(daftarTreatment[i]);
            }

            System.out.print("Pilih nomor treatment (1-3): ");
            int pilihan = input.nextInt();

            // 10. Seleksi: Validasi pilihan menu
            if (pilihan < 1 || pilihan > 3) {
                System.out.println("Pilihan treatment tidak valid!");
                return;
            }

            // Mengambil data berdasarkan indeks array (pilihan - 1)
            String treatmentTerpilih = daftarTreatment[pilihan - 1];
            double hargaTerpilih = hargaTreatment[pilihan - 1];

            System.out.print("Apakah pelanggan memiliki Member Premium? (y/n): ");
            char statusMember = input.next().toLowerCase().charAt(0);

            // 2. Object & 10. Seleksi Polimorfisme
            Pelanggan pelanggan;
            if (statusMember == 'y') {
                // Instansiasi Object Premium
                pelanggan = new PelangganPremium(nama, treatmentTerpilih, hargaTerpilih);
            } else {
                // Instansiasi Object Reguler
                pelanggan = new Pelanggan(nama, treatmentTerpilih, hargaTerpilih);
            }

            // 12. IO Sederhana: Output Hasil Booking
            System.out.println("\n=====================================");
            System.out.println("       NOTA BOOKING GLOWCARE SALON   ");
            System.out.println("=====================================");
            System.out.println("Nama Pelanggan  : " + pelanggan.getNama());
            System.out.println("Treatment       : " + pelanggan.getJenisTreatment());
            System.out.println("Total Biaya     : Rp " + pelanggan.hitungTotalBiaya());
            System.out.println("=====================================");

        } catch (InputMismatchException e) {
            // Menangkap error jika user memasukkan huruf pada input yang harusnya angka
            System.out.println("Terjadi Kesalahan: Input harus berupa angka yang valid!");
        } finally {
            input.close();
        }
    }
}