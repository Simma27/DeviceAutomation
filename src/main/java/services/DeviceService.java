package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Device;

import static config.DeviceConfig.*;
import static io.restassured.RestAssured.given;

/**
 * Service class provides basic functions for working with device.
 * Consist of method: Create, Delete, Update, Move devices.
 */
public class DeviceService implements AuthService {

    /**
     * The createDevice method sends a request to create Device.
     *
     * @param device The input is a Device with the parameters we need.
     * @return Response to a request to create a device as a Device class.
     */
    public Device createDevice(Device device) {

        RestAssured.baseURI = "http://127.0.0.1";
        RestAssured.basePath = "/api/json";

        return given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(CREATEDEVICE)
                .then()
                .statusCode(200)
                .extract()
                .as(Device.class);
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param serialNumber serial number of the Device to be deleted.
     * @return Response to a request to delete Device as a Device class.
     */
    public Device deleteDevice(long serialNumber) {
        return given()
                .contentType(ContentType.JSON)
                .body(Device.builder()
                        .username(USERNAME)
                        .password(PASSWORD)
                        .serialNumber(serialNumber)
                        .build())
                .post(DELETEDEVICE)
                .then()
                .statusCode(200)
                .extract()
                .as(Device.class);
    }

    /**
     * The updateDevice method sends a request to update Device with the parameters we need.
     *
     * @param device The input is a Device with the parameters we need.
     * @return Response to a request to update Device as a Device class.
     */
    public Device updateDevice(Device device) {
        return given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(UPDATEDEVICE)
                .then()
                .statusCode(200)
                .extract()
                .as(Device.class);
    }

    /**
     * The updateDevice method sends a request to move Device to another Department.
     *
     * @param device The input is a Device with the parameters(Department ID, searchCriteria).
     * @return Response to a request to move Device as a Device class.
     */
    public Device moveDevice(Device device) {
        return given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(MOVEDEVICE)
                .then()
                .statusCode(200)
                .extract()
                .as(Device.class);
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param device input is a Device to be removed.
     * @return Response to a request to delete Device as a Device class.
     */
    public Device deleteDevice(Device device) {
        return given()
                .contentType(ContentType.JSON)
                .body(device)
                .post(DELETEDEVICE)
                .then()
                .statusCode(200)
                .extract()
                .as(Device.class);
    }
}
