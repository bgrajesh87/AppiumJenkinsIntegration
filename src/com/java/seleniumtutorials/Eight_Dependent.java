package com.java.seleniumtutorials;

import org.testng.annotations.Test;

public class Eight_Dependent {
	@Test( dependsOnMethods = {"openBrowser"} )
	public void signIn() {
		System.out.println("This will execute second(SignIn)");
	}
	@Test
	public void openBrowser() {
		System.out.println("This will execute first(openBrowser)");
	}
	@Test( dependsOnMethods = {"signIn"} )
	public void signOut() {
		System.out.println("This will execute last(signOut)");
	}
}
