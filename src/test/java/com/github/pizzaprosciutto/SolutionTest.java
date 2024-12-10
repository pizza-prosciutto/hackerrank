package com.github.pizzaprosciutto;

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

}
