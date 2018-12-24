package com.prashanth.pluralsight.learning;

public class Customer {

    public static final Customer JIM = new Customer("Jim");
    public static final Customer AMY = new Customer("Amy");
    public static final Customer HOWY = new Customer("Howy");

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void reply(final String message) {
        System.out.printf("%s: %s\n", name, message);
    }
}
