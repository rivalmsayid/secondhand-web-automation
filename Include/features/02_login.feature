Feature: login

	Scenario: TC.Log.002.001 - user can successfully login with valid credentials
		Given user is in login page
		When user input valid credentials and click login button
		Then user can successfully login
		
	Scenario: TC.Log.002.002 - user can successfully login with email address capital letters
		Given user is in login page
		When user input valid credentials with email address capital letters and click login button
		Then user can successfully login