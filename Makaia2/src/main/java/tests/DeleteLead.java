package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class DeleteLead extends WebDriverServiceImpl {
	
	@Test
	public void main() {
		
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
		
		// Click on Phone number tab and Search by Phone number 
		
		click(locateElement("xpath", "(//span[@class='x-tab-strip-text '])[2]"));
		
		WebElement elePhoneNo = locateElement("name", "phoneNumber");
		
		type(elePhoneNo, "9884955591");		
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click the first id in the table
		
		WebElement leadIdInTable = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		
		String leadId = getText(leadIdInTable);
		
		click(leadIdInTable);
		
		//Delete the lead Details
		
		click(locateElement("link", "Delete"));
		
		click(locateElement("link", "Find Leads"));
		
		type(locateElement("xpath", "(//div[@class='x-form-item x-tab-item'])[2]//input"), leadId);
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Locate the Page info(Page Number element and find No Records displayed
		
		WebElement elePageInfo = locateElement("class", "x-paging-info");
		
		String pageInfo = getText(elePageInfo);
		
		System.out.println(pageInfo);
		
		if(pageInfo.contains("No records to display"))
			System.out.println("Record Deleted Successfully");
			
		closeActiveBrowser();
		
		
	}

}
