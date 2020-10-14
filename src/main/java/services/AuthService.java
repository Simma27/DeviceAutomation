package services;

import models.Device;


/**
 * Iterface provide main method: Create, Delete, Update, Move devices.
 */
public interface AuthService {

    Device createDevice(Device device);

    Device deleteDevice(long serialNumber);

    Device updateDevice(Device device);

    Device moveDevice(Device device);
}
