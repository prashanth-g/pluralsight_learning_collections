package com.prashanth.pluralsight.learning;

import java.util.*;

public class LookupTableComparison {

    private static final int ITERATION = 5;
    private static final int NUMBER_OF_PRODUCTS = 20000;

    private static final List<Product> products = generateProducts();

    private static List<Product> generateProducts() {
        final List<Product> products = new ArrayList<>();
        final Random weightGenerator = new Random();

        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
            products.add(new Product(i, "Product"+i, 10+weightGenerator.nextInt(10)));
        }
        Collections.shuffle(products);
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

    public static void main(String[] args) {
        runLookups(new MapProductLookupTable());
        runLookups(new NaiveProductLookupTable());
    }

    private static void runLookups(ProductLookupTable productLookupTable) {
        final List<Product> products = LookupTableComparison.products;
        System.out.println("Running lookups with "+productLookupTable.getClass().getSimpleName());
        for (int i = 0; i < ITERATION; i++) {
            final long startTime = System.nanoTime();
            for (Product product:products) {
                productLookupTable.addProduct(product);
            }

            for (Product product:products) {
                 final Product result = productLookupTable.lookupById(product.getId());
                 if(result != product) {
                     throw new IllegalStateException("Lookup table returned wrong product");
                 }
            }
            productLookupTable.clear();
            final long endTime = System.nanoTime();
            final long totalTime = (endTime - startTime) / 1000000;
            System.out.println(totalTime+"ms");
        }
    }
}
