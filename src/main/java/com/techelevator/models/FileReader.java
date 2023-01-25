package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class FileReader {

    //th

    public String fileName = "catering.csv";
    File cateringFile = new File(fileName);
    ArrayList<VendingItem> inventoryList = new ArrayList<>();

    public List<VendingItem> readingFile() {

        List<VendingItem> inventoryList = new ArrayList<>();
        String line = "";
        //customer input
        try (Scanner reader = new Scanner(cateringFile)) {
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                String[] lineOfText = line.split(",");
                VendingItem item = new VendingItem(lineOfText[0], lineOfText[1], new BigDecimal(lineOfText[2]), lineOfText[3]);
                inventoryList.add(item);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error  -- unable to read the file!");
            System.exit(1);
        }
        return inventoryList;
    }

    public Map<Object, Integer> getInventoryAtStart(){
        Map<Object, Integer> mapOfInventory = new TreeMap<>();
        int initialStock =6;
        for(VendingItem eachLine : readingFile()){
            mapOfInventory.put(eachLine.getItemName(), initialStock );
        }
        return  mapOfInventory;
    }


    public String selectingItemName(String userLocation) {
        String name= "";
        for (VendingItem item : inventoryList) {
            if (userLocation.equals(item.getLocation())) {
                name = item.getItemName();
            }
        }
        return name;
    }

}
