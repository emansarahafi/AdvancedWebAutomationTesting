@SmokeFeature
Feature: Feature to test contact page
    @smoketest
    Scenario: Open contact page
        Given user is on website
        When user navigates to the contact page
        Then user should see the contact page loaded successfully
