package main.java.com.upb.agripos.model;
// menambahkan  sub class obat hama
public class ObatHama extends Produk {
    private String targetHama;

    public ObatHama(String kode, String nama, double harga, int stok, String targetHama) {
        super(kode, nama, harga, stok);
        this.targetHama = targetHama;
    }

    public String getTargetHama() { return targetHama; }
    public void setTargetHama(String targetHama) { this.targetHama = targetHama; }

    
    @Override
    public void getInfo() {
        System.out.println("Produk: " + getNama() + " (Kode: " + getKode() + " Stok: " + getStok() + ") untuk hama: " + targetHama + " dengan harga: " + getHarga());
    }
}
