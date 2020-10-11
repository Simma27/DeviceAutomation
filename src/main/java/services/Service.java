package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.BodyRequestToCreateDevice;
import models.api.BodyResponseCreatedDevice;

import static io.restassured.RestAssured.*;

public class Service {


    public static BodyResponseCreatedDevice createDevice(BodyRequestToCreateDevice device){
        Response response = given()
                .contentType(ContentType.JSON)
                .body(device)
                .post("http://127.0.0.1/api/json/admin/device/create");
        if (response.statusCode() == 200) {
            System.out.println(response.prettyPrint());
            return response.as(BodyResponseCreatedDevice.class);
        }
        return null;
    }

}
