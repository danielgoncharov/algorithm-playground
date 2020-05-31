package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderOfPeopleHeights {

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> inFronts) {
        List<NodeValue> nodeValues = new ArrayList<>();
        for (int index = 0; index < heights.size(); index++) nodeValues.add(new NodeValue(1));
        SegmentTree<NodeValue> segmentTree = new SegmentTree(nodeValues, new Query());
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


    static class NodeValue {
        final int emptyCount;
        final Integer value;

        public NodeValue(int emptyCount) {
            this.emptyCount = emptyCount;
            this.value = null;
        }

        public NodeValue(int emptyCount, Integer value) {
            this.emptyCount = emptyCount;
            this.value = value;
        }


    }

    private static class Query implements SegmentTree.AssociativeFunction<NodeValue> {

        @Override
        public NodeValue baseValue() {
            return new NodeValue(0);
        }

        @Override
        public NodeValue apply(NodeValue left, NodeValue right) {
            if (left.value != null && right.value != null) {
                return new NodeValue(0);
            } else {
                return new NodeValue(left.emptyCount + right.emptyCount);
            }

        }
    }
}


