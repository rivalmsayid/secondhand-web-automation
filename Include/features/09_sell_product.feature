Feature: sell product

  Scenario: user want to sell product after login
    Given user login with valid credentials
    When user view the notification
    And user choose product offer
    And user accept the offer from buyer
    Then user stay on the offer page

  Scenario: user want to sell product before login
    Given user go to home page
    When user click the sell button
    Then user can see pop up alert message that user must login first
