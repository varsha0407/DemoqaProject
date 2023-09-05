package com.forms;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectSubjects {
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
	
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void selectSubjects() {
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String forms = p.getProperty("forms");	
		String practiceForm = p.getProperty("practiceForm");	
		String subjectInput = p.getProperty("subjectInput");	
		String subject1 = p.getProperty("subject1");	
		String subject2 = p.getProperty("subject2");	
		String subject3 = p.getProperty("subject3");	
		String subject4 = p.getProperty("subject4");	
		String scroll = p.getProperty("scroll");	

	
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

		//select subjects
		
		d.findElement(By.xpath(subjectInput)).sendKeys(subject1);
		d.findElement(By.xpath(subjectInput)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		Thread.sleep(2000);

		d.findElement(By.xpath(subjectInput)).sendKeys(subject2);
		d.findElement(By.xpath(subjectInput)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		Thread.sleep(2000);

		d.findElement(By.xpath(subjectInput)).sendKeys(subject3);
		d.findElement(By.xpath(subjectInput)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(2000);

		d.findElement(By.xpath(subjectInput)).sendKeys(subject4);
		d.findElement(By.xpath(subjectInput)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
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


