package jzoffer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Offer30 {
    LinkedList<Integer> list;
    LinkedList<Integer> sortedList;

    public Offer30() {
        list = new LinkedList<Integer>();
        sortedList = new LinkedList<>();
    }

    public void push(int x) {
        list.add(0,x);
        if (!sortedList.isEmpty() && x <= sortedList.get(0)) {
            sortedList.add(0,x);
        }else if (!sortedList.isEmpty() && x >= sortedList.getLast()) {
            sortedList.add(x);
        }else {
            sortedList.add(x);
            Collections.sort(sortedList);
        }
    }

    public void pop() {
        Integer integer = list.removeFirst();
        sortedList.remove(integer);
    }

    public int top() {
        return list.getFirst();
    }

    public int min() {
        return sortedList.getFirst();
    }

    public static void main(String[] args) {
        Offer30 offer30 = new Offer30();
        offer30.push(0);
        System.out.println(offer30.min());
        offer30.push(-1);
        System.out.println(offer30.min());
        offer30.push(4);
        System.out.println(offer30.min());
        offer30.push(-3);
        System.out.println(offer30.min());
        offer30.push(2);
        System.out.println(offer30.min());
        offer30.pop();
        System.out.println(offer30.min());
        offer30.pop();
        System.out.println(offer30.min());
        offer30.pop();
        System.out.println(offer30.min());
        offer30.pop();
        System.out.println(offer30.min());
        offer30.pop();

    }
}
