package com.upb.agripos;

// class object untuk dipanggil pada shoppingcart
public class Product {
    private final String code;
    private final String name;
    private final double price;
// inisialisasi produk memiliki code, name, dan price
    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    // untuk mengambil value dari code, name, dan price memanfaatkan getter karena bersifat private
 public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
   
