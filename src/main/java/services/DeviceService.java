package services;

import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.deletedevice.ResponseDeviceDelete;
import models.api.deletedevice.SearchCriteria;
import models.api.movedevice.RequestDeviceMove;
import models.api.movedevice.ResponseDeviceMove;
import models.api.specification.Specification;
import models.api.updatedevice.RequestDeviceUpdate;
import models.api.updatedevice.ResponseDeviceUpdate;

import java.util.Collections;

import static config.ApiDeviceConfig.*;
import static config.UpdateDeviceConfig.DEVICE_SERIAL_NUMBER;
import static io.restassured.RestAssured.given;

/**
 * Service class provides basic functions for working with device.
 * Consist of method: Create, Delete, Update, Move devices.
 */
public class DeviceService {

    /**
     * The createDevice method sends a request to create Device.
     *
     * @param requestBody The input is a body with the parameters we need.
     * @return Response to a request to create a device as a Device class.
     */
    public ResponseDeviceCreate createDevice(RequestDeviceCreate requestBody) {

        return given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceCreate.class);
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param serialNumber serial number of the Device to be deleted.
     */
    public void deleteDevice(int serialNumber) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(RequestDeviceDelete.builder()
                        .serialNumber(serialNumber)
                        .searchCriterias(Collections.singletonList(SearchCriteria
                                .builder()
                                .searchOption(DEVICE_SERIAL_NUMBER.name())
                                .searchTerms(serialNumber)
                                .build()))
                        .build())
                .post(DELETE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceDelete.class);
    }

    public void deleteDevice(RequestDeviceDelete requestDeviceDelete) {
        given()
                .spec(Specification.getRequestSpecification())
                .body(requestDeviceDelete)
                .post(DELETE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceDelete.class);
    }

    /**
     * The updateDevice method sends a request to update Device with the parameters we need.
     *
     * @param requestDeviceUpdate The input is a Request body with the parameters we need.
     * @return Response to a request to update Device as a Device class.
     */
    public ResponseDeviceUpdate updateDevice(RequestDeviceUpdate requestDeviceUpdate) {
        return given()
                .spec(Specification.getRequestSpecification())
                .body(requestDeviceUpdate)
                .post(UPDATE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceUpdate.class);
    }

    /**
     * The updateDevice method sends a request to move Device to another Department.
     *
     * @param requestDeviceMove The input is a request body with the parameters(Department ID, searchCriteria).
     * @return Response to a request to move Device as a Device class.
     */
    public ResponseDeviceMove moveDevice(RequestDeviceMove requestDeviceMove) {
        return given()
                .spec(Specification.getRequestSpecification())
                .body(requestDeviceMove)
                .post(MOVE_DEVICE.getPath())
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceMove.class);
    }

}
