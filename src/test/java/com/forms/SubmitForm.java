package com.forms;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitForm {
	
	WebDriver d;
	
	@BeforeTest
	
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();	
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	
	public void submitForm() {
		
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\91797\\eclipse-workspace\\Demoqa_Project\\input.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");	
		String forms = p.getProperty("forms");	
		String practiceForm = p.getProperty("practiceForm");	
		String genderRadioButton = p.getProperty("genderRadioButton");	
		String scroll = p.getProperty("scroll");	
		String firstName = p.getProperty("firstName");	
		String firstNameInput = p.getProperty("firstNameInput");	
		String lastName = p.getProperty("lastName");	
		String lastNameInput = p.getProperty("lastNameInput");	
		String emailf = p.getProperty("emailf");	
		String emailfInput = p.getProperty("emailfInput");	
		String mobileNumber = p.getProperty("mobileNumber");	
		String mobileNumberInput = p.getProperty("mobileNumberInput");	
		String currentAddress1 = p.getProperty("currentAddress1");	
		String currentAddress1Input = p.getProperty("currentAddress1Input");	
		String subjectInput = p.getProperty("subjectInput");	
		String subject1 = p.getProperty("subject1");	
		String uploadPicture = p.getProperty("uploadPicture");	
		String hobby1 = p.getProperty("hobby1");	
		String hobby2 = p.getProperty("hobby2");	
		String hobby3 = p.getProperty("hobby3");	
		String state = p.getProperty("state");	
		String stateInput = p.getProperty("stateInput");	
		String city = p.getProperty("city");	
		String cityInput = p.getProperty("cityInput");	
		String interaction = p.getProperty("interaction");	
		String year = p.getProperty("year");	
		String yearInput = p.getProperty("yearInput");	
		String month = p.getProperty("month");	
		String monthInput = p.getProperty("monthInput");	
		String date = p.getProperty("date");	
		String dateField = p.getProperty("dateField");	
		String submitButton = p.getProperty("submitBtn");	

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

		// enter firstname and lastname
		d.findElement(By.xpath(firstName)).sendKeys(firstNameInput);	
		Thread.sleep(2000);

		d.findElement(By.xpath(lastName)).sendKeys(lastNameInput);
		Thread.sleep(2000);

		// enter emailid
		d.findElement(By.xpath(emailf)).sendKeys(emailfInput);
		Thread.sleep(2000);
		
		//select gender
		
		d.findElement(By.xpath(genderRadioButton)).click();	
		Thread.sleep(2000);

		// enter mobile number
		d.findElement(By.xpath(mobileNumber)).sendKeys(mobileNumberInput);
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
		Thread.sleep(3000);			

		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript(scroll);
		Thread.sleep(2000);

		//select subjects
		
		d.findElement(By.xpath(subjectInput)).sendKeys(subject1);
		d.findElement(By.xpath(subjectInput)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		Thread.sleep(6000);


		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript(scroll);
		Thread.sleep(2000);

		//select hobby
		
		d.findElement(By.xpath(hobby1)).click();	
		Thread.sleep(2000);
		
		d.findElement(By.xpath(hobby2)).click();	
		Thread.sleep(2000);
		
		d.findElement(By.xpath(hobby3)).click();	
		Thread.sleep(2000);		
		
		//select picture
		
		WebElement upload = d.findElement(By.xpath(uploadPicture));	
		
		upload.sendKeys("C:\\Users\\91797\\Desktop\\Pic.png");
		Thread.sleep(2000);		
		
		// enter current Address
		d.findElement(By.xpath(currentAddress1)).sendKeys(currentAddress1Input);
		Thread.sleep(2000);

		JavascriptExecutor j5 = (JavascriptExecutor)d;
		j5.executeScript(scroll);
		Thread.sleep(2000);
		
		//select state
		
		WebElement state1 = d.findElement(By.xpath(state));	
		state1.click();
		Thread.sleep(2000);
		
		d.findElement(By.xpath(stateInput)).click();
		Thread.sleep(3000);
		
		d.findElement(By.xpath(interaction)).click();
		Thread.sleep(3000);
		
		JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript(scroll);
		Thread.sleep(2000);
		
		//select city
		
		WebElement city1 = d.findElement(By.xpath(city));	
		city1.click();
		Thread.sleep(3000);
				
		d.findElement(By.xpath(cityInput)).click();
		Thread.sleep(4000);
		
		// click on submit button
		
		d.findElement(By.xpath(submitButton)).click();
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
