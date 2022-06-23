package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class ListCycle {

    public ListNode detectCycle(ListNode input) {
        ListNode rabbit = input;
        ListNode frog =input ;
        while (frog != null && rabbit != null && rabbit.next!=null) {
            frog = frog.next;
            rabbit = rabbit.next.next;
            if (frog == rabbit) {
                return frog.next;
            }
        }
        return null;
    }
}
