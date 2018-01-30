package com.company;

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

    public void setContnetsAt(Item _item, int index){
        contents[index] = _item;
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
        contents[count] = unsortedInv[rand.nextInt(((unsortedInv.length - 1) - 0) +1)];
        int currStrBound = rand.nextInt(((contents[count].getMaxStr() - contents[count].getMinStr()) + 1)
                + contents[count].getMinStr());
        contents[count].setCurrStr(currStrBound);
        count++;
    }

    /**
     * Performs linear search of the bag for a random item from srcInv.
     * @param _item Item to linear search bag for.
     * @return position List with positions of item occurrences.
     */
    public ArrayList<Integer> linearSearch(Item _item, ArrayList<Integer>_searchCurrStr){
        ArrayList<Integer> position = new ArrayList<>();
        String searchName = _item.getName();
        String searchRarity = _item.getRarity();

        for(int i = 0; i < contents.length; i++)
        {
            if(contents[i].getName().equalsIgnoreCase(searchName) &&
                    contents[i].getRarity().equalsIgnoreCase(searchRarity))
            {
                position.add(i);
                _searchCurrStr.add(contents[i].getCurrStr());
            }
        }

        return position;
    }

    /**
     *
     */
    public int binarySearch(Item _item, ArrayList<Integer> pos){
        return binarySearch(_item, 0, contents.length-1, pos);
    }

    public int binarySearch(Item _item, int min, int max, ArrayList<Integer> pos){
        if(min > max)
            return -1;


        int mid = (max + min) / 2;
        String searchName = _item.getName();
        String searchRarity = _item.getRarity();
        if(contents[mid].getName().equalsIgnoreCase(searchName) &&
                contents[mid].getRarity().equalsIgnoreCase(searchRarity))
        {
            pos.add(mid);
            return mid;
        }
        else if(contents[mid].getName().compareTo(searchName) > 0)
        {
            return binarySearch(_item, min, mid-1, pos);
        }
        else
        {
            return binarySearch(_item, mid+1, max, pos);
        }
    }
}
