package com.planittesting.jupitertoys.model.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupitertoys.model.data.ContactData;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String text) {

		driver.findElement(By.id("email")).sendKeys(text);
	}

	private String getErrorText(By locator) {
		List<WebElement> element = driver.findElements(locator);
		if (element.isEmpty()) {
			return "";
		} else {
			return element.get(0).getText();
		}
	}

	public String getEmailValidation() {
		return getErrorText(By.id("email-err"));
	}

	public String getForenameValidation() {
		return getErrorText(By.id("forename-err"));
	}

	public String getMessageValidation() {
		return getErrorText(By.id("message-err"));
	}

	public void clickSubmit() {

		driver.findElement(By.linkText("Submit")).click();

	}

	public void setContactData(ContactData contactData) {
		if (contactData.getForename() != null) {
			setForename(contactData.getForename());
		}

		if (contactData.getSurname() != null) {
			setSurname(contactData.getSurname());
		}
		if (contactData.getMessage() != null) {
			setMessage(contactData.getMessage());
		}

		if (contactData.getTelephone() != null) {
			setTelephone(contactData.getTelephone());

		}
		if (contactData.getEmail() != null) {
			setEmail(contactData.getEmail());

		}
	}

	private void setSurname(String surname) {
		driver.findElement(By.id("surname")).sendKeys(surname);
		
	}

	public void setForename(String forename) {

		driver.findElement(By.id("forename")).sendKeys(forename);

	}

	public void setMessage(String text) {

		driver.findElement(By.id("message")).sendKeys(text);

	}
	
	public void setTelephone(String telephone) {
		driver.findElement(By.id("telephone")).sendKeys(telephone);
	}

}
