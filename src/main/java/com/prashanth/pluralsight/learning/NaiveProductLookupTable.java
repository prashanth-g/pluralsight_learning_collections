package com.prashanth.pluralsight.learning;

import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable {

    private List<Product> productList = new ArrayList<>();

    @Override
    public Product lookupById(int id) {
        for (Product product: productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(final Product productToAdd) {
        for (Product product: productList) {
            if(product.getId() == productToAdd.getId()) {
                throw new IllegalArgumentException("Product already exists: "+productToAdd);
            }
        }
        productList.add(productToAdd);
    }

    @Override
    public void clear() {
        productList.clear();
    }
}
