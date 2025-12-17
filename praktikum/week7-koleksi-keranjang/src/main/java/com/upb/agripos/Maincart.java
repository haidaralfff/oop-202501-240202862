package com.upb.agripos;
// main product untuk menjalankan program
public class Maincart {
    public class MainCart {
    public static void main(String[] args) {
        // menampilkan informasi diri
        System.out.println("Hello, I am Haidar Habibi Al Farisi-240202862 (Koleksi Keranjang Week 7)");
        //  menggunakan double untuk harga dan quantity dan stock product
        Product p1 = new Product("P01", "Beras", 200, 50000);
        Product p2 = new Product("P02", "Pupuk", 100, 30000);
        // membuat objek keranjang belanja
        ShoppingCart cart = new ShoppingCart();
        // method dari product p1 dan p2 dengan double quantity
        cart.addProduct(p2, 0);
        cart.addProduct(p1, 1);
        cart.addProduct(p2, 1);
        // setelah p1 dihapus dari keranjang
        System.out.println("setelah dihapus dari keranjang belanja p1");
        cart.removeProduct(p1);
        cart.printCart();
    }
}
}