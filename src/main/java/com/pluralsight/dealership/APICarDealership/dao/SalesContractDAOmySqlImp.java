
package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.Contract;
import com.pluralsight.dealership.APICarDealership.model.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesContractDAOmySqlImp implements SalesContractDAO{
    private DataSource ds;
    public SalesContractDAOmySqlImp(DataSource ds) {
        this.ds = ds;
    }
    @Override
    public void saveSalesContract(SalesContract contract) {
        List<Contract> contractsList = new ArrayList<>();
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
}
