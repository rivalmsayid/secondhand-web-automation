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

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import internal.GlobalVariable

public class sell_product {
	@Given("user login with valid credentials")
	public void user_login_with_valid_credentials() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/users/sign_in')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_email'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_password'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_email'), 'anggasaputra05@gmail.com')
		WebUI.setText(findTestObject('Object Repository/login/input_password'), 'binaracademy')
		WebUI.click(findTestObject('Object Repository/login/button_masuk'))
	}

	@When("user view the notification")
	public void user_view_the_notification() {
		WebUI.delay(5)
		WebUI.navigateToUrl('https://secondhand.binaracademy.org/notifications')
	}

	@When("user choose product offer")
	public void user_choose_product_offer() {
		WebUI.click(findTestObject('Object Repository/sell_product/detail_product_offer'))
	}

	@When("user accept the offer from buyer")
	public void user_accept_the_offer() {
		WebUI.click(findTestObject('Object Repository/sell_product/button_terima_penawaran'))
	}

	@Then("user stay on the offer page")
	public void user_stay_on_the_offer_page() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/sell_product/button_hubungi'), 0)
	}

	@Given("user go to home page")
	public void user_go_to_home_page() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/')
		WebUI.maximizeWindow()
	}

	@When("user click the sell button")
	public void user_click_the_sell_button() {
		WebUI.click(findTestObject('Object Repository/sell_product/button_sell'))
	}

	@Then("user can see pop up alert message that user must login first")
	public void user_can_see_pop_up_alert() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/alert_message_login'), 0)
		WebUI.closeBrowser()
	}
}
