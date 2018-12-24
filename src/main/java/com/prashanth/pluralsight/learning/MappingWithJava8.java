package com.prashanth.pluralsight.learning;

import java.util.HashMap;
import java.util.Map;

public class MappingWithJava8 {
    public static void main(String[] args) {
        final Product product = new Product(-1, "Whatever customer wants", 100);

        final Map<Integer, Product> productMap = new HashMap<>();
        productMap.put(1, ProductFixtures.door);
        productMap.put(2, ProductFixtures.doorPanel);
        productMap.put(3, ProductFixtures.window);

        Product result = productMap.getOrDefault(10, product);
        System.out.println(result);

        Product result01 = productMap.replace(1, new Product(1, "Big Door", 140));
        System.out.println(productMap.get(1));

        System.out.println(productMap);

        productMap.replaceAll((id, oldProduct) -> new Product(id, oldProduct.getName(), oldProduct.getWeight()+10));

        System.out.println(productMap);

        productMap.forEach((key, value) -> {
            System.out.println(key + " -> "+value);
        });
    }
}
