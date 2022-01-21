package com.example.api.Interface;


import com.example.api.DTO.Products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Products,ObjectId> {
    Products findBy_id(ObjectId _id);
}
