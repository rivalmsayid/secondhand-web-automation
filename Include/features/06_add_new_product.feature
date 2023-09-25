Feature: add new product

  Background: TC.Log.002.001 - user can successfully login with valid credentials
    Given user is in login page
    When user input valid credentials and click login button

  Scenario Outline: user is not succesfully add new product data because not fill <condition> field
    And user in homepage
    And user click jual button
    And user redirect to add product page
    When user is input the product data except <condition> field
    And user click terbitkan button
    Then user will not sucessfully add the product

    Examples: 
      | case_id          | condition   |
      | TCW.Prod.001.002 | Name        |
      | TCW.Prod.001.003 | Price       |
      | TCW.Prod.001.004 | Category    |
      | TCW.Prod.001.005 | Description |

  Scenario: TCW.Prod.001.001 user is succesfully add new product data
    And user in homepage
    And user click jual button
    And user redirect to add product page
    When user is input all the product data fields
    And user click terbitkan button
    Then user successfully add new product
