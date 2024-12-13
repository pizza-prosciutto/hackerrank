package com.github.pizzaprosciutto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    /**
     * 1 Month Preparation Kit Week 1, Flipping bits
     * 
     * Flip all the bits and return the result as an unsigned integer.
     * 
     * @param n an integer
     * @return the unsigned decimal integer result
     */
    public static long flippingBits(long n) {
        return n & 0xFFFFFFFFL ^ 0xFFFFFFFFL;
    }

    /**
     * 1 Month Preparation Kit Week 1, Diagonal Difference
     * 
     * Given a square matrix, calculate the absolute difference between the sums of
     * its diagonals.
     * 
     * @param arr an array of integers
     * @return the absolute diagonal difference
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        Integer sumLeftToRight = 0, sumRightToLeft = 0;
        for (int i = 0; i < arr.get(0).size(); i++) {
            List<Integer> subList = arr.get(i);
            sumLeftToRight += subList.get(i);
            sumRightToLeft += subList.get(subList.size() - i - 1);
        }
        int diff = sumLeftToRight - sumRightToLeft;
        return Math.abs(diff);
    }

    /**
     * 1 Month Preparation Kit Week 1, Diagonal Difference
     * 
     * Given a list of integers, count and return the number of times each value
     * appears as an array of integers.
     * 
     * @param arr an array of integers
     * @return a frequency array
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> frequency = new ArrayList<>(Collections.nCopies(100, 0));
        for (int i = 0; i < arr.size(); i++) {
            int idx = arr.get(i);
            frequency.set(idx, frequency.get(idx) + 1);
        }
        return frequency;
    }

    /**
     * 1 Month Preparation Kit Week 1, Panagrams
     * 
     * A pangram is a string that contains every letter of the alphabet. Given a
     * sentence determine whether it is a pangram in the English alphabet. Ignore
     * case. Return either pangram or not pangram as appropriate.
     * 
     * @param s a string to test
     * @return either pangram or not pangram
     */
    public static String pangrams(String s) {
        Map<Character, Integer> letters = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 0));
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int v = Character.getNumericValue(c);
            if ((Character.getNumericValue('A') <= v &&
                    Character.getNumericValue('Z') >= v) ||
                    (Character.getNumericValue('a') <= v &&
                            Character.getNumericValue('z') >= v)) {
                letters.replace(Character.toLowerCase(c), 1);
            }
        }
        return letters.values().stream().filter(v -> v.equals(0)).count() == 0 ? "pangram" : "not pangram";
    }

    /**
     * 1 Month Preparation Kit Week 1, Permuting Two Arrays
     * 
     * There are two n-element arrays of integers, A and B. Permute them into some
     * A' and B' such that the relation A'[i] + B'[i] >= k holds for all
     * i where 0 <= i <= n.
     * 
     * @param k an integer
     * @param A an array of integers
     * @param B an array of integers
     * @return either YES or NO
     */
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        B.sort((x, y) -> x.compareTo(y));
        List<Integer> diffs = A.stream().map(a -> k - a).sorted().collect(Collectors.toList());
        for (Integer b : B) {
            for (Integer diff : diffs) {
                if (diff > b) {
                    return "NO";
                }
                diffs.remove(diff);
                break;
            }
        }
        return "YES";
    }

    /**
     * 1 Month Preparation Kit Week 1, Subarray Division 1
     * 
     * Lily decides to share a contiguous segment of the bar selected such that:
     * * The length of the segment matches Ron's birth month, and,
     * * The sum of the integers on the squares is equal to his birth day.
     * Determine how many ways she can divide the chocolate.
     * 
     * @param s the numbers on each of the squares of chocolate
     * @param d Ron's birth day
     * @param m Ron's birth month
     * @return the number of ways the bar can be divided
     */
    public static int birthday(List<Integer> s, int d, int m) {
        int ways = 0;
        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += s.get(i + j);
            }
            if (sum == d)
                ways += 1;
        }
        return ways;
    }

    /**
     * 1 Month Preparation Kit Week 1, XOR Strings 2
     * 
     * Given two strings consisting of digits 0 and 1 only, find the XOR of the two
     * strings.
     * 
     * * Note: You can modify at most three lines in the given code and you cannot
     * * add or remove lines to the code.
     */
    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i))
                res += "0";
            else
                res += "1";
        }

        return res;
    }

}