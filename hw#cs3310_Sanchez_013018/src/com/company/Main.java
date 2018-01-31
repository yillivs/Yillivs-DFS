package com.company;

import java.util.Scanner;

public class Main {

    public static final int LINECONST = 750;

    /**
     * Demo which accepts user input and performs tasks specified in
     * project description.
     */
    public static void demo() {
        String filepath = "weapons.txt";
        BagUtility inventoryUtility = new BagUtility();
        inventoryUtility.readArray(filepath, LINECONST);

        System.out.println("Please enter how many bags you would like to create.");
        Scanner kb = new Scanner(System.in);

        int bagCount = 0;
        try{
            bagCount = Integer.parseInt(kb.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Provided bag size is not in integer format");
        }

        System.out.println("Value of n is : " + bagCount);
        Bag[] userBags = new Bag[bagCount];
        for(int i = 0; i < bagCount; i++)
        {
            userBags[i] = new Bag();
        }

        int bagIndex = 0;
        while(userBags[bagIndex].getCount() < 20) {
            userBags[bagIndex].addRandomItem(inventoryUtility.getInventory());
            bagIndex++;
            if (bagIndex == bagCount) {
                bagIndex = 0;
            }
        }
        System.out.println("Bags before sorting ->");
        inventoryUtility.printBagContent(userBags);
        long singleSearchStart = System.nanoTime();
        inventoryUtility.randomLinearSearch(userBags, true);
        System.out.println("Single search time: " + (System.nanoTime() - singleSearchStart) + " nanoseconds.");

        long avgSearchStart1 = System.nanoTime();
        inventoryUtility.randomLinearSearch(userBags, false);
        long avgSearchStart2 = System.nanoTime();
        inventoryUtility.randomLinearSearch(userBags, false);
        long avgSearchStart3 = System.nanoTime();
        inventoryUtility.randomLinearSearch(userBags, false);
        System.out.println("Average search time: " + (((avgSearchStart2 - avgSearchStart1) + (avgSearchStart3 - avgSearchStart2)
                 + (System.nanoTime() - avgSearchStart3))/3) + " nanoseconds.");

        System.out.println("Bags after sorting ->");
        inventoryUtility.sortArray(userBags);
        inventoryUtility.printBagContent(userBags);
        singleSearchStart = System.nanoTime();
        inventoryUtility.randomBinarySearch(userBags, true);
        System.out.println("Single search time: " + (System.nanoTime() - singleSearchStart) + " nanoseconds.");

        avgSearchStart1 = System.nanoTime();
        inventoryUtility.randomBinarySearch(userBags, false);
        avgSearchStart2 = System.nanoTime();
        inventoryUtility.randomBinarySearch(userBags, false);
        avgSearchStart3 = System.nanoTime();
        inventoryUtility.randomBinarySearch(userBags, false);
        System.out.println("Average search time: " + (((avgSearchStart2 - avgSearchStart1) + (avgSearchStart3 - avgSearchStart2)
                + (System.nanoTime() - avgSearchStart3))/3) + " nanoseconds.");
    }

    public static void main(String[] args) {
        demo();
    }
}
