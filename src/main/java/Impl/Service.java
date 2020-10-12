package Impl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.Device;
import services.AuthService;
import services.BasicService;

import static io.restassured.RestAssured.given;


public class Service implements AuthService {

    private final String CREATE = "/create";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String MOVE = "/move";


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

    public static Device move(Device device) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post("http://127.0.0.1/api/json/admin/device/move");
        if (response.statusCode() == 200){
            return response.as(Device.class);
        }
        return null;
    }

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
