package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService {
    private static int nextId = 1;  // (1)

    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)

    public ArrayList<Sneaker> getInventory() {
        return inventory;
    }

    public Sneaker create(String name, String brand, String sport, double size, int qty, float price) {
        Sneaker createdSneaker = new Sneaker(nextId++,name,brand,sport,size,qty, price);
        inventory.add(createdSneaker);
        return createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        for(Sneaker sneaker : inventory){
            if(sneaker.getId()==id){
                return sneaker;
            }
        }
        return null;
    }

    //read all
    public Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
        return inventory.toArray(new Sneaker[0]);
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for(Sneaker sneaker : inventory){
            if(sneaker.getId()==id){
                inventory.remove(sneaker);
                return true;
            }
        }
        return false;
    }
}
