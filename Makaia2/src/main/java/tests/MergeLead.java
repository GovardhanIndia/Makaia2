package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class MergeLead extends WebDriverServiceImpl {

	@Test
	public void main() throws InterruptedException {
		/*// TODO Auto-generated method stub
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
		
		click(locateElement("link", "Merge Leads"));
		
		
		click(locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[1]"));	
		
		//Switch to newly opened window
		
		switchToWindow(1);
		
		WebElement eleLeadId = locateElement("name", "id");
		
		type(eleLeadId, "10223");
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
				
		WebElement tabLeadId = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		
		waitBeforeClickingAnElement(tabLeadId);
	
		Thread.sleep(2000);
		
		
		
		tabLeadId.click();		
			
		switchToWindow(0); 
		
		click(locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]"));
		
		switchToWindow(1);
		
		WebElement eleToLeadId = locateElement("name", "id");
		
		type(eleToLeadId, "10225");
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		
		
		Thread.sleep(7000);

		tabLeadId = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");

		
		tabLeadId.click();
		
		switchToWindow(0); 

		
*/		
	}

	

}
