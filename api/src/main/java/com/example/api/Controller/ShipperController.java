package com.example.api.Controller;


import com.example.api.DTO.Shipper;
import com.example.api.Interface.ShipperRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ShipperController {
    private final ShipperRepository shipperRepository;
     @Autowired
    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @GetMapping("/api/shipper")
    public List<Shipper> getShipper(){
        return shipperRepository.findAll();
    }
    @PutMapping("/api/editshipper/{id}")
    public Shipper EditProduct(@PathVariable("id") ObjectId id, @RequestBody Shipper shipper) {
        shipper.set_id(id);
        shipperRepository.save(shipper);
        return shipper;
    }
    @DeleteMapping("/api/deleteshipper/{id}")
    public void deleteContact(@PathVariable ObjectId id) {
        shipperRepository.delete(shipperRepository.findBy_id(id));
    }
    @GetMapping("/api/shipper/{id}")
    public Shipper getContactById(@PathVariable("id") ObjectId id) {
        return shipperRepository.findBy_id(id);
    }


}
