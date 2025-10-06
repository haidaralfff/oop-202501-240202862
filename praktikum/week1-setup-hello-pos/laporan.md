# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Paradigma Pemrograman di Java (OOP, Functional, Procedural)
## Identitas
- Nama  : Haidar Habibi Al Farisi
- NIM   : 240202862
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa memahami perbedaan paradigma pemrograman di Java, yaitu OOP, Functional, dan Procedural.  
- Mahasiswa memahami konsep class dan object pada pemrograman berorientasi objek.
## Dasar Teori
1.Prosedural: program dibangun sebagai rangkaian perintah (fungsi/prosedur).
2.OOP (Object-Oriented Programming): program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).
3.Fungsional: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data.

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. **Setup**
   - Install Java Development Kit (JDK).
   - Pastikan `javac` dan `java` dapat dijalankan di terminal/command prompt.
   - Buat folder project praktikum, misalnya `praktikum-paradigma`.

2. **Coding**
   - Buat file Java untuk masing-masing paradigma:
     - `HelloOOP.java`
     - `HelloFunctional.java`
     - `HelloProcedural.java`
   - Tulis kode sesuai paradigma yang diminta.

3. **Run**
   - Compile setiap file:  
     ```bash
     javac HelloOOP.java
     javac HelloFunctional.java
     javac HelloProcedural.java
     ```
   - Jalankan program:  
     ```bash
     java HelloOOP
     java HelloFunctional
     java HelloProcedural
     ```


---

## Kode Program
 kode utama yang dibuat:  
package main.java.com.upb.agripos;

// Procedural
public class HelloProcedural {
    public static void main(String[] args) {
        String Nim = "240202862";
        String Nama = "Haidar Habibi Al Farisi";

        System.out.println("Hello World, I am " + Nama + ", " + Nim);
    }
}

package main.java.com.upb.agripos;


    // HelloOOP
class Mahasiswa{
   String nama;
   int nim;
   Mahasiswa(String m, int n) {
      this.nama = m ;
      this.nim = n;

   }
   void sapa(){
    System.out.println("Hello world I am "+ nama + ","+nim);
   }
}

public class HelloOOP {
   public static void main(String[] args) {
    Mahasiswa m = new Mahasiswa("Haidar Habibi Al Farisi",240202862);
    m.sapa();
   }
}



package main.java.com.upb.agripos;

//functional
import java.util.function.BiConsumer;

public class HelloFunctional {
   
    public static void main(String[] args) {
        BiConsumer<String, String> sapa = 
            (nama, nim) -> System.out.println( nama + " -" + nim);

        // eksekusi fungsi
        sapa.accept("Hello World I am Haidar Habibi Al Farisi", "240202862");
        System.out.println("Program Functional Selesai");
    }

}






---

## Hasil Eksekusi
(hasil eksekusi program.  
![Screenshot hasil](/praktikum/week1-setup-hello-pos/src/main/java/com/upb/agripos/screenshots/Tugas%20OOPProcedural1.png)
![Screenshot hasil](/praktikum/week1-setup-hello-pos/src/main/java/com/upb/agripos/screenshots/Tugas%20OOPProcedural1.png)
![Screenshot hasil](/praktikum/week1-setup-hello-pos/src/main/java/com/upb/agripos/screenshots/TugasOOPFUNCTIONAL3.png)
)
---

## Analisis
(
1.Jelaskan bagaimana kode berjalan.  
- !(Program ditulis dalam paradigma **procedural**.  
- Eksekusi dimulai dari method `main(String[] args)`.  
- Dua variabel dibuat (`Nim` dan `Nama`) untuk menyimpan data mahasiswa.  
- Program mencetak output dengan menggunakan `System.out.println`, yang menggabungkan teks dengan isi variabel.  
- Hasilnya:) 
2. Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  

3. Kendala yang dihadapi dan cara mengatasinya. 
**Kendala 1:** Awalnya lupa menuliskan `package` sesuai struktur folder, sehingga program tidak bisa dijalankan.  
- **Solusi:** Memastikan struktur folder sesuai dengan deklarasi package (`main/java/com/upb/agripos`).  
- **Kendala 2:** Error ketika menjalankan `javac` karena file tidak berada di path yang tepat.   
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
- Praktikum ini memberikan pemahaman tentang tiga paradigma pemrograman di Java, yaitu **Procedural, OOP, dan Functional**.  
- **Procedural** menekankan pada penggunaan fungsi/metode sederhana tanpa class tambahan.  
- **OOP (Object-Oriented Programming)** menggunakan **class** dan **object** untuk merepresentasikan data dan perilaku secara lebih terstruktur dengan prinsip seperti **enkapsulasi**.  
- **Functional** menggunakan **lambda expression** atau **functional interface** untuk menuliskan kode yang lebih ringkas dan deklaratif.  
- Dengan membandingkan ketiga paradigma, mahasiswa dapat memahami bahwa satu masalah yang sama (misalnya “Hello World”) bisa diselesaikan dengan pendekatan berbeda, sesuai kebutuhan dan kompleksitas program.  
- Praktikum ini juga melatih mahasiswa untuk memahami perbedaan pola pikir (paradigm shift) antara pemrograman prosedural, berorientasi objek, dan fungsional.  

)

---

## Quiz
( 1.Apakah OOP selalu lebih baik dari prosedural?
Jawaban: Tidak selalu. OOP lebih baik untuk program besar karena modular dan reusable, tapi untuk program kecil yang sederhana, prosedural lebih cepat dan mudah dibuat.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
Jawaban: Functional cocok dipakai saat mengolah data dalam jumlah besar, pemrosesan paralel/stream, atau aplikasi AI/ML, karena minim side-effect dan lebih aman dalam environment multi-thread.

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?
Jawaban:

Prosedural: maintainability rendah, rawan spaghetti code, sulit diskalakan.
OOP: lebih mudah dimaintain dan diskalakan karena modularitas (class & object).
Functional: sangat maintainable untuk operasi data dan parallel, tetapi lebih sulit untuk I/O kompleks.
Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
Jawaban: Karena aplikasi POS melibatkan banyak entitas nyata (Produk, Transaksi, Pelanggan) yang lebih mudah dimodelkan sebagai objek dengan atribut dan perilaku. Hal ini membuat program lebih terstruktur, mudah dikembangkan, dan lebih scalable dibanding prosedural.

4. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?
Jawaban: Dengan memanfaatkan fungsi murni, higher-order function, dan lambda expression, developer bisa menulis logika sekali lalu dipakai ulang tanpa perlu banyak kode tambahan. Hal ini mengurangi boilerplate dan membuat kode lebih ringkas.

 )
