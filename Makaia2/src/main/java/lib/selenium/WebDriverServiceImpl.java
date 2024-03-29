package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {

			case "id": return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "name" : return driver.findElement(By.name(locValue));

			case "xpath" : return driver.findElement(By.xpath(locValue));

			default:
				break;
			}

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("The element "+locator+" Value "+locValue+" is not available " );
			return null;
		}
		return null;
	}


	public List <WebElement> locateElements(String locator, String locValue) {

		switch (locator) {

		case "xpath" : 
			return driver.findElements(By.xpath(locValue));


		default:		
			break;
		}
		return null;
	}

	public void clearField(WebElement locValue) {
		driver.unregister(this);
		locValue.clear();
		driver.register(this);
	}


	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
		} catch (InvalidElementStateException e) {
			// TODO Auto-generated catch block
			System.err.println("The ele"+ele+" is not ready for typing");
		}		
	}

	public void click(WebElement ele) {
		ele.click();		
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			return ele.getText();
		} catch (InvalidElementStateException e) {
			// TODO Auto-generated catch block
			System.out.println("Element "+ele+" Text is not available");
			return null;
		}
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			Select ddSelect = new Select(ele);
			ddSelect.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Drop Down Text is not available");
		}

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select ddSelect = new Select(ele);
		ddSelect.selectByValue(value);

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowHandlesList = new ArrayList<String>();
			windowHandlesList.addAll(windowHandles);
			driver.switchTo().window(windowHandlesList.get(index));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("The Window index : "+index+" is not available to Switch");
		}	catch (IndexOutOfBoundsException e) {
			System.out.println("The Window index : "+index+" is not available to Switch");
		}
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeActiveBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Driver Closed Abruptly ");
		}

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}
	public void mouseHover(WebElement ele) {
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
	}

	public void keyBoardActions(String data ) {
		switch(data){
		case "ESCAPE":
			driver.getKeyboard().sendKeys(Keys.ESCAPE);
			break;

		case "PAGEDOWN":
			driver.getKeyboard().sendKeys(Keys.ESCAPE);
			break;
			
		default:
			break;
		}
	}
}
