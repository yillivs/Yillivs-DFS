package com.yillivs;

/**
 * Node implementation for linked list
 */
public class MyNode {
    private int myNum;
    private MyNode next;

    /**
     * Constructor
     */
    MyNode(){
        myNum = -1;
        next = null;
    }

    /**
     * Parameterized constructor
     * @param val insertion value
     */
    MyNode(int val){
        myNum = val;
        next = null;
    }

    /**
     * Attribute Setter
     * @param myNum int to set node to
     */
    public void setMyNum(int myNum) {
        this.myNum = myNum;
    }

    /**
     * Attribute getter
     * @return myNum integer value
     */
    public int getMyNum() {
        return myNum;
    }

    /**
     * Getter for node link
     * @return next Node
     */
    public MyNode getNext() {
        return next;
    }

    /**
     * Setter for node link
     * @param next node to be set as next
     */
    public void setNext(MyNode next) {
        this.next = next;
    }
}
