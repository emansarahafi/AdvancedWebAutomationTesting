@SmokeFeature
Feature: Feature to test service client page
    @smoketest
    Scenario: Open service client page
        Given user is on the website
        When user navigates to the service client page
        Then user should see the service client page loaded successfully
