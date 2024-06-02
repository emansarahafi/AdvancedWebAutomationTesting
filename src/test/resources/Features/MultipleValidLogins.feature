
@SmokeFeature
Feature: Feature to test mutiple valid logins
	
	@smoketest
  Scenario: Check logins are successful with valid credentials
    Given users are on login page
    When users enter correct email and password
    And click on login button
    Then users are navigated to home page
