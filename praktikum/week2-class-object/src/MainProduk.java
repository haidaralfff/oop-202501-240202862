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
