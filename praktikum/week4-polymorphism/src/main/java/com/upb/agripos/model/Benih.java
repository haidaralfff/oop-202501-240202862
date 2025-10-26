package main.java.com.upb.agripos.model;



public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }


    // Override method subclas product
    @Override
    public void getInfo() {
        System.out.println("Produk: " + getNama() + " (Kode: " + getKode() + " Stok: " + getStok() + ") varietas: " + varietas + " dengan harga: " + getHarga());
    }
}