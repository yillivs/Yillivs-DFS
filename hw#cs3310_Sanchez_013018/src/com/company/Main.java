package com.company;

import java.util.Scanner;

public class Main {

    public static final int LINECONST = 750;

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
        inventoryUtility.randomLinearSearch(userBags);
        inventoryUtility.sortArray(userBags);
        inventoryUtility.randomBinarySearch(userBags);

    }

    public static void main(String[] args) {
        demo();
    }
}
