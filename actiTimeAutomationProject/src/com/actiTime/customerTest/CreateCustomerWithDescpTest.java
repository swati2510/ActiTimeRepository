package com.actiTime.customerTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actiTime.genericLib.BaseClass;
import com.actiTime.objectRepoLib.ActiveProAndCust;
import com.actiTime.objectRepoLib.CreateCustomer;
import com.actiTime.objectRepoLib.Home;
import com.actiTime.objectRepoLib.OpenTask;

@Listeners(com.actiTime.genericLib.ListImpClass.class)
public class CreateCustomerWithDescpTest extends BaseClass {
	@Test
	public void createCustomerWithDescpTest() throws Throwable {
		
		/*Read data from ExcelSheet*/
		String customerName=flib.getExcelData("Sheet1", 2, 1);
		String customerDescp=flib.getExcelData("Sheet1", 2, 2);
		
		/*Navigate to TASK page*/
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.getTaskImg().click();
		
		/*Click on Project And Customer Link*/
		OpenTask op=PageFactory.initElements(driver, OpenTask.class);
		op.getProjectandCustomerLnk().click();
		
		/*Click Create New Customer Button*/ 
		ActiveProAndCust act=PageFactory.initElements(driver, ActiveProAndCust.class);
		act.getCreateNewCustomerBtn().click();
		
		/*Create Customer*/
		CreateCustomer ccp=PageFactory.initElements(driver, CreateCustomer.class);
		ccp.createCustomer(customerName, customerDescp);
		
		/*Verify*/
		String actMsg=act.getCustomerSuccessmsg().getText();
		System.out.println(actMsg);
		boolean stat=actMsg.contains("successfully created");
		Assert.assertTrue(stat);
		
	}

}
