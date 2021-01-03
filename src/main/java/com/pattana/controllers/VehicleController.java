package com.pattana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.pattana.dto.VehicleCreateDTO;
import com.pattana.dto.VehicleUpdateDTO;
import com.pattana.model.Vehicle;
import com.pattana.services.VehicleService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/vehicles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/vehicles")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleCreateDTO vehicleCreateDTO){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/vehicles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleUpdateDTO vehicleUpdateDTO, @PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleUpdateDTO, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/vehicles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(vehicleService.deleteVehicleById(id), HttpStatus.OK);
    }
}
