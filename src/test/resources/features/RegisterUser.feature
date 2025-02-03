Feature: Register user

  Scenario: Register a new user
    Given I open up the sign up form
    When I fill the sign up form
    And I wait 10 seconds
    And I validate that the registration email
    Then I validate that the registration is successful
