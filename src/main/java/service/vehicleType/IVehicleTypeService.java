package service.vehicleType;

import model.Ride;
import model.VehicleType;
import service.rider.IRiderService;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface IVehicleTypeService {

    Logger log = Logger.getLogger(IRiderService.class.getName());

    void addVehicleType(Ride ride);

    Ride getVehicleTypeByID(int id);

    ArrayList<VehicleType> getVehicleTypes();

    Ride updateVehicleType(int id, Ride ride);

    void removeVehicleType(int id);

}
