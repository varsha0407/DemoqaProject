package com.elements;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddWebTable {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void addWebTable() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String element = p.getProperty("element");	
		String webTable = p.getProperty("webTable");	
        String scroll = p.getProperty("scroll");	
        String scroll1 = p.getProperty("scroll1");	
        String addWebTable = p.getProperty("addWebTable");	
        String firstName = p.getProperty("firstName");	
        String firstNameInput = p.getProperty("firstNameInput");	
        String lastName = p.getProperty("lastName");	
        String lastNameInput = p.getProperty("lastNameInput");	
        String email1 = p.getProperty("email1");	
        String email1Input = p.getProperty("email1Input");	
        String salary = p.getProperty("salary");	
        String salaryInput = p.getProperty("salaryInput");	
        String age = p.getProperty("age");	
        String ageInput = p.getProperty("ageInput");	
        String department = p.getProperty("department");	
        String departmentInput = p.getProperty("departmentInput");	
        String submitWebTable = p.getProperty("submitWebTable");	
  
		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on element
		
		d.findElement(By.xpath(element)).click();
		Thread.sleep(2000);

		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll1);
		Thread.sleep(2000);

		//click on webTable
		
		d.findElement(By.xpath(webTable)).click();
		Thread.sleep(3000);

		//click on add
		
		d.findElement(By.xpath(addWebTable)).click();
		Thread.sleep(2000);

		d.findElement(By.xpath(firstName)).sendKeys(firstNameInput);
		Thread.sleep(2000);

		d.findElement(By.xpath(lastName)).sendKeys(lastNameInput);
		Thread.sleep(2000);

		d.findElement(By.xpath(email1)).sendKeys(email1Input);
		Thread.sleep(2000);

		d.findElement(By.xpath(age)).sendKeys(ageInput);
		Thread.sleep(2000);

		d.findElement(By.xpath(salary)).sendKeys(salaryInput);
		Thread.sleep(2000);

		d.findElement(By.xpath(department)).sendKeys(departmentInput);
		Thread.sleep(2000);

		d.findElement(By.xpath(submitWebTable)).click();
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
