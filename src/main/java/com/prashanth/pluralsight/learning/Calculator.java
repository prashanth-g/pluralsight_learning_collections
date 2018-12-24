package com.prashanth.pluralsight.learning;

import org.omg.CORBA.StringHolder;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;

public class Calculator {
    public int evaluate(final String expression) {
        final Deque<String> stack = new ArrayDeque<>();

        final Deque<String> stacks = new LinkedList<>();

        final String[] tokens = expression.split(" ");
        for (String token: tokens) {
            stack.add(token);
        }

        while(stack.size() > 1) {
            final int left = parseInt(stack.pop());
            final String operator = stack.pop();
            final int right = parseInt(stack.pop());

            int result = 0;

            switch (operator) {
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
            }
            stack.push(String.valueOf(result));
        }
        return parseInt(stack.pop());
    }


}
