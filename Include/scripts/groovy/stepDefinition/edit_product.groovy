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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable


public class edit_product {
	@Then("user click daftar jual saya button")
	public void user_click_daftar_jual_saya_button() {
		WebUI.click(findTestObject('Object Repository/homepage/button_my_product'))
	}
	@Then("user is choosing the product to edit")
	public void user_is_choosing_the_product_to_edit() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/product_list/product_card'), 0)
		WebUI.click(findTestObject('Object Repository/product_list/product_card'))
	}
	@Then("user redirect to product detail page and click edit")
	public void user_redirect_to_product_detail_page_and_click_edit() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/button_edit'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/button_delete'), 0)
		WebUI.click(findTestObject('Object Repository/detail_product/button_edit'))
	}
	@When("user is edit all the product data fields")
	public void user_is_edit_all_the_product_data_fields() {
		WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'))
		WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'), 'Monitor Samsung Gaming')
		WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'))
		WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'), '4000000')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/edit_product/dropdown_edit_kategori'), 5)
		WebUI.clearText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'))
		WebUI.setText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 2 Tahun')
		WebUI.uploadFile(findTestObject("Object Repository/edit_product/select_picture"), 'D:\\2. Pictures\\monitor1.png')
		WebUI.delay(3)
	}
	@Then("user successfully edit the product")
	public void user_successfully_edit_the_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/product_info'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/detail_product/seller_info'), 0)
	}
	@When("user is edit the product data but clear (.*) field")
	public void user_is_edit_the_product_data_but_clear_field(String condition) {
		if(condition=="Name") {
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'))
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'))
			WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'), '4000000')
			WebUI.selectOptionByIndex(findTestObject('Object Repository/edit_product/dropdown_edit_kategori'), 5)
			WebUI.clearText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'))
			WebUI.setText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 2 Tahun')
			WebUI.uploadFile(findTestObject("Object Repository/edit_product/select_picture"), 'D:\\2. Pictures\\monitor1.png')
		}else if(condition=="Price") {
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'))
			WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'), 'Monitor Samsung Gaming')
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'))
			WebUI.selectOptionByIndex(findTestObject('Object Repository/edit_product/dropdown_edit_kategori'), 5)
			WebUI.clearText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'))
			WebUI.setText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 2 Tahun')
			WebUI.uploadFile(findTestObject("Object Repository/edit_product/select_picture"), 'D:\\2. Pictures\\monitor1.png')
		}else if(condition=="Category") {
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'))
			WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'), 'Monitor Samsung Gaming')
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'))
			WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'), '4000000')
			WebUI.selectOptionByIndex(findTestObject('Object Repository/edit_product/dropdown_edit_kategori'), 0)
			WebUI.clearText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'))
			WebUI.setText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'), 'Monitor Samsung Gaming 165Hz Garansi 2 Tahun')
			WebUI.uploadFile(findTestObject("Object Repository/edit_product/select_picture"), 'D:\\2. Pictures\\monitor1.png')
		}else if(condition=="Description") {
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'))
			WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_nama_produk'), 'Monitor Samsung Gaming')
			WebUI.clearText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'))
			WebUI.setText(findTestObject('Object Repository/edit_product/input_edit_harga_produk'), '4000000')
			WebUI.selectOptionByIndex(findTestObject('Object Repository/edit_product/dropdown_edit_kategori'), 5)
			WebUI.clearText(findTestObject('Object Repository/edit_product/textarea_edit_deskripsi'))
			WebUI.uploadFile(findTestObject("Object Repository/edit_product/select_picture"), 'D:\\2. Pictures\\monitor1.png')
		}
	}
	@Then("user click terbitkan button after edit")
	public void user_click_terbitkan_button_after_edit() {
		WebUI.click(findTestObject('Object Repository/edit_product/button_terbitkan'))
	}
}
