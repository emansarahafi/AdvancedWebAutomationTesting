
@SmokeFeature
Feature: Feature to test search filters
	@smoketest
  Scenario: Test search filters
    Given user is searching for laptops
    When user selects the Asus brand
    And user selects the Windows 11 Pro operating system
    Then user sees the Asus Expertbook B5
