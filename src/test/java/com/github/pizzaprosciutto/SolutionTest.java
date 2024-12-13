package com.github.pizzaprosciutto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class SolutionTest {

    private String callAndRedirect(Consumer<List<Integer>> callback, List<Integer> input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        callback.accept(input);
        return baos.toString();
    }

    @Test
    public void plusMinusTest() {
        List<Integer> arr = Arrays.asList(1, 1, 0, -1, -1);
        String expected = String.format("0.400000\n0.400000\n0.200000");

        String result = callAndRedirect(Solution::plusMinus, arr);

        assertEquals(expected, result.substring(0, result.length() - 1));
    }

    @Test
    public void miniMaxSumTest() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        String expected = "10 14";

        String result = callAndRedirect(Solution::miniMaxSum, arr);

        // remove trailing new line
        assertEquals(expected, result.substring(0, result.length() - 1));
    }

    @Test
    public void timeConversionTest() {
        String expected = "19:05:45";
        String converted = Solution.timeConversion("07:05:45PM");
        assertEquals(expected, converted);
    }

    @Test
    public void matchingStrings() {
        List<String> strings = List.of("aba", "baba", "aba", "xzxb");
        List<String> queries = List.of("aba", "xzxb", "ab");
        List<Integer> expected = List.of(2, 1, 0);
        List<Integer> result = Solution.matchingStrings(strings, queries);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void lonelyintegerTest() {
        List<Integer> testList = List.of(1, 2, 3, 4, 3, 2, 1);
        Integer expected = 4;
        Integer result = Solution.lonelyinteger(testList);
        assertEquals(expected, result);
    }

    @Test
    public void flippingBitsTest() {
        long expected = 4294967294L;
        long result = Solution.flippingBits(1);
        System.out.println(Integer.toBinaryString((int) result));
        assertEquals(expected, result);
    }

    @Test
    public void diagonalDifferenceTest() {
        List<List<Integer>> testList = List.of(
                List.of(11, 2, 4),
                List.of(4, 5, 6),
                List.of(10, 8, -12));
        Integer expected = 15;
        Integer result = Solution.diagonalDifference(testList);
        assertEquals(expected, result);
    }

    @Test
    public void countingSortTest() {
        List<Integer> testList = List.of(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67,
                99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96,
                27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30,
                20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70,
                33);
        List<Integer> expected = List.of(0, 2, 0, 2, 0, 0, 1, 0, 1, 2, 1, 0, 1, 1, 0, 0, 2, 0, 1, 0, 1, 2, 1, 1, 1, 3,
                0, 2, 0, 0, 2, 0, 3, 3, 1, 0, 0, 0, 0, 2, 2, 1, 1, 1, 2, 0, 2, 0, 1, 0, 1, 0, 0, 1, 0, 0, 2, 1, 0, 1, 1,
                1, 0, 1, 0, 1, 0, 2, 1, 3, 2, 0, 0, 2, 1, 2, 1, 0, 2, 2, 1, 2, 1, 2, 1, 1, 2, 2, 0, 3, 2, 1, 1, 0, 1, 1,
                1, 0, 2, 2);
        List<Integer> result = Solution.countingSort(testList);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void pangramsTest() {
        String testInput = "We promptly judged antique ivory buckles for the next prize";
        String result = Solution.pangrams(testInput);
        assertEquals("pangram", result);

        testInput = "We promptly judged antique ivory buckles for the prize";
        result = Solution.pangrams(testInput);
        assertEquals("not pangram", result);
    }

}
