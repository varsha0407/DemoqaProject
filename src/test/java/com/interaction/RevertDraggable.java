package com.interaction;

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

public class RevertDraggable {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void revertDroppable(){
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String interaction1 = p.getProperty("interaction1");	
        String scroll = p.getProperty("scroll");	
        String droppable = p.getProperty("droppable");	
        String revertDraggable = p.getProperty("revertDraggable");	
        String notRevert = p.getProperty("notRevert");	
        String dropHere = p.getProperty("dropHere");	

		d.get(url);
		Thread.sleep(2000);
		
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript(scroll);
		Thread.sleep(2000);

		//click on interaction
		
		d.findElement(By.xpath(interaction1)).click();
		Thread.sleep(2000);

		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll);
		Thread.sleep(2000);
		
		//click on droppable
		
		d.findElement(By.xpath(droppable)).click();
		Thread.sleep(3000);

		d.findElement(By.xpath(revertDraggable)).click();
		Thread.sleep(3000);

		 WebElement element1 = d.findElement(By.xpath(notRevert));
		
		WebElement element2 = d.findElement(By.xpath(dropHere));
		
		Actions act= new Actions(d);
		
		act.dragAndDropBy(element1, 310, 40).perform();
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
