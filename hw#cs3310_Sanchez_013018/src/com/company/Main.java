package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final int LINECONST = 750;

    /**
     *
     * @param fp
     * @return
     */
    public static Item[] readArray(String fp){
        Item[] list = new Item[LINECONST];

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
        return list;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String filepath = "weapons.txt";
        Item[] populatedList = readArray(filepath);

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
        while(randomBags[bagIndex].getCount() < 20)
        {
            randomBags[bagIndex].addRandomItem(populatedList);
            bagIndex++;
            if(bagIndex == bagCount){
                bagIndex = 0;
            }
        }
    }
}
