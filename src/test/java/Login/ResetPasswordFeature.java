package Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class ResetPasswordFeature {
	
	
	@Given("open browser")
	public void open_browser() {
	    Driver.getInstance();
	    Driver.getInstance().navigate().to("http://go-grids.site/");
	} 
	
	@And("user click Reset Password")
	public void user_click_reset_password() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/div[2]/div/a")).click();
	}
	
	@And("user input username {string}")
	public void user_input_username (String username) {
		Driver.getInstance().findElement(By.xpath("//input[@id='input-5']")).sendKeys(username);
	}
	
	@When("user click on submit button")
	public void user_click_on_submit_button() {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button"))).click();
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button")).click();
	}
	
	
	@Then("page show created message notification")
	public void page_show_created_message_notification() {
		assertEquals(Driver.getInstance().findElement(By.xpath("/html/body/div[3]/div")).getText(), "Password your has been sent to afannyputria@gmail.com");
	}
	
}
