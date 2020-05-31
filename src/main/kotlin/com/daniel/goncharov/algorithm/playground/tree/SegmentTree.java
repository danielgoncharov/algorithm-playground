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

    /* A recursive function to get the sum of values in given range
        of the array. The following are parameters for this function.

    st --> Pointer to segment tree
    si --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
    ss & se --> Starting and ending indexes of the segment represented
                    by current node, i.e., st[si]
    qs & qe --> Starting and ending indexes of query range */
    private T query(int ss, int se, int qs, int qe, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return treeStorage.get(si);

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return function.apply(
                query(ss, mid, qs, qe, 2 * si + 1),
                query(mid + 1, se, qs, qe, 2 * si + 2)
        );
    }

    /* A recursive function to update the nodes which have the given
    index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i --> index of the element to be updated. This index is in
                input array.
    diff --> Value to be added to all nodes which have i in range */
    private void updateValueUtil(int ss, int se, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        treeArray[si] = treeArray[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
// It uses updateValueUtil() to update the value in segment tree
    void updateValue(int arr[], int n, int i, int new_val) {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }


    T query(int start, int end) {
        if (start < 0 || end > originalItemsSize - 1 || start > end) {
            throw new IllegalArgumentException("The query range is outside of bounds");
        }
        return query(0, originalItemsSize - 1, start, end, 0);
    }


}
