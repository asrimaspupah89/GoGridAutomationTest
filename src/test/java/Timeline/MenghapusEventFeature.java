package Timeline;


import Driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

//Author : Reihan Reinaldi Suryaman
//Date	: 22/04/2023
//Description : Testing GoGrids view event feature

public class MenghapusEventFeature {
    @When("user click on trash icon")
    public void userClickOnTrashIcon() {
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div/div/div/div[2]/h4")));
        WebElement element = Driver.getInstance().findElement(By.xpath("//*[name()='svg' and @data-v-76aa6b74]"));
        element.click();

        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-container")));
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-container")));
    }

    @Then("event is deleted")
    public void eventIsDeleted() {
        List<WebElement> elementList = Driver.getInstance().findElements(By.xpath("//*[name()='svg' and @data-v-31904c38]")).stream().toList();
        try{
            assertEquals(0, elementList.size());
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }
    }
}
