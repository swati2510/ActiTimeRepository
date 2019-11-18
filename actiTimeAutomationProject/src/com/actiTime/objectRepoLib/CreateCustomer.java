package com.actiTime.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCustomer {
	@FindBy(name="name")
	private WebElement customerNameEdt;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomerBtn;
	
	@FindBy(name="description")
	private WebElement createDescpEdt;

	public WebElement getCustomerNameEdt() {
		return customerNameEdt;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public void createCustomer(String customerNAme) {
		customerNameEdt.sendKeys(customerNAme);
		createCustomerBtn.click();
	}
	public void createCustomer(String customerNAme,String desp) {
		customerNameEdt.sendKeys(customerNAme);
		createDescpEdt.sendKeys(desp);
		createCustomerBtn.click();

}
}
