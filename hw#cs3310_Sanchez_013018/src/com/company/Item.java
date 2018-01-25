package com.company;

public class Item {
    protected String name;
    protected int    minStr;
    protected int    maxStr;
    protected String rarity;
    protected int    currStr;

    public String getName() {
        return name;
    }

    public int getMinStr() {
        return minStr;
    }

    public int getMaxStr() {
        return maxStr;
    }

    public String getRarity() {
        return rarity;
    }

    public int getCurrStr() {
        return currStr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    public void setMaxStr(int maxStr) {
        this.maxStr = maxStr;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setCurrStr(int currStr) {
        this.currStr = currStr;
    }
}
