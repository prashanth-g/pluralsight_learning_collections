package com.prashanth.pluralsight.learning;

public class ProductFixtures {
    public static Product door = new Product(1,"door", 30);
    public static Product window = new Product(2, "window", 10);
    public static Product doorPanel = new Product(3, "doorPanel", 40);

    public static Supplier bobs = new Supplier("Bob's household suppliers");
    public static Supplier kates = new Supplier("Kate's suppliers");

    static {
        bobs.products().add(door);
        bobs.products().add(doorPanel);

        kates.products().add(doorPanel);
        kates.products().add(door);
        kates.products().add(window);
    }
}
