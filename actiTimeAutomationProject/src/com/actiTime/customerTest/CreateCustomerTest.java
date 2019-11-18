package com.actiTime.customerTest;


import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actiTime.genericLib.BaseClass;
import com.actiTime.objectRepoLib.ActiveProAndCust;
import com.actiTime.objectRepoLib.CreateCustomer;

import com.actiTime.objectRepoLib.Login;
import com.actiTime.objectRepoLib.Home;
import com.actiTime.objectRepoLib.OpenTask;

@Listeners(com.actiTime.genericLib.ListImpClass.class)

public class CreateCustomerTest extends BaseClass {
	
	@Test
	public void createCustomerTest() throws Throwable {
		/*Read data from Excel*/
		String customerName=flib.getExcelData("Sheet1", 1, 1);
		
		/*Step 2: navigate to Task Page*/
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.getTaskImg().click();
		
		/*Step 3: Click on Project And Customer link*/
		OpenTask op=PageFactory.initElements(driver, OpenTask.class);
		op.getProjectandCustomerLnk().click();
		
		/*Step 4: Click on create New Customer Button*/
		ActiveProAndCust act=PageFactory.initElements(driver, ActiveProAndCust.class);
		act.getCreateNewCustomerBtn().click();
		
		/*Step 5: Create Customer*/
		CreateCustomer ccp=PageFactory.initElements(driver, CreateCustomer.class);
		ccp.createCustomer(customerName);
		
		/*Step 6: Verify*/
		String actMsg=act.getCustomerSuccessmsg().getText();
		System.out.println(actMsg);
		boolean stat=actMsg.contains("successfully created");
		Assert.assertTrue(stat);
		
	} }


