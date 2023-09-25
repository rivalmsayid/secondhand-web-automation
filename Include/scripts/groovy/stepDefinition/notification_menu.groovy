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

public class notification_menu {
	@Given("user already to dashboard page")
	public void user_already_to_dashboard_page() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/text_telusuri_kategori'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/new_icon_notifikasi'), 0)
		WebUI.delay(2)
	}

	@When("user click button notifikasi menu")
	public void user_click_button_notifikasi_menu() {
		WebUI.click(findTestObject('Object Repository/homepage/new_icon_notifikasi'))
	}

	@Then ("system will display a list of notifications received by the user")
	public void system_will_display_a_list_of_notification_received_by_the_user() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/notification_menu/card_notifikasi'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/notification_menu/detail_date_time_notif'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/notification_menu/message_notif_new'), 0)
	}
}