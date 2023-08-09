package day36;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Grouping {

	/*
	loginByEmail  - sanity & regression
	loginByfacebook - sanity
	loginBytwitter  - sanity

	signupbyemail - sanity & regression
	signupbyfacebook  - regression
	signupbytwitter  - regression

	paymentinrupees - sanity & regression
	paymentindollar - sanity  
	paymentReturnbyBank  - regression
	*/
	
	@Test(priority = 1, groups = {"sanity","regression"})
	void loginByEmail()
	{
		System.out.println("This is login By email..");
	}
	
	@Test(priority = 2, groups = {"sanity"})
	void loginByfacebook()
	{
		System.out.println("This is login By facebook..");
	}
	
	@Test(priority = 3, groups = {"sanity"})
	void loginBytwitter()
	{
		System.out.println("This is login By twitter..");
	}
	
	@Test(priority = 4, groups = {"sanity","regression"})
	void signupbyemail()
	{
		System.out.println("This is signup By email..");
	}
	
	@Test(priority = 5, groups = {"regression"})
	void signupbyfacebook()
	{
		System.out.println("This is signup By facebook..");
	}
	
	@Test(priority = 6, groups = {"regression"})
	void signupbytwitter()
	{
		System.out.println("This is signup By twitter..");
	}
	
	@Test(priority = 7, groups = {"sanity","regression"})
	void paymentinrupees()
	{
		System.out.println("this is payement by rupess method.");
	}
	
	@Test(priority = 8, groups = {"sanity"})
	void paymentindollar()
	{
		System.out.println("this is payement by dollar method.");
	}
	
	@Test(priority = 9, groups = {"regression"})
	void paymentReturnbyBank()
	{
		System.out.println("payment return by bank");
	}
	
	}
	
