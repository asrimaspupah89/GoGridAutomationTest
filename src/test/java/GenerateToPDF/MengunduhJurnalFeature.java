package GenerateToPDF;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import Driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MengunduhJurnalFeature {	
	@Given("user is on export page")
	public void user_is_on_export_page() {
	    // Write code here that turns the phrase above into concrete actions
		Driver.getInstance().navigate().to("http://103.172.204.236:5173/");
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys("Orion2805");
		Driver.getInstance().findElement(By.xpath("//input[@type='password']")).sendKeys("Orion12345");
		Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")).click();
	    Driver.getInstance().findElement(By.cssSelector("[href=\"/export\"]")).click();
	}

	@When("user clicks on generate pdf button")
	public void user_clicks_on_generate_pdf_button() throws InterruptedException {
		Driver.getInstance().findElement(By.xpath("//a[contains(text(), ' generate to PDF ')]")).click();
		Thread.sleep(500);
	}
	
	@Then("page show pdf generated notification")
	public void page_show_pdf_generated_notification() {
		assertEquals(Driver.getInstance().findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText(), "PDF has been generated");
		Driver.getInstance().close();
		Driver.deleteInstance();
	}
}
