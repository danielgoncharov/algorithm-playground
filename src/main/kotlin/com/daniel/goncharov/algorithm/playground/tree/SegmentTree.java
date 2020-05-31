package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.List;

class SegmentTree<T> {
    private final int originalItemsSize;
    private List<T> treeStorage;
    private AssociativeFunction<T> function;

    private SegmentTree(List<T> items, AssociativeFunction<T> function) {
        this.originalItemsSize = items.size();
        this.function = function;
        int length = items.size();
        int closetPowerOfTwo = (int) (Math.ceil(Math.log(length) / Math.log(2)));//TODO clear the logic
        int maxSize = 2 * (int) Math.pow(2, closetPowerOfTwo) - 1;
        treeStorage = new ArrayList<>(maxSize);
        constructSegmentTree(items, 0, length - 1, 0);
    }

    private T constructSegmentTree(List<T> items, int startSegment, int endSegment, int nodeIndex) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (startSegment == endSegment) {
            treeStorage.set(nodeIndex, items.get(startSegment));
            return items.get(startSegment);
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int middleIndex = middleIndex(startSegment, endSegment);
        T result = function.apply(
                constructSegmentTree(items, startSegment, middleIndex, leftNodeIndex(nodeIndex)),
                constructSegmentTree(items, middleIndex + 1, endSegment, rightNodeIndex(nodeIndex))
        );
        treeStorage.set(nodeIndex, result);
        return treeStorage.get(nodeIndex);
    }

    private int middleIndex(int leftIndex, int rightIndex) {
        return leftIndex + (rightIndex - leftIndex) / 2;
    }

    private int leftNodeIndex(int index) {
        return index * 2 + 1;
    }

    private int rightNodeIndex(int index) {
        return index * 2 + 2;
    }

    private T query(int startSegment, int endSegment, int queryStart, int queryEnd, int currentNodeIndex) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (queryStart <= startSegment && queryEnd >= endSegment) return treeStorage.get(currentNodeIndex);

        // If segment of this node is outside the given range
        if (endSegment < queryStart || startSegment > queryEnd) return function.baseValue();

        // If a part of this segment overlaps with the given range
        int mid = middleIndex(startSegment, endSegment);
        return function.apply(
                query(startSegment, mid, queryStart, queryEnd, leftNodeIndex(currentNodeIndex)),
                query(mid + 1, endSegment, queryStart, queryEnd, rightNodeIndex(currentNodeIndex))
        );
    }

    /* A recursive function to update the nodes which have the given
    index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i --> index of the element to be updated. This index is in
                input array.
    diff --> Value to be added to all nodes which have i in range */
    private void updateValue(int startSegment, int endSegment, int index, int diff, int currentNodeIndex) {
        if (index < startSegment || index > endSegment) return;
        // If the input index is in range of this node, then update the
        // value of the node and its children
        treeArray[currentNodeIndex] = treeArray[currentNodeIndex] + diff;
        if (endSegment != startSegment) {
            int middleIndex = middleIndex(startSegment, endSegment);
            updateValue(startSegment, middleIndex, index, diff, leftNodeIndex(currentNodeIndex));
            updateValue(middleIndex + 1, endSegment, index, diff, rightNodeIndex(currentNodeIndex));
        }
    }

    void updateValue(int index, T newValue) {
        validateIndex(index);

        int diff = newValue - arr[index];

        updateValue(0, originalItemsSize - 1, index, diff, 0);
    }


    T query(int start, int end) {
        validateIndex(start);
        validateIndex(end);
        if (start > end) throw new IllegalArgumentException("Start is more the end");
        return query(0, originalItemsSize - 1, start, end, 0);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > originalItemsSize - 1) throw new IllegalArgumentException("Invalid index");
    }

    interface AssociativeFunction<T> {
        T baseValue();

        T apply(T left, T right);
    }
}
