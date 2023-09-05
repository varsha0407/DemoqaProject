package com.elements;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBox {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void textBox() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String element = p.getProperty("element");	
		String textBox = p.getProperty("textBox");	
		String userName = p.getProperty("userName");	
		String userNameInput = p.getProperty("userNameInput");	
		String email = p.getProperty("email");	
		String emailInput = p.getProperty("emailInput");	
		String currentAddress = p.getProperty("currentAddress");	
        String currentAddressInput = p.getProperty("currentAddressInput");	
        String permanentAddress = p.getProperty("permanentAddress");	
        String submitButton = p.getProperty("submitButton");	
        String scroll = p.getProperty("scroll");	
        String scroll1 = p.getProperty("scroll1");	

		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on element
		
		d.findElement(By.xpath(element)).click();
		Thread.sleep(2000);

		//click on textBox
		
		d.findElement(By.xpath(textBox)).click();
		Thread.sleep(2000);

		//select userName
		
		d.findElement(By.xpath(userName)).sendKeys(userNameInput);
		Thread.sleep(2000);
		

		//enter email
		
		d.findElement(By.xpath(email)).sendKeys(emailInput);
		Thread.sleep(2000);

		//enter currentAddress

		d.findElement(By.xpath(currentAddress)).sendKeys(currentAddressInput);
		Thread.sleep(2000);

		//enter permanentAddress

		d.findElement(By.xpath(permanentAddress)).sendKeys(currentAddressInput);
		Thread.sleep(2000);
		
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll1);
		Thread.sleep(2000);
		
		//click on submitButton
		
		d.findElement(By.xpath(submitButton)).click();
		Thread.sleep(2000);	

		
	} catch (Exception e) {
        System.out.println(e);
}
	}

	@AfterTest
	
	public void closeBrowser() {
		
		d.close();

	}
}
