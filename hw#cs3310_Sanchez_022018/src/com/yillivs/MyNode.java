package com.yillivs;

public class MyNode {
    private int myNum;
    private MyNode next;

    MyNode(){
        myNum = -1;
        next = null;
    }

    MyNode(int val){
        myNum = val;
        next = null;
    }

    public void setMyNum(int myNum) {
        this.myNum = myNum;
    }

    public int getMyNum() {
        return myNum;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
