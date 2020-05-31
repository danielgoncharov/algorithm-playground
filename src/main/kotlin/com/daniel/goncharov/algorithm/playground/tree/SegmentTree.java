package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

class SegmentTree<T> {
    private final int originalItemsSize;
    private List<T> treeStorage;
    private BiFunction<T, T, T> function;

    private SegmentTree(List<T> items, BiFunction<T, T, T> function) {
        this.originalItemsSize = items.size();
        this.function = function;
        int length = items.size();
        int closetPowerOfTwo = (int) (Math.ceil(Math.log(length) / Math.log(2)));//TODO clear the logic
        int maxSize = 2 * (int) Math.pow(2, closetPowerOfTwo) - 1;
        treeStorage = new ArrayList<>(maxSize);
        constructSegmentTree(items, 0, length - 1, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree st
    private T constructSegmentTree(List<T> items, int ss, int se, int si) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            treeStorage.set(si, items.get(ss));
            return items.get(ss);
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        T result = function.apply(
                constructSegmentTree(items, ss, mid, si * 2 + 1),
                constructSegmentTree(items, mid + 1, se, si * 2 + 2)
        );
        treeStorage.set(si, result);
        return treeStorage.get(si);
    }

    // A utility function to get the middle index from corner indexes.
    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /* A recursive function to get the query of values in given range
        of the array. The following are parameters for this function.

    si --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
    ss & se --> Starting and ending indexes of the segment represented
                    by current node, i.e., st[si]
    qs & qe --> Starting and ending indexes of query range */
    private T query(int ss, int se, int queryStart, int queryEnd, int currentNodeIndex) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (queryStart <= ss && queryEnd >= se) return treeStorage.get(currentNodeIndex);

        // If segment of this node is outside the given range
        if (se < queryStart || ss > queryEnd) return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return function.apply(
                query(ss, mid, queryStart, queryEnd, 2 * currentNodeIndex + 1),
                query(mid + 1, se, queryStart, queryEnd, 2 * currentNodeIndex + 2)
        );
    }

    /* A recursive function to update the nodes which have the given
    index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i --> index of the element to be updated. This index is in
                input array.
    diff --> Value to be added to all nodes which have i in range */
    private void updateValueUtil(int ss, int se, int index, int diff, int si) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (index < ss || index > se)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        treeArray[si] = treeArray[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, index, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, index, diff, 2 * si + 2);
        }
    }

    void updateValue(int index, T newValue) {
        validateIndex(index);

        int diff = newValue - arr[index];

        updateValueUtil(0, originalItemsSize - 1, index, diff, 0);
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
}
