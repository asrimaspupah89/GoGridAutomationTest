package Calendar;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import Driver.Driver;

public class MenghapusEventCalendar {
	
	@Given("browser open")
	public void browser_is_open() {
	    Driver.getInstance();
	}

	@And("user on calendar page")
	public void user_is_on_calendar_page() {
		Driver.getInstance().navigate().to("http://go-grids.site/");
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys("zahwaaaa8");
		Driver.getInstance().findElement(By.xpath("//input[@type='password']")).sendKeys("Rendang8");
		Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")).click();
	    Driver.getInstance().findElement(By.cssSelector("[href=\"/calendar\"]")).click();
	}
	
	@When("user clicks event Calendar {string}")
	public void user_clicks_event_Calendar(String event) {
	    Driver.getInstance().findElement(By.xpath("//div[@class='fc-daygrid-day-events']//div[@class='fc-event-title'][text()= \"" + event+ "\"]")).click();
	}
	
	@And("user clicks Delete")
	public void user_clicks_on_Delete() {
		Driver.getInstance().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/div/button[2]/span[3]")).click();
	}
	
	@Then("page show event created notifications")
	public void page_show_event_created_notification() {
		assertEquals(Driver.getInstance().findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText(), "Successfully delete your Event");
	}
}
