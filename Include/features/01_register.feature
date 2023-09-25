Feature: register
    
  Scenario: TC.Reg.001.001 - user can register with valid information
    Given user is in register page 
    When user input valid information and click register button 
    Then user can successfully register with valid information
    
  Scenario Outline: user cannot register with wrong email format and registered email
    Given user is in register page 
    When user input <condition> in register page 
    And user click register button 
    Then user get pop up <result> 
 
    Examples:  
   |    case_id   |               condition             |                 result                    |
   |TC.Reg.001.002|wrong email format and valid password|Please include an '@' in the email address.|
   |TC.Reg.001.003|registered email and valid password  |Email has already been taken               |
   
