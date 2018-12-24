package com.prashanth.pluralsight.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.prashanth.pluralsight.learning.Electronics.Mobile;
import static com.prashanth.pluralsight.learning.Electronics.Thermostat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectronicsProductsTest {

    private ElectronicProducts electronicProducts = new ElectronicProducts();

    @Test
    @DisplayName("Add electronic products")
    void addProducts() {
        // Adding duplicate items and asserting the size
        electronicProducts.add(Mobile);
        electronicProducts.add(Mobile);
        electronicProducts.add(Thermostat);
        assertEquals(2, electronicProducts.getElectronicsSize());
    }
}

