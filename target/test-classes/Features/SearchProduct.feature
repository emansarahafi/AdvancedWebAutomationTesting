@SmokeFeature
Feature: Feature to search for Laptop

  @smoketest
  Scenario: Check search for laptop
    Given user is on homee page
    When user enters laptop name
    And user clicks enter 
    Then user is navigated to search results page

