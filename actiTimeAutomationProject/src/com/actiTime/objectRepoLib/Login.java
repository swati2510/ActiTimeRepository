package com.actiTime.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

	public class Login {//RULE-1
		
		//Identification or initialization of Elements===========>RULE-2
		@FindBy(name="username")
		private WebElement usernameEdt;
		
		@FindBy(name="pwd")
		private WebElement passwordEdt;
		
		@FindBy(id="loginButton")
		private WebElement loginButton;
		
		//USAGE=======> RULE-3
		public WebElement getUsernameEdt() 
		{
			return usernameEdt;
		}
		public WebElement getpasswordEdt()
		{
			return passwordEdt;
		}
		public WebElement getloginButton()
		{
			return loginButton;
		}
		
		//BUSINESS METHOD============>RULE-4
		public void loginToApp(String userName,String password)
		{
			usernameEdt.sendKeys(userName);
			passwordEdt.sendKeys(password);
			loginButton.click();
		}
		
	}

	


