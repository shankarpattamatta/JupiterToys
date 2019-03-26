package com.planittesting.jupitertoys.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.planittesting.jupitertoys.model.data.ContactData;
import com.planittesting.jupitertoys.model.pages.ContactPage;
import com.planittesting.jupitertoys.model.pages.HomePage;
import com.planittesting.jupitertoys.tests.data.CsvToContactData;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ContactTests extends BaseTests {

	@Test
	public void validateWrongEmailId()
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickContactPage();
		ContactPage contactPage = new ContactPage(driver);
		homePage.clickContactPage();
		contactPage.setEmail("abc");
		assertEquals(contactPage.getEmailValidation(),"Please enter a valid email");
	}
    
	@ParameterizedTest
	@CsvSource(value = { "asdasd,,a@b.com,,hello",
			             "yuweyew,,ddd@hhh.com,,world"})
	public void validateContactForm(@CsvToContactData ContactData contactData)
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickContactPage();
		ContactPage contactPage = new ContactPage(driver);
		contactPage.clickSubmit();
		assertEquals(contactPage.getForenameValidation(),"Forename is required");
		assertEquals(contactPage.getEmailValidation(),"Email is required");
		assertEquals(contactPage.getMessageValidation(),"Message is required");
		contactPage.setContactData(contactData);
		assertEquals(contactPage.getForenameValidation(),"");
		assertEquals(contactPage.getEmailValidation(),"");
		assertEquals(contactPage.getMessageValidation(),"");
		
	}
	
	
	
	
		
	
}
