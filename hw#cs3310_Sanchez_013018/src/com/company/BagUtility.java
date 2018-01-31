package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Utility class for Bag
 */
public class BagUtility {
    protected Item[] inventory;

    /**
     * Constructor
     */
    public BagUtility() {
        inventory = null;
    }

    /**
     * Inventory setter
     * @param inventory items to be used
     */
    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    /**
     * Inventory getter
     * @return list of Items contained in file
     */
    public Item[] getInventory() {
        return inventory;
    }

     /**
     * reads in an array of Items from a text document.
     * @param fp filepath to the document.
     * @param lineLength Item array list size.
     */
    public void readArray(String fp, int lineLength){
        Item[] list = new Item[lineLength];

        String line = null;
        int counter = 0;

        try
        {
            FileReader freader = new FileReader(fp);
            BufferedReader buffReader = new BufferedReader(freader);

            buffReader.readLine();
            while((line = buffReader.readLine()) != null)
            {
                if(line.trim().length() > 0)
                {
                    String[] split = line.split(",");
                    Item lineItem = new Item();
                    lineItem.setName(split[0]);
                    if(split[1].equalsIgnoreCase(""))
                    {
                        lineItem.setMinStr(0);
                    }
                    else
                    {
                        lineItem.setMinStr(Integer.parseInt(split[1]));
                    }
                    if(split[2].equalsIgnoreCase(""))
                    {
                        lineItem.setMaxStr(0);
                    }
                    else
                    {
                        lineItem.setMaxStr(Integer.parseInt(split[2]));
                    }
                    lineItem.setRarity(split[3]);
                    list[counter] = lineItem;
                    counter++;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
        inventory = list;
    }
    
    /**
     * Sorts entire inventory of items in Bag
     * @param bagInv bag array to be sorted.
     */
    public void sortArray(Bag[] bagInv){
        int itemListLen = bagInv.length * 20;
        Item[] bagInventory = new Item[itemListLen];
        for(int i = 0; i < bagInv.length; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                bagInventory[(i*20)+j] = bagInv[i].getContents()[j];
            }
        }
        Arrays.sort(bagInventory, Item.ItemNameComparator);

        for(int i = 0; i < bagInv.length; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                bagInv[i].setContentsAt(bagInventory[(i*20)+j], j);
            }
        }
    }

    /**
     * performs linear search on a random item from the inventory array.
     * @param srcBags Bag array to perform search in.
     * @param printFlag true if output should be printed, false otherwise
     */
    public void randomLinearSearch(Bag[] srcBags, boolean printFlag){
        Random rand = new Random();
        int randomPos = (rand.nextInt((inventory.length - 1) - 0) + 1);

        if(printFlag)
        System.out.println("Linear search for: " +
                inventory[randomPos].getRarity() + " " + inventory[randomPos].getName());

        for(int i = 0; i < srcBags.length; i++)
        {
            ArrayList<Integer> bagPos = new ArrayList<>();
            ArrayList<Integer> searchItemCurrStr = new ArrayList<>();
            bagPos = srcBags[i].linearSearch(inventory[randomPos], searchItemCurrStr);
            if(!bagPos.isEmpty() && printFlag)
            {
               System.out.println("Bag #: " + i + "\nSlot #:");
               for(int j = 0; j < bagPos.size(); j++)
               {
                   System.out.print(bagPos.get(j) + "\nCurr. Strength: "+ searchItemCurrStr.get(j));
               }
               System.out.println();
            }
        }
    }

    /**
     * Performs binary search on an array of bags
     * @param srcBags bag array which is to be searched upon
     * @param printFlag true if output should be printed, false otherwise
     */
    public void randomBinarySearch(Bag[] srcBags, boolean printFlag){
         Random rand = new Random();
        int randomPos = (rand.nextInt((inventory.length - 1) - 0) + 1);
        if(printFlag)
        System.out.println("Binary search for: " +
                inventory[randomPos].getRarity() + " " + inventory[randomPos].getName());

        for(int i = 0; i < srcBags.length; i++)
        {
            ArrayList<Integer> bagPos = new ArrayList<>();
            ArrayList<Integer> searchItemCurrStr = new ArrayList<>();
            srcBags[i].binarySearch(inventory[randomPos], bagPos, searchItemCurrStr);

            if(!bagPos.isEmpty() && printFlag)
            {
               System.out.println("Bag #: " + i + "\nSlot #:");
               for(int j = 0; j < bagPos.size(); j++)
               {
                   System.out.print(bagPos.get(j) +  "\nCurr. Strength: "+ searchItemCurrStr.get(j));
               }
               System.out.println();
            }
        }
    }

    /**
     * Prints first 5 items of the bag if n is less than 8
     * @param srcBag Bag array to print items from.
     */
    public void printBagContent(Bag[] srcBag){
        if(srcBag.length <= 8){
            for(int i = 0; i < srcBag.length; i++){
                System.out.println("Bag: " + (i+1));
                srcBag[i].printBag();
            }
        }
    }
}
