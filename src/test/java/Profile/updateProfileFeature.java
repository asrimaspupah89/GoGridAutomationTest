package Profile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class updateProfileFeature {
    WebDriver drivers = null;

    @Given("browsers is open")
    public void browsers_is_open() {
        System.setProperty("webdriver.chrome.driver", "D:\\Kuliah\\Semester 6\\APPL2\\CucumberJava - Copy\\src\\test\\Resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        drivers = new ChromeDriver(options);

        drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        drivers.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
    }

    @And("users is on login page")
    public void user_is_on_login_page() {
        drivers.navigate().to("http://go-grids.site/");
    }

    @When("users enters {word} and {word}")
    public void users_enters_Username_and_Password(String Username, String Password) {
        drivers.findElement(By.xpath("//*[@id=\"input-0\"]")).sendKeys("kuncenaman");
        drivers.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/div[1]/div/div/div[3]/input")).sendKeys("Lima12345");
    }

    @And("click on login button")
    public void click_on_login_button() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button/span[3]")).click();
    }

    @Then("user is navigated to the home pages")
    public void user_is_navigated_to_the_home_pages() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div")).isDisplayed();
        drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        drivers.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @And("click on profile picture")
    public void click_on_profile_picture() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/img")).click();
    }

    @And("click on setting button")
    public void click_on_setting_button() {
        drivers.findElement(By.xpath("/html/body/div[2]/div/div/div/a")).click();
    }

    @When("user enter firstname and lastname")
    public void user_enters_Firstname_and_Lastname() {
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[1]/div/div/div/div[3]/input")).clear();
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[2]/div/div/div/div[3]/input")).clear();
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[1]/div/div/div/div[3]/input")).sendKeys("kuncen");
        drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[2]/div/div/div/div[3]/input")).sendKeys("aman");
    }

    @When("user enter {string} and {string}")
    public void user_enters_Question_and_Answer(String firstname, String lastname) {
        if (!firstname.equals("<blank>")) drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[1]/div/div/div/div[3]/input")).clear();
        if (!lastname.equals("<blank>")) drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[2]/div/div/div/div[3]/input")).clear();
        if (!firstname.equals("<blank>")) drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[1]/div/div/div/div[3]/input")).sendKeys(firstname);
        if (!lastname.equals("<blank>")) drivers.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div/div/div/div/div/div[3]/form/div[2]/div[2]/div/div/div/div[3]/input")).sendKeys(lastname);
    }

    @And("click on save button")
    public void click_on_submit_button() {
        drivers.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div/div[5]/form/div[2]/div[2]/div/button/span[3]")).click();
    }
}
