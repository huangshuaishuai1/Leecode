package jzoffer;

import java.util.LinkedList;
import java.util.Stack;

public class Offer09 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public Offer09() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty()) {
            return -1;
        }
        while(!s1.isEmpty()) {
            Integer pop = s1.pop();
            s2.push(pop);
        }
        Integer ret = s2.pop();
        while (!s2.isEmpty()) {
            Integer pop = s2.pop();
            s1.push(pop);
        }
        return ret;
    }

    public static void main(String[] args) {
        Offer09 offer09 = new Offer09();
        offer09.appendTail(1);
        offer09.appendTail(2);
        int i = offer09.deleteHead();
        System.out.println("i = " + i);
        int i1 = offer09.deleteHead();
        System.out.println("i1 = " + i1);
        int i2 = offer09.deleteHead();
        System.out.println("i2 = " + i2);
    }
}
