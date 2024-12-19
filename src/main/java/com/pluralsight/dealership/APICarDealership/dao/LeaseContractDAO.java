package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.LeaseContract;

import java.util.List;

public interface LeaseContractDAO {
    void saveLeaseContract(LeaseContract contract);
    List<LeaseContract> findAllLeaseContract();
    LeaseContract findLeaseById(int id);
}
