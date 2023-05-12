package Journal;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import org.openqa.selenium.By;

import Driver.Driver;

public class MemperbaruiJournalFeature {
	private String question;
	private String answer;

	@Given ("Browser is open")
	public void Browser_is_open() {
	    Driver.getInstance();
	}
	
	@And ("User is on dashboard")
	public void User_is_on_dashboard() {
		Driver.getInstance().navigate().to("http://go-grids.site/");
		Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys("syahdafia");
		Driver.getInstance().findElement(By.xpath("//input[@type='password']")).sendKeys("Syahdacantik7");
		Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@When("User click journal {string} on dashboard")
	public void User_click_journal_journalName_on_dashboard(String journalName) {
	    Driver.getInstance().findElement(By.xpath("//div[@class='v-card-item__content']//div[@class='v-card-title gridTitle'][text()= \"" + journalName + "\"]")).click();
	    
	}
	
	@And ("User update journal {string}")
	public void User_update_journal_question(String question) {
		this.question = question;
		Driver.getInstance().findElement(By.xpath("//*[@id=\"swal-input1\"]")).sendKeys(question);
	}
	
	@And ("User update {string}")
	public void User_update_answer(String answer) {
		this.answer = answer;
		Driver.getInstance().findElement(By.xpath("//*[@id=\"swal-input2\"]")).sendKeys(answer);
	}
	
	@And ("User click simpan button")
	public void User_click_simpan_button() {
		Driver.getInstance().findElement(By.xpath("//button[text()='Simpan']")).click();
	}
	
	@Then("Page show journal updated notification")
	public void Page_show_journal_updated_notification() {
		Driver.getInstance().findElement(By.xpath("//button[text()='OK']")).click();
		Driver.getInstance().close();
		Driver.deleteInstance();
	}
	
}
