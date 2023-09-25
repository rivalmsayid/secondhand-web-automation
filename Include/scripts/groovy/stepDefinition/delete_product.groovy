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

public class delete_product {
	@When("user click menu daftar jual saya")
	public void user_click_menu_daftar_jual_saya() {
		WebUI.click(findTestObject('Object Repository/delete product/button produk saya'))
	}
	@When("user click detail product")
	public void user_click_detail_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/choose kategori product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/card my product'), 0)
		WebUI.click(findTestObject('Object Repository/delete product/card my product'))
	}

	@When("user click delete")
	public void user_click_delete() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/button edit'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/button delete'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/detail user'), 0)
		WebUI.click(findTestObject('Object Repository/delete product/button delete'))
	}

	@Then("the system will delete the product")
	public void the_system_will_delete_the_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/button tambah produk'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/delete product/choose kategori product'), 0)
	}
}
