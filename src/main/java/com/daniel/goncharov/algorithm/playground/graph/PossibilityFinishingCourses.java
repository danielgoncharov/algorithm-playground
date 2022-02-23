package com.daniel.goncharov.algorithm.playground.graph;

import java.util.*;

public class PossibilityFinishingCourses {

    private static final int NOT_FOUND = -1;

    public int solve(
            int courseNumber,
            ArrayList<Integer> dependencyCourses,
            ArrayList<Integer> course
    ) {
        Queue<Integer> entryCourses = findEntryCourses(course, courseNumber);
        Set<Integer> visitedCourse = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        while (!entryCourses.isEmpty()) {
            int entryCourse = entryCourses.poll();
            dfsFromEntryPoint(dependencyCourses, course, entryCourse, visitedCourse, deque);
        }
        return visitedCourse.size() == courseNumber ? 1 : 0;
    }

    private void dfsFromEntryPoint(
            ArrayList<Integer> dependencyCourses,
            ArrayList<Integer> course,
            Integer entryCourse,
            Set<Integer> visitedCourse,
            Deque<Integer> deque
    ) {

        int dependencyIndex = dependencyCourses.indexOf(entryCourse);
        deque.add(dependencyIndex);
        while (!deque.isEmpty()) {
            int currentIndex = deque.pollFirst();
            if (currentIndex == dependencyIndex) {
                addDecendends(course, deque, dependencyIndex);
                visitedCourse.add(entryCourse);
            } else if (!visitedCourse.contains(currentIndex) && doesNotHaveResolvedDependencies(currentIndex,visitedCourse)) {
                addDecendends()
            }
        }

    }

    private boolean doesNotHaveResolvedDependencies(int currentIndex, Set<Integer> visitedCourse) {
        return false;
    }

    private void addDecendends(ArrayList<Integer> course, Deque<Integer> deque, int dependencyIndex) {
        while (dependencyIndex != NOT_FOUND) {
            int courseIndex = course.indexOf(dependencyIndex);
            deque.add(courseIndex);
        }
    }

    private Queue<Integer> findEntryCourses(ArrayList<Integer> course, int courseNumber) {
        return null;
    }
}
