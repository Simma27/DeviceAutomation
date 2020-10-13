package services;

import io.restassured.response.Response;
import models.api.Device;
import models.api.Device;


public interface AuthService {

    public Device createDevice(Device device);

    public Device deleteDevice(long serialNumber);

    public Device updateDevice(Device device);

    public Device moveDevice(Device device);
}
