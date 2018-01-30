package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BagUtility {
    protected Item[] inventory;

    public BagUtility() {
        inventory = null;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public Item[] getInventory() {
        return inventory;
    }

     /**
     * reads in an array of Items from a text document.
     * @param fp filepath to the document.
     * @return array of unsorted Items.
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
     * Creates a shallow copy then sorts the array of Items.
     * @return sorted Item array
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
                bagInv[i].setContnetsAt(bagInventory[(i*20)+j], j);
            }
        }
    }

    /**
     * performs linear search on a random item from the inventory array.
     * @param srcBags Bag array to perform search in.
     */
    public void randomLinearSearch(Bag[] srcBags){
        Random rand = new Random();
        int randomPos = (rand.nextInt((inventory.length - 1) - 0) + 1);
        System.out.println("Linear search for: " +
                inventory[randomPos].getRarity() + " " + inventory[randomPos].getName());
        for(int i = 0; i < srcBags.length; i++)
        {
            ArrayList<Integer> bagPos = new ArrayList<>();
            ArrayList<Integer> searchItemCurrStr = new ArrayList<>();
            bagPos = srcBags[i].linearSearch(inventory[randomPos], searchItemCurrStr);
            if(!bagPos.isEmpty())
            {
               System.out.println("Bag #: " + i + "\nSlot #:");
               for(int j = 0; j < bagPos.size(); j++)
               {
                   System.out.print(bagPos.get(j) + " Curr. Strength: "+ searchItemCurrStr.get(j));
               }
               System.out.println();
            }
        }
    }

    public void randomBinarySearch(Bag[] srcBags){
         Random rand = new Random();
        int randomPos = (rand.nextInt((inventory.length - 1) - 0) + 1);
        System.out.println("Binary search for: " +
                inventory[randomPos].getRarity() + " " + inventory[randomPos].getName());
        for(int i = 0; i < srcBags.length; i++)
        {
            ArrayList<Integer> bagPos = new ArrayList<>();
            srcBags[i].binarySearch(inventory[randomPos], bagPos);

            if(!bagPos.isEmpty())
            {
               System.out.println("Bag #: " + i + "\nSlot #:");
               for(int j = 0; j < bagPos.size(); j++)
               {
                   System.out.print(bagPos.get(j));
               }
               System.out.println();
            }
        }
    }
}
