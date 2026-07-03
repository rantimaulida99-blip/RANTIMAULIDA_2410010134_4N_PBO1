# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data pemesanan (booking) salon menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa nama pelanggan, pilihan treatment yang tersedia, serta status keanggotaan member premium. Output dari aplikasi ini berupa nota booking detail yang berisi informasi nama, treatment yang dipilih, beserta total biaya setelah dikalkulasikan (termasuk potongan diskon jika pelanggan merupakan member premium).

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overriding (Polymorphism), Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Pelanggan`, `PelangganPremium`, dan `MainSalon` adalah contoh dari class.

```java
public class Pelanggan {
    ...
}

public class PelangganPremium extends Pelanggan {
    ...
}

public class MainSalon {
    ...
}
```


2. **Object** adalah instance dari class. Pada kode ini, pembentukan object dinamis dilakukan berdasarkan kondisi seleksi member, contoh pembuatan object:

```java
pelanggan = new PelangganPremium(nama, treatmentTerpilih, hargaTerpilih);
// atau
pelanggan = new Pelanggan(nama, treatmentTerpilih, hargaTerpilih);
```


3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, nama, jenisTreatment, hargaDasar, dan diskonMember adalah contoh atribut.
   
```java
private String nama;
private String jenisTreatment;
protected double hargaDasar;
private double diskonMember = 0.15;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class Pelanggan dan PelangganPremium.

```java
public Pelanggan(String nama, String jenisTreatment, double hargaDasar) {
    this.nama = nama;
    this.jenisTreatment = jenisTreatment;
    this.hargaDasar = hargaDasar;
}

public PelangganPremium(String nama, String jenisTreatment, double hargaDasar) {
    super(nama, jenisTreatment, hargaDasar);
}

public MahasiswaDetail(String nama, String npm) {
    super(nama, npm);
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, setNama adalah contoh method mutator.

```java
public void setNama(String nama) {
    this.nama = nama;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, getNama dan getJenisTreatment adalah contoh method accessor.

```java
public String getNama() {
    return nama;
}

public String getJenisTreatment() {
    return jenisTreatment;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut seperti nama dan jenisTreatment dienkapsulasi menggunakan hak akses private.

```java
private String nama;
private String jenisTreatment;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, PelangganPremium mewarisi Pelanggan dengan sintaks extends.

```java
public class PelangganPremium extends Pelanggan {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Pada kode ini, polymorphism diterapkan dalam bentuk Overriding, di mana method hitungTotalBiaya() pada parent class (Pelanggan) ditulis ulang pada child class (PelangganPremium) untuk menghitung potongan harga diskon member.

```java
// Di dalam class Pelanggan (Parent)
public double hitungTotalBiaya() {
    return hargaDasar;
}

// Di dalam class PelangganPremium (Child)
@Override
public double hitungTotalBiaya() {
    return hargaDasar - (hargaDasar * diskonMember);
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi if untuk validasi nomor menu treatment dan penentuan instansiasi tipe objek pelanggan (Premium / Reguler).
```java
if (pilihan < 1 || pilihan > 3) {
    System.out.println("Pilihan treatment tidak valid!");
    return;
}

if (statusMember == 'y') {
    pelanggan = new PelangganPremium(nama, treatmentTerpilih, hargaTerpilih);
} else {
    pelanggan = new Pelanggan(nama, treatmentTerpilih, hargaTerpilih);
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop for untuk menampilkan daftar menu treatment dari Array.
```java
for (int i = 0; i < daftarTreatment.length; i++) {
    System.out.println(daftarTreatment[i]);
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class Scanner untuk menerima input data booking dan method System.out.println untuk menampilkan output Nota Booking Salon.
```java
Scanner input = new Scanner(System.in);
System.out.print("Masukkan Nama Pelanggan: ");
String nama = input.nextLine();

System.out.println("Nama Pelanggan  : " + pelanggan.getNama());
System.out.println("Total Biaya     : Rp " + pelanggan.hitungTotalBiaya());
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel dengan tipe data yang sama. Pada kode ini, daftarTreatment dan hargaTreatment adalah contoh penggunaan array.
```java
String[] daftarTreatment = {"1. Hair Cut & Wash (Rp 50.000)", "2. Hair Spa & Vitamin (Rp 120.000)", "3. Coloring Premium (Rp 250.000)"};
double[] hargaTreatment = {50000, 120000, 250000};
```

14. **Error Handling** digunakan untuk menangani error (exception) yang mungkin terjadi saat runtime agar program tidak berhenti paksa. Pada kode ini, digunakan try-catch-finally dengan InputMismatchException untuk mengantisipasi jika pengguna salah memasukkan huruf pada input nomor pilihan treatment yang seharusnya angka.
```java
try {
    // code yang berpotensi menimbulkan error input
} catch (InputMismatchException e) {
    System.out.println("Terjadi Kesalahan: Input harus berupa angka yang valid!");
} finally {
    input.close();
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Ranti Maulida
NPM: 2410010134
