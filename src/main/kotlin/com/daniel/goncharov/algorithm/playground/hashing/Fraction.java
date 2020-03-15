package com.daniel.goncharov.algorithm.playground.hashing;

    import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Fraction {

    public String fractionToDecimal(int numIn, int denIn) {
        long num = numIn;
        long den = denIn;
        int sign = ((num > 0 && den > 0) || (num < 0 && den < 0)) ? 1 : -1;
        num = Math.abs(num);
        den = Math.abs(den);
        if (num == 0) return "0";
        if (den == 1) return String.valueOf((num / den) * sign);
        if (canDiv2or5(den)) return new BigDecimal(sign * (num / (double) den)).toPlainString();
        long floorPart = num / den;
        num = num % den;
        LinkedHashMap<Long, String> linkedHashMap = new LinkedHashMap<>();
        String result = floorPart + ".";
        while (!linkedHashMap.containsKey(num)) {
            long numNew = num;
            StringBuilder value = new StringBuilder();
            while (numNew < den) {
                numNew *= 10;
                value.append("0");
            }
            value.replace(0, 1, "");
            linkedHashMap.put(num, value.append(numNew / den).toString());
            num = numNew % den;
        }

        boolean isStaticPartAdded = false;
        for (Map.Entry<Long, String> entry : linkedHashMap.entrySet()) {
            Long key = entry.getKey();
            String value = entry.getValue();
            if (key != num && !isStaticPartAdded) {
                result += value;
                continue;
            }
            if (!isStaticPartAdded) {
                result += "(";
                isStaticPartAdded = true;
            }
            result += value;
        }
        if (sign == -1) {
            result = "-" + result;
        }
        return result + ")";
    }

    private boolean canDiv2or5(long number) {
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else if (number % 5 == 0) {
                number /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
