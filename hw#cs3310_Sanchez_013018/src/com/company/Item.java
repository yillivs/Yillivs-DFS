package com.company;

import java.util.Comparator;

/**
 * Defines an Item
 */
public class Item implements Comparable<Item>{
    protected String name;
    protected int    minStr;
    protected int    maxStr;
    protected String rarity;
    protected int    currStr;

    /**
     * Item constructor
     */
    public Item(){
        this.name = null;
        this.minStr = 0;
        this.maxStr = 0;
        this.rarity = null;
        this.currStr = 0;
    }

    /**
     * Item name attribute getter
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * Item minimum strength getter
     * @return minimum item strength
     */
    public int getMinStr() {
        return minStr;
    }

    /**
     * Item maximum strength getter
     * @return maximum item strength
     */
    public int getMaxStr() {
        return maxStr;
    }

    /**
     * Item rarity getter
     * @return item rarity
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Item current strength getter
     * @return current item strength
     */
    public int getCurrStr() {
        return currStr;
    }

    /**
     * Item name setter
     * @param name Item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Item minimum strength setter
     * @param minStr Item minimum strength
     */
    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    /**
     * Item max strength setter
     * @param maxStr Item maximum strength
     */
    public void setMaxStr(int maxStr) {
        this.maxStr = maxStr;
    }

    /**
     * Item rarity setter
     * @param rarity Item rarity
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * Item current strength setter
     * @param currStr Item current strength
     */
    public void setCurrStr(int currStr) {
        this.currStr = currStr;
    }

    /**
     * Permits comparison of object by current strength
     * @param compareItem comparison object
     * @return object with highest current Item strength.
     */
    @Override
    public int compareTo(Item compareItem) {

        int compareCurrStr = ((Item)compareItem).getCurrStr();

        return this.currStr - compareCurrStr;
    }

    /**
     * Comparator to utilize Arrays.sort for object.
     */
    public static Comparator<Item> ItemNameComparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            String itemName1 = o1.getName();
            String itemName2 = o2.getName();

            return itemName1.compareTo(itemName2);
        }
    };
}
