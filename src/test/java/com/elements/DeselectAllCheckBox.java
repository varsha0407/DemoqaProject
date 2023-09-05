package com.elements;

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

public class DeselectAllCheckBox {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void deselectAllCheckBox() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String element = p.getProperty("element");	
		String checkBox = p.getProperty("checkBox");	
		String plusSymbol = p.getProperty("plusSymbol");	
		String homeCheckBox = p.getProperty("homeCheckBox");	
        String scroll = p.getProperty("scroll");	
        String scroll1 = p.getProperty("scroll1");	
        String scroll2 = p.getProperty("scroll2");	

		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on element
		
		d.findElement(By.xpath(element)).click();
		Thread.sleep(2000);

		//click on checkBox
		
		d.findElement(By.xpath(checkBox)).click();
		Thread.sleep(3000);

		//click on plussymbol
		
		d.findElement(By.xpath(plusSymbol)).click();
		Thread.sleep(2000);

		//click on home CheckBox
		
		d.findElement(By.xpath(homeCheckBox)).click();
		Thread.sleep(2000);
		
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll1);
		Thread.sleep(3000);
		
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript(scroll2);
		Thread.sleep(3000);

		// deselect home CheckBox
		
		d.findElement(By.xpath(homeCheckBox)).click();
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