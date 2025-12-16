# Laporan Praktikum Minggu 9

Topik: Exception Handling dan Custom Exception pada Aplikasi Agri-POS

## Identitas

* Nama  : [Nama Mahasiswa]
* NIM   : [NIM Mahasiswa]
* Kelas : [Kelas]

---

## Tujuan

Tujuan dari praktikum minggu ke-9 ini adalah agar mahasiswa memahami perbedaan antara error dan exception, mampu mengimplementasikan mekanisme try–catch–finally, serta dapat membuat dan menerapkan custom exception pada studi kasus keranjang belanja (Agri-POS).

---

## Dasar Teori

1. Error merupakan kesalahan fatal yang tidak dapat ditangani oleh program, sedangkan exception adalah kesalahan yang masih dapat ditangani.
2. Exception handling di Java menggunakan struktur try–catch–finally.
3. Custom exception dibuat untuk menangani kasus kesalahan yang spesifik sesuai kebutuhan bisnis.
4. Penggunaan exception membuat kode lebih aman, terstruktur, dan mudah dipelihara.

---

## Langkah Praktikum

1. Membuat project Java dan package `com.upb.agripos`.
2. Membuat class custom exception: `InvalidQuantityException`, `ProductNotFoundException`, dan `InsufficientStockException`.
3. Membuat class `Product` sebagai model data produk.
4. Mengimplementasikan class `ShoppingCart` dengan validasi dan exception handling.
5. Membuat class `MainExceptionDemo` untuk menguji program.
6. Menjalankan program dan mengamati hasil eksekusi.
7. Melakukan commit ke repository dengan pesan commit yang sesuai.

---

## Kode Program

Berikut contoh potongan kode utama yang digunakan dalam praktikum:

```java
package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Hello, I am Haidar Habibi Al Farisi-240202862 (Week9)");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);
        // contoh penambahan stok
        try {
            // menambahkan produk dengan stok negatif
            cart.addProduct(p1, -1);
        } catch (InvalidQuantityException e) {
            // menampilkan informasi quantity tidak valid
            System.out.println("Kesalahan: " + e.getMessage());
        }
        // contoh pengurangan stok
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            // menampilkan informasi produk tidak ditemukan
            System.out.println("Kesalahan: " + e.getMessage());
        }
        // jika stok kurang dari 5 maka tidak bisa checkout
        try {
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

    }
}
```

Kode di atas digunakan untuk menguji custom exception `InvalidQuantityException` ketika jumlah pembelian tidak valid.

---

## Hasil Eksekusi

Hasil eksekusi program menampilkan pesan kesalahan sesuai dengan custom exception yang terjadi, misalnya:

* "Quantity harus lebih dari 0."
* "Produk tidak ada dalam keranjang."
* "Stok tidak cukup untuk: Pupuk Organik"

![Screenshot hasil](/praktikum/week9-exception-handling/screenshots/week9exceptionhandling.png)

---

## Analisis

* Program berjalan dengan memvalidasi setiap aksi pada keranjang belanja menggunakan custom exception.
* Dibandingkan minggu sebelumnya, pendekatan minggu ini lebih fokus pada penanganan kesalahan (error handling) daripada hanya logika bisnis.
* Kendala yang dihadapi adalah memahami alur exception, namun dapat diatasi dengan mempelajari struktur try–catch secara bertahap.

---

## Kesimpulan

Dengan menerapkan exception handling dan custom exception, aplikasi Agri-POS menjadi lebih robust dan mampu menangani kesalahan input maupun kondisi bisnis dengan lebih baik. Program menjadi lebih terstruktur dan mudah dikembangkan.

---

## Quiz

1. Jelaskan perbedaan error dan exception.
   **Jawaban:** Error adalah kesalahan fatal yang tidak dapat ditangani program, sedangkan exception adalah kesalahan yang masih dapat ditangani.

2. Apa fungsi finally dalam blok try–catch–finally?
   **Jawaban:** Finally digunakan untuk mengeksekusi kode yang selalu dijalankan, baik terjadi exception maupun tidak.

3. Mengapa custom exception diperlukan?
   **Jawaban:** Custom exception diperlukan untuk menangani kesalahan spesifik sesuai kebutuhan bisnis agar program lebih jelas dan terkontrol.

4. Berikan contoh kasus bisnis POS yang membutuhkan custom exception.
   **Jawaban:** Contohnya ketika stok produk tidak mencukupi saat checkout atau jumlah pembelian bernilai nol.
