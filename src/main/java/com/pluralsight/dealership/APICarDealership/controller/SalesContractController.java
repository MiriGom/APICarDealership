package com.pluralsight.dealership.APICarDealership.controller;


import com.pluralsight.dealership.APICarDealership.dao.SalesContractDAO;
import com.pluralsight.dealership.APICarDealership.model.SalesContract;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/salesContracts")
public class SalesContractController {
    private SalesContractDAO salesContractDAO;
    @Autowired
    public SalesContractController(SalesContractDAO salesContractDAO) {
        this.salesContractDAO = salesContractDAO;
    }
    @GetMapping("/sale/id")
    public SalesContract getSalesContractById(@PathVariable("id") int id) {
        return salesContractDAO.findSalesById(id);
    }


  //  @Autowired
   // public SalesContractController(SalesContractDAO )
}
