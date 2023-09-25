Feature: Search Product Feature

  Scenario: TC-Sch-001 User want searches for available items in the system
    Given user login with valid credentials
    And user already to dashboard page
    When user inputs the keyword buku in the search field
    And user click enter on the keyboard
    Then system will display a list of products with name buku

  Scenario: TC-Sch-002 User wants to find product based on category
    Given user login with valid credentials
    And user already to dashboard page
    When user click category name hobi
    Then the system will display a list of products with categories hobi

  Scenario: TC-Sch-003 user wants to search for items by not log in
    Given user already to dashboard page as a guest
    When user inputs the keyword buku in the search field
    And user click enter on the keyboard
    Then system will display a list of products with name buku
