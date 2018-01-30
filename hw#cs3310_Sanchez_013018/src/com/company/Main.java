package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final int LINECONST = 750;



    /**
     * Creates a shallow copy then sorts the array of Items.
     * @param _unsortedInventory unsorted Item array
     * @return sorted Item array
     */
    public static Item[] sortArray(Item []_unsortedInventory){
        Item[] sortedInventory = _unsortedInventory;

        Arrays.sort(sortedInventory, Item.ItemNameComparator);

        for(int i = 0; i < LINECONST; i++)
            System.out.println(sortedInventory[i].getName());

        return sortedInventory;
    }
    /**
     * Controlls flow and accepts user input.
     * @param args
     */
    public static void main(String[] args) {
        String filepath = "weapons.txt";
        BagUtility inventoryUtility = new BagUtility();
        inventoryUtility.readArray(filepath, LINECONST);
        Item[] sortedList;

        System.out.println("Please enter how many bags you would like to create.");
        Scanner kb = new Scanner(System.in);

        int bagCount = 0;
        //Ensures the newline is consumed.
        try{
            bagCount = Integer.parseInt(kb.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Provided bag size is not in integer format");
        }

        Bag[] randomBags = new Bag[bagCount];
        Bag[] sortedBags = new Bag[bagCount];

        //initialize bag object
        for(int i = 0; i < bagCount; i++)
        {
            randomBags[i] = new Bag();
            sortedBags[i] = new Bag();
        }

        int bagIndex = 0;
        while(randomBags[bagIndex].getCount() < 20) {
            randomBags[bagIndex].addRandomItem(inventoryUtility.getInventory());
            bagIndex++;
            if (bagIndex == bagCount) {
                bagIndex = 0;
            }
        }

        for(int i = 0; i < randomBags.length; i++)
            randomBags[i].linearSearch(inventoryUtility.getInventory()[20]);

        sortedList = sortArray(inventoryUtility.getInventory());

    }
}
