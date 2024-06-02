
@SmokeFeature
Feature: Feature to valid registration
	
	@smoketest
  Scenario: Check register is successful with valid credentials format
    Given user is on registration page
    When user enters correct credentials format
    And clicks on register button
    Then user is navigated to account page
