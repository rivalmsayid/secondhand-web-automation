Feature: Delete Product

  Scenario: TC-Delete.Product-001 User wants to delete product
    Given user login with valid credentials
    And user already to dashboard page
    When user click menu daftar jual saya
    And user click detail product
    And user click delete
    Then the system will delete the product

    
    