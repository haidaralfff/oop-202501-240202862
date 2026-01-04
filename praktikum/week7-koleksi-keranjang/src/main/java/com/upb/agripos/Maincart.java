package com.upb.agripos;


public class Maincart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Haidar Habibi Al Farisi-240202862 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000, 0);
        Product p2 = new Product("P02", "Pupuk", 30000, 0);
        

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

    System.out.println("\nSetelah menghapus " + p2.getCode() + " " + p2.getName() + " dari keranjang:");
        cart.removeProduct(p2);
        cart.printCart();
    }
}