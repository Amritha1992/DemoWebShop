package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class LoginTest extends Base
{
	HomePage home;

	LoginPage login;

	UserAccountPage useraccount;
	@Test(priority=1,enabled=true,description="tc_003 verify Valid Login",groups={"Sanity"})
	public void tc_003_verifyValidLogin()
	{
		List<ArrayList<String>> data= ExcelUtility.excelDataReader("LoginPage");

		String useremail = data.get(1).get(0);

		String password = data.get(1).get(1);

		home= new HomePage(driver);

		login= home.clickOnLoginLink();

		login.enterUserEmailId(useremail);

		login.enterUserPassword(password);

		useraccount = login.clickOnLoginButton();

		String actEmail = useraccount.getEmailText();

		Assert.assertEquals(useremail, actEmail, ErrorMessage.INVALID_EMAIL_ID);
	}

}
