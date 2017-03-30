package com.java.seleniumtutorials;

import org.testng.annotations.Test;

public class Eight_Grouping {
	@Test(groups={"car"})
	public void car1() {
		System.out.println("Batch car - Test car1");
	}
	@Test(groups={"car"})
	public void car2() {
		System.out.println("Batch car - Test car2");
	}
	@Test(groups={"scooter"})
	public void scooter1() {
		System.out.println("Batch scooter - Test scooter1");
	}
	@Test(groups={"scooter"})
	public void scooter2() {
		System.out.println("Batch scooter - Test scooter2");
	}
	@Test(groups={"car","sedan car"})
	public void sedanCar() {
		System.out.println("Batch sedan car - Test sedan1");
	}
		
}
