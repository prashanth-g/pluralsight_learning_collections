package com.prashanth.pluralsight.learning;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewOverMaps {
    public static void main(String[] args) {
        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.doorPanel);
        idToProduct.put(3, ProductFixtures.window);

        System.out.println(idToProduct);

        final Set<Integer> ids =  idToProduct.keySet();
        System.out.println(ids);

        final Collection<Product> productCollection = idToProduct.values();
        System.out.println(productCollection);

        // productCollection.remove(ProductFixtures.doorPanel);
        final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();

        for (Map.Entry<Integer, Product> entry: entries) {
            System.out.println(entry.getKey() + " -> " +entry.getValue());
            entry.setValue(ProductFixtures.window);
        }

        System.out.println(idToProduct);
    }
}
