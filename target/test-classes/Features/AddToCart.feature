@SmokeFeature
Feature: Feature to add product to cart

  @smoketest
  Scenario: Check if a product is added to cart
    Given user is on home page
    When user searches for a product
    And clicks on add to cart
    Then the cart content is updated
