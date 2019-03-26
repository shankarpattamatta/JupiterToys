package com.planittesting.jupitertoys.tests;

import com.planittesting.jupitertoys.model.dialouges.LoginDialouge;
import com.planittesting.jupitertoys.model.dialouges.LogoutDialouge;
import com.planittesting.jupitertoys.model.pages.HomePage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTests{
	
	
	
	@Test
	public void validateProfile() {
		
		HomePage homePage = new HomePage(driver);
		LoginDialouge loginDialouge = homePage.clickLogin();
		loginDialouge.setUserName("abc");
		loginDialouge.setPassword("letmein");
		loginDialouge.clickLoginButton();
		assertEquals("abc",homePage.getUserName());
		
		}
	
	@Test
	public void validateUserLogin()
	{
		HomePage homePage = new HomePage(driver);
		LoginDialouge loginDialouge =homePage.clickLogin();
		loginDialouge.setUserName("abc");
		loginDialouge.setPassword("letmein");
		loginDialouge.clickLoginButton();
		LogoutDialouge logoutDialouge= homePage.clickLogout();
		logoutDialouge.clickLogout();
		assertEquals("", homePage.getUserName());
		
		
	}

}
