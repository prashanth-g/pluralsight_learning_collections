package com.prashanth.pluralsight.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Supplier {

    private List<Product> products = new ArrayList<>();

    private String name;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> products() {
        return products;
    }
}
