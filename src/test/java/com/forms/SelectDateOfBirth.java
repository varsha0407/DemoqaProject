package com.forms;

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

public class SelectDateOfBirth {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void selectDateOfBirth() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String forms = p.getProperty("forms");	
		String practiceForm = p.getProperty("practiceForm");	
		String year = p.getProperty("year");	
		String yearInput = p.getProperty("yearInput");	
		String month = p.getProperty("month");	
		String monthInput = p.getProperty("monthInput");	
		String date = p.getProperty("date");	
        String scroll = p.getProperty("scroll");	
        String dateField = p.getProperty("dateField");	

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

		//select year
		
		d.findElement(By.xpath(dateField)).click();
		Thread.sleep(2000);
		
		WebElement year1 = d.findElement(By.xpath(year));	
		
		Select s = new Select(year1);
		s.selectByValue(yearInput);
		Thread.sleep(2000);

		//select month
		
		WebElement month1 = d.findElement(By.xpath(month));	
		
		Select s1 = new Select(month1);
		s1.selectByVisibleText(monthInput);
		Thread.sleep(2000);	
		
		//select date
		
		d.findElement(By.xpath(date)).click();
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
