package Calendar;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


import Driver.Driver;

public class MemperbaruiEventFeature {
	private String title;

	@Given ("Browser is open")
	public void Browser_is_open() {
	    Driver.getInstance();
	}
	
	@And ("User is on calendar page")
	public void User_is_on_calendar_page() {
		Driver.getInstance().navigate().to("http://go-grids.site/");
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys("syahdafia");
		Driver.getInstance().findElement(By.xpath("//input[@type='password']")).sendKeys("Syahdacantik7");
		Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")).click();
	    Driver.getInstance().findElement(By.cssSelector("[href=\"/calendar\"]")).click();
	}
	
	@When("User click event {string} on calendar")
	public void User_click_event_eventName_on_calendar(String eventName) {
	    Driver.getInstance().findElement(By.xpath("//div[@class='fc-daygrid-day-events']//div[@class='fc-event-title'][text()= \"" + eventName + "\"]")).click();
	}
	
	@And ("User update event {string}")
	public void User_update_event_title(String title) {
		this.title = title;
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys(title);
	}
	
	@And("User add {int}")
	public void User_add_participant(int participant) throws AWTException, InterruptedException {
		if (participant > 0) {
	        WebElement dropdown = Driver.getInstance().findElement(By.xpath("(//input[@type='text'])[2]"));
	        dropdown.click();
	        Thread.sleep(500);
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);
	        robot.keyPress(KeyEvent.VK_SPACE);
	        robot.keyRelease(KeyEvent.VK_SPACE);
	        for (int i = 1; i < participant; i++) {
	            robot.keyPress(KeyEvent.VK_DOWN);
	            robot.keyRelease(KeyEvent.VK_DOWN);
	            robot.keyPress(KeyEvent.VK_DOWN);
	            robot.keyRelease(KeyEvent.VK_DOWN);
	            robot.keyPress(KeyEvent.VK_SPACE);
	            robot.keyRelease(KeyEvent.VK_SPACE);
	        }
	    }
	}
	
	@And ("User click update button")
	public void User_click_update_button() {
		 WebElement updateButton = Driver.getInstance().findElement(By.xpath("//form/div[2]/div/div/button[1]"));
		    JavascriptExecutor executor = (JavascriptExecutor) Driver.getInstance();
		    executor.executeScript("arguments[0].click();", updateButton);
	}
	
	@Then("Page show event updated notification")
	public void Page_show_event_updated_notification() {
		assertEquals(Driver.getInstance().findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText(), "Successfully update Event");
		Driver.getInstance().close();
		Driver.deleteInstance();
	}
	
}
