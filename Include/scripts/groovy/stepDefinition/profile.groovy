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
import com.kms.katalon.core.webui.keyword.builtin.VerifyElementPresentKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import ch.qos.logback.core.joran.conditional.ElseAction
import internal.GlobalVariable
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then

public class profile {

	@Given("user is already on homepage")
	public void user_is_already_on_homepage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/field_search_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/button_jual'), 0)
	}

	@When("user click button profile")
	public void user_click_button_profile() {
		WebUI.click(findTestObject('Object Repository/logout/button_profile'))
	}

	@When("user click navbar user profile")
	public void user_click_navbar_user_profile() {
		WebUI.click(findTestObject('Object Repository/profile/nav_user_profile'))
		WebUI.delay(3)
	}

	@When("user update profile")
	public void user_update_profile() {
		WebUI.maximizeWindow()
		WebUI.uploadFile(findTestObject('Object Repository/profile/add_image_profile'), 'D:\\team03.jpg')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/profile/select_kota'), 3)
		WebUI.setText(findTestObject('Object Repository/profile/textarea_alamat'), 'Jln. Pahlawan 03')
		WebUI.scrollToElement(findTestObject('Object Repository/profile/input_no_handphone'), 3)
		WebUI.setText(findTestObject('Object Repository/profile/input_no_handphone'), '085897241333')
		WebUI.delay(3)
	}

	@When("user click simpan button")
	public void user_click_simpan_button() {
		WebUI.scrollToElement(findTestObject('Object Repository/profile/button_simpan'), 3)
		WebUI.click(findTestObject('Object Repository/profile/button_simpan'))
	}

	@Then("user successfully update profile")
	public void user_successfully_update_profile() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/field_search_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/button_kategori_kendaraan'), 0)
		WebUI.delay(3)
	}

	@When("user update profile but (.*)")
	public void user_update_profile(String condition){
		WebUI.maximizeWindow()

		if(condition=="leave nama field empty") {
			WebUI.clearText(findTestObject('Object Repository/profile/input_nama'))
			WebUI.delay(3)
		}else if(condition=="without select kota") {
			WebUI.selectOptionByIndex(findTestObject('Object Repository/profile/select_kota'), 0)
			WebUI.delay(3)
		}else if(condition=="leave alamat field empty") {
			WebUI.clearText(findTestObject('Object Repository/profile/textarea_alamat'))
			WebUI.delay(3)
		}else if(condition=="leave no handphone field empty") {
			WebUI.scrollToElement(findTestObject('Object Repository/profile/input_no_handphone'), 3)
			WebUI.clearText(findTestObject('Object Repository/profile/input_no_handphone'))
			WebUI.delay(3)
		}
	}

	@Then("user get pop-up (.*)")
	public void user_get_pop_up(String result) {
		WebUI.maximizeWindow()

		if(result=="please fill out this field") {
			WebUI.delay(3)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/add_image_profile'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/input_nama'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/select_kota'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/textarea_alamat'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/input_no_handphone'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/button_simpan'), 0)
		}else if(result=="please select an item in the list") {
			WebUI.delay(3)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/add_image_profile'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/input_nama'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/select_kota'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/textarea_alamat'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/input_no_handphone'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/button_simpan'), 0)
		}else(result=="please fill out this field") {
			WebUI.delay(3)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/add_image'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/input_nama'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/select_kota'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/textarea_alamat'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/input_no_handphone'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/profile/button_simpan'), 0)
			WebUI.delay(3)
			WebUI.closeBrowser()
			}
	}
}
