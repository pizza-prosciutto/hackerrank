package com.github.pizzaprosciutto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Solution {

    /**
     * 1 Month Preparation Kit Week 1, Plus Minus
     * 
     * @param arr
     */
    public static void plusMinus(List<Integer> arr) {
        int positives = (int) arr.stream().filter(e -> e > 0).count();
        int negatives = (int) arr.stream().filter(e -> e < 0).count();
        int zeroes = (int) arr.stream().filter(e -> e == 0).count();
        int length = arr.size();
        System.out.println(
                String.format("%.6f\n%.6f\n%.6f",
                        (float) positives / length,
                        (float) negatives / length,
                        (float) zeroes / length));
    }

    /**
     * 1 Month Preparation Kit Week 1, Min-Max Sum
     * 
     * Print two space-separated integers on one line: the minimum sum and the
     * maximum sum of of elements.
     * 
     * @param arr input array, e.g. 1 2 3 4 5
     */
    public static void miniMaxSum(List<Integer> arr) {
        arr.sort((x, y) -> x.compareTo(y));
        Long min = arr.subList(0, 4).stream().map(Long::valueOf).reduce(0L, (x, y) -> x + y);
        Long max = arr.subList(1, 5).stream().map(Long::valueOf).reduce(0L, (x, y) -> x + y);
        System.out.println(String.format("%d %d", min, max));
    }

    /**
     * 1 Month Preparation Kit Week 1, Time Conversion
     * 
     * @param s time in the format of 07:05:45PM
     * @return time in the format of 19:05:45
     */
    public static String timeConversion(String s) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("h:m:sa");
            Date timestamp = df.parse(s);
            return String.format("%tH:%tM:%tS", timestamp, timestamp, timestamp);
        } catch (Exception e) {
            return null;
        }

    }
}
