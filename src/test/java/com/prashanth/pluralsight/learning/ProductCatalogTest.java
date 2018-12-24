package com.prashanth.pluralsight.learning;

import org.junit.jupiter.api.Test;

import static com.prashanth.pluralsight.learning.ProductFixtures.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class ProductCatalogTest {

    private Shipment shipment = new Shipment();

    @Test
    void shouldOnlyHoldUniqueProducts() {
        ProductCatalog productCatalog = new ProductCatalog();

        productCatalog.isSuppliedBy(bobs);
        productCatalog.isSuppliedBy(kates);

        assertThat(productCatalog, containsInAnyOrder(door, doorPanel, window));
    }

    @Test
    void shouldFindLightVanProducts() {
        ProductCatalog productCatalog = new ProductCatalog();

        productCatalog.isSuppliedBy(bobs);
        productCatalog.isSuppliedBy(kates);

        assertThat(productCatalog.lightVanProducts(), containsInAnyOrder(window));
    }

    @Test
    void shouldFindHeavyVanProducts() {
        ProductCatalog productCatalog = new ProductCatalog();

        productCatalog.isSuppliedBy(bobs);
        productCatalog.isSuppliedBy(kates);

        assertThat(productCatalog.heavyVanProducts(), containsInAnyOrder(door, doorPanel));
    }

}