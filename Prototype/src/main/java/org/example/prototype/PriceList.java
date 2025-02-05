package org.example.prototype;

import java.util.ArrayList;
import java.util.List;

public class PriceList implements IPrototype {

    private String name;
    private List<Product> productList;

    public PriceList(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
    }

    @Override
    public IPrototype clone() {
        // Clonación superficial: la lista sigue apuntando al mismo objeto en memoria.
        PriceList clone = new PriceList(this.name);
        clone.productList = new ArrayList<>(this.productList); // Se copia la referencia de los objetos
        return clone;
    }

    @Override
    public IPrototype deepClone() {
        // Clonación profunda: se clonan los productos dentro de la lista
        PriceList clone = new PriceList(this.name);
        List<Product> cloneProducts = new ArrayList<>();

        for (Product product : this.productList) {
            cloneProducts.add(product.clone()); // Clonación profunda de cada producto
        }

        clone.setProductList(cloneProducts);
        return clone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + " - PriceList{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
