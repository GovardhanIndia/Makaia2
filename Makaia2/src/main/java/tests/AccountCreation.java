package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class AccountCreation extends WebDriverServiceImpl {
	
	@Test
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		//Click on CRM/SFA Link and click on Find Leads link
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		//Create an Account
		
		click(locateElement("link", "Accounts"));
		
		click(locateElement("link", "Create Account"));
		
		//Enter the Account Name
		
		type(locateElement("id", "accountName"), "UFT");
		
		WebElement industryEle = locateElement("name", "industryEnumId");
		
		selectDropDownUsingVisibleText(industryEle, "Manufacturing");
		
		WebElement sourceEle = locateElement("id", "dataSourceId");
		
		selectDropDownUsingValue(sourceEle, "LEAD_PARTNER");
		
		WebElement marketCampEle = locateElement("id", "marketingCampaignId");
		
		selectDropDownUsingValue(marketCampEle, "CATRQ_AUTOMOBILE");
		
		type(locateElement("id", "primaryPhoneNumber"), "9884955591");
		
		type(locateElement("id", "generalCity"), "Chennai");
		
		type(locateElement("id", "primaryEmail"), "govardhan.chennai@gmail.com");
		
		WebElement stateEle = locateElement("id", "generalStateProvinceGeoId");
		
		selectDropDownUsingVisibleText(stateEle, "Arizona");
		
		click(locateElement("xpath", "//input[@class='smallSubmit']"));
		
			
		String accId = getText(locateElement("xpath", "(//span[@class = 'tabletext'])[3]"));
		/*String rawAccount_ = extractedAccName;
		String[] rawAccountName_ = rawAccount_.split("\\(");
		String accountName = rawAccountName_[0];
		
		String[] rawAccountId = (rawAccountName_[1].split("\\"));
		String accId = (rawAccountId[0]);*/
		accId = accId.replaceAll("\\D", "");
		click(locateElement("link", "Find Accounts"));
		
		type(locateElement("xpath", "(//input[@name='accountName'])[2]"), "UFT");
		
		type(locateElement("name", "id"), accId);
		
		click(locateElement("xpath", "(//button[text() = 'Find Accounts'])"));
		
		Thread.sleep(5000);
		
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		String industry = getText(locateElement("xpath", "//span[text()='Manufacturing']"));
		
		if(industry.equals("Manufacturing"))
			System.out.println("Test Case Pass");
		
		closeActiveBrowser();
		
	}

}
