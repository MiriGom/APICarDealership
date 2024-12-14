package com.pluralsight.dealership.APICarDealership.controller;

import com.pluralsight.dealership.APICarDealership.dao.VehicleDAO;
import com.pluralsight.dealership.APICarDealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/vehicles")
public class VehicleController {
    private VehicleDAO vehicleDAO;
    @Autowired
    public VehicleController(VehicleDAO vehicleFromDataBase) {
        this.vehicleDAO = vehicleFromDataBase;
    }

    @GetMapping("/allCars")
    public List<Vehicle> findAllVehicles() {
        return vehicleDAO.findAllVehicles();
    }
    @GetMapping("/vehiclePrice")
    public List<Vehicle> findByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice){
        return vehicleDAO.findByPrice(minPrice, maxPrice);
    }

    @GetMapping("/vehicleMakeModel")
    public List<Vehicle> findMakeModel(@RequestParam("make") String make, @RequestParam("model") String model){
        return vehicleDAO.findMakeModel(make, model);
    }

    @GetMapping("/vehicleYear")
    public List<Vehicle> findByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        return vehicleDAO.findByYear(minYear, maxYear);
    }
    //needs fixing.
    @GetMapping("/vehicleColor")
    public List<Vehicle> findByColor (@RequestParam("color") String color){
        return vehicleDAO.findByColor(color);
    }

    @GetMapping("/vehicleMileage")
    public List<Vehicle> findVehiclesByMiles(@RequestParam("minMiles") int minMiles, @RequestParam("maxMiles") int maxMiles) {
        return vehicleDAO.findByMileage(minMiles, maxMiles);
    }
    @GetMapping("/vehicleVin")
    public List<Vehicle> findByVin(@RequestParam("vin") int vin) {
        return vehicleDAO.findByVin(vin);
    }

    
    /*
    @GetMapping
    @RequestMapping(path = "/{vin}")
    public Vehicle findByVin(@PathVariable ("id") int vehicleVin) {
        return new Vehicle(1111, 2001, "Toyota", "Celica", "car", "red", 234585, 80000);
    }
    @GetMapping

    public List<Vehicle> findALlVehicles() {
        List<Vehicle> results = new ArrayList<>();
        results.add(new Vehicle(1111, 2001, "Toyota", "Celica", "car", "red", 234585, 80000));
        return results;
    }
    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        System.out.println(vehicle);
        return vehicle;
    }
    public void deleteByVin(Integer vin) {

    }

     */

}
