package services;

import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.deletedevice.ResponseDeviceDelete;

import static config.ApiDeviceConfig.*;
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
    public ResponseDeviceCreate createDevicePositiv(RequestDeviceCreate requestBody) {

        return given()
                .spec(Specification.getRequestSpecification())
                .body(requestBody)
                .post(CREATE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceCreate.class);
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param serialNumber serial number of the Device to be deleted.
     * @return Response to a request to delete Device as a Device class.
     */
    public ResponseDeviceDelete deleteDevicePositiv(long serialNumber) {
        return given()
                .spec(Specification.getRequestSpecification())
                .body(RequestDeviceDelete.builder()
                        .serialNumber(serialNumber)
                        .build())
                .post(DELETE_DEVICE)
                .then()
                .spec(Specification.getResponseSpecification())
                .extract()
                .as(ResponseDeviceDelete.class);
    }

//    /**
//     * The updateDevice method sends a request to update Device with the parameters we need.
//     *
//     * @param requestDeviceUpdate The input is a Request body with the parameters we need.
//     * @return Response to a request to update Device as a Device class.
//     */
//    public ResponseDeviceUpdate updateDevicePositiv(RequestDeviceUpdate requestDeviceUpdate) {
//        return given()
//                .contentType(ContentType.JSON)
//                .body(requestDeviceUpdate)
//                .post(UPDATE_DEVICE)
//                .then()
//                .spec(responseSpec)
//                .extract()
//                .as(ResponseDeviceUpdate.class);
//    }
//
//    /**
//     * The updateDevice method sends a request to move Device to another Department.
//     *
//     * @param requestDeviceMove The input is a request body with the parameters(Department ID, searchCriteria).
//     * @return Response to a request to move Device as a Device class.
//     */
//    public ResponseDeviceMove moveDevicePositiv(RequestDeviceMove requestDeviceMove) {
//        return given()
//                .spec(requestSpecification)
//                .body(requestDeviceMove)
//                .post(MOVE_DEVICE)
//                .then()
//                .spec(responseSpec)
//                .extract()
//                .as(ResponseDeviceMove.class);
//    }
//
//    /**
//     * The deleteDevice method sends a request to delete Device by serial number.
//     *
//     * @param emptyObject input is a Device to be removed.
//     * @return Response to a request to delete Device as a Device class.
//     */
//    public ResponseDeviceDelete deleteDevice(Object emptyObject) {
//        return given()
//                .spec(requestSpecification)
//                .body(emptyObject)
//                .post(DELETE_DEVICE)
//                .then()
//                .spec(responseSpecNegativ)
//                .extract()
//                .as(ResponseDeviceDelete.class);
//    }
}
