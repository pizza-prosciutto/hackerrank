package com.github.pizzaprosciutto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    /**
     * 1 Month Preparation Kit Week 1, Sparse Arrays
     * 
     * The function must return an array of integers representing the frequency of
     * occurrence of each query string in strings.
     * 
     * @param strings an array of strings to search
     * @param queries an array of query strings
     * @return an array of results for each query
     */
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            results.add((int) strings.stream().filter(s -> s.equals(query)).count());
        }
        return results;
    }

    /**
     * 1 Month Preparation Kit Week 1, Lonely Integer
     * 
     * Given an array of integers, where all elements but one occur twice, find the
     * unique element.
     * 
     * @param a an array of integers
     * @return the element that occurs only once
     */
    public static int lonelyinteger(List<Integer> a) {
        List<Integer> list = new ArrayList<>(a);
        list.sort((x, y) -> x.compareTo(y));
        int lonelyInteger = list.get(0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            int element = list.get(i);
            if ((lonelyInteger != element) && (count == 1)) {
                return lonelyInteger;
            } else if (lonelyInteger != element) {
                lonelyInteger = element;
                count = 1;
            } else {
                count++;
            }
        }
        return list.get(list.size() - 1);
    }

}