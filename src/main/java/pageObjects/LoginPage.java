package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By email= By.xpath("//input[@id='user_email']");
	By pass= By.xpath("//input[@id='user_password']");
	By button=By.name("commit");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	


	public WebElement email() {
		return driver.findElement(email);
	}


	public WebElement password() {
		// TODO Auto-generated method stub
		return driver.findElement(pass);
	}
	
	public WebElement click()
	{
		return driver.findElement(button);
	}


}
