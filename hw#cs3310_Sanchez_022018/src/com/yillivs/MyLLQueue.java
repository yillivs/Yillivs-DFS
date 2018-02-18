package com.yillivs;

public class MyLLQueue {
    private MyLinkList queueList;

    public MyLLQueue() {
        queueList = new MyLinkList();
    }

    public void enqueue(int value){
        queueList.insertAtTail(value);
    }

    public void dequeue(){
        queueList.deleteFromHead();
    }
}
