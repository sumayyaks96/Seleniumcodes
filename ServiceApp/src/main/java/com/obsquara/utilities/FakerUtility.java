package com.obsquara.utilities;

import java.util.Locale;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility {
	public static String firstName() {
		Faker faker=new Faker();
		String firstName=faker.name().firstName();
		return firstName;
		}
	public static String fullName() {
		Faker faker=new Faker();
		String fullName=faker.name().fullName();
		return fullName;
		}
	public static String username() {
		Faker faker=new Faker();
		String username=faker.name().fullName();
		return username;
		}
	public static String cityName() {
		Faker faker=new Faker();
		String cityName=faker.address().city();
		return cityName;
		}
	public static String coundryName() {
		Faker faker=new Faker();
		String coundryName=faker.address().country();
		return coundryName;
		}
	public static String phoneNumber() {
		Faker faker=new Faker();
		String phoneno=faker.phoneNumber().phoneNumber();
		return phoneno;
		}
	public static String companyName() {
		Faker faker=new Faker();
		String companyname=faker.company().name();
		return companyname;
		}
	public static String fakeValuesServiceEmail() {
		FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????##@gmail.com");
		return email;
	}
}
