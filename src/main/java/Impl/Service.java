package Impl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.Device;
import models.api.deviceUpdateProperty;
import services.AuthService;
import services.BasicService;

import static io.restassured.RestAssured.given;


public class Service implements AuthService {


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

    public static void main(String[] args) {

        deviceUpdateProperty deviceUpdateProperty = models.api.deviceUpdateProperty
                .builder()
                .propertyName("SUSPEND")
                .propertyValue(String.valueOf(true))
                .build();

        System.out.println(deviceUpdateProperty.getPropertyName());
        System.out.println(deviceUpdateProperty.getPropertyValue());
        System.out.println(deviceUpdateProperty.toString());
    }


}
