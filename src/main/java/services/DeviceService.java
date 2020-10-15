package services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.api.createdevice.RequestDeviceCreate;
import models.api.createdevice.ResponseDeviceCreate;
import models.api.deletedevice.RequestDeviceDelete;
import models.api.deletedevice.RequestDeviceDeleteEmpty;
import models.api.deletedevice.ResponseDeviceDelete;
import models.api.movedevice.RequestDeviceMove;
import models.api.movedevice.ResponseDeviceMove;
import models.api.updatedevice.RequestDeviceUpdate;
import models.api.updatedevice.ResponseDeviceUpdate;
import org.apache.commons.lang3.ObjectUtils;

import static config.DeviceConfig.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Service class provides basic functions for working with device.
 * Consist of method: Create, Delete, Update, Move devices.
 */
public class DeviceService {


    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://127.0.0.1")
            .setBasePath("/api/json")
            .setContentType(ContentType.JSON)
            .build();


    ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectBody("success", equalTo(true))
            .expectBody("errorCode", nullValue())
            .expectBody("errorMessage", nullValue())
            .expectBody("timestamp", notNullValue())
            .expectBody("timestampStr", notNullValue())
            .expectStatusCode(200)
            .build();

    ResponseSpecification responseSpecNegativ = new ResponseSpecBuilder()
            .expectBody("success", equalTo(false))
            .expectBody("timestamp", notNullValue())
            .expectBody("timestampStr", notNullValue())
            .expectStatusCode(200)
            .build();


    /**
     * The createDevice method sends a request to create Device.
     *
     * @param requestBody The input is a body with the parameters we need.
     * @return Response to a request to create a device as a Device class.
     */
    public ResponseDeviceCreate createDevicePositiv(RequestDeviceCreate requestBody) {

        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(CREATE_DEVICE)
                .then()
                .spec(responseSpec)
                .extract()
                .as(ResponseDeviceCreate.class);
    }

    public ResponseDeviceCreate createDeviceNegativ(RequestDeviceCreate requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(CREATE_DEVICE)
                .then()
                .spec(responseSpecNegativ)
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
                .contentType(ContentType.JSON)
                .body(RequestDeviceDelete.builder()
                        .serialNumber(serialNumber)
                        .build())
                .post(DELETE_DEVICE)
                .then()
                .spec(responseSpec)
                .extract()
                .as(ResponseDeviceDelete.class);
    }

    public ResponseDeviceDelete deleteDeviceNegativ(long serialNumber) {
        return given()
                .contentType(ContentType.JSON)
                .body(RequestDeviceDelete.builder()
                        .serialNumber(serialNumber)
                        .build())
                .post(DELETE_DEVICE)
                .then()
                .spec(responseSpecNegativ)
                .extract()
                .as(ResponseDeviceDelete.class);
    }

    /**
     * The updateDevice method sends a request to update Device with the parameters we need.
     *
     * @param requestDeviceUpdate The input is a Request body with the parameters we need.
     * @return Response to a request to update Device as a Device class.
     */
    public ResponseDeviceUpdate updateDevicePositiv(RequestDeviceUpdate requestDeviceUpdate) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDeviceUpdate)
                .post(UPDATE_DEVICE)
                .then()
                .spec(responseSpec)
                .extract()
                .as(ResponseDeviceUpdate.class);
    }

    public ResponseDeviceUpdate updateDeviceNegativ(RequestDeviceUpdate requestDeviceUpdate) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDeviceUpdate)
                .post(UPDATE_DEVICE)
                .then()
                .spec(responseSpecNegativ)
                .extract()
                .as(ResponseDeviceUpdate.class);
    }

    /**
     * The updateDevice method sends a request to move Device to another Department.
     *
     * @param requestDeviceMove The input is a request body with the parameters(Department ID, searchCriteria).
     * @return Response to a request to move Device as a Device class.
     */
    public ResponseDeviceMove moveDevicePositiv(RequestDeviceMove requestDeviceMove) {
        return given()
                .spec(requestSpecification)
                .body(requestDeviceMove)
                .post(MOVE_DEVICE)
                .then()
                .spec(responseSpec)
                .extract()
                .as(ResponseDeviceMove.class);
    }

    public ResponseDeviceMove moveDeviceNegativ(RequestDeviceMove requestDeviceMove) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDeviceMove)
                .post(MOVE_DEVICE)
                .then()
                .spec(responseSpecNegativ)
                .extract()
                .as(ResponseDeviceMove.class);
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     *
     * @param requestDeviceDelete input is a Device to be removed.
     * @return Response to a request to delete Device as a Device class.
     */
    public ResponseDeviceDelete deleteDevice(Object object) {
        return given()
                .spec(requestSpecification)
                .body(object)
                .post(DELETE_DEVICE)
                .then()
                .spec(responseSpecNegativ)
                .extract()
                .as(ResponseDeviceDelete.class);
    }
}
