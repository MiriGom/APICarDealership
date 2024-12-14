package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface VehicleDAO {
    List<Vehicle> findByColor(String color);
    List<Vehicle> findByMileage(int min, int max);
    List<Vehicle> findByVehicleType(String type);
    List<Vehicle> findAllVehicles();
    List<Vehicle> findByPrice(double min, double max);
    List<Vehicle> findByYear(int min, int max);
    List<Vehicle> findMakeModel(String make, String model);
    List<Vehicle>findByVin(int vin);
    void saveVehicle(Vehicle vehicle);
    void removeVehicle(int vin);
}
