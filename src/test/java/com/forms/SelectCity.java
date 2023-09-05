package com.forms;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCity {
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void selectCity() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String forms = p.getProperty("forms");	
		String practiceForm = p.getProperty("practiceForm");	
		String scroll = p.getProperty("scroll");	
		String state = p.getProperty("state");	
		String stateInput = p.getProperty("stateInput");	
		String city = p.getProperty("city");	
		String cityInput = p.getProperty("cityInput");	
		String interaction = p.getProperty("interaction") ;
		
		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on forms
		
		d.findElement(By.xpath(forms)).click();
		Thread.sleep(2000);

		//click on practiceForm
		
		d.findElement(By.xpath(practiceForm)).click();
		Thread.sleep(2000);
		
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll);
		Thread.sleep(2000);

		//select state
		
		WebElement state1 = d.findElement(By.xpath(state));	
		state1.click();
		Thread.sleep(2000);
		
		d.findElement(By.xpath(stateInput)).click();
		Thread.sleep(3000);
		
		d.findElement(By.xpath(interaction)).click();
		Thread.sleep(3000);
		
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript(scroll);
		Thread.sleep(2000);
		
		//select city
		
		WebElement city1 = d.findElement(By.xpath(city));	
		city1.click();
		Thread.sleep(3000);
				
		d.findElement(By.xpath(cityInput)).click();
		Thread.sleep(4000);

	} catch (Exception e) {
        System.out.println(e);
}
	}

	@AfterTest
	
	public void closeBrowser() {
		
		d.close();

	}
}
