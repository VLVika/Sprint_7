package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.net.HttpURLConnection;

import static utils.LocalVariables.BASE_PATH;
import static utils.LocalVariables.BASE_URL;

public class Specification {

    public static final RequestSpecification REQ_SPEC =
        new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();




    public static final ResponseSpecification RES_SPEC_CREATED =
            getSpecBuilder()
                    .expectStatusCode(HttpURLConnection.HTTP_CREATED)
                    .build();

    private static ResponseSpecBuilder getSpecBuilder() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL);
    }


    public static final ResponseSpecification RES_SPEC_CONFLICT =
            getSpecBuilder()
                    .expectStatusCode(HttpURLConnection.HTTP_CONFLICT)
                    .build();


    public static final ResponseSpecification RES_SPEC_OK =
            getSpecBuilder()
                    .expectStatusCode(HttpURLConnection.HTTP_OK)
                    .build();

    public static final ResponseSpecification RES_SPEC_BAD_REQUEST =
            getSpecBuilder()
                    .expectStatusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                    .build();

    public static final ResponseSpecification RES_SPEC_NOT_FOUND =
            getSpecBuilder()
                    .expectStatusCode(HttpURLConnection.HTTP_NOT_FOUND)
                    .build();

}
