package com.upb.agripos;
// main product untuk menjalankan program
public class Maincart {
    public class MainCart {
    public static void main(String[] args) {
        // menampilkan informasi diri
        System.out.println("Hello, I am Haidar Habibi Al Farisi-240202862 (Koleksi Keranjang Week 7)");
        // membuat objek produk dengan variabel p1 dan p2
        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);
        // membuat objek keranjang belanja
        ShoppingCart cart = new ShoppingCart();
        // memamnggil fungsi dari shoppingcart
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();


        cart.removeProduct(p1);
        cart.printCart();
    }
}
}
