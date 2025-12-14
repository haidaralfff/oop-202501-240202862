package com.upb.agripos;
import java.util.ArrayList;

// Constructor
public class ShoppingCart {

    private final ArrayList<Product> items = new ArrayList<>();
    // factory method dari class ShoppingCart
    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }
    // total harga
    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        // mengembalikan nilai kalkulasi dari total harga
        return sum;
    }
    // memamnggil isi keranjang untuk ditampilkan
    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}