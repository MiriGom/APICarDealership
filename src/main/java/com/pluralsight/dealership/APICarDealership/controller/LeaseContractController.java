package com.pluralsight.dealership.APICarDealership.controller;

import com.pluralsight.dealership.APICarDealership.dao.LeaseContractDAO;
import com.pluralsight.dealership.APICarDealership.model.LeaseContract;
import com.pluralsight.dealership.APICarDealership.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "leaseContracts")
public class LeaseContractController {
    private LeaseContractDAO leaseContractDAO;

    @Autowired
    public LeaseContractController(LeaseContractDAO leaseContractDAO) {
        this.leaseContractDAO = leaseContractDAO;
    }
    @GetMapping("allContracts")
    public List<LeaseContract>getAllContracts() {
        return leaseContractDAO.findAllLeaseContract();
    }
    @GetMapping("/lease/{id}")
    public LeaseContract getLeaseContractById(@PathVariable("id") int id) {
        return leaseContractDAO.findLeaseById(id);
    }
    @PostMapping("/lease")
    @ResponseStatus (code = HttpStatus.CREATED)
    public void addLeaseContract(@RequestBody LeaseContract leaseContract) {
        leaseContractDAO.saveLeaseContract(leaseContract);
    }
}
