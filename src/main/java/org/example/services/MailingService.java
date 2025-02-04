package org.example.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Random;


public class MailingService {
    
    private static final String PROTOCOL = "https";
    private static final String EMAIL_STATIC_PART = "aappiumtest";
    private static final String EMAIL_PROVIDER = "mailsac.com";
    private static final int RANDOM_BOUND = 30000;

    private String email;

    public MailingService() {
        final int id = new Random().nextInt(RANDOM_BOUND);
        email = EMAIL_STATIC_PART + id + "@" + EMAIL_PROVIDER;

        String generatedEmail = PROTOCOL + "://" + EMAIL_PROVIDER; // Only base URL is used here
        System.out.println("Generated email address: " + generatedEmail + "/inbox/" + email);

        RestAssured.baseURI = generatedEmail;
    }

    public String getValidationLink() {
        try {
            // Send GET request to retrieve inbox contents with the email-specific path
            Response response = RestAssured.given()
                .when()
                .get("/inbox/" + email); // The "/inbox" path is added in the request

            // Extract the body of the response
            final String responseBody = response.getBody().asString();

            // Check if the response contains the expected link structure
            final int startIndex = responseBody.indexOf("\"links\":[\"");
            if (startIndex == -1) {
                System.err.println("Links not found in the response body");
                return null;
            }
            
            final int endIndex = responseBody.indexOf("\"]", startIndex);
            if (endIndex == -1) {
                System.err.println("Invalid response format: No closing bracket found for links");
                return null;
            }

            // Extract and return the link
            String validationLink = responseBody.substring(startIndex + 9, endIndex); // Extract link from within quotes
            return validationLink;
        } catch (Exception e) {
            System.err.println("Error occurred while fetching validation link: " + e.getMessage());
            return null;
        }
    }

    public String getEmailAddress() {
        return email;
    }
}
