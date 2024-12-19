
package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.Contract;
import com.pluralsight.dealership.APICarDealership.model.SalesContract;
import com.pluralsight.dealership.APICarDealership.model.Vehicle;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class SalesContractDAOmySqlImp implements SalesContractDAO{
    private DataSource ds;

    public SalesContractDAOmySqlImp(DataSource ds) {
        this.ds = ds;
    }
    @Override
    public void saveSalesContract(SalesContract contract) {
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("""
             INSERT INTO sales_contracts(date, vin, customer_name, customer_email, monthly_payment, total_price, sales_tax, recording_fee, processing_fee, financing )
             VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
             """);
            ps.setString(1, contract.getDateOfContract());
            ps.setInt(2, contract.getVehicleSold().getVin());
            ps.setString(3, contract.getCustomerName());
            ps.setString(4, contract.getCustomerEmail());
            ps.setDouble(5, contract.getMonthlyPayment());
            ps.setDouble(6, contract.getTotalPrice());
            ps.setDouble(7, contract.getSalesTax());
            ps.setDouble(8, contract.getRecordingFee());
            ps.setDouble(9, contract.getProcessingFee());
            ps.setBoolean(10,contract.isFinancing());

            ps.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<SalesContract> findAllSalesContracts(){
        List<SalesContract> allSalesContracts = new ArrayList<>();
        String date;
        String customerName;
        String customerEmail;
        String make;
        String model;
        String vehicleType;
        String color;
        int vin;
        int year;
        int odometer;
        double price;
        boolean isFinancing;
        Vehicle vehicleSold;

        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("""
             SELECT * FROM sales_contracts
             JOIN vehicles ON vehicles.vin = sales_contracts.vin
             """);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getString("date");
                customerName = rs.getString("customer_name");
                customerEmail = rs.getString("customer_email");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("vehicle_type");
                color = rs.getString("car_color");
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                isFinancing = rs.getBoolean("financing");

                vehicleSold = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                allSalesContracts.add(new SalesContract(date, customerName, customerEmail, vehicleSold, isFinancing));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allSalesContracts;
    }
    @Override
    public SalesContract findSalesById(int id){

        String date;
        String customerName;
        String customerEmail;
        String make;
        String model;
        String vehicleType;
        String color;
        int vin;
        int year;
        int odometer;
        double price;
        boolean isFinancing;
        Vehicle vehicleSold;

        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("""
             SELECT * FROM sales_contracts
             JOIN vehicles ON vehicles.vin = sales_contracts.vin
             WHERE sales_id = ?;
             """);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                rs.next();
                date = rs.getString("date");
                customerName = rs.getString("customer_name");
                customerEmail = rs.getString("customer_email");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("vehicle_type");
                color = rs.getString("car_color");
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                isFinancing = rs.getBoolean("financing");

                vehicleSold = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                return new SalesContract(date, customerName, customerEmail, vehicleSold, isFinancing);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
