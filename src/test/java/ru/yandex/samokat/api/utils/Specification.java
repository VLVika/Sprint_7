package ru.yandex.samokat.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.net.HttpURLConnection;

public class Specification {

    public static final RequestSpecification REQ_SPEC =
        new RequestSpecBuilder()
                .setBaseUri("http://qa-scooter.praktikum-services.ru/")
                .setBasePath("api/v1/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();



    public static final ResponseSpecification RES_SPEC =
            new ResponseSpecBuilder()
                    .log(LogDetail.ALL)
                    .expectStatusCode(HttpURLConnection.HTTP_CREATED)
                    .build();

}
