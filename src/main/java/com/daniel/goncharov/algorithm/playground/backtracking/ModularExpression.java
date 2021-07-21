package com.daniel.goncharov.algorithm.playground.backtracking;

public class ModularExpression {
    public int Mod(int base, int exp, int mod) {
        if (exp == 0) return 1 % mod;
        long result;
        if (exp % 2 == 0) {
            result = Mod(base, exp / 2, mod);
            result = (result * result) % mod;
        } else {
            result = base % mod;
            result = (result * Mod(base, exp - 1, mod)) % mod;
        }
        return (int) ((result + mod) % mod);
    }
}
