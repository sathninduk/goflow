package service.vehicleType;

import model.VehicleType;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface IVehicleTypeService {

    Logger log = Logger.getLogger(IVehicleTypeService.class.getName());

    void addVehicleType(VehicleType vehicleType);

    VehicleType getVehicleTypeByID(int id);

    ArrayList<VehicleType> getVehicleTypes();

    VehicleType updateVehicleType(int id, VehicleType vehicleType);

    void removeVehicleType(int id);

}
