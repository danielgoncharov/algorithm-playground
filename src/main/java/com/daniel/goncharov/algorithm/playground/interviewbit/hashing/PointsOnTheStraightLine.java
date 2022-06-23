package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.*;

public class PointsOnTheStraightLine {

    public int maxPoints(ArrayList<Integer> xCoord, ArrayList<Integer> yCoord) {
        if (xCoord.size() <= 2) return xCoord.size();
        HashMap<Integer, HashSet<Integer>> lines = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < xCoord.size(); i++) {
            int x1 = xCoord.get(i);
            int y1 = yCoord.get(i);
            for (int j = i + 1; j < xCoord.size(); j++) {
                int x2 = xCoord.get(j);
                int y2 = yCoord.get(j);
                List<Integer> coef = getCoef(x1, y1, x2, y2);
                int hash = Objects.hash(
                        coef.get(0),
                        coef.get(1),
                        coef.get(2)
                );
                HashSet<Integer> dots = lines.getOrDefault(hash, new HashSet<>(Arrays.asList(Objects.hash(x1, y1))));
                if (!dots.contains(Objects.hash(x2, y2))) {
                    dots.add(Objects.hash(x2, y2));
                    lines.put(hash, dots);
                }
                max = Math.max(max, dots.size());
            }
        }
        return max;
    }

    private List<Integer> getCoef(int x1, int y1, int x2, int y2) {
        int a = y1 - y2;
        int b = x2 - x1;
        int c = x1 * y2 - x2 * y1;
        int gcd = gcd(a, b);
        gcd = gcd(gcd, c);
        gcd = gcd == 0 ? 1 : gcd;
        List<Integer> result = new ArrayList<>();
        result.add(a / gcd);
        result.add(b / gcd);
        result.add(c / gcd);
        return result;
    }

    int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
