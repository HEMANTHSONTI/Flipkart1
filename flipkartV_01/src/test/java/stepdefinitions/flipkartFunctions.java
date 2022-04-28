package stepdefinitions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class flipkartFunctions 
{
	public static WebDriver driver;
	public static String link_tobe_check = "Core i7";

	
	@Given("^I open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		driver.get(url);
		Thread.sleep(3000);
		
		
	}

	@When("^I enter text in search it should display items$")
	public void i_enter_text_in_search_it_should_display_items()
	{
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("laptops");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}


	@When("^I click on specific filters it should display products$")
	public void i_click_on_specific_filters_it_should_display_products() throws InterruptedException
	{
		WebElement chkbox = driver.findElement(By.xpath("//div[@title='Core i7']")); 
		
		if(!chkbox.isSelected())
		{
			chkbox.click();
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[2]/div[4]")).click();
		Thread.sleep(5000);
		
	}

	@Then("^I should see text present in display products$")
	public void i_should_see_text_present_in_display_products()
	{
		List<WebElement> Title1 =driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		boolean ispresent = false;
		
		for(int i=0;i<Title1.size();i++)
		{
			if(Title1.get(i).getText().contains(link_tobe_check))
			{
				ispresent=true;
				break;
			}
		}
		if(ispresent)
		{
			System.out.println(link_tobe_check+" is present in the page, test pass");
		}
		else
		{
			System.out.println(link_tobe_check+" is not present in the page, test fail");
		}
	}
	
	
	@Then("^I close the browser$")
	public void i_close_the_browser()
	{
		driver.quit();
	}
	
		
		
	@When("^I click on add to cart it should add to cart$")
	public void i_click_on_add_to_cart_it_should_add_to_cart()
	{
		driver.findElement(By.partialLinkText("MSI GE76 Core i7")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		Object[] windows = allwindows.toArray();
		String window1 = windows[0].toString();
		String window2 = windows[1].toString();
		
		driver.switchTo().window(window2);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		System.out.println("product is added to the cart");
		

		
	}
	
	
	@When("^I enter text and apply filter it should display items$")
	public void i_enter_text_and_apply_filter_it_should_display_items()
	{
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("apple watches");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement chkbox = driver.findElement(By.xpath("//div/section[7]/div[2]/div/div[1]/div/label/div[1]")); 
		
		if(!chkbox.isSelected())
		{
			chkbox.click();
		}
		
	}

	@When("^I click on next button$")
	public void i_click_on_next_button() throws InterruptedException
	{
		WebElement element = driver.findElement(By.className("_1LKTO3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 


		
		List<WebElement>pages =driver.findElements(By.xpath("//a[starts-with(@class,'ge-49M')]"));
		System.out.println("total pages found are =="+pages.size());
		for(int i=1;i<pages.size();i++)
		{
			pages.get(i).click();
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
			
		
		}
		
		
		
	}

}
