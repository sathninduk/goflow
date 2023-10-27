package service.vehicleType;

import model.VehicleType;

import java.util.ArrayList;
import java.util.logging.Logger;

// This is the interface for the VehicleTypeService class
public interface IVehicleTypeService {

    // logger object
    Logger log = Logger.getLogger(IVehicleTypeService.class.getName());

    void addVehicleType(VehicleType vehicleType); // add vehicle type method

    VehicleType getVehicleTypeByID(int id); // get vehicle type by id method

    VehicleType getVehicleTypeByName(String name); // get vehicle type by name method

    ArrayList<VehicleType> getVehicleTypes(); // get all vehicle types method

    VehicleType updateVehicleType(int id, VehicleType vehicleType); // update vehicle type method

    void removeVehicleType(int id); // remove vehicle type method

}
