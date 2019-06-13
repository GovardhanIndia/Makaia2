package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl {
	
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
		
		//Click on Email and enter the Email id to search the lead by eMail
		
		click(locateElement("xpath", "//span[text()='Email']"));
		
		type(locateElement("name", "emailAddress"), "govardhan.chennai@gmail.com");
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement eleTableFirstName = locateElement("xpath", "(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/following-sibling::td[2]//a");
		
		String txtFirstName = getText(eleTableFirstName);
		
		click(eleTableFirstName);
		
		click(locateElement("link", "Duplicate Lead"));
		
		if(getText(locateElement("id", "sectionHeaderTitle_leads")).equals("Duplicate Lead")) {
			click(locateElement("xpath", "//input[@class = 'smallSubmit']"));
			
			if (getText(locateElement("id", "viewLead_firstName_sp")).equals(txtFirstName)) {
				System.out.println("The Lead Duplicated Successfully : "+txtFirstName);
			}
		}
		
		closeActiveBrowser();
	}

}
