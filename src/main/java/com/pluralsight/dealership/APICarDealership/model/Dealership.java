package com.pluralsight.dealership.APICarDealership.model;
import java.util.ArrayList;
import java.util.List;

//Class and declared private variables
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();


    //Main constructor
    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);

    }
    public void removeVehicle(Vehicle v){
        inventory.remove(v);
    }

    public List<Vehicle> getAllVehicles(){
        if (inventory.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return inventory;
    }
}
