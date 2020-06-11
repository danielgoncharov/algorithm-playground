package com.daniel.goncharov.algorithm.playground.heap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NmaxPairCombinations {

    public ArrayList<Integer> solve(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        Collections.sort(arrayA);
        Collections.sort(arrayB);

        PriorityQueue<Element> heap = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Indexes> indexesChecked = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        int i = arrayA.size() - 1;
        int j = arrayB.size() - 1;
        Indexes indexes = new Indexes(i, j);
        heap.add(new Element(arrayA.get(i) + arrayB.get(j), indexes));
        indexesChecked.add(indexes);
        for (int index = 0; index < arrayA.size(); index++) {
            Element element = heap.poll();
            result.add(element.sum);

            i = element.indexes.i;
            j = element.indexes.j;

            indexes = new Indexes(i - 1, j);
            addToHeap(arrayA, arrayB, heap, indexesChecked, indexes);

            indexes = new Indexes(i, j - 1);
            addToHeap(arrayA, arrayB, heap, indexesChecked, indexes);


        }
        return result;
    }

    private void addToHeap(
            ArrayList<Integer> arrayA,
            ArrayList<Integer> arrayB,
            PriorityQueue<Element> heap,
            HashSet<Indexes> indexesChecked,
            Indexes indexes
    ) {
        if (indexes.i < 0 || indexes.j < 0) return;
        if (!indexesChecked.contains(indexes)) {
            heap.add(new Element(arrayA.get(indexes.i) + arrayB.get(indexes.j), indexes));
            indexesChecked.add(indexes);
        }
    }

    private static class Element implements Comparable<Element> {
        private final Integer sum;
        private final Indexes indexes;

        public Element(int sum, Indexes indexes) {
            this.sum = sum;
            this.indexes = indexes;
        }

        @Override
        public int compareTo(@NotNull Element other) {
            return sum.compareTo(other.sum);
        }
    }

    private static class Indexes {
        private final int i;
        private final int j;

        public Indexes(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Indexes indexes = (Indexes) o;
            return i == indexes.i &&
                    j == indexes.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
