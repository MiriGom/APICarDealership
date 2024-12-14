package com.pluralsight.dealership.APICarDealership.dao;

import javax.sql.DataSource;

public class DealershipDAOImp implements DealershipDAO{
    private DataSource ds;
    public DealershipDAOImp (DataSource ds) {
        this.ds = ds;
    }
    @Override
    public void findAllDealership() {

    }

    @Override
    public void removeVehicle() {

    }
}
