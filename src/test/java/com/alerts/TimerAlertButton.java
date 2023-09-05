package com.alerts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimerAlertButton {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void timerAlertButton() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String alertFrameAndWindow = p.getProperty("alertFrameAndWindow");	
        String scroll = p.getProperty("scroll");	
        String alert = p.getProperty("alert");	
        String timerAlertButton = p.getProperty("timerAlertButton");	

		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on alertFrameAndWindow
		
		d.findElement(By.xpath(alertFrameAndWindow)).click();
		Thread.sleep(2000);

		//click on alert
		
		d.findElement(By.xpath(alert)).click();
		Thread.sleep(3000);

		//click on timerAlertButton
		
		d.findElement(By.xpath(timerAlertButton)).click();
		Thread.sleep(6000);

		Alert alt = d.switchTo().alert();
		alt.accept();
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
