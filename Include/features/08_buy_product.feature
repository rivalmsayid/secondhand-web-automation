Feature: buy product

  Scenario: user want to buy product after login
    Given user fill the login page with valid credentials
    And user successfully login
    When user choose the product that want to buy
    And user input the nominal of product offer and click submit
    Then user successfully offer the product

  Scenario: user want to buy product before login
    Given user go to homepage
    And user choose the product
    And user input product offer and click submit
    Then user can see alert message that user must login first

  Scenario: user want to buy product with 0 on the offer page
    Given user already login
    When user choose the product to buy
    And user input the nominal of product offer with 0 and click submit
    Then user stay in the product page
