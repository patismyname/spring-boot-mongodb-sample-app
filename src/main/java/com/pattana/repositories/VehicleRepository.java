package com.pattana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattana.model.Vehicle;

import java.util.UUID;

public interface VehicleRepository extends MongoRepository<Vehicle, UUID> {
}
