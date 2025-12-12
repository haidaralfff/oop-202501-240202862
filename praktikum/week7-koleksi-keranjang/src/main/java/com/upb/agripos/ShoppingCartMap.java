package com.upb.agripos;
// library yang digunakan bawaan java
import java.util.HashMap;
import java.util.Map;

// Class ShoppingCartMap menggunakan Map
public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    // Menambahkan produk ke keranjang
    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    //hapus barang dari keranjang
    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }
    // calculate total price
    public double getTotal() {
        double total = 0;
        // mapping product dan quantity
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
    // isi keranjang
    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}
