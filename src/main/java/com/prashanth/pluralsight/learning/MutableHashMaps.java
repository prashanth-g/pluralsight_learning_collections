package com.prashanth.pluralsight.learning;

import java.util.HashMap;
import java.util.Map;

public class MutableHashMaps {
    public static void main(String[] args) {
        final Map<MutableString, String> mutableStringMap = new HashMap<>();

        final String value = "abc";

        final MutableString key = new MutableString(value);

        mutableStringMap.put(key, value);

        System.out.println(mutableStringMap.get(key));
        System.out.println(mutableStringMap);

        key.setValue("def");

        System.out.println(mutableStringMap.get(key));
        System.out.println(mutableStringMap);
    }

    private static class MutableString {
        private String value;

        public MutableString(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MutableString that = (MutableString) o;

            return value != null ? value.equals(that.value) : that.value == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "MutableString{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
