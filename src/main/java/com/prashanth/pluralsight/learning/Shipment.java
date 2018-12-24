package com.prashanth.pluralsight.learning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {

    private static final int PRODUCT_NOT_PRESENT = -1;
    private static final int LIGHT_WEIGHT_VAN_WEIGHT = 20;

    private final List<Product> productList = new ArrayList<>();

    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;

    public void add(Product product) {
        productList.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {
        final int index = productList.indexOf(oldProduct);
        if(index != PRODUCT_NOT_PRESENT) {
            productList.set(index, newProduct);
        }
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.iterator();
    }

    public void prepare() {
        // sort products by weight
        productList.sort(Product.BY_WEIGHT);
        int splitPoint = findSplitPoint();
        lightVanProducts = productList.subList(0,splitPoint);
        heavyVanProducts = productList.subList(splitPoint, productList.size());
    }

    private int findSplitPoint() {
        for (int i = 0; i < productList.size(); i++) {
            final Product product = productList.get(i);
            if(product.getWeight() > LIGHT_WEIGHT_VAN_WEIGHT) {
                return i;
            }
        }
        return 0;
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }
}
