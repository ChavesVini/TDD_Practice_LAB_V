package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {

    private final CustomStack<T> stack;
    List<T> result = new ArrayList<>();

    public NumberAscOrder(CustomStack<T> stack) {
        this.stack = stack;
    }

    public List<T> sort() {
        try {
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            Collections.sort(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
