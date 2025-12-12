package com.upb.agripos;
import java.util.ArrayList;

// Class ShoppingCart menggunakan ArrayList 
public class ShoppingCart {

    private final ArrayList<Product> items = new ArrayList<>();
    // tambah produk
    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }
    // calculate total price
    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }
    // isi keranjang
    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}