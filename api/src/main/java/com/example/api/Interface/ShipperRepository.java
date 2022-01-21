package com.example.api.Interface;

import com.example.api.DTO.Shipper;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends MongoRepository<Shipper,ObjectId> {
    Shipper findBy_id(ObjectId _id);
}
