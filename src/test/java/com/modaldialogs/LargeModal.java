package com.modaldialogs;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LargeModal {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void largeModal() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String alertFrameAndWindow = p.getProperty("alertFrameAndWindow");	
        String scroll = p.getProperty("scroll");	
        String modalDialog = p.getProperty("modalDialog");	
        String largeModal = p.getProperty("largeModal");	
        String closeLargeModal = p.getProperty("closeLargeModal");	
        String scroll1 = p.getProperty("scroll1");	
        String scroll2 = p.getProperty("scroll2");	

		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on alertFrameAndWindow
		
		d.findElement(By.xpath(alertFrameAndWindow)).click();
		Thread.sleep(2000);

		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll1);
		Thread.sleep(2000);
		//click on modal dialog
		
		d.findElement(By.xpath(modalDialog)).click();
		Thread.sleep(3000);

		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript(scroll2);
		Thread.sleep(2000);
		//click on large Modal
		
		d.findElement(By.xpath(largeModal)).click();
		Thread.sleep(3000);


		d.findElement(By.xpath(closeLargeModal)).click();
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
