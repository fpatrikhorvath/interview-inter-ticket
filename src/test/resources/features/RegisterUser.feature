Feature: Register user

  Scenario: Register a new user
    Given I open up the sign up form
    When I fill the sign up form
    Then I validate that the registration is successful
    And I wait 10 seconds
    When I validate that the registration email