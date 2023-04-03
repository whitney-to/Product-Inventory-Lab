package services;

import models.Whiskey;

import java.util.ArrayList;

public class WhiskeyService {
    private static int nextId = 1;  // (1)

    private ArrayList<Whiskey> inventory = new ArrayList<>();  // (2)

    public ArrayList<Whiskey> getInventory() {
        return inventory;
    }

    public Whiskey create(String brand, float price) {
        Whiskey createdWhiskey = new Whiskey(nextId++,brand, price);
        inventory.add(createdWhiskey);
        return createdWhiskey;
    }

    //read
    public Whiskey findWhiskey(int id) {
        // should take an int and return an object with that id, if exists
        for(Whiskey whiskey : inventory){
            if(whiskey.getId()==id){
                return whiskey;
            }
        }
        return null;
    }

    //read all
    public Whiskey[] findAll() {
        // should return a basic array copy of the ArrayList
        return inventory.toArray(new Whiskey[0]);
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for(Whiskey whiskey : inventory){
            if(whiskey.getId()==id){
                inventory.remove(whiskey);
                return true;
            }
        }
        return false;
    }
}
