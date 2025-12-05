package Year2025;

import java.io.*;
import java.util.*;

public class day1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Year2025/txt/txt/day1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        }

        int password = computePassword(lines);
        System.out.println("Password: " + password);
    }

    public static int computePassword(List<String> rotations) {
        int pos = 50; // starting position
        int hits = 0; // count of times dial lands on 0

        for (String rotation : rotations) {
            char dir = rotation.charAt(0);
            int dist = Integer.parseInt(rotation.substring(1));

            if (dir == 'L') {
                pos = (pos - dist) % 100;
                if (pos < 0)
                    pos += 100; // handle negative wrap
            } else if (dir == 'R') {
                pos = (pos + dist) % 100;
            } else {
                throw new IllegalArgumentException("Invalid rotation: " + rotation);
            }

            if (pos == 0) {
                hits++;
            }
        }
        return hits;
    }
}
