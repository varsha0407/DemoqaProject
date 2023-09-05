package com.elements;

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

public class UploadAndDownload {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void uploadAndDownload() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String element = p.getProperty("element");	
		String uploadAndDownload = p.getProperty("uploadAndDownload");	
		String upload = p.getProperty("upload");	
        String scroll = p.getProperty("scroll");	
        String downloadButton = p.getProperty("downloadButton");	

		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on element
		
		d.findElement(By.xpath(element)).click();
		Thread.sleep(2000);

		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll);
		Thread.sleep(2000);	
		
		//click on uploadAndDownload
		
		d.findElement(By.xpath(uploadAndDownload)).click();
		Thread.sleep(3000);

		//select picture
		
		WebElement upload1 = d.findElement(By.xpath(upload));	
				
		upload1.sendKeys("C:\\Users\\91797\\Desktop\\Pic.png");
		Thread.sleep(2000);
		
		//click on yes downloadButton
		
		d.findElement(By.xpath(downloadButton)).click();
		Thread.sleep(3000);
		
		
	} catch (Exception e) {
        System.out.println(e);
}
	}

	@AfterTest
	
	public void closeBrowser() {
		
		d.close();

	}
}
