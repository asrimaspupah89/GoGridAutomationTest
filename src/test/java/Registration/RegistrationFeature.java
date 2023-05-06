package Registration;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationFeature {
	
	@Given("browser open")
	public void browser_open() {
	    Driver.getInstance();
	}
	
	@And("user on login page")
	public void user_on_login_page() {
		Driver.getInstance().navigate().to("http://go-grids.site/");
	}
	
	@And("user Click button register now")
	public void user_Click_button_register_now() {
		Driver.getInstance().findElement(By.xpath("//*[@class=\"button-RegisterHere\"]/a")).click();
		try {
			 WebElement homePageElement = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div"));
		        if (homePageElement.isDisplayed()) {
		            System.out.println("User is navigated to the register page.");
		        } else {
		            System.out.println("Register page element is not displayed.");
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("Register page element is not found.");
		    } catch (Exception e) {
		        System.out.println("An error occurred while navigating to the register page: " + e.getMessage());
		    }
	}
	
	@And("user enters {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_firstname_and_lastname_and_email_and_username_and_password_and_confirmPassword(String firstname, String lastname, String email,String username, String password, String confirmPassword) {
		
		if (!firstname.equals("<blank>")) {
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-5\"]"))).sendKeys(firstname);
		}
		if (!lastname.equals("<blank>")) {
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-7\"]"))).sendKeys(lastname);
		}
		if (!email.equals("<blank>")) {
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-9\"]"))).sendKeys(email);
		}
		if (!username.equals("<blank>")) {
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-11\"]"))).sendKeys(username);
		}
		if (!password.equals("<blank>")) {
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-13\"]"))).sendKeys(password);
		}
		if (!confirmPassword.equals("<blank>")) {
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-15\"]"))).sendKeys(confirmPassword);
		}
	}
	
	@When("user click on submit button")
	public void user_click_submit_button() {
//		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[4]/form/div/div[6]/div[2]")).click();
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[4]/form/div/div[6]/div[2]")));
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[4]/form/div/div[6]/div[2]")).click();
	}
	
//	@Then("page show notification")
//	public void page_show_notification() {
//		assertEquals(Driver.getInstance().findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText(), "Your Account Has Been Created");
//	}
	
	@Then("user navigated to login page")
	public void user_navigated_to_login_page() {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
		WebElement loginPageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"v-card-text pt-2\"]//*[self::h3[@class=\"text-h3 text-b font-weight-bold mb-0\" and @style=\"font-family: Poppins, sans-serif !important;\"] or self::p[@class=\"mb-2 text-b font-weight-normal\"]]")));
			if (loginPageElement.isDisplayed()) {
				System.out.println("User has successfully registration and navigated to the login page");
			}else {
				System.out.println("user unsuccess to register");
			}
	}
	
	
	@Then("user on register page")
	public void user_on_register_page() {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
		WebElement loginPageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"v-card-text pt-2\"]//*[self::h3[@class=\"text-h3 font-weight-bold mb-0\" and @style=\"font-family: Poppins, sans-serif !important;\"] or self::p[@class=\"mb-2 text-b\"]]")));
			if (loginPageElement.isDisplayed()) {
				System.out.println("user unsuccess to register");
			}else {
				System.out.println("User has successfully registration and navigated to the login page");
			}
	}

}
