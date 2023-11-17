package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.prerequisite;

public class Tests extends prerequisite{
    @Test(dataProvider="testData")
	public static void login(String Username, String Password) 
	{
		driver.findElement(By.linkText(Loc.getProperty("signin link"))).click();
		driver.findElement(By.id(Loc.getProperty("email field"))).sendKeys(Username);
		driver.findElement(By.id(Loc.getProperty("next button"))).click();
		driver.findElement(By.id(Loc.getProperty("password field"))).sendKeys(Password);
		driver.findElement(By.xpath(Loc.getProperty("signin button"))).click();
		
		
		// TODO Auto-generated method stub

	}

    @DataProvider(name="testData")
    public Object[][] createData1() {
    	 return new Object[][] {
    	   {"dileepkumarrouthu45@gmail.com","dhoomdil"  },
    	   { "dileepkumarrouthu55@gmail.com","dhoomdil1"  },
    	 };
    	}

    	
    
}
