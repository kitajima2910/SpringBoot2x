package com.hoaipx.learn2021.pxh.hackerrank;

import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {

    public static void main(String ...args) {
        System.out.println(compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8)));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        Integer[] totals = {0, 0};

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) > b.get(i)) {
                totals[0]++;
            } else if(a.get(i) < b.get(i)) {
                totals[1]++;
            }
        }

        return Arrays.asList(totals);
    }

}
