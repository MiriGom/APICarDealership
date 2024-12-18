package com.pluralsight.dealership.APICarDealership.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract public class Contract {

    protected String customerName;
    protected String customerEmail;
    protected String dateOfContract;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {

        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        //take
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.now();
        this.dateOfContract = date.format(dateFormatter);
    }
    public Contract( String customerName, String customerEmail, Vehicle vehicleSold) {

        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        //take
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.now();
        this.dateOfContract = date.format(dateFormatter);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    abstract public double getTotalPrice();
    abstract public double getMonthlyPayment();
}
