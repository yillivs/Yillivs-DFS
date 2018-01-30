package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Defines a Bag as an object which contains up to
 * 20 Items.
 */
public class Bag {
    protected Item[] contents;
    protected int count;

    /**
     * Bag Constructor.
     */
    public Bag(){
        contents = new Item[20];
        count = 0;
    }

    /**
     * Bag contents attribute setter.
     * @param contents array of Items.
     */
    public void setContents(Item[] contents) {
        this.contents = contents;
        count = contents.length;
    }

    /**
     * Bag contents attribute getter.
     * @return Bag contents
     */
    public Item[] getContents() {
        return contents;
    }

    /**
     * Bag count attribute getter.
     * @return Bag count
     */
    public int getCount() {
        return count;
    }

    /**
     * Add one random item from an unsorted inventory.
     * @param unsortedInv Unsorted Item array.
     */
    public void addRandomItem(Item[] unsortedInv){
        Random rand = new Random();
        contents[count] = unsortedInv[rand.nextInt((unsortedInv.length - 0) +1)];
        count++;
    }

    /**
     * Performs linear search of the bag for a random item from srcInv.
     * @param _item Item to linear search bag for.
     * @return position List with positions of item occurrences.
     */
    public ArrayList<Integer> linearSearch(Item _item){
        ArrayList<Integer> position = new ArrayList<>();

        for(int i = 0; i < contents.length; i++)
        {
            if(contents[i].equals(_item))
            {
                position.add(i);
            }
        }

        return position;
    }

    /**
     *
     */
    public void binaryRandomSearch(){

    }
}
