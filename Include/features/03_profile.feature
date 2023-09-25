Feature: profile

  Background: TC.Log.002.001 - user can successfully login with valid credentials
    Given user is in login page
    When user input valid credentials and click login button

  Scenario: TC.Upd.Prof.001.001 - user can update profile
    Given user is already on homepage
    When user click button profile
    And user click navbar user profile
    And user update profile
    And user click simpan button
    Then user successfully update profile

  Scenario Outline: user can not update profile
    Given user is already on homepage
    When user click button profile
    And user click navbar user profile
    And user update profile but <condition>
    And user click simpan button
    Then user get pop-up <result>

    Examples: 
      | case_id             | condition                      | result                            |
      | TC.Upd.Prof.001.002 | leave nama field empty         | please fill out this field        |
      | TC.Upd.Prof.001.003 | without select kota            | please select an item in the list |
      | TC.Upd.Prof.001.004 | leave alamat field empty 	     | please fill out this field        |
      | TC.Upd.Prof.001.005 | leave no handphone field empty | please fill out this field        |
