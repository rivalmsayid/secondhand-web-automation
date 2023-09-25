package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then

public class register {

	@Given("user is in register page")
	public void user_is_in_register_page() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/users/sign_up')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_username'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_email'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_password'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register/button_daftar'), 0)
	}

	@When("user input valid information and click register button")
	public void user_input_valid_information_and_click_register_button() {
		WebUI.setText(findTestObject('Object Repository/register/input_username'), 'web-kelompok3')
		WebUI.setText(findTestObject('Object Repository/register/input_email'), 'web-kelompok3@gmail.com')
		WebUI.setText(findTestObject('Object Repository/register/input_password'), '12345')
		WebUI.click(findTestObject('Object Repository/Register/button_daftar'))
		WebUI.delay(5)
	}

	@When("user input (.*) in register page")
	public void user_input_in_register_page(String condition) {
		WebUI.maximizeWindow()

		if(condition=="wrong email format and valid password") {
			WebUI.setText(findTestObject('Object Repository/Register/input_username'), 'kelompok3-web')
			WebUI.setText(findTestObject('Object Repository/Register/input_email'), 'kelompok3-webgmail.com')
			WebUI.setText(findTestObject('Object Repository/Register/input_password'), '12345')
			WebUI.click(findTestObject('Object Repository/Register/button_daftar'))
		}else if(condition=="registered email and valid password") {
			WebUI.setText(findTestObject('Object Repository/Register/input_username'), 'kelompok3-web')
			WebUI.setText(findTestObject('Object Repository/Register/input_email'), 'web-kelompok3@gmail.com')
			WebUI.setText(findTestObject('Object Repository/Register/input_password'), '12345')
			WebUI.click(findTestObject('Object Repository/Register/button_daftar'))
			WebUI.delay(3)
		}
	}

	@Then("user can successfully register with valid information")
	public void user_can_successfully_register_with_valid_information() {
		WebUI.closeBrowser()
	}

	@When("user click register button")
	public void user_click_register_button() {
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Register/button_daftar'))
		WebUI.delay(3)
	}

	@Then("user get pop up (.*)")
	public void user_get_pop_up(String result) {
		WebUI.maximizeWindow()

		if(result=="Please include an '@' in the email address. is missing an '@'") {
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_username'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_email'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_password'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/button_daftar'), 0)
		}else if(result=="Email has already been taken") {
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_username'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_email'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/input_password'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Register/button_daftar'), 0)
			WebUI.delay(3)
			WebUI.closeBrowser()
		}
	}
}



