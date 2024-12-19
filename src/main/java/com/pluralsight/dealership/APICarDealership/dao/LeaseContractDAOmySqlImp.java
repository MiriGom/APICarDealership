package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.Contract;
import com.pluralsight.dealership.APICarDealership.model.LeaseContract;
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
public class LeaseContractDAOmySqlImp implements LeaseContractDAO {
    private DataSource ds;

    public LeaseContractDAOmySqlImp(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void saveLeaseContract(LeaseContract contract) {
        List<Contract> leaseContractList = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("""
                    INSERT INTO lease_contracts(date, vin, customer_name, customer_email, monthly_payment, total_price, expected_ending_value, lease_fee, monthly_lease_finance)
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
                    """);
            ps.setString(1, contract.getDateOfContract());
            ps.setInt(2, contract.getVehicleSold().getVin());
            ps.setString(3, contract.getCustomerName());
            ps.setString(4, contract.getCustomerEmail());
            ps.setDouble(5, contract.getMonthlyPayment());
            ps.setDouble(6, contract.getTotalPrice());
            ps.setDouble(7, contract.getExpectedEndingValue());
            ps.setDouble(8, contract.getLeaseFee());
            ps.setDouble(9, contract.getMonthlyLeaseFinance());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<LeaseContract> findAllLeaseContract() {
        List<LeaseContract> allLeaseContract = new ArrayList<>();
        String date;
        String customerName;
        String customerEmail;
        double monthlyPayment;
        int vin;
        double expectedEndingValue;
        double totalPrice;
        double leaseFee;
        double monthlyLeaseFinance;
        String make;
        String model;
        String vehicleType;
        String color;
        int year;
        int odometer;
        double price;
        Vehicle vehicleLeased;

        try (Connection connection = ds.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("""
                    SELECT * FROM lease_Contracts
                    JOIN vehicles ON vehicles.vin = lease_contracts.vin
                    """);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getString("date");
                vin = rs.getInt("vin");
                customerName = rs.getString("customer_name");
                customerEmail = rs.getString("customer_email");
                monthlyPayment = rs.getDouble("monthly_payment");
                totalPrice = rs.getDouble("total_price");
                expectedEndingValue = rs.getDouble("expected_ending_value");
                leaseFee = rs.getDouble("lease_fee");
                monthlyLeaseFinance = rs.getDouble("monthly_lease_finance");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("vehicle_type");
                color = rs.getString("car_color");
                year = rs.getInt("year");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                vehicleLeased = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                allLeaseContract.add(new LeaseContract(date, customerName, customerEmail, vehicleLeased, expectedEndingValue, leaseFee, monthlyLeaseFinance));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allLeaseContract;
    }

    public LeaseContract findLeaseById(int id) {
        String date;
        String customerName;
        String customerEmail;
        double monthlyPayment;
        int vin;
        double expectedEndingValue;
        double totalPrice;
        double leaseFee;
        double monthlyLeaseFinance;
        String make;
        String model;
        String vehicleType;
        String color;
        int year;
        int odometer;
        double price;
        Vehicle vehicleLeased;

        try (Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("""
                    SELECT * FROM lease_contracts
                    JOIN vehicles ON vehicles.vin = lease_contracts.vin
                    WHERE lease_id = ?;
                    """);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            date = rs.getString("date");
            vin = rs.getInt("vin");
            customerName = rs.getString("customer_name");
            customerEmail = rs.getString("customer_email");
            expectedEndingValue = rs.getDouble("expected_ending_value");
            leaseFee = rs.getDouble("lease_fee");
            monthlyLeaseFinance = rs.getDouble("monthly_lease_finance");
            make = rs.getString("make");
            model = rs.getString("model");
            vehicleType = rs.getString("vehicle_type");
            color = rs.getString("car_color");
            year = rs.getInt("year");
            odometer = rs.getInt("odometer");
            price = rs.getDouble("price");

            vehicleLeased = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            return new LeaseContract(date, customerName, customerEmail, vehicleLeased, expectedEndingValue, leaseFee, monthlyLeaseFinance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
