package Impl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.Device;
import services.AuthService;
import services.BasicService;

import static io.restassured.RestAssured.given;

/**
 *  Service class provides basic functions for working with device.
 *  Consist of method: Create, Delete, Update, Move devices.
 */
public class Service implements AuthService {

    private final String CREATE = "/create";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String MOVE = "/move";

    /**
     * The createDevice method sends a request to create Device.
     * @param device The input is a Device with the parameters we need.
     * @return Response to a request to create a device as a Device class.
     */
    public static Device createDevice(Device device) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post("http://127.0.0.1/api/json/admin/device/create");
        if (response.statusCode() == 200) {
            System.out.println(response.prettyPrint());
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     * @param serialNumber serial number of the Device to be deleted.
     * @return Response to a request to delete Device as a Device class.
     */
    public static Device deleteDevice(long serialNumber) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(Device.builder()
                        .username(BasicService.USERNAME)
                        .password(BasicService.PASSWORD)
                        .serialNumber(serialNumber)
                        .build())
                .post("http://127.0.0.1/api/json/admin/device/delete");

        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The updateDevice method sends a request to update Device with the parameters we need.
     * @param device The input is a Device with the parameters we need.
     * @return Response to a request to update Device as a Device class.
     */
    public static Device updateDevice(Device device) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post("http://127.0.0.1/api/json/admin/device/update");
        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The updateDevice method sends a request to move Device to another Department.
     * @param device The input is a Device with the parameters(Department ID, searchCriteria).
     * @return Response to a request to move Device as a Device class.
     */
    public static Device moveDevice(Device device) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post("http://127.0.0.1/api/json/admin/device/move");
        if (response.statusCode() == 200){
            return response.as(Device.class);
        }
        return null;
    }

    /**
     * The deleteDevice method sends a request to delete Device by serial number.
     * @param device input is a Device to be removed.
     * @return Response to a request to delete Device as a Device class.
     */
    public static Device deleteDevice(Device device) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post("http://127.0.0.1/api/json/admin/device/delete");

        if (response.statusCode() == 200) {
            return response.as(Device.class);
        }
        return null;
    }
}
