package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
