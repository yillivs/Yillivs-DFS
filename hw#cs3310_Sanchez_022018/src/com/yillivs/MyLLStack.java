package com.yillivs;

/**
 * Linked list stack implementation
 */
public class MyLLStack {
    private MyLinkList stackList;

    /**
     * Constructor
     */
    public MyLLStack(){
        stackList = new MyLinkList();
    }

    /**
     * Adds a value to the stack.
     * @param value value to be placed on stack.
     */
    public void push(int value){
        stackList.insertAtTail(value);
    }

    /**
     * Removes a value from the stack.
     */
    public void pop(){
        stackList.deleteFromTail();
    }
}
