package com.daniel.goncharov.algorithm.playground.interviewbit.graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SmallestMultipleWith0and1 {
    // https://www.youtube.com/watch?v=sdTubUR99OA
    public String multiple(int number) {
        Deque<Item> deque = new LinkedList<>();
        Set<Integer> reminders = new HashSet<>();
        if (1 % number == 0) return "1";
        deque.add(new Item("1", 1 % number));
        while (!deque.isEmpty()) {

            Item item = deque.pollFirst();

            String next = item.number + "0";
            int thisModZero = item.previousMod * 10 % number;
            if (thisModZero  == 0) return next;
            if(!reminders.contains(thisModZero)){
                deque.addLast(new Item(next, thisModZero));
                reminders.add(thisModZero);
            }

            next = item.number + "1";
            int thisModOne = (item.previousMod * 10 + 1)% number;
            if (thisModOne  == 0) return next;

            if(!reminders.contains(thisModOne)){
                deque.addLast(new Item(next, thisModOne));
                reminders.add(thisModOne);
            }

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
