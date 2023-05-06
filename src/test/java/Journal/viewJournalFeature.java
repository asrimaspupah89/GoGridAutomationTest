package Journal;

//gogirds
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class viewJournalFeature {

WebDriver driver = null;
	
	public void browser_open() {
		Driver.getInstance();
	}
	
	
	public void user_is_on_login_page() {
		
		//System.out.println("Inside Step - user is on login page");
		Driver.getInstance().navigate().to("http://go-grids.site/");
	}


	public void user_enters_username_and_password() {
		
		//System.out.println("Inside Step - user enters username and password");
		Driver.getInstance().findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys("nabiilahnadaa");
		Driver.getInstance().findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys("haliibaN19");
	}
	
	

	public void clicks_on_login_button() {
		
		//System.out.println("Inside Step - clicks on login button");
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button")).click();
	}
	
	
	public void user_is_navigated_to_home_page() {
		 try {
			 WebElement homePageElement = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/nav/div/ul/li[1]/a"));
		        if (homePageElement.isDisplayed()) {
		            System.out.println("User is navigated to the home page.");
		        } else {
		            System.out.println("Home page element is not displayed.");
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("Home page element is not found.");
		    } catch (Exception e) {
		        System.out.println("An error occurred while navigating to the home page: " + e.getMessage());
		    }
		}
	
	@Given("user is log in")
	public void user_is_logged_in() {
		this.browser_open();
		this.user_is_on_login_page();
		this.user_enters_username_and_password();
	}
	
	@When ("user click login button")
	public void user_click_login_button() {
	this.clicks_on_login_button();
	}

	@Then ("navigate to home page")
	public void navigate_to_home_page() {
	this.user_is_navigated_to_home_page();
	}
}	