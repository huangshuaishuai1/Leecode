package linkedlist;

import java.util.List;

public class MyLinkedList {
    int size;

    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode();
    }

    public int get(int index) {
        if (index > size || index < 0) {
            return -1;
        }
        int i = 0;
        ListNode node = head;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size ++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = head;
        int i = 1;
        while (i < size) {
            cur = cur.next;
            i++;
        }
        cur.next = node;
        node.next = null;
        size++;

    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode addNode = new ListNode(val);
        if (index <= 0) {
            addAtHead(val);
        }else if (index == size){
            addAtTail(val);
        } else {
            int i = 0;
            ListNode cur = head;
            while(i < index - 1) {
                cur = cur.next;
                i++;
            }
            addNode.next = cur.next;
            cur.next = addNode;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            size --;
        } else if (index > 0 && index < size) {
            int i = 0;
            ListNode deleteNode = head;
            ListNode cur = head;
            while(i < index - 1) {
                deleteNode = deleteNode.next;
                cur = cur.next;
                i++;
            }
            deleteNode = cur.next;
            cur.next = deleteNode.next;
            size --;
        }

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0,10);
        linkedList.addAtIndex(0,20);
        linkedList.addAtIndex(1,30);
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);

    }
}


