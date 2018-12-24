package com.prashanth.pluralsight.learning;

import java.util.Comparator;
import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private int weight;

    public Product(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);

    public static Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
