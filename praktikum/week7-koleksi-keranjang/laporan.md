# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Haidar Habibi Al Farisi
- NIM   : 240202862
- Kelas : 3IKRA

---

## Tujuan
(Tujuan praktikum minggu ke-7 ini adalah agar mahasiswa mampu memahami dan menerapkan Java Collections Framework, khususnya penggunaan ArrayList dan Map dalam pembuatan sistem keranjang belanja (Shopping Cart) pada aplikasi Agri-POS. Mahasiswa diharapkan dapat melakukan operasi dasar seperti menambah produk, menghapus produk, dan menghitung total transaksi secara tepat.*)

---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1.Membuat package com.upb.agripos.

2.Membuat class Product untuk merepresentasikan data produk (kode, nama, dan harga).

3.Membuat class ShoppingCart menggunakan ArrayList untuk menyimpan daftar produk.

4.Mengimplementasikan method addProduct, removeProduct, dan getTotal.

5.Membuat class MainCart sebagai program utama untuk menjalankan aplikasi.

6.Menjalankan program dan mendokumentasikan hasil eksekusi dalam bentuk screenshot.

7.Melakukan commit dan push ke repository GitHub sesuai ketentuan.)

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit message yang digunakan.)

---

## Kode Utama
(Tuliskan kode utama yang dibuat, contoh:  

```java

package com.upb.agripos;
// main product untuk menjalankan program
public class Maincart {
    public class MainCart {
    public static void main(String[] args) {
        // menampilkan informasi diri
        System.out.println("Hello, I am Haidar Habibi Al Farisi-240202862 (Koleksi Keranjang Week 7)");
        // membuat objek produk dengan variabel p1 dan p2
        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);
        // membuat objek keranjang belanja
        ShoppingCart cart = new ShoppingCart();
        // memamnggil fungsi dari shoppingcart
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}
}

```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week7-koleksi-keranjang/screenshots/week7koleksi%20keranjang.png)
)
---

## Analisis
(
Program berjalan dengan membuat objek Product yang kemudian disimpan ke dalam ArrayList pada class ShoppingCart. Method addProduct() digunakan untuk menambahkan produk ke keranjang, sedangkan removeProduct() digunakan untuk menghapus produk dari keranjang. Perhitungan total harga dilakukan dengan melakukan iterasi pada collection dan menjumlahkan harga setiap produk.

Perbedaan praktikum minggu ini dibandingkan minggu sebelumnya adalah penggunaan struktur data collection yang bersifat dinamis, sehingga pengelolaan data menjadi lebih fleksibel dan efisien. Kendala yang dihadapi adalah memahami konsep collection, namun dapat diatasi dengan mempelajari modul dan mencoba langsung implementasinya. 
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
: *Dengan menggunakan Java Collections Framework, khususnya ArrayList, sistem keranjang belanja dapat diimplementasikan dengan lebih terstruktur dan fleksibel. Collection mempermudah pengelolaan data produk dan meningkatkan efisiensi pengembangan aplikasi Agri-POS.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:List bersifat terurut dan dapat menyimpan data duplikat, Map menyimpan data dalam bentuk pasangan key–value, sedangkan Set tidak mengizinkan data duplikat.** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:Karena ArrayList bersifat dinamis, mudah digunakan, dan mendukung penyimpanan data duplikat.** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:Set menggunakan mekanisme hashing atau perbandingan objek untuk menolak elemen yang sama.** …  )
