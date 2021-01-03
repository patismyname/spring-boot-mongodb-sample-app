package com.pattana.services;

import java.util.UUID;

import com.pattana.dto.VehicleCreateDTO;
import com.pattana.dto.VehicleUpdateDTO;
import com.pattana.model.Vehicle;

public interface VehicleService {

    public Vehicle getVehicleById(UUID id);
    public Vehicle createVehicle(VehicleCreateDTO vehicleCreateDTO);
    public Vehicle updateVehicle(VehicleUpdateDTO vehicleUpdateDTO, UUID id);
    public Vehicle deleteVehicleById(UUID id);
}
