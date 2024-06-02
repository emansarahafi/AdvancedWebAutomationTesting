
@SmokeFeature
Feature: Feature to test logout	
	@smoketest
  Scenario: Check logout is successful
    Given user is loggedin
    When user redirects to his account page
    And clicks on logout button
    Then user is navigated to the home page
