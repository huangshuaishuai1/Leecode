package jzoffer;

import java.util.LinkedList;

public class Offer35 {
    public Node copyRandomList(Node head) {
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Node> newList = new LinkedList<>();
        Node temp = head;
        while(temp != null) {
            list.add(temp);
            newList.add(new Node(temp.val));
            temp = temp.next;
        }


        temp = newList.get(0);
        for(int i = 1; i < list.size(); i++) {
            temp.next = newList.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int i1 = list.indexOf(node.random);
            newList.get(i).random = newList.get(i1);
        }

        return newList.get(0);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}