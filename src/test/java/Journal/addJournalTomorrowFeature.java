package Journal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class addJournalTomorrowFeature {
    WebDriver drivers = null;

    @Given("browsers is open")
    public void browsers_is_open(){
        System.setProperty("webdriver.chrome.driver", "D:\\Kuliah\\Semester 6\\APPL2\\CucumberJava - Copy\\src\\test\\Resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        drivers = new ChromeDriver(options);

        drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        drivers.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
    }
    @And ("users is on login page")
    public void user_is_on_login_page() {
        drivers.navigate().to("http://go-grids.site/");
    }
    @When ("users enters {word} and {word}")
    public void users_enters_Username_and_Password(String Username, String Password) {
        drivers.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys("kuncenaman");
        drivers.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/div[1]/div/div/div[3]/input")).sendKeys("Lima12345");
    }
    @And("click on login button")
    public void click_on_login_button() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button/span[3]")).click();
    }
    @Then ("user is navigated to the home pages")
    public void user_is_navigated_to_the_home_pages() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div")).isDisplayed();
        drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        drivers.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @And("click on date tomorrow")
    public void click_on_date_tomorrow() {
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div[4]/div[5]/div")).click();
    }
    @And("click add grid journal")
    public void click_add_grid_journal() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/button/span[3]")).click();
    }
    @When ("user enter question and answer")
    public void user_enters_Question_and_Answer() {
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div[2]/div/div/div[1]/div/div/div[3]/input")).sendKeys("test1");
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/textarea")).sendKeys("coba1");
    }

    @When ("user enter {string} and {string}")
    public void user_enters_Question_and_Answer(String question, String answer) {
        if (!question.equals("<blank>")) drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div[2]/div/div/div[1]/div/div/div[3]/input")).sendKeys(question);
        if (!answer.equals("<blank>")) drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/textarea")).sendKeys(answer);
    }
    @And("click on submit button")
    public void click_on_submit_button() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div[2]/div/form/button/span[3]")).click();
    }
    @Then ("users is navigated to the home pages")
    public void users_is_navigated_to_the_home_pages() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div")).isDisplayed();
    }
    @And("click on date tomorrow2")
    public void click_on_date_tomorrow2() {
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div[4]/div[5]/div")).click();
    }
}