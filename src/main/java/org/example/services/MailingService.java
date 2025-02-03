package org.example.services;

import io.restassured.RestAssured;

import java.util.Random;


public class MailingService {
    private static final String PROTOCOL           = "https";
    private static final String ENDPOINT           = "mailsac.com/inbox";
    private static final String EMAIL_STATIC_START = "aappiumtest";
    private static final String EMAIL_STATIC_END   = "@mailsac.com";
    private static final int    RANDOM_BOUND       = 30000;

    private String email;

    public MailingService() {
        final int id = new Random().nextInt(RANDOM_BOUND);
        email = EMAIL_STATIC_START + id + EMAIL_STATIC_END;

        System.out.println("Generated email address: " + PROTOCOL + "://" + ENDPOINT + "/" + email);
        RestAssured.baseURI = PROTOCOL + "://" + ENDPOINT + "/" + email;
    }

    public String getValidationLink() {

        final String responseBody = RestAssured
                .given()
                .when()
                .get()
                .then()
                .extract()
                .response()
                .getBody()
                .asPrettyString();

        final int startIndex = responseBody.indexOf("\"links\":[\"");
        final int endIndex   = responseBody.indexOf("\"]", startIndex);

        return responseBody.substring(startIndex, endIndex).replace("\"links\":[\"", "");
    }


    public String getEmailAddress() {
        return email;
    }
}
