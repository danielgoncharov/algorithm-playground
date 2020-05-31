package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderOfPeopleHeights {

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> inFronts) {
        SegmentTree segmentTree = new SegmentTree(new int[heights.size()]);
        ArrayList<Item> items = createSortedItemsList(heights, inFronts);
        for (int index = 0; index < items.size(); index++) {
            segmentTree.query()
        }
    }

    private ArrayList<Item> createSortedItemsList(ArrayList<Integer> heights, ArrayList<Integer> inFronts) {
        ArrayList<Item> result = new ArrayList<>();
        for (int index = 0; index < heights.size(); index++) {
            result.add(new Item(heights.get(index), inFronts.get(index)));
        }
        Collections.sort(result, Comparator.comparing(item -> item.height));
        return result;
    }



    private class Item {
        final Integer height;
        final Integer peopleInFront;

        public Item(Integer height, Integer peopleInFront) {
            this.height = height;
            this.peopleInFront = peopleInFront;
        }
    }
}


