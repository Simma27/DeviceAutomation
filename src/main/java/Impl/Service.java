package Impl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.Device;
import services.AuthService;

import static config.DeviceConfig.*;
import static io.restassured.RestAssured.given;
import static services.BasicService.SERVICE;

/**
 * Service class provides basic functions for working with device.
 * Consist of method: Create, Delete, Update, Move devices.
 */
public class Service implements AuthService {

    /**
     * The createDevice method sends a request to create Device.
     *
     * @param device The input is a Device with the parameters we need.
     * @return Response to a request to create a device as a Device class.
     */
    public Device createDevice(Device device) {
        final String CREATE = "/create";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(URI + SERVICE + CREATE);
        if (response.statusCode() == 200) {
            System.out.println(response.prettyPrint());
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param serialNumber serial number of the Device to be deleted.
     * @return Response to a request to delete Device as a Device class.
     */
    public Device deleteDevice(long serialNumber) {
        final String DELETE = "/delete";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(Device.builder()
                        .username(USERNAME)
                        .password(PASSWORD)
                        .serialNumber(serialNumber)
                        .build())
                .post(URI + SERVICE + DELETE);

        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The updateDevice method sends a request to update Device with the parameters we need.
     *
     * @param device The input is a Device with the parameters we need.
     * @return Response to a request to update Device as a Device class.
     */
    public Device updateDevice(Device device) {
        final String UPDATE = "/update";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(URI + SERVICE + UPDATE);
        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The updateDevice method sends a request to move Device to another Department.
     *
     * @param device The input is a Device with the parameters(Department ID, searchCriteria).
     * @return Response to a request to move Device as a Device class.
     */
    public Device moveDevice(Device device) {
        final String MOVE = "/move";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(URI + SERVICE + MOVE);
        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param device input is a Device to be removed.
     * @return Response to a request to delete Device as a Device class.
     */
    public Device deleteDevice(Device device) {
        final String DELETE = "/delete";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(URI + SERVICE + DELETE);

        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }
}
