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


public class buy_product {
	@Given("user fill the login page with valid credentials")
	public void user_fill_login_page() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/users/sign_in')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_email'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_password'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_email'), 'anggasaputra05@gmail.com')
		WebUI.setText(findTestObject('Object Repository/login/input_password'), 'binaracademy')
		WebUI.click(findTestObject('Object Repository/login/button_masuk'))
	}

	@When("user successfully login")
	public void user_successfully_login() {
		WebUI.scrollToElement(findTestObject('Object Repository/buy_product/view_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/view_product'),0)
	}

	@When("user choose the product that want to buy")
	public void user_choose_the_product_that_want_to_buy() {
		WebUI.scrollToElement(findTestObject('Object Repository/buy_product/view_product'), 0)
		WebUI.click(findTestObject('Object Repository/buy_product/view_product'))
	}

	@When("user input the nominal of product offer and click submit")
	public void user_input_the_nominal() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/button_saya_tertarik'), 0)
		WebUI.click(findTestObject('Object Repository/buy_product/button_saya_tertarik'))
		WebUI.clearText(findTestObject('Object Repository/buy_product/input_harga_tawar'))
		WebUI.setText(findTestObject('Object Repository/buy_product/input_harga_tawar'),'200000')
		WebUI.click(findTestObject('Object Repository/buy_product/button_kirim_penawaran'))
	}

	@Then("user successfully offer the product")
	public void user_successfully_offer() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/card_desc_product'), 0)
	}

	@Given("user go to homepage")
	public void user_go_to_homepage() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/')
		WebUI.maximizeWindow()
	}

	@When("user choose the product")
	public void user_choose_the_product() {
		WebUI.scrollToElement(findTestObject('Object Repository/buy_product/view_product'), 0)
		WebUI.click(findTestObject('Object Repository/buy_product/view_product2'))
	}

	@When("user input product offer and click submit")
	public void user_input_product_offer() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/button_saya_tertarik'), 0)
		WebUI.click(findTestObject('Object Repository/buy_product/button_saya_tertarik'))
		WebUI.clearText(findTestObject('Object Repository/buy_product/input_harga_tawar'))
		WebUI.setText(findTestObject('Object Repository/buy_product/input_harga_tawar'),'200000')
		WebUI.click(findTestObject('Object Repository/buy_product/button_kirim_penawaran'))
	}

	@Then("user can see alert message that user must login first")
	public void user_can_see_alert_message() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/alert_message_login'), 0)
	}


	@Given("user already login")
	public void user_already_login() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/users/sign_in')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_email'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_password'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_email'), 'anggasaputra055@gmail.com')
		WebUI.setText(findTestObject('Object Repository/login/input_password'), 'binaracademy')
		WebUI.click(findTestObject('Object Repository/login/button_masuk'))
	}

	@When("user choose the product to buy")
	public void user_choose_the_product_to_buy() {
		WebUI.scrollToElement(findTestObject('Object Repository/buy_product/view_product'), 0)
		WebUI.click(findTestObject('Object Repository/buy_product/view_product2'))
	}

	@When("user input the nominal of product offer with 0 and click submit")
	public void user_input_the_nominal_of_product_offer_with_0() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/button_saya_tertarik'), 0)
		WebUI.click(findTestObject('Object Repository/buy_product/button_saya_tertarik'))
		WebUI.clearText(findTestObject('Object Repository/buy_product/input_harga_tawar'))
		WebUI.setText(findTestObject('Object Repository/buy_product/input_harga_tawar'),'0')
		WebUI.click(findTestObject('Object Repository/buy_product/button_kirim_penawaran'))
	}

	@Then("user stay in the product page")
	public void user_stay_in_the_product_page() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/seller_info'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/product_picture'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/buy_product/card_desc_product'), 0)
		WebUI.closeBrowser()
	}
}