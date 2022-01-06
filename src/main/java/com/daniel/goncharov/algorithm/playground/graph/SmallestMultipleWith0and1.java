package com.daniel.goncharov.algorithm.playground.graph;

import java.util.Deque;
import java.util.LinkedList;

public class SmallestMultipleWith0and1 {
    // https://www.youtube.com/watch?v=sdTubUR99OA
    public String multiple(int number) {
        Deque<Item> deque = new LinkedList<>();
        if (1 % number == 0) return "1";
        deque.add(new Item("1", 1 % number));
        while (!deque.isEmpty()) {

            Item item = deque.pollFirst();

            String next = item.number + "0";
            int thisModZero = item.previousMod * 10 % number;
            if (thisModZero  == 0) return next;
            deque.addLast(new Item(next, thisModZero));

            next = item.number + "1";
            int thisModOne = (item.previousMod * 10 + 1)% number;
            if (thisModOne  == 0) return next;
            deque.addLast(new Item(next, thisModOne));
        }
        return "-1";
    }

    static class Item {
        final String number;
        final int previousMod;

        public Item(String number, int mod) {
            this.number = number;
            this.previousMod = mod;
        }
    }
}
