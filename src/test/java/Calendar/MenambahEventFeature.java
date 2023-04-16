package Calendar;
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

public class MenambahEventFeature {
	
	private int days = -1;
	private String title = null;
	WebDriverWait wait = null;
	
	@Given("browser is open")
	public void browser_is_open() {
	    Driver.getInstance();
	}

	@Given("user is on calendar page")
	public void user_is_on_calendar_page() {
		Driver.getInstance().navigate().to("http://go-grids.site/");
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys("Orion2805");
		Driver.getInstance().findElement(By.xpath("//input[@type='password']")).sendKeys("Orion12345");
		Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")).click();
	    Driver.getInstance().findElement(By.cssSelector("[href=\"/calendar\"]")).click();
	}

	@When("user click on {int} days later")
	public void user_click_on_n_days_later(int days) {
		LocalDate date = LocalDate.now().plusDays(days);
		this.days = days;
	    Driver.getInstance().findElement(By.xpath("//td[@data-date=\"" + date + "\"]/div/div[1]")).click();
	}

	@When("user enters event {string}")
	public void user_enters_event_title(String title) {
		this.title = title;
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys(title);
	}
	
	@When("user add {int} participants")
	public void user_add_n_participants(int n) throws AWTException, InterruptedException {
		WebElement dropdown = Driver.getInstance().findElement(By.xpath("(//input[@type='text'])[2]"));
		dropdown.click();
		Thread.sleep(500);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		for(int i = 1; i < n; i ++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
		}
	}

	@When("user click submit button")
	public void user_click_submit_button() {
		Driver.getInstance().findElement(By.xpath("//form/div[2]/div/button[1]")).click();
	}

	@Then("page show event created notification")
	public void page_show_event_created_notification() {
		assertEquals(Driver.getInstance().findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText(), "Successfully create new Event");
	}
	
	@Then("show event name required message")
	public void show_error_message() {
		assertEquals("Event name is required",Driver.getInstance().findElement(By.className("v-messages")).getText());
		Driver.getInstance().close();
		Driver.deleteInstance();
	}

	@Then("event show in box")
	public void event_show_in_box() {
		LocalDate date = LocalDate.now().plusDays(this.days);
		wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@data-date=\"" + date + "\"]/div/div[2]"), this.title));
		String data = Driver.getInstance().findElement(By.xpath("//td[@data-date=\"" + date + "\"]/div/div[2]")).getText();
		assertTrue(data.contains(this.title));
		Driver.getInstance().close();
		Driver.deleteInstance();
	}
}
