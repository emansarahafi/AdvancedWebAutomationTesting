
@SmokeFeature
Feature: Feature to test edit profile info	
	@smoketest
  Scenario: Check edit profile info	
    Given user is logged in
    When user goes to his edit account page
    And saves a new name
    Then user sees the field updated
