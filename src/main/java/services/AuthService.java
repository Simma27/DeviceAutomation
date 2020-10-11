package services;

import io.restassured.response.Response;
import models.api.BodyRequestToCreateDevice;
import models.api.BodyResponseCreatedDevice;

public interface AuthService {

    public BodyResponseCreatedDevice createDevice(BodyRequestToCreateDevice request);

    public BodyResponseCreatedDevice updateDevice();

    public Response moveDevice();

    public Response deleteDevice();
}
