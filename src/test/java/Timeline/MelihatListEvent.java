package Timeline;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MelihatListEvent {
    @Then("user should not be able to see any event")
    public void userShouldNotBeAbleToSeeAnyEvent() {
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[2]/h4")));
        List<WebElement> elementList = Driver.getInstance().findElements(By.xpath("//*[name()='svg' and @data-v-31904c38]")).stream().toList();

        try{
            assertEquals(0, elementList.size());
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }

    }

    @And("user is on home page")
    public void userIsOnHomePage() {
        Driver.getInstance().navigate().to("http://go-grids.site/");
        Driver.getInstance().findElement(By.xpath("//input[@type='text']")).sendKeys("reinaldi28");
        Driver.getInstance().findElement(By.xpath("//input[@type='password']")).sendKeys("GoGrid123");
        Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
        Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[2]/div[3]/form/div/div[2]/button")).click();
    }

    @When("user click on timeline menu")
    public void userClickOnTimelineMenu() {
        WebElement element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")));
        element.click();
        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href=\"/tables\"]")));
        element.click();
    }

    @And("there is already one event entered")
    public void thereIsAlreadyOneEventEntered() {
        WebElement element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")));
        element.click();

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href=\"/calendar\"]")));
        element.click();

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("fc-day-future")));
        element.click();

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input-15\"]")));
        element.sendKeys("Event Name Test");

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/button[1]")));
        element.click();

        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-container")));
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-container")));

    }

    @Then("user should be able to see {int} event")
    public void userShouldBeAbleToSeeEvent(int eventCount) {
        WebElement element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[2]/h4")));
        List<WebElement> elementList = Driver.getInstance().findElements(By.xpath("//*[name()='svg' and @data-v-31904c38]")).stream().toList();

        try{
            assertEquals(eventCount, elementList.size());
        } catch (Exception e){
            Driver.getInstance().close();
            Driver.deleteInstance();
        }

        elementList.forEach(webElement -> {
            try{
                webElement.click();
            } catch (StaleElementReferenceException e){
                Driver.getInstance().findElement(By.xpath("//*[name()='svg' and @data-v-31904c38]")).click();
            }

            new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-container")));
            new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-container")));
        });

        Driver.getInstance().close();
        Driver.deleteInstance();
    }

    @And("there is already two events entered")
    public void thereIsAlreadyTwoEventsEntered() {
        WebElement element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div/header/div/div[1]/button")));
        element.click();

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href=\"/calendar\"]")));
        element.click();

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("fc-day-future")));
        element.click();

        WebElement event = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        event.sendKeys("Event Name Test");

        WebElement submit = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/button[1]")));
        submit.click();

        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-container")));
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-container")));

        element = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("fc-day-future")));
        element.click();

        event = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        event.sendKeys("Event Name Test 2");

        submit = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/button[1]")));
        submit.click();

        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-container")));
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-container")));
    }
}
