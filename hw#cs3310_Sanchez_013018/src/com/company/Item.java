package com.company;

/**
 *
 */
public class Item {
    protected String name;
    protected int    minStr;
    protected int    maxStr;
    protected String rarity;
    protected int    currStr;

    /**
     *
     */
    public Item(){
        this.name = null;
        this.minStr = 0;
        this.maxStr = 0;
        this.rarity = null;
        this.currStr = 0;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getMinStr() {
        return minStr;
    }

    /**
     *
     * @return
     */
    public int getMaxStr() {
        return maxStr;
    }

    /**
     *
     * @return
     */
    public String getRarity() {
        return rarity;
    }

    /**
     *
     * @return
     */
    public int getCurrStr() {
        return currStr;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param minStr
     */
    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    /**
     *
     * @param maxStr
     */
    public void setMaxStr(int maxStr) {
        this.maxStr = maxStr;
    }

    /**
     *
     * @param rarity
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     *
     * @param currStr
     */
    public void setCurrStr(int currStr) {
        this.currStr = currStr;
    }
}
