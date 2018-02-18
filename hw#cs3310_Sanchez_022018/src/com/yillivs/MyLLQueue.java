package com.yillivs;

/**
 * Linked list queue implementation
 */
public class MyLLQueue {
    private MyLinkList queueList;

    /**
     * Constructor
     */
    public MyLLQueue() {
        queueList = new MyLinkList();
    }

    /**
     * Adds an element to the end of the queue.
     * @param value value to be inserted in queue.
     */
    public void enqueue(int value){
        queueList.insertAtTail(value);
    }

    /**
     * Removes a value from the beginning of the queue.
     */
    public void dequeue(){
        queueList.deleteFromHead();
    }
}
