# 📘 Manual Book Sistem Agri-POS

**Panduan Penggunaan Aplikasi untuk Admin dan Kasir**

---

## 📑 Daftar Isi

1. [Pendahuluan](#1-pendahuluan)
2. [Spesifikasi Sistem](#2-spesifikasi-sistem)
3. [Instalasi Aplikasi](#3-instalasi-aplikasi)
4. [Hak Akses Pengguna](#4-hak-akses-pengguna)
5. [Panduan Penggunaan Sistem](#5-panduan-penggunaan-sistem)
6. [Penanganan Error](#6-penanganan-error)
7. [Contoh Skenario Penggunaan](#7-contoh-skenario-penggunaan)
8. [FAQ](#8-faq)
9. [Penutup](#9-penutup)

---

## 1. Pendahuluan

### 1.1 Nama Aplikasi
**Agri-POS** (Agriculture Point of Sale)

### 1.2 Fungsi Utama Aplikasi

Agri-POS adalah sistem Point of Sale (Kasir) terintegrasi yang dirancang khusus untuk mendukung operasional toko pertanian modern. Aplikasi ini menyediakan solusi lengkap untuk:

- 🛒 **Manajemen Produk** - Menambah, mengubah, menghapus, dan mencari produk pertanian dengan kategori dan stok real-time
- 💳 **Transaksi Penjualan** - Memproses penjualan dengan shopping cart yang dinamis dan fleksibel
- 💰 **Metode Pembayaran** - Mendukung pembayaran dengan metode Tunai dan E-Wallet
- 🧾 **Struk Penjualan** - Menghasilkan dan mencetak bukti transaksi yang detail
- 📊 **Laporan Penjualan** - Menampilkan data transaksi dan grafik omset penjualan untuk analisis bisnis
- 🔐 **Keamanan** - Sistem login dengan role-based access control untuk Admin dan Kasir

### 1.3 Tujuan Manual Book

Manual book ini disusun sebagai panduan penggunaan aplikasi Agri-POS. Panduan ini bertujuan untuk:

- Memudahkan pengguna dalam mengoperasikan aplikasi
- Menjelaskan setiap fitur dan menu yang tersedia
- Memberikan langkah-langkah penggunaan yang jelas dan terstruktur
- Mengatasi masalah/error yang mungkin muncul
- Memastikan pengguna dapat menggunakan semua fitur secara optimal

### 1.4 Sasaran Pengguna

Manual book ini ditujukan bagi:

- 👤 **Admin Toko** - Pengguna dengan akses untuk mengelola produk dan melihat laporan penjualan
- 👤 **Kasir** - Pengguna dengan akses untuk melakukan transaksi penjualan dan pembayaran

---

## 2. Spesifikasi Sistem

### 2.1 Spesifikasi Perangkat Keras

| Komponen | Minimum | Recommended |
|----------|---------|-------------|
| **Prosesor** | Intel Core i3 atau setara | Intel Core i5 atau lebih tinggi |
| **RAM** | 4 GB | 8 GB atau lebih |
| **Penyimpanan** | 500 MB ruang kosong | 1 GB ruang kosong |
| **Monitor** | 1366 x 768 (16:9) | 1920 x 1080 (16:9) atau lebih tinggi |
| **Printer** | Optional | Recommended untuk cetak struk |

### 2.2 Spesifikasi Perangkat Lunak

| Komponen | Versi | Keterangan |
|----------|-------|-----------|
| **Sistem Operasi** | Windows 10 / 11, Linux, macOS | Cross-platform |
| **Java Runtime** | JDK/JRE 21 LTS | Java 21 atau lebih baru |
| **Database** | PostgreSQL 12+ | Server database |
| **Browser** | Chrome, Firefox, Edge | Untuk dokumentasi online (optional) |

### 2.3 Koneksi Internet

- ✓ **Koneksi Database** - Lokal atau jaringan (LAN) dengan server PostgreSQL
- ✓ **Print Server** - Koneksi ke printer lokal atau jaringan
- ✓ **Optional** - Koneksi internet untuk update (tidak wajib)

---

## 3. Instalasi Aplikasi

### 3.1 Persiapan Sebelum Instalasi

Pastikan Anda sudah memiliki:
- [ ] Java Development Kit (JDK) 21 sudah terinstall
- [ ] PostgreSQL 12 atau lebih tinggi sudah berjalan
- [ ] Akses internet untuk download dependencies (jika diperlukan)

### 3.2 Langkah Instalasi

#### Langkah 1: Install Java JDK 21

```
Windows:
1. Download JDK 21 dari https://www.oracle.com/java/technologies/downloads/
2. Jalankan installer (.exe)
3. Ikuti wizard instalasi (next, next, finish)
4. Verifikasi: Buka Command Prompt, ketik "java -version"
   Output harus: java version "21.x.x"

Linux/macOS:
1. Gunakan package manager: apt install openjdk-21-jdk
   atau brew install openjdk@21
2. Verifikasi: java -version
```

#### Langkah 2: Install PostgreSQL

```
Windows:
1. Download PostgreSQL dari https://www.postgresql.org/download/
2. Jalankan installer, pilih lokasi instalasi
3. Set password untuk user "postgres" (catat password ini!)
4. Pilih port default 5432
5. Finish

Linux:
1. apt update && apt install postgresql postgresql-contrib
2. Service akan otomatis berjalan

macOS:
1. brew install postgresql
2. brew services start postgresql
```

#### Langkah 3: Buat Database dan User

```sql
-- Buka terminal/command prompt
psql -U postgres

-- Lalu jalankan command berikut:
CREATE DATABASE agripos;
CREATE USER agripos_user WITH PASSWORD 'agripos_pass123';
ALTER ROLE agripos_user WITH CREATEDB;
GRANT ALL PRIVILEGES ON DATABASE agripos TO agripos_user;
\c agripos
\q
```

#### Langkah 4: Import Database Schema

```bash
-- Di terminal, navigasi ke folder project
cd oop-20251-XXXXX/praktikum/week15-proyek-kelompok

-- Import schema
psql -U agripos_user -d agripos -f sql/schema.sql

-- (Optional) Import data awal
psql -U agripos_user -d agripos -f sql/seed.sql
```

#### Langkah 5: Build dan Jalankan Aplikasi

```bash
-- Di folder project week15-proyek-kelompok

-- Build aplikasi
mvn clean install

-- Jalankan aplikasi
mvn javafx:run

-- Atau langsung dari JAR jika sudah di-package
java -cp "target/classes:target/dependency/*" com.agripos.ui.App
```

**Jika berhasil, layar login akan muncul.**

### 3.3 Konfigurasi (Jika Diperlukan)

Jika database connection bermasalah, edit file:
```
src/main/java/com/agripos/database/DBConnection.java
```

Sesuaikan dengan konfigurasi Anda:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/agripos";
private static final String USER = "agripos_user";
private static final String PASSWORD = "agripos_pass123";
```

---

## 4. Hak Akses Pengguna

### 4.1 Role dalam Sistem

Sistem Agri-POS memiliki 2 role utama dengan hak akses yang berbeda:

| Fitur | Admin | Kasir |
|-------|:-----:|:-----:|
| **Login** | ✓ | ✓ |
| **Manajemen Produk** (Tambah/Edit/Hapus) | ✓ | ✗ |
| **Lihat Daftar Produk** | ✓ | ✓ |
| **Transaksi Penjualan** | ✗ | ✓ |
| **Pembayaran** | ✗ | ✓ |
| **Cetak Struk** | ✗ | ✓ |
| **Lihat Laporan Penjualan** | ✓ | ✗ |
| **Lihat Grafik Omset** | ✓ | ✗ |
| **Export Data** | ✓ | ✗ |

### 4.2 Penjelasan Role

#### 👨‍💼 ADMIN
- Mengelola seluruh data produk (tambah, ubah, hapus)
- Melihat laporan penjualan dan analisis
- Melihat grafik omset
- Export data ke CSV/TXT
- Tidak dapat melakukan transaksi penjualan

#### 🧑‍💼 KASIR
- Melakukan transaksi penjualan
- Menambahkan produk ke keranjang
- Memproses pembayaran (Tunai / E-Wallet)
- Mencetak/melihat struk transaksi
- Melihat history transaksi personal
- Tidak dapat mengelola produk atau laporan

---

## 5. Panduan Penggunaan Sistem

### ⭐ Bagian TERPENTING - Panduan Lengkap Setiap Menu

---

### 5.1 Login Sistem

#### Tujuan
Untuk masuk ke sistem dan mengakses fitur sesuai dengan peran pengguna (Admin atau Kasir).

#### Kredensial Default

| Username | Password | Role |
|----------|----------|------|
| **admin** | admin123 | ADMIN |
| **kasir1** | kasir123 | KASIR |
| **kasir2** | kasir123 | KASIR |

#### Langkah Penggunaan

**Langkah 1:** Buka aplikasi Agri-POS (jika belum terbuka, jalankan `mvn javafx:run`)

**Langkah 2:** Halaman login akan muncul dengan field:
- Username
- Password
- Role (Auto-detected berdasarkan username)

**Langkah 3:** Masukkan credential
```
Contoh login sebagai Admin:
- Username: admin
- Password: admin123
```

**Langkah 4:** Klik tombol **"Login"**

#### Hasil Sukses
- ✅ Sistem menampilkan dashboard sesuai role
- ✅ Jika Admin → Tab "Produk" dan "Laporan" akan muncul
- ✅ Jika Kasir → Tab "Penjualan" akan muncul

#### Pesan Error & Solusi

| Error | Penyebab | Solusi |
|-------|----------|--------|
| "Username atau password salah" | Kredensial salah | Cek username dan password di tabel |
| "Pengguna tidak ditemukan" | User tidak terdaftar | Hubungi admin untuk membuat akun |
| "Koneksi database gagal" | Database tidak berjalan | Pastikan PostgreSQL sudah running |

#### Logout
Setelah selesai menggunakan sistem:
1. Klik tombol **"Logout"** (biasanya di pojok kanan atas)
2. Anda akan kembali ke halaman login

---

### 5.2 Manajemen Produk (ADMIN ONLY)

#### Tujuan
Mengelola data produk pertanian: menambah, mengubah, menghapus, dan mencari produk.

#### 5.2.1 Melihat Daftar Produk

**Langkah:**
1. Login sebagai **ADMIN**
2. Klik tab **"Produk"**
3. Daftar semua produk akan ditampilkan dalam tabel

**Informasi yang ditampilkan:**
- Kode Produk (Product Code)
- Nama Produk
- Kategori (Sayuran, Buah, Pupuk, dll)
- Harga (Rp)
- Stok (Jumlah)

#### 5.2.2 Menambah Produk Baru

**Tujuan:** Memasukkan produk baru ke dalam database

**Langkah Penggunaan:**

1. Klik tab **"Produk"**
2. Klik tombol **"Tambah Produk"** (atau "Add Product")
3. Form input produk akan muncul dengan field:
   - **Kode Produk** (Code) - Unik, tidak boleh duplikat
   - **Nama Produk** (Name)
   - **Kategori** (Category) - Pilih dari dropdown
   - **Harga** (Price) - Rp (Rupiah)
   - **Stok Awal** (Initial Stock) - Jumlah unit

**Contoh Pengisian:**
```
Kode Produk: TOMAT-001
Nama Produk: Tomat Segar Organik
Kategori: Sayuran
Harga: 12000
Stok Awal: 50
```

4. Klik tombol **"Simpan"** (atau "Save")

**Validasi Input:**
- ✓ Semua field wajib diisi (tidak boleh kosong)
- ✓ Kode produk tidak boleh duplikat
- ✓ Harga harus ≥ 0
- ✓ Stok harus ≥ 0

**Hasil Sukses:**
- ✅ Produk tersimpan dalam database
- ✅ Produk muncul di daftar tabel
- ✅ Pesan sukses: "Produk berhasil ditambahkan"

#### 5.2.3 Mengubah Produk Existing

**Tujuan:** Merubah data produk yang sudah ada

**Langkah Penggunaan:**

1. Klik tab **"Produk"**
2. Cari produk yang ingin diubah di tabel
3. Klik tombol **"Edit"** pada baris produk tersebut
4. Form edit produk akan muncul dengan data yang sudah terisi
5. Ubah field yang diperlukan (Nama, Kategori, Harga, Stok)
6. Klik tombol **"Update"** (atau "Simpan")

**Contoh perubahan:**
```
SEBELUM:
- Nama: Tomat Segar Organik
- Harga: 12000
- Stok: 50

SESUDAH:
- Nama: Tomat Merah Premium
- Harga: 15000
- Stok: 30
```

**Hasil Sukses:**
- ✅ Data produk terupdate
- ✅ Perubahan langsung terlihat di tabel
- ✅ Pesan sukses: "Produk berhasil diupdate"

#### 5.2.4 Menghapus Produk

**⚠️ PERHATIAN: Aksi ini tidak bisa dibatalkan!**

**Langkah Penggunaan:**

1. Klik tab **"Produk"**
2. Cari produk yang ingin dihapus di tabel
3. Klik tombol **"Hapus"** (atau "Delete") pada baris produk
4. Dialog konfirmasi akan muncul: "Yakin ingin menghapus produk ini?"
5. Klik **"Ya"** untuk konfirmasi atau **"Tidak"** untuk batal

**Hasil Sukses:**
- ✅ Produk dihapus dari database
- ✅ Produk tidak muncul lagi di tabel
- ✅ Pesan sukses: "Produk berhasil dihapus"

#### 5.2.5 Mencari Produk

**Tujuan:** Menemukan produk tertentu dengan cepat

**Langkah Penggunaan:**

1. Klik tab **"Produk"**
2. Cari field **"Cari Produk"** (biasanya di atas tabel)
3. Ketik kode produk atau nama produk
4. Sistem akan otomatis filter tabel dengan hasil pencarian

**Contoh Pencarian:**
```
Ketik: "Tomat"
Hasil: Menampilkan semua produk dengan nama yang mengandung "Tomat"

Ketik: "TOMAT-001"
Hasil: Menampilkan produk dengan kode "TOMAT-001"
```

#### 5.2.6 Export Data Produk

**Tujuan:** Mengekspor data produk ke file CSV untuk backup atau analisis

**Langkah Penggunaan:**

1. Klik tab **"Produk"**
2. Klik tombol **"Export ke CSV"** (atau "Export Data")
3. Dialog "Simpan File" akan muncul
4. Pilih lokasi penyimpanan
5. Klik **"Simpan"**

**Hasil:**
- ✅ File CSV tersimpan dengan nama: `products_[tanggal].csv`
- ✅ File dapat dibuka dengan Excel atau text editor

---

### 5.3 Transaksi Penjualan (KASIR ONLY)

#### Tujuan
Melakukan proses penjualan kepada pelanggan dan menerima pembayaran.

#### 5.3.1 Memulai Transaksi

**Langkah Penggunaan:**

1. Login sebagai **KASIR**
2. Klik tab **"Penjualan"** (atau "Sales")
3. Halaman transaksi penjualan akan ditampilkan dengan:
   - Daftar Produk (di sebelah kiri)
   - Keranjang Belanja (di sebelah kanan)
   - Total Harga
   - Tombol Checkout

#### 5.3.2 Menambahkan Produk ke Keranjang

**Langkah Penggunaan:**

1. Di halaman penjualan, cari produk yang ingin dijual
2. Ada beberapa cara untuk menambahkan:
   
   **Cara 1: Click Produk + Masukkan Jumlah**
   - Klik tombol **"Tambah"** pada produk
   - Input field untuk jumlah (quantity) akan muncul
   - Masukkan jumlah yang diinginkan
   - Klik **"OK"** atau **"Konfirmasi"**

   **Cara 2: Double-click pada Produk**
   - Double-click produk akan menambahkan 1 unit
   - Lakukan berkali-kali untuk jumlah lebih banyak

**Contoh Transaksi:**
```
Pelanggan membeli:
- 2 kg Tomat Segar (harga: 12000/kg) = 24000
- 3 buah Cabai Rawit (harga: 8000/buah) = 24000
- 1 kg Pupuk Organik (harga: 50000/kg) = 50000
```

**Validasi:**
- ✓ Stok harus tersedia (tidak bisa membeli lebih dari stok)
- ✓ Jumlah harus > 0
- ✓ Sistem otomatis update stok

#### 5.3.3 Mengubah Jumlah Item di Keranjang

**Langkah Penggunaan:**

1. Di keranjang belanja, cari item yang ingin diubah
2. Klik tombol **"Edit"** pada item tersebut
3. Ubah jumlah (quantity) sesuai kebutuhan
4. Klik **"Update"** untuk menyimpan perubahan

**Contoh:**
```
Item: Tomat Segar
Jumlah Lama: 2 kg
Jumlah Baru: 5 kg
Harga akan otomatis terupdate: 60000 (5 × 12000)
```

#### 5.3.4 Menghapus Item dari Keranjang

**Langkah Penggunaan:**

1. Di keranjang belanja, cari item yang ingin dihapus
2. Klik tombol **"Hapus"** (atau "Remove") pada item
3. Item akan terhapus dari keranjang
4. Total harga akan terupdate otomatis

#### 5.3.5 Checkout (Proses Pembayaran)

**Langkah Penggunaan:**

1. Setelah semua produk ditambahkan ke keranjang
2. Klik tombol **"Checkout"** (atau "Proses Pembayaran")
3. Halaman pembayaran akan muncul dengan:
   - Summary transaksi (daftar produk + harga)
   - Total yang harus dibayar
   - Pilihan metode pembayaran

#### Lanjut ke Bagian 5.4 (Pembayaran)

---

### 5.4 Metode Pembayaran

#### Tujuan
Menerima pembayaran dari pelanggan dengan metode Tunai atau E-Wallet.

#### 5.4.1 Pembayaran Tunai (Cash)

**Langkah Penggunaan:**

1. Klik tab **"Penjualan"** → Selesaikan transaksi → Klik **"Checkout"**
2. Di halaman pembayaran, pilih metode **"Tunai"** (atau "Cash")
3. Input field akan muncul:
   - **Total Harga** (auto-filled, tidak bisa diubah)
   - **Jumlah Pembayaran** (uang yang diberikan pelanggan)

**Contoh Pembayaran Tunai:**
```
Total Harga Transaksi: 98000 (24000 + 24000 + 50000)
Pelanggan memberikan: 100000
Kembalian: 2000
```

4. Masukkan jumlah uang yang diterima dari pelanggan
5. Sistem otomatis hitung kembalian (Jumlah Pembayaran - Total Harga)
6. Verifikasi jumlah uang sudah sesuai
7. Klik **"Bayar"** (atau "Proses Pembayaran")

**Validasi:**
- ✓ Jumlah pembayaran harus ≥ Total harga
- ✗ Jika < Total harga → Error: "Uang tidak cukup"

**Hasil Sukses:**
- ✅ Transaksi berhasil diproses
- ✅ Struk akan ditampilkan/dicetak
- ✅ Stok produk terupdate
- ✅ Pesan sukses: "Pembayaran berhasil"

#### 5.4.2 Pembayaran E-Wallet

**Langkah Penggunaan:**

1. Klik tab **"Penjualan"** → Selesaikan transaksi → Klik **"Checkout"**
2. Di halaman pembayaran, pilih metode **"E-Wallet"** (atau "Digital Wallet")
3. Form pembayaran E-Wallet akan muncul:
   - **Total Harga** (auto-filled)
   - **Nomor Akun E-Wallet** (optional - untuk referensi)
   - Konfirmasi pembayaran

4. Verifikasi total harga
5. Klik **"Konfirmasi Pembayaran"** atau **"Bayar"**

**Catatan:**
- E-Wallet diasumsikan selalu punya saldo cukup (dalam sistem ini)
- Tidak ada verifikasi balance E-Wallet (bisa disesuaikan di implementasi)
- Pembayaran langsung diproses tanpa dialog tambahan

**Hasil Sukses:**
- ✅ Transaksi berhasil diproses
- ✅ Struk akan ditampilkan/dicetak
- ✅ Stok produk terupdate
- ✅ Pesan sukses: "Pembayaran berhasil"

#### 5.4.3 Perbandingan Kedua Metode

| Aspek | Tunai | E-Wallet |
|-------|:-----:|:--------:|
| **Input Jumlah** | Wajib | Tidak perlu |
| **Kembalian** | Ada | Tidak ada |
| **Verifikasi** | Validasi uang cukup | Auto-approved |
| **Kecepatan** | Butuh hitung kembalian | Langsung proses |

---

### 5.5 Cetak Struk

#### Tujuan
Menampilkan dan mencetak bukti transaksi untuk pelanggan.

#### Langkah Penggunaan

1. Setelah pembayaran berhasil, halaman struk akan otomatis ditampilkan
2. Struk menampilkan:
   - Nama Toko & Tanggal Transaksi
   - Daftar Produk (dengan harga satuan & subtotal)
   - Total Harga
   - Metode Pembayaran
   - Jumlah Bayar & Kembalian (untuk tunai)
   - Nama Kasir & ID Transaksi

**Contoh Format Struk:**
```
╔════════════════════════════════════════╗
║        AGRI-POS TOKO PERTANIAN         ║
║     StrukPenjualan & Bukti Bayar       ║
╚════════════════════════════════════════╝

Tanggal: 25 Jan 2026 14:35:22
Kasir: Kasir1 (ID: 1)
Transaksi ID: TXN-20260125-001

────────────────────────────────────────
Produk                  Qty    Harga
────────────────────────────────────────
Tomat Segar              2    24.000
Cabai Rawit              3    24.000
Pupuk Organik            1    50.000
────────────────────────────────────────
TOTAL HARGA                    98.000

Metode Pembayaran: TUNAI
Jumlah Bayar:                 100.000
Kembalian:                      2.000
────────────────────────────────────────

Terima kasih telah berbelanja!
Agri-POS v1.0

════════════════════════════════════════
```

#### 5.5.1 Mencetak Struk

**Langkah Penggunaan:**

1. Di halaman struk, klik tombol **"Print"** (atau "Cetak Struk")
2. Dialog Print akan muncul
3. Pilih printer yang tersedia
4. Atur setting (jumlah copy, dll)
5. Klik **"OK"** atau **"Print"** untuk mencetak

**Catatan:**
- Pastikan printer sudah terhubung dan aktif
- Kertas minimal 80x200 mm untuk struk
- Printer thermal direkomendasikan untuk struk

#### 5.5.2 Menyimpan Struk (Optional)

Beberapa sistem memiliki fitur:
1. Klik tombol **"Simpan Struk"** (atau "Save as PDF")
2. Pilih lokasi penyimpanan
3. Struk akan disimpan sebagai file

---

### 5.6 Laporan Penjualan (ADMIN ONLY)

#### Tujuan
Melihat data transaksi penjualan dan analisis bisnis untuk pengambilan keputusan.

#### Langkah Penggunaan

1. Login sebagai **ADMIN**
2. Klik tab **"Laporan"** (atau "Reports")
3. Halaman laporan akan ditampilkan dengan:
   - Tabel data transaksi
   - Filter tanggal (dari - sampai)
   - Grafik omset penjualan
   - Tombol export/cetak

#### 5.6.1 Melihat Daftar Transaksi

**Informasi yang ditampilkan:**
- No. Transaksi (Transaction ID)
- Tanggal & Waktu
- Total Penjualan (Rp)
- Metode Pembayaran
- Kasir yang melayani
- Status

**Contoh Tabel:**
```
No  | Tanggal Jam     | Total      | Metode   | Kasir  | Status
----|-----------------|-----------|----------|--------|--------
1   | 25/01 14:35:22  | 98.000    | Tunai    | Kasir1 | Selesai
2   | 25/01 15:12:44  | 150.000   | E-Wallet | Kasir1 | Selesai
3   | 25/01 16:45:30  | 75.000    | Tunai    | Kasir2 | Selesai
```

#### 5.6.2 Filter Laporan Berdasarkan Tanggal

**Langkah Penggunaan:**

1. Di halaman laporan, cari field **"Dari Tanggal"** dan **"Sampai Tanggal"**
2. Klik field "Dari Tanggal", pilih tanggal awal periode laporan
3. Klik field "Sampai Tanggal", pilih tanggal akhir periode
4. Klik tombol **"Filter"** atau **"Terapkan"**
5. Tabel akan menampilkan transaksi hanya dalam periode yang dipilih

**Contoh Filter:**
```
Dari Tanggal: 1 Januari 2026
Sampai Tanggal: 31 Januari 2026
Result: Menampilkan semua transaksi selama bulan Januari
```

#### 5.6.3 Melihat Grafik Omset

**Tujuan:** Visualisasi trend penjualan dalam bentuk grafik

**Informasi Grafik:**
- Sumbu X: Tanggal atau Periode
- Sumbu Y: Total Omset (Rp)
- Garis grafik menunjukkan trend penjualan harian/mingguan/bulanan

**Cara Membaca Grafik:**
- Garis naik = Penjualan meningkat
- Garis turun = Penjualan menurun
- Peak = Hari/periode dengan penjualan tertinggi
- Valley = Hari/periode dengan penjualan terendah

#### 5.6.4 Export Laporan

**Langkah Penggunaan:**

1. Di halaman laporan, klik tombol **"Export ke CSV"** (atau "Export Data")
2. Dialog "Simpan File" akan muncul
3. Pilih lokasi penyimpanan
4. Klik **"Simpan"**

**File yang dihasilkan:**
- Nama: `laporan_penjualan_[tanggal].csv`
- Format: CSV (bisa dibuka di Excel)
- Isi: Daftar transaksi lengkap dengan detail

#### 5.6.5 Cetak Laporan

**Langkah Penggunaan:**

1. Di halaman laporan, klik tombol **"Cetak"** (atau "Print Report")
2. Dialog Print akan muncul
3. Atur setting printer
4. Klik **"OK"** untuk mencetak

**Catatan:**
- Laporan akan dicetak dengan tabel lengkap
- Rekomendasi: Gunakan kertas A4 landscape untuk tampilan optimal

---

## 6. Penanganan Error

Bagian ini membantu user mengatasi masalah yang mungkin timbul.

### 6.1 Error Umum & Solusi

| No | Error | Penyebab | Solusi |
|----|----|---------|--------|
| 1 | **Login Gagal: "Username atau password salah"** | Kredensial tidak sesuai | Cek kembali username & password, case-sensitive |
| 2 | **"Pengguna tidak ditemukan"** | User belum terdaftar | Hubungi admin untuk membuat akun |
| 3 | **"Koneksi Database Gagal"** | PostgreSQL tidak running | Pastikan PostgreSQL sudah start: `pg_ctl start` |
| 4 | **"Table tidak ditemukan"** | Schema belum di-import | Import schema: `psql -U agripos_user -d agripos -f sql/schema.sql` |
| 5 | **"Stok tidak cukup"** | Kuantitas melebihi stok | Kurangi jumlah atau pilih produk lain |
| 6 | **"Produk sudah ada"** | Kode produk duplikat | Gunakan kode yang berbeda |
| 7 | **"Uang tidak cukup"** (Tunai) | Jumlah pembayaran < total | Minta tambahan uang ke pelanggan |
| 8 | **"Harga tidak valid"** | Harga < 0 atau format salah | Masukkan angka positif, format: 15000 |
| 9 | **Aplikasi Crash/Error** | Bug sistem atau memory penuh | Restart aplikasi: tutup dan buka kembali |
| 10 | **"Printer tidak ditemukan"** | Printer belum terhubung | Hubungkan printer dan restart aplikasi |

### 6.2 Troubleshooting

#### 🔧 Jika Aplikasi Tidak Bisa Jalankan

```
Error: "Command 'mvn' not found"

Solusi:
1. Maven belum diinstall atau PATH tidak benar
2. Install Maven dari https://maven.apache.org/
3. Tambahkan folder bin Maven ke PATH environment variable
4. Restart terminal/command prompt
5. Coba lagi: mvn --version
```

```
Error: "javafx-maven-plugin not found"

Solusi:
1. Jalankan: mvn clean install
2. Tunggu proses download dependency
3. Coba jalankan lagi: mvn javafx:run
```

```
Error: "Connection refused (Database)"

Solusi:
1. Pastikan PostgreSQL sudah running
2. Di Windows: Buka Services, cari PostgreSQL, klik Start
3. Di Linux: sudo systemctl start postgresql
4. Verifikasi: psql -U postgres
```

#### 🔧 Jika Transaksi Bermasalah

```
Error: "Tidak bisa tambah produk ke keranjang"

Solusi:
1. Cek apakah database sudah konek (lihat status connection)
2. Cek stok produk (harus > 0)
3. Cek jumlah input (harus angka positif)
4. Restart aplikasi
```

```
Error: "Pembayaran gagal"

Solusi:
1. Untuk Tunai: Cek jumlah uang sudah cukup
2. Untuk E-Wallet: Proses sudah berhasil (biasanya auto-approved)
3. Lihat pesan error spesifik di layar
4. Hubungi admin jika masih error
```

### 6.3 Apa yang Dilakukan Sistem untuk Mencegah Error

✓ **Validasi Input** - Mencegah input yang tidak sesuai format  
✓ **Pengecekan Stok** - Tidak bisa jual lebih dari stok  
✓ **Database Transaction** - Data tidak hilang jika ada error  
✓ **Duplicate Prevention** - Kode produk tidak bisa duplikat  
✓ **Connection Pooling** - Koneksi database reliable  

---

## 7. Contoh Skenario Penggunaan

### Skenario 1: Kasir Melakukan Transaksi Penjualan

#### Situasi
Kasir "Kasir1" melayani pelanggan yang membeli 3 jenis produk dan membayar dengan tunai.

#### Langkah Demi Langkah

**Step 1: Login**
```
Username: kasir1
Password: kasir123
Klik Login
→ Masuk ke dashboard Kasir
```

**Step 2: Mulai Transaksi**
```
Klik tab "Penjualan"
→ Halaman penjualan terbuka dengan daftar produk
```

**Step 3: Tambah Produk ke Keranjang**
```
Produk 1: Tomat Segar
- Klik tombol "Tambah" / Input jumlah: 2 kg
- Harga satuan: 12.000 → Subtotal: 24.000

Produk 2: Cabai Rawit
- Klik tombol "Tambah" / Input jumlah: 3 buah
- Harga satuan: 8.000 → Subtotal: 24.000

Produk 3: Pupuk Organik
- Klik tombol "Tambah" / Input jumlah: 1 kg
- Harga satuan: 50.000 → Subtotal: 50.000

Total Keranjang: 98.000
```

**Step 4: Checkout**
```
Klik tombol "Checkout"
→ Halaman pembayaran terbuka
```

**Step 5: Pilih Metode Pembayaran**
```
Pilih metode: "Tunai"
Input jumlah uang: 100.000
Sistem hitung kembalian: 100.000 - 98.000 = 2.000
```

**Step 6: Proses Pembayaran**
```
Klik tombol "Bayar"
→ Transaksi diproses
→ Stok produk berkurang:
   - Tomat Segar: -2 kg
   - Cabai Rawit: -3 buah
   - Pupuk Organik: -1 kg
```

**Step 7: Cetak Struk**
```
Klik tombol "Print Struk"
→ Dialog printer muncul
→ Pilih printer
→ Klik "OK" untuk mencetak
→ Struk tercetak untuk pelanggan
```

**Step 8: Selesai**
```
Transaksi selesai
Total penjualan: 98.000
Uang diterima: 100.000
Kembalian: 2.000
→ Ready untuk transaksi berikutnya
```

---

### Skenario 2: Admin Mengelola Stok Produk

#### Situasi
Admin "admin" perlu mengecek stok produk karena ada informasi beberapa produk mulai habis.

#### Langkah Demi Langkah

**Step 1: Login**
```
Username: admin
Password: admin123
Klik Login
→ Masuk ke dashboard Admin
```

**Step 2: Buka Menu Produk**
```
Klik tab "Produk"
→ Halaman produk terbuka
→ Menampilkan daftar semua produk dengan stok
```

**Step 3: Cek Stok Produk**
```
Lihat kolom "Stok":
- Tomat Segar: 48 kg (banyak, normal)
- Cabai Rawit: 17 buah (sedikit, perlu restock)
- Pupuk Organik: 4 kg (sangat sedikit, urgent!)
```

**Step 4: Update Stok untuk Produk yang Habis**
```
Produk: Pupuk Organik
Status: Stok hanya 4 kg, perlu diisi

Klik tombol "Edit" pada baris Pupuk Organik
→ Form edit terbuka

Ubah nilai Stok: 4 → 100 kg

Klik tombol "Update"
→ Stok Pupuk Organik updated: 100 kg
```

**Step 5: Lihat Laporan Penjualan untuk Insight**
```
Klik tab "Laporan"
→ Halaman laporan terbuka

Filter laporan periode: Januari 2026
→ Lihat data penjualan bulan ini

Analisis:
- Produk terlaris: Pupuk Organik (banyak terjual → stok cepat habis)
- Produk lambat: Bibit Cabai
- Rata-rata harian: 2.450.000
```

**Step 6: Export Data Stok untuk Backup**
```
Klik tab "Produk"
→ Klik tombol "Export ke CSV"
→ Pilih lokasi simpan
→ File tersimpan: products_20260125.csv
→ Bisa di-backup atau dibuka di Excel
```

**Step 7: Logout**
```
Klik tombol "Logout"
→ Kembali ke halaman login
→ Selesai
```

---

### Skenario 3: Troubleshooting - Kasir Lupa Password

#### Situasi
Kasir "Kasir2" lupa password dan tidak bisa login.

#### Langkah Penyelesaian

```
1. Kasir2 klik "Lupa Password" atau hubungi Admin

2. Admin login dengan akun admin
   Username: admin
   Password: admin123

3. Admin pergi ke menu "Manajemen User" (jika ada)
   atau hubungi database admin untuk reset password

4. Admin reset password Kasir2 ke password temporary

5. Kasir2 login dengan password baru, lalu ubah password

6. Selesai, Kasir2 bisa login lagi
```

---

## 8. FAQ (Pertanyaan Umum)

### Q1: Bagaimana jika listrik mati saat transaksi?

**A:** Data transaksi yang sudah tersimpan tidak akan hilang karena sudah masuk database. Hanya transaksi yang sedang berjalan (belum checkout) yang bisa hilang. Sistem menggunakan database transaction untuk consistency.

**Tips Pencegahan:**
- Gunakan UPS (Uninterruptible Power Supply) untuk server
- Backup database secara berkala
- Simpan struk fisik sebagai bukti

---

### Q2: Bisakah saya mengubah password login?

**A:** Tergantung fitur sistem. Jika ada menu "Pengaturan" atau "Profil Pengguna", Anda bisa ubah password di sana. Jika tidak ada, hubungi admin untuk bantuan.

---

### Q3: Apakah sistem bisa offline?

**A:** Tidak. Sistem memerlukan koneksi ke database PostgreSQL. Jika database offline, aplikasi tidak bisa berjalan. Solusi: Setup database lokal di komputer yang sama.

---

### Q4: Bagaimana jika ada error saat mencetak struk?

**A:** 
1. Pastikan printer sudah terhubung dan aktif
2. Cek setting printer di sistem operasi
3. Coba cetak dari aplikasi lain untuk verifikasi
4. Jika masih error, restart printer dan aplikasi

---

### Q5: Bisakah stok produk tidak boleh negatif?

**A:** Ya, sistem sudah ada validasi. Kasir tidak bisa menjual lebih dari stok yang ada. Akan muncul error: "Stok tidak cukup".

---

### Q6: Bagaimana jika ada kesalahan transaksi?

**A:** Transaksi yang sudah checkout dan tersimpan tidak bisa dihapus/dibatalkan (untuk akurasi data). Jika ada kesalahan:
- Catat ID transaksi
- Hubungi admin
- Admin membuat nota koreksi atau refund manual
- Update inventory sesuai kebutuhan

---

### Q7: Apakah ada batasan jam operasional?

**A:** Tidak ada. Sistem 24/7 siap digunakan. Tapi disarankan restart aplikasi/database secara berkala untuk menjaga performa.

---

### Q8: Berapa banyak transaksi yang bisa diproses per hari?

**A:** Tidak ada batasan. Sistem dapat menangani ribuan transaksi per hari (tergantung hardware dan database optimization).

---

### Q9: Bagaimana cara reset database ke data awal?

**A:** 
```sql
-- Login ke PostgreSQL
psql -U agripos_user -d agripos

-- Drop semua table
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- Import schema lagi
exit
psql -U agripos_user -d agripos -f sql/schema.sql
```

---

### Q10: Apakah data transaksi bisa dihapus?

**A:** Idealnya tidak. Data transaksi adalah record penting untuk audit trail. Jika ada kebutuhan untuk menghapus:
- Hubungi database admin
- Buat backup terlebih dahulu
- Hapus dengan hati-hati dan catat alasannya

---

## 9. Penutup

### Kesimpulan

Sistem **Agri-POS** adalah solusi lengkap untuk mengelola operasional toko pertanian. Dengan fitur-fitur yang komprehensif dan antarmuka yang user-friendly, sistem ini memudahkan:

✅ **Admin** dalam mengelola stok produk dan melihat laporan penjualan  
✅ **Kasir** dalam melayani pelanggan dengan cepat dan akurat  
✅ **Pemilik Toko** dalam memantau performa bisnis  

### Siap Digunakan

Setelah mengikuti panduan instalasi dan panduan penggunaan di manual book ini, sistem Agri-POS sudah **siap untuk dioperasionalkan di toko Anda**.

### Dukungan Teknis

Jika mengalami masalah yang tidak tercakup dalam manual book ini:

📧 **Email Support:** support@agripos.local  
📞 **WhatsApp:** [Hubungi Admin]  
🔧 **In-Site Support:** Hubungi tim teknis

### Update & Revisi

Manual book ini akan diupdate sesuai dengan versi terbaru aplikasi. Periksa secara berkala untuk mendapatkan informasi terbaru.

**Versi Manual Book:** 1.0  
**Tanggal Publikasi:** 25 Januari 2026  
**Aplikasi:** Agri-POS v1.0  

---

## Terima Kasih

Terima kasih telah menggunakan **Agri-POS**. Semoga aplikasi ini membantu meningkatkan efisiensi bisnis Anda.

**Happy Selling! 🌾🛒**

---

**© 2026 Agri-POS Development Team**  
*Solusi POS untuk Toko Pertanian Indonesia*
