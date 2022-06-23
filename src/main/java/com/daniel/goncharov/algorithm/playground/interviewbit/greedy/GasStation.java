package com.daniel.goncharov.algorithm.playground.interviewbit.greedy;

import java.util.List;

public class GasStation {

    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int currentFuel = 0;
        int remaining;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.size(); i++){
            remaining = gas.get(i) - cost.get(i);
            if(currentFuel >= 0)
                currentFuel += remaining;
            else{
                currentFuel = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }
}
