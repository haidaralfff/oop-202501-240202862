# Laporan Praktikum Minggu 5 
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Haidar Habibi Al Farisi
- NIM   : 240202862
- Kelas : 3IKRA

---

## Tujuan
(*Mahasiswa memahami konsep abstraction-interface*)

---

## Dasar Teori
( 
1. **Abstraksi (Abstraction)** adalah proses menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas penting kepada pengguna.  
2. **Abstract Class** digunakan untuk membuat class dasar yang tidak dapat diinstansiasi secara langsung, tetapi dapat diwariskan oleh class turunannya.  
3. **Interface** adalah kontrak yang mendefinisikan metode tanpa implementasi, yang harus diimplementasikan oleh class yang menggunakannya.  
4. **Polymorphism** dapat terjadi melalui interface dan abstract class, memungkinkan objek dari class yang berbeda untuk diperlakukan sama.  
5. Abstraksi membantu pengembang fokus pada apa yang dilakukan suatu class, bukan bagaimana ia melakukannya.
)

---


## Langkah Praktikum
1. Membuat struktur proyek Java dengan package berikut:
   - `main.java.com.upb.agripos.model.kontrak`
   - `main.java.com.upb.agripos.model.pembayaran`
   - `main.java.com.upb.agripos.util`
2. Membuat class abstrak `Pembayaran` dan beberapa class turunan seperti `Cash`, `EWallet`, dan `TransferBank`.
3. Membuat interface `Receiptable` yang memiliki metode `cetakStruk()`.
4. Mengimplementasikan interface tersebut di masing-masing class pembayaran.
5. Membuat class `MainAbstraction` untuk menjalankan program.
6. Melakukan kompilasi dan menjalankan program menggunakan perintah `javac` dan `java`.
7. Commit kode dengan pesan:  
   > `Implement abstraction and interface for payment system`
---

## Kode Program
 
```java
// kode utama
package main.java.com.upb.agripos;
import main.java.com.upb.agripos.model.kontrak.*;
import main.java.com.upb.agripos.model.pembayaran.*;
import main.java.com.upb.agripos.util.CreditBy;


public class MainAbstraction{
     public static void main(String[] args) {
        Pembayaran cash = new Cash("INV-001", 100000, 120000);
        Pembayaran ew = new EWallet("INV-002", 150000, "user@ewallet", "123456");
        Pembayaran tb = new TransferBank("INV-003", 200000, "Bank WTC", "123-456-7890");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println(((Receiptable) tb).cetakStruk());

        CreditBy.print("240202862", "Haidar Habibi Al Farisi");
    }

}

```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week5-abstraction-interface/screenshots/week5-abstraction.png)
)
---

## Analisis
(
-Program ini berjalan dengan menggunakan class abstrak sebagai dasar bagi berbagai jenis pembayaran (Cash, EWallet, TransferBank).
Interface Receiptable digunakan agar setiap class dapat mencetak struk dengan cara masing-masing, namun tetap memiliki metode yang sama (cetakStruk()), menunjukkan penerapan abstraction dan polymorphism.

-Pendekatan minggu ini berbeda dari minggu sebelumnya karena kita tidak hanya melakukan overriding atau overloading, tetapi juga membuat kontrak perilaku (interface) dan kerangka dasar (abstract class).

-Kendala yang dihadapi adalah kesalahan pada import package (cannot be resolved) yang diatasi dengan memastikan struktur folder sesuai dengan deklarasi package di dalam file Java. 
)
---

## Kesimpulan
(*Dengan menerapkan abstraksi dan interface, program menjadi lebih fleksibel, terstruktur, dan mudah dikembangkan. Konsep ini memungkinkan pengembang untuk membuat sistem yang dapat diperluas tanpa perlu mengubah kode utama.*)

---

## Quiz
(1. Apa perbedaan antara class abstrak dan interface dalam Java?  
   **Jawaban:*Class abstrak dapat memiliki atribut dan metode dengan implementasi, sedangkan interface hanya dapat memiliki deklarasi metode (tanpa implementasi, kecuali default atau static). Class dapat meng-extend satu class abstrak, tetapi dapat mengimplementasikan banyak interface.* …  

(2.Kapan sebaiknya menggunakan abstract class dibandingkan interface?
   **Jawaban:*Abstract class digunakan ketika beberapa class memiliki kesamaan perilaku dan atribut, sedangkan interface digunakan ketika kita ingin mendefinisikan kontrak umum untuk berbagai class yang tidak memiliki hubungan langsung dalam hierarki pewarisan.* … ) 

(3. Bagaimana penerapan polymorphism dalam penggunaan interface di praktikum  
   **Jawaban:*Polymorphism terjadi saat objek dari berbagai class (Cash, EWallet, TransferBank) diperlakukan sama melalui tipe interface Receiptable. Masing-masing class memiliki implementasi berbeda dari metode cetakStruk(), namun dipanggil dengan cara yang sama.* …  )
