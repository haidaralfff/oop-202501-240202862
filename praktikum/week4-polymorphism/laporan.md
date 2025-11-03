# Laporan Praktikum Minggu ke (4)
Topik: [Mahasiswa mampu **mengimplementasikan polymorphism (overriding, overloading, dynamic binding)** dalam program.]

## Identitas
- Nama  : Haidar Habibi Al Farisi
- NIM   : 240202862
- Kelas : 3IKRA

---

## Tujuan
(Tuliskan tujuan praktikum minggu ini.  
 *Mahasiswa memahami konsep class dan object serta dapat membuat class Produk dengan enkapsulasi.*)

---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1. Class adalah blueprint dari objek.  
2. Object adalah instansiasi dari class.  
3. Enkapsulasi digunakan untuk menyembunyikan data.)

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam praktikum, contoh:
1. Overloading:Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.  
2. Overriding:
Tambahkan method getInfo() pada superclass Produk.
Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian. 
3. Dynamic Binding
Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual
)

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// kode utama program
package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.AlatPertanian;
import main.java.com.upb.agripos.model.Benih;
import main.java.com.upb.agripos.model.ObatHama;
import main.java.com.upb.agripos.model.Pupuk;
import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja"),
            new ObatHama("OBT-301", "Obat Hama Serangga", 50000, 20, "Serangga")
        };
// dynamic binding untuk menampilkan info produk
        for (Produk p : daftarProduk) {
            p.getInfo();
        }

        CreditBy.print("240202862", "Haidar Habibi Al Farisi");
    }
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week4-polymorphism/screenshots/week4-polymorpishm.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan:
Analisa kode berjalan. Kode ini menggunakan Polymorphism dengan overriding method getInfo() di setiap subclass untuk menampilkan detail spesifik produk. Melalui loop pada array referensi Produk[], dynamic binding secara otomatis memanggil implementasi getInfo
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya:Perbedaan minggu ini dibanding minggu sebelumnya. Minggu lalu (Inheritance) berfokus pada pewarisan struktur data (attributes), membuat subclass mendapatkan properti umum. Minggu ini (Polymorphism) berfokus pada perilaku yang beragam (methods), di mana satu panggilan method menghasilkan respons yang berbeda-beda, memungkinkan penanganan semua produk secara seragam. 
- Kendala yang dihadapi dan cara mengatasinya 
)
---

## Kesimpulan
(*Polymorphism untuk menciptakan sistem Agri-POS yang fleksibel. Dengan menggunakan Overriding pada getInfo(), objek yang berbeda merespons panggilan method yang sama dengan perilaku yang berbeda, menghasilkan deskripsi produk yang spesifik. Dynamic Binding memungkinkan penanganan berbagai jenis produk (Benih, Pupuk, dll.) secara seragam melalui satu tipe referensi (Produk), menjadikan kode lebih modular dan mudah dikelola.*)

---

## Quiz
(1. Apa perbedaan overloading dan overriding? 
   **Jawaban:*Overloading adalah tentang variasi input di satu kelas, sementara Overriding adalah tentang perubahan perilaku dalam konteks pewarisan* …  

2.  Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?   
   **Jawaban:*Dynamic binding hanya terjadi pada method yang non-statis, non-final, dan non-private ketika dipanggil melalui referensi superkelas yang menunjuk ke objek subkelas.* …  

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.   
   **Jawaban:* MenuItem bisa memiliki subclass seperti Makanan, Minuman, dan Dessert. Masing-masing subclass dapat meng-override method getInfo() untuk menampilkan detail menu spesifik seperti bahan, ukuran porsi, atau suhu penyajian. Saat daftar menu ditampilkan menggunakan array MenuItem[], Java akan memanggil method getInfo() yang sesuai dengan tipe objek aktualnya* …  )
