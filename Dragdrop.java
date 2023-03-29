package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxCommandContext;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dragdrop {
	FirefoxDriver driver;

	@BeforeTest
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod	
	public void urlloading()
	{
		driver.get("https://demoqa.com/droppable/");
		System.out.println("url loading");
	}
	@Test
	public void test()
	{
		WebElement dragme=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement dropme=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		Actions act=new Actions(driver);
		 act.dragAndDrop(dragme,dropme).build().perform();	
		act.perform();
		String exp="Dropped!";
		String s= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/p")).getText();
		System.out.println(s); 
		System.out.println("actualtext="+s);

		if(s.equals(exp))
		{
			System.out.println("dropped is present");
		}
		else
		{
			System.out.println("dropped is fail");
		}
		
	}
	
	@AfterMethod
	public void aftermethod()
	{
		System.out.print("aftermethod");
	}
	@AfterTest()
	public void teardown()
	{
		System.out.println("browserclose");
		//driver.quit();
	}
}
