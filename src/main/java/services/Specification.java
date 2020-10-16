package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;


public class Specification {

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("http://127.0.0.1")
                .setBasePath("/api/json")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectBody("success", equalTo(true))
                .expectBody("errorCode", nullValue())
                .expectBody("errorMessage", nullValue())
                .expectBody("timestamp", notNullValue())
                .expectBody("timestampStr", notNullValue())
                .expectStatusCode(200)
                .build();
    }


    public static ResponseSpecification getResponseSpecificationNegativ() {
        return new ResponseSpecBuilder()
                .expectBody("success", equalTo(false))
                .expectBody("timestamp", notNullValue())
                .expectBody("timestampStr", notNullValue())
                .expectStatusCode(200)
                .build();
    }

}
