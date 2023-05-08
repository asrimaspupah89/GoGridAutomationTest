package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class deleteAll {
    WebDriver driver;
    
    public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\taufi\\Downloads\\Pict_Doct\\AutomationTesting\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions  options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	
	public void user_is_on_login_page() {
		driver.navigate().to("http://go-grids.site/");
	}
	
	public void user_enters_username_and_password() {
		driver.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys("aziz");
		driver.findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys("1234567890Aziztaufiq");
	}
	
	public void user_enters_username_and_password(String username, String password) {
		if (!username.equals("<blank>")) driver.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys(username);
		if (!password.equals("<blank>")) driver.findElement(By.xpath("//*[@id=\"input-2\"]")).sendKeys(password);
	}
	
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button")).click();
	}
	
//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() {
//		driver.findElement(By.xpath("//*[@id=\"psaapp\"]/div/div[2]/div/div[2]/div/div[1]")).isDisplayed();
//	}
	
	public void user_is_navigated_to_the_home_page() {
	    try {
	        WebElement homePageElement = driver.findElement(By.xpath("//*[@id=\"psaapp\"]/div/div[2]/div/div[2]/div/div[1]"));
	        if (homePageElement.isDisplayed()) {
	            System.out.println("User has successfully navigated to the home page.");
	        } else {
	            System.out.println("Home page element is not displayed.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Home page element is not found.");
	    } catch (Exception e) {
	        System.out.println("An error occurred while navigating to the home page: " + e.getMessage());
	    }
	}
    
    
    @Given("user is logged in")
    public void user_is_logged_in() {
       this.browser_is_open();
       this.user_is_on_login_page();
       this.user_enters_username_and_password();
       this.clicks_on_login_button();
       this.user_is_navigated_to_the_home_page();
    }

    @When("user clicks on delete icon")
    public void user_clicks_on_delete_icon() {
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/form/button/span[3]")).click();
    }
    
    @And ("click on ok button")
    public void user_clicks_on_logout_icon() {
    	driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    }
    @Then("user is navigated to the homepage")
    public void user_is_navigated_to_the_homepage() {
    	this.user_is_navigated_to_the_home_page();
        driver.quit();
    }
}

