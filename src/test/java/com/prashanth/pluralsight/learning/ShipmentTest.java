package com.prashanth.pluralsight.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.prashanth.pluralsight.learning.ProductFixtures.door;
import static com.prashanth.pluralsight.learning.ProductFixtures.doorPanel;
import static com.prashanth.pluralsight.learning.ProductFixtures.window;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class ShipmentTest {
    private Shipment shipment = new Shipment();

    @Test
    @DisplayName("SHOULD ADD ITEMS &#x1F601;")
    void shouldAddItems() {
        shipment.add(door);
        shipment.add(window);
        assertThat(shipment, contains(door, new Product(1, "window", 10)));
    }

    @Test
    void shouldReplaceItems() {
        shipment.add(door);
        shipment.add(window);

        shipment.replace(door, doorPanel);
        assertThat(shipment, contains(doorPanel, window));
    }

    @Test
    void shouldNotReplaceMissingItems() {
        shipment.add(window);
        shipment.replace(door, doorPanel);
        assertThat(shipment, contains(window));
    }

    @Test
    void shouldIdentifyVanRequests() {

       shipment.add(door);
       shipment.add(window);
       shipment.add(doorPanel);

       shipment.prepare();

       assertThat(shipment.getLightVanProducts(), contains(window));
       assertThat(shipment.getHeavyVanProducts(), contains(door, doorPanel));
    }

}