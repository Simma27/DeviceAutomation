package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.BodyRequestToCreateDevice;
import models.api.BodyResponseCreatedDevice;

import static io.restassured.RestAssured.*;

public class Service {

    BodyRequestToCreateDevice bodyRequestToCreateDevice = BodyRequestToCreateDevice.builder()
            .username("superuser")
            .password("traverse")
            .accountSerialNumber(49L)
            .address("127.0.0.5")
            .applyAutomationProfiles(true)
            .automaticTestDiscovery(true)
            .clearOnOk(false)
            .comment("")
            .doNotResolveAddress(false)
            .model("")
            .tag1("")
            .tag2("")
            .tag3("")
            .tag4("")
            .tag5("")
            .vendor("")
            .configBackupEnabled(false)
            .flapPreventionWaitCycles(2L)
            .locationName("Default Location")
            .name("Simma2")
            .processCollectionEnabled(false)
            .rediscoveryEnabled(false)
            .showOnSummary(true)
            .smartNotify(true)
            .type(0L)
            .build();


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
