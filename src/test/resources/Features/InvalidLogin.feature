@SmokeFeature
Feature: Feature to test invalid login
	
	@smoketest
  Scenario: Check login is unsuccessful with invalid credentials
    Given user on login page
    When user enters incorrect email and password
    And clicks on the login button
    Then user is navigated to login page
