package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class EditLead extends WebDriverServiceImpl{

	@Test
	public void main() {
		//Login to the Application
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		//Click on CRM/SFA Link and click on Find Leads link
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		click(locateElement("link", "Leads"));
		
		click(locateElement("link", "Find Leads"));
		
		// Search by First Name in the Find Leads screen and click on Find Leads Button
		
		WebElement eleFirstName = locateElement("xpath", "(//input[@name = 'firstName'])[3]");
		
		type(eleFirstName, "Govardhan");		
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Get the Number of rows once the Lead Name is entered
		
		List<WebElement> eleLeadIds = locateElements("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])");
		
		
		//Iterate through each row to locate the Lead Id that matches the user requirement and click on the particular lead id
		
		for(int row = 1; row<=eleLeadIds.size();row++) {
			WebElement tableClass = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])["+row+"]/a");
			
			if (getText(tableClass).equals("10030")) {
				click(tableClass);
				break;
			}
		}
		
		//Edit the last Name
		
		click(locateElement("link", "Edit"));
		
		//Clear the existing value and change the value given by the user
		
		WebElement eleLastName = locateElement("id", "updateLeadForm_lastName");
		clearField(eleLastName);
		
		type(eleLastName, "Balaji");
		click(locateElement("xpath", "//input[@class = 'smallSubmit']"));		
		
		WebElement eleUpdatedLastName = locateElement("id", "viewLead_lastName_sp");
		
		if(getText(eleUpdatedLastName).equals("Balaji")) {
			System.out.println("Last name Updated Successfully");
		}
		closeActiveBrowser();
	}
	
}
