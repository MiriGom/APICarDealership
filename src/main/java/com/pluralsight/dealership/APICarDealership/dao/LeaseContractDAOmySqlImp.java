package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.Contract;
import com.pluralsight.dealership.APICarDealership.model.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaseContractDAOmySqlImp implements LeaseContractDAO{
    private DataSource ds;
    public LeaseContractDAOmySqlImp (DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void saveLeaseContract(LeaseContract contract) {
        List<Contract> leaseContractList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {
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

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
