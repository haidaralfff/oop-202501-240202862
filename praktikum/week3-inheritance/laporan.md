# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Haidar Habibi Al Farisi
- NIM   : 240202862
- Kelas : 3IKRA

---

## Tujuan
(Tuliskan tujuan praktikum minggu ini.  
Contoh: *Mahasiswa memahami konsep class dan object serta dapat membuat class Produk dengan enkapsulasi.*)

---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1. Class adalah blueprint dari objek. Pemrograman Berorientasi Objek (OOP): Paradigma pemrograman yang mengatur desain perangkat lunak di sekitar objek (entitas yang memiliki data/properti dan perilaku/metode). Kode ini menunjukkan objek (Benih, Pupuk, AlatPertanian) dibuat dari Kelas yang mendefinisikan strukturnya. 
2. Pewarisan (Inheritance): Ini adalah prinsip utama yang mendasari nama praktikum (MainInheritance). Pewarisan memungkinkan kelas baru (Subclass/Kelas Anak, seperti Benih) untuk mengambil/mewarisi semua properti dan metode dari kelas yang sudah ada (Superclass/Kelas Induk, mungkin Produk). Tujuannya adalah untuk menggunakan kembali (reusability) kode dan membangun hierarki yang logis.  
3. Instansiasi Objek dan Konstruktor: Setiap objek (b, p, a) dibuat menggunakan kata kunci new dan konstruktor kelasnya. Konstruktor bertanggung jawab untuk menginisialisasi properti objek dengan nilai awal yang diberikan (misalnya, kode produk, nama, dan harga).


---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit message yang digunakan.)

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Kode utama Yang Dibuat

import main.java.com.upb.agripos.model.*;
import main.java.com.upb.agripos.util.*;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("------------Deskripsi Produk-------------");
        b.deskripsiBenih();
        p.deskripsiPupuk();
        a.deskripsiAlat();
        System.out.println("-----------------------------------");
        CreditBy.print("240202862", "Haidar Habibi Al Farisi");
    }
};
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week3-inheritance/screenshots/oop-week3-inheriatance.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.
Instansiasi Objek:
Sebuah objek Benih bernama b dibuat dengan detail seperti kode produk ("BNH-001"), nama ("Benih Padi IR64"), harga (25000), stok (100), dan jenis benih ("IR64").
Sebuah objek Pupuk bernama p dibuat dengan detail seperti kode produk ("PPK-101"), nama ("Pupuk Urea"), harga (350000), stok (40), dan jenis pupuk ("Urea").
Sebuah objek AlatPertanian bernama a dibuat dengan detail seperti kode produk ("ALT-501"), nama ("Cangkul Baja"), harga (90000), stok (15), dan bahan ("Baja").
Pencetakan Judul:
Kode mencetak garis pemisah dan judul: "------------Deskripsi Produk-------------".
Pemanggilan Metode Deskripsi:
Metode b.deskripsiBenih() dipanggil untuk objek Benih, yang akan mencetak detail benih.
Metode p.deskripsiPupuk() dipanggil untuk objek Pupuk, yang akan mencetak detail pupuk.
Metode a.deskripsiAlat() dipanggil untuk objek AlatPertanian, yang akan mencetak detail alat pertanian.
Pencetakan Penutup:
Kode mencetak garis pemisah penutup: "-----------------------------------".
Pencetakan Kredit:
Metode statis CreditBy.print() dipanggil untuk mencetak informasi pengembang ("240202862", "Haidar Habibi Al Farisi").
Intinya, kode ini bertujuan untuk menampilkan informasi detail dari tiga produk pertanian berbeda.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.
Akses Properti Induk	Properti umum (misalnya, harga, stok) di kelas induk mungkin dideklarasikan sebagai private, sehingga tidak dapat diakses langsung oleh kelas anak (misalnya, di dalam deskripsiBenih().  
- Kendala yang dihadapi dan cara mengatasinya.
Gunakan modifier protected untuk properti umum di kelas induk agar kelas anak dapat mengaksesnya. Atau, sediakan metode public getter di kelas induk untuk mengambil nilai properti tersebut.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Penerapan Pewarisan Inheritance:
Praktikum ini bertujuan untuk menunjukkan bagaimana hierarki kelas dibuat.
Kelas-kelas spesifik (Benih, Pupuk, AlatPertanian) diasumsikan mewarisi properti dan perilaku umum dari kelas induk (Superclass), yang kemungkinan besar adalah Produk.
Tujuan utamanya adalah meminimalkan duplikasi kode (sifat-sifat umum seperti kode, nama, harga, dan stok didefinisikan sekali di kelas induk) dan menciptakan struktur program yang lebih terorganisir.
Instansiasi dan Penggunaan Objek:
Kode berhasil melakukan instansiasi (pembuatan) objek dari kelas anak (b, p, a), mengisi data melalui constructor, dan kemudian memanggil metode spesifik (seperti deskripsiBenih()) untuk menampilkan informasi objek tersebut.
Hal ini memvalidasi pemahaman tentang bagaimana objek hidup dan berinteraksi di dalam program.
Fokus pada Spesialisasi:
Masing-masing objek anak (misalnya, Benih) memiliki atribut spesifik yang tidak dimiliki oleh objek lain (misalnya, jenis benih "IR64"), yang menunjukkan kemampuan pewarisan untuk menambahkan spesialisasi di atas properti umum yang diwariskan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
