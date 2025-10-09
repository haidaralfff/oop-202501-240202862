# Laporan Praktikum Minggu 1 (2)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Haidar Habibi Al Farisi
- NIM   : 240202862
- Kelas : 3IKRA

---

## Tujuan
(Tuliskan tujuan praktikum minggu ini.  
 *Penerapan Konsep Class, Object, dan Enkapsulasi dalam Pemrograman Berorientasi Objek (OOP) menggunakan Java*)

---

## Dasar Teori
(ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
 
1. Class merupakan cetakan atau rancangan untuk membuat objek.
Di dalam class berisi atribut (variabel) dan method (fungsi) yang menggambarkan perilaku suatu objek.  
2. Atribut (data member): kode, nama, harga, stok
Method (perilaku): tambahStok(), kurangiStok(), getNama(), setHarga(), dsb. 
3. Class MainProduk adalah program utama yang menggunakan blueprint Produk dan CreditBy untuk membuat objek nyata dan menjalankannya.
4. Objek adalah hasil nyata yang dibuat dari class. Setiap objek punya data sendiri sesuai blueprint-nya.
5. Penjelasan konsep: 
Enkapsulasi melindungi data agar tidak bisa diakses langsung dari luar class, tapi harus melalui getter dan setter.
)

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. Buka VS Code
2. Buat file Java berikut di dalam folder project:
-Produk.java
-MainProduk.java
-CreditBy.java
Kompilasi semua file
 -Produk.java 
 -CreditBy.java 
 -MainProduk.java
3. week 2-class object.
)

---

## Kode Program
(
 // produk.java 

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        // menambahkan stok produk untuk mengelola stok produk
        if (jumlah > 0) {
            this.stok += jumlah;
            System.out.println(jumlah + " stok berhasil ditambahkan. Total stok sekarang: " + stok);
        } else {
            System.out.println("Jumlah stok sudah lebih dari cukup!");
        }
    }

    public void kurangiStok(int jumlah) {
        // mengurangi stok produk mengelola stok produk
         if (jumlah > 0 && jumlah <= stok) {
            stok -= jumlah;
            System.out.println(jumlah + " stok berhasil dikurangi. Total stok sekarang: " + stok);
        } else {
           System.out.println("Jumlah stok yang dikurangi tidak valid atau melebihi stok yang tersedia.");
        }
    }
}



(
    // mainproduk.java
public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        // Tampilkan identitas mahasiswa nama dan nim
        CreditBy.print("240202862", "Haidar Habibi Al Farisi");

        //function get untuk memanggil class produk
        //function tambahStok dan kurangiStok untuk menambah dan mengurangi stok produk
        // dan menampilan hasil tiga objek produk beserta perubahan stoknya
        p1.tambahStok(20);
        System.out.println(p1.getNama() + ", " + p1.getHarga() + ", " + p1.getStok() + " menambah stok 20");
        p2.kurangiStok(5);
        System.out.println(p2.getNama() + ", " + p2.getHarga() + ", " + p2.getStok() + " mengurangi stok 5");
        p3.tambahStok(5); 
        System.out.println(p3.getNama() + ", " + p3.getHarga() + ", " + p3.getStok() + " menambah stok 20");
    }
}
)



// creditBy.java
public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " +  nama + " - " +  nim);
    }
}
)






## Hasil Eksekusi
(screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week2-class-object/screenshots/Produkjava1-OOP.png)
![Screenshot hasil](/praktikum/week2-class-object/screenshots/mainproduk.png)
![Screenshot hasil](/praktikum/week2-class-object/screenshots/creditbyjava.png)
)
---

## Analisis
(
1. Jelaskan bagaimana kode berjalan:
-MainProduk.java → membuat objek dari Produk.java → menjalankan method tambah/kurang stok → memanggil CreditBy.java untuk menampilkan identitas.

2. Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.
Data terlindungi dengan enkapsulasi (private dan getter/setter). 
3. Kendala yang dihadapi dan cara mengatasinya.  
Output stok tidak berubah
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
*Class Produk berperan sebagai blueprint yang mendefinisikan atribut dan perilaku produk seperti kode, nama, harga, dan stok.*
*Program ini juga memperlihatkan bagaimana method tambahStok() dan kurangiStok() digunakan untuk mengubah data produk dengan cara yang teratur dan terproteksi.*)

---

## Quiz
(1. [Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?]  
   **Agar data tidak dapat diakses langsung dari luar class dan hanya dapat dimodifikasi melalui method khusus getter dan setter, sehingga menjaga keamanan dan konsistensi data.**
 …  

2. [Apa fungsi getter dan setter dalam enkapsulasi?]  
   **Getter digunakan untuk mengambil nilai atribut, sedangkan setter digunakan untuk mengubah nilai atribut secara terkontrol**…  

3. [Bagaimana class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?]  
   **Class Produk menjadi dasar model data untuk aplikasi POS karena dapat diperluas dengan fitur tambahan seperti kategori, diskon, transaksi, atau manajemen stok otomatis tanpa perlu mengubah struktur utama program.** …  )
