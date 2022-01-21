package com.example.api.Interface;

import com.example.api.DTO.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,ObjectId> {
   Order findBy_id(ObjectId _id);
}
