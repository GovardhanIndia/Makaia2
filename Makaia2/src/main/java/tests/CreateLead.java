package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class CreateLead extends WebDriverServiceImpl{

	@Test(invocationCount = 2, invocationTimeOut = 60000)
	public void createLead() {
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleCreateLead = locateElement("link", "Create Lead");
		click(eleCreateLead);
		
		WebElement eleCompName = locateElement("id", "createLeadForm_companyName");
		type(eleCompName, "TCS");
		
		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, "Govardhan");
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, "Surendran");
		
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), "9884955591");
		
		type(locateElement("id", "createLeadForm_primaryEmail"), "govardhan.chennai@gmail.com");
		
		WebElement eleCreateLeadButton = locateElement("class", "smallSubmit");
		click(eleCreateLeadButton);		
		closeActiveBrowser();
	}	
}




