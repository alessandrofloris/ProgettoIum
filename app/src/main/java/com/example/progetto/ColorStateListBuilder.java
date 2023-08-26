package com.example.progetto;

import android.content.res.ColorStateList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorStateListBuilder {
    List<Integer> colors = new ArrayList<>();
    List<int[]> states = new ArrayList<>();

    public ColorStateListBuilder addState(int[] state, int color) {
        states.add(state);
        colors.add(color);
        return this;
    }

    public ColorStateList build() {
        return new ColorStateList(convertToTwoDimensionalIntArray(states),
                convertToIntArray(colors));
    }

    private int[][] convertToTwoDimensionalIntArray(List<int[]> integers) {
        int[][] result = new int[integers.size()][1];
        Iterator<int[]> iterator = integers.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    private int[] convertToIntArray(List<Integer> integers) {
        int[] result = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            result[i] = iterator.next();
        }
        return result;
    }
}