package Year2025;

import java.io.*;
import java.util.*;

public class day3 {
    public static void main(String[] args) throws IOException {
        List<String> banks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Year2025/txt/txt/day3.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty())
                    banks.add(line);
            }
        }

        long total = 0;
        for (String bank : banks) {
            total += maxJoltage(bank);
        }
        System.out.println("Total output joltage: " + total);
    }

    // Compute the largest two-digit number from ordered pair (i < j)
    static int maxJoltage(String s) {
        int n = s.length();
        if (n < 2)
            return 0;

        // Precompute max digit in suffix starting at each index
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = s.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            suffixMax[i] = Math.max(d, suffixMax[i + 1]);
        }

        int best = 0;
        for (int i = 0; i < n - 1; i++) {
            int tens = s.charAt(i) - '0';
            int ones = suffixMax[i + 1]; // best possible digit after i
            int val = tens * 10 + ones;
            if (val > best)
                best = val;
            // Early exit: if tens == 9 and ones == 9, best is 99
            if (best == 99)
                break;
        }
        return best;
    }
}
