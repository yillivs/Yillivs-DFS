package com.yillivs;

public class MyLLStack {
    private MyLinkList stackList;

    public MyLLStack(){
        stackList = new MyLinkList();
    }

    public void push(int value){
        stackList.insertAtTail(value);
    }

    public void pop(){
        stackList.deleteFromTail();
    }
}
