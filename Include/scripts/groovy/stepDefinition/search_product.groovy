package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PublicKey

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
import org.openqa.selenium.Keys as Keys


public class search_product {

	@When("user inputs the keyword buku in the search field")
	public void user_inputs_the_keyword_buku_in_the_search_field() {
		WebUI.setText(findTestObject('Object Repository/homepage/field_search_product'), 'buku')
	}

	@When ("user click enter on the keyboard")
	public void user_click_enter_on_the_keyboard(){
		WebUI.sendKeys(findTestObject('Object Repository/homepage/field_search_product'), Keys.chord(Keys.ENTER))
	}


	@Then("system will display a list of products with name buku")
	public void system_will_display_a_list_of_products_with_name_buku() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/card_product_book'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/name_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/name_category_product'), 0)
	}

	@When("user click category name hobi")
	public void user_click_category_name_hobi() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/homepage/button_category_hobi'), 3)
		//WebUI.scrollToElement(findTestObject('Object Repository/homepage/button_jual'), 0)
		WebUI.click(findTestObject('Object Repository/homepage/button_category_hobi'))
	}

	@Then("the system will display a list of products with categories hobi")
	public void the_system_will_display_a_list_of_products_with_categories_hobi() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/name_product_hobi'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/name_category_hobi'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/item_product_hobi'), 0)
	}

	@Given("user already to dashboard page as a guest")
	public void user_already_to_dashboard_page_as_a_guest() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/field_search_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/button_masuk_guest'), 0)
	}
}
