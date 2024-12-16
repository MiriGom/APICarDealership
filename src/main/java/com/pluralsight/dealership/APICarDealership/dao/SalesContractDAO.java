
package com.pluralsight.dealership.APICarDealership.dao;

import com.pluralsight.dealership.APICarDealership.model.SalesContract;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SalesContractDAO {
    void saveSalesContract(SalesContract contract);
    List<SalesContract> findAllSalesContracts();

    SalesContract findSalesById(int id);
}
