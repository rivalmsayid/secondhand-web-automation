Feature: Logout

  Background: TC.Log.002.001 - user can successfully login with valid credentials
    Given user is in login page
    When user input valid credentials and click login button
    And user can successfully login

  Scenario: TC.Log.002.001 - user want to log out 
    And user click button profile in header
    And user click keluar
    Then user successfully log out
