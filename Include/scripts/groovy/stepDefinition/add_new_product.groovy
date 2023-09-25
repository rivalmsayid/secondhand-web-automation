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
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.And


public class add_new_product {
	@Given("user in homepage")
	public void user_in_homepage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/button_jual'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/field_search_product'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/button_kategori_kendaraan'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/homepage/button_my_product'), 0)
	}

	@Then("user click jual button")
	public void user_click_jual_button() {
		WebUI.click(findTestObject('Object Repository/homepage/button_jual'))
	}

	@Then("user redirect to add product page")
	public void user_redirect_to_add_product_page() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/input_nama_produk'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/input_harga_produk'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/dropdown_kategori'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/textarea_deskripsi'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/button_terbitkan'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/button_preview'), 0)
	}

	@When("user is input all the product data fields")
	public void user_is_input_product_data() {
		WebUI.setText(findTestObject('Object Repository/add_product/input_nama_produk'), 'Monitor Samsung')
		WebUI.setText(findTestObject('Object Repository/add_product/input_harga_produk'), '3000000')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/add_product/dropdown_kategori'), 3)
		WebUI.setText(findTestObject('Object Repository/add_product/textarea_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 5 Tahun')
		WebUI.uploadFile(findTestObject("Object Repository/add_product/select_picture"), 'D:\\2. Pictures\\monitor.png')
		WebUI.delay(3)
	}

	@When("user is input the product data except (.*) field")
	public void user_is_input_product_data_except_field(String condition) {
		if(condition=="Name") {
			WebUI.setText(findTestObject('Object Repository/add_product/input_harga_produk'), '3000000')
			WebUI.selectOptionByIndex(findTestObject('Object Repository/add_product/dropdown_kategori'), 3)
			WebUI.setText(findTestObject('Object Repository/add_product/textarea_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 5 Tahun')
			WebUI.uploadFile(findTestObject("Object Repository/add_product/select_picture"), 'D:\\2. Pictures\\monitor.png')
		}else if(condition=="Price") {
			WebUI.setText(findTestObject('Object Repository/add_product/input_nama_produk'), 'Monitor Samsung')
			WebUI.selectOptionByIndex(findTestObject('Object Repository/add_product/dropdown_kategori'), 3)
			WebUI.setText(findTestObject('Object Repository/add_product/textarea_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 5 Tahun')
			WebUI.uploadFile(findTestObject("Object Repository/add_product/select_picture"), 'D:\\2. Pictures\\monitor.png')
		}else if(condition=="Category") {
			WebUI.setText(findTestObject('Object Repository/add_product/input_nama_produk'), 'Monitor Samsung')
			WebUI.setText(findTestObject('Object Repository/add_product/input_harga_produk'), '3000000')
			WebUI.setText(findTestObject('Object Repository/add_product/textarea_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 5 Tahun')
			WebUI.uploadFile(findTestObject("Object Repository/add_product/select_picture"), 'D:\\2. Pictures\\monitor.png')
		}else if(condition=="Description") {
			WebUI.setText(findTestObject('Object Repository/add_product/input_nama_produk'), 'Monitor Samsung')
			WebUI.setText(findTestObject('Object Repository/add_product/input_harga_produk'), '3000000')
			WebUI.selectOptionByIndex(findTestObject('Object Repository/add_product/dropdown_kategori'), 3)
			WebUI.uploadFile(findTestObject("Object Repository/add_product/select_picture"), 'D:\\2. Pictures\\monitor.png')
		}
	}

	@Then("user click terbitkan button")
	public void user_click_terbitkan_button() {
		WebUI.click(findTestObject('Object Repository/add_product/button_terbitkan'))
	}

	@Then("user successfully add new product")
	public void user_successfully_add_new_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/seller_info'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/product_info'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/button_delete'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/button_edit'), 0)
	}

	@Then("user will not sucessfully add the product")
	public void user_will_not_sucessfully_add_the_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/input_nama_produk'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/input_harga_produk'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/dropdown_kategori'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/textarea_deskripsi'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/button_terbitkan'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/add_product/button_preview'), 0)
		WebUI.closeBrowser()
	}
}
