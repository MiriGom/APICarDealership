package com.pluralsight.dealership.APICarDealership.controller;


import com.pluralsight.dealership.APICarDealership.dao.SalesContractDAO;
import com.pluralsight.dealership.APICarDealership.model.SalesContract;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/salesContracts")
public class SalesContractController {
    private SalesContractDAO salesContractDAO;
    @Autowired
    public SalesContractController(SalesContractDAO salesContractDAO) {
        this.salesContractDAO = salesContractDAO;
    }
    @GetMapping("/sale/{id}")
    public SalesContract getSalesContractById(@PathVariable("id") int id) {
        return salesContractDAO.findSalesById(id);
    }
    @GetMapping("/allContracts")
    public List<SalesContract> getAllSales() {
        return salesContractDAO.findAllSalesContracts();
    }
    @PostMapping("/sale")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addSalesContract(@RequestBody SalesContract salesContract) {
        salesContractDAO.saveSalesContract(salesContract);
    }

  //  @Autowired
   // public SalesContractController(SalesContractDAO )
}
