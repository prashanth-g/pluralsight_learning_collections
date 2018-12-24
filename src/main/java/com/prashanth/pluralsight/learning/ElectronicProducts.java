package com.prashanth.pluralsight.learning;

import java.util.EnumSet;

public class ElectronicProducts {

    EnumSet<Electronics> electronics = EnumSet.noneOf(Electronics.class);

    public void add(Electronics electronicItems) {
        electronics.add(electronicItems);
    }

    // To confirm that element is added
    public int getElectronicsSize() {
        return electronics.size();
    }

}
