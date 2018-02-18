package com.yillivs;

/**
 * Linked list implementation based on MyNode
 */
public class MyLinkList {
    private MyNode head;
    private MyNode tail;
    private int listSize;

    /**
     * Constructor
     */
    public MyLinkList(){
        head = null;
        tail = null;
    }

    /**
     * Inserts a value at the end of the list.
     * @param val value to be inserted.
     */
    public void insertAtTail(int val) {
        MyNode curr = head;

        if (curr == null) {
            head = new MyNode(val);
        } else {
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }

            curr.setNext(new MyNode(val));
            tail = curr.getNext();
        }
        listSize++;
    }

    /**
     * Delete value from the end of the list.
     */
    public void deleteFromTail(){
        if((head == null) || (tail == null))
        {
            System.out.println("Deletion from empty list causing underflow");
        }
        MyNode temp = head;
        while(temp.getNext() != tail){
            temp = temp.getNext();
        }
        System.out.println("Deleting " + tail.getMyNum());
        tail = temp;
        tail.setNext(null);

    }

    /**
     * Deletes a node from the front of the list.
     * Displays the value that is recently deleted.
     */
    public void deleteFromHead(){
        if(head == null) {
            System.out.println("Deletion from empty list causing underflow");
        }
        MyNode temp = head;
        head = temp.getNext();
        if(head == null) {
            tail = null;
        }
        System.out.println("Deleted: " + temp.getMyNum());
    }
}
