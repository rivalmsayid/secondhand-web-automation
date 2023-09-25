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

public class login {

	@Given("user is in login page")
	public void user_is_in_login_page() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/users/sign_in')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_email'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_password'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/button_masuk'), 0)
	}

	@When("user input valid credentials and click login button")
	public void user_input_valid_credentials_and_click_login_button() {
		WebUI.setText(findTestObject('Object Repository/login/input_email'), 'web-kelompok3@gmail.com')
		WebUI.setText(findTestObject('Object Repository/login/input_password'), '12345')
		WebUI.click(findTestObject('Object Repository/login/button_masuk'))
		WebUI.delay(3)
	}

	@When("user input valid credentials with email address capital letters and click login button")
	public void user_input_valid_credentials_with_email_address_capital_letters_and_click_login_button() {
		WebUI.setText(findTestObject('Object Repository/login/input_email'), 'WEB-KELOMPOK3@GMAIL.COM')
		WebUI.setText(findTestObject('Object Repository/login/input_password'), '12345')
		WebUI.click(findTestObject('Object Repository/login/button_masuk'))
		WebUI.delay(3)
	}

	@Then("user can successfully login")
	public void user_can_successfully_login() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/field_search_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/text_telusuri_kategori'), 0)
	}
}
