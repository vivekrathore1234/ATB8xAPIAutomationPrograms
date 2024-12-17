package com.thetestingacademy.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PUT_NONBddStyle {

    RequestSpecification requestSpecification;


    //    public void get_token(){
//
//    }
//
//    public void get_booking_id(){
//        return bookingid;
//    }


    // {
    //    "token": "de4c0f487606091"
    //}

//    {
//        "bookingid": 3111,
//            "booking": {
//        "firstname": "Jim",
//                "lastname": "Brown",
//                "totalprice": 111,
//                "depositpaid": true,
//                "bookingdates": {
//            "checkin": "2018-01-01",
//                    "checkout": "2019-01-01"
//        },
//        "additionalneeds": "Breakfast"
//    }
//    }


    @Description("Verify the PUT Request for the Restful Booker APIs")
    @Test
    public void test_put_non_bdd() {
        // Booking ID
        // Token
        // 6118
        // Token -  Token?
        // Payload - {
        //    "firstname" : "Pramod",
        //    "lastname" : "Brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
        //}

        String token = "1e817e5321b553f";
        String bookingid = "2179";


        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);


    }


}