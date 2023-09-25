Feature: add product

  Background: TC.Log.002.001 - user can successfully login with valid credentials
    Given user is in login page
    When user input valid credentials and click login button

  Scenario Outline: user is not succesfully edit product data because delete <condition> field
    And user in homepage
    And user click daftar jual saya button
    And user is choosing the product to edit
    And user redirect to product detail page and click edit
    When user is edit the product data but clear <condition> field
    And user click terbitkan button after edit
    Then user will not sucessfully add the product

    Examples: 
      | case_id          | condition   |
      | TCW.Edit.001.002 | Name        |
      | TCW.Edit.001.003 | Price       |
      | TCW.Edit.001.004 | Category    |
      | TCW.Edit.001.005 | Description |

  Scenario: TCW.Edit.001.001 user is succesfully edit product data
    And user in homepage
    And user click daftar jual saya button
    And user is choosing the product to edit
    And user redirect to product detail page and click edit
    When user is edit all the product data fields
    And user click terbitkan button after edit
    Then user successfully edit the product
