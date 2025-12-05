package Year2025;

import java.io.*;
import java.util.*;

public class day2 {
    public static void main(String[] args) throws IOException {
        String input;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Year2025/txt/txt/day2.txt"))) {
            input = br.readLine().trim();
        }

        long sum = computeInvalidSum(input);
        System.out.println("Sum of invalid IDs: " + sum);
    }

    public static long computeInvalidSum(String input) {
        long total = 0;
        String[] ranges = input.split(",");

        for (String range : ranges) {
            String[] parts = range.split("-");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);

            for (int id = start; id <= end; id++) {
                if (isInvalid(id)) {
                    total += id;
                }
            }
        }
        return total;
    }

    public static boolean isInvalid(int id) {
        String s = String.valueOf(id);
        int len = s.length();

        // Must be even length
        if (len % 2 != 0)
            return false;

        String firstHalf = s.substring(0, len / 2);
        String secondHalf = s.substring(len / 2);

        return firstHalf.equals(secondHalf);
    }
}
