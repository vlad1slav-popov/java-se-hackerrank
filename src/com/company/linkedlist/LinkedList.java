package com.company.linkedlist;

import java.util.Objects;

public class LinkedList {

    private Node head;
    private Node tail;

    public void remove(Integer value) {
        Node currentElement = new Node();
        while (currentElement.next != null) {
            if (Objects.equals(currentElement.next.value, value)) {
                currentElement.next = currentElement.next.next;
                currentElement.next.next.prev = currentElement.next;
                return;
            }
        }

    }

    public void add(Integer prev, Integer next, Integer value) {

    }
}
