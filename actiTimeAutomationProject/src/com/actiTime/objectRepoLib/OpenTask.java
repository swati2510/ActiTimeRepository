package com.actiTime.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenTask {
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projectandCustomerLnk;

	public WebElement getProjectandCustomerLnk() {
		return projectandCustomerLnk;
	}
	
	

}
