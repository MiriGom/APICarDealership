package com.pluralsight.dealership.APICarDealership.controller;

import com.pluralsight.dealership.APICarDealership.dao.VehicleDAO;
import com.pluralsight.dealership.APICarDealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/vehicles")
public class VehicleController {
    private VehicleDAO vehicleDAO;

    @Autowired
    public VehicleController(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @GetMapping("/allCars")
    public List<Vehicle> findAllVehicles() {
        return vehicleDAO.findAllVehicles();
    }

    @GetMapping("/vehiclePrice")
    public List<Vehicle> findByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice) {
        return vehicleDAO.findByPrice(minPrice, maxPrice);
    }

    @GetMapping("/vehicleMakeModel")
    public List<Vehicle> findMakeModel(@RequestParam("make") String make, @RequestParam("model") String model) {
        return vehicleDAO.findMakeModel(make, model);
    }

    @GetMapping("/vehicleYear")
    public List<Vehicle> findByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        return vehicleDAO.findByYear(minYear, maxYear);
    }

    //needs fixing.
    @GetMapping("/vehicleColor")
    public List<Vehicle> findByColor(@RequestParam("color") String color) {
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

    //fix code
    @PutMapping("/changeVehicle/{vin}")
    public void changeVehicle(@RequestBody Vehicle vehicle, @PathVariable("vin") int vin) {
        vehicleDAO.changeVehicle(vehicle, vin);
    }
    @PostMapping("addVehicle")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addVehicles(@RequestBody Vehicle vehicle) {
        vehicleDAO.addVehicle(vehicle);
    }
    @DeleteMapping("/deleteVehicle/{vin}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable int vin){
        vehicleDAO.removeVehicle(vin);
    }

}
