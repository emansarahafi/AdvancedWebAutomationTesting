
@SmokeFeature
Feature: Feature to test valid login
	
	@smoketest
  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters correct email and password
    And clicks on login button
    Then user is navigated to home page
