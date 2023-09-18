package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FaqPage {
    private WebDriver driver;

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    public void scrollToAccordion() {
        WebElement faqElement = driver.findElement(By.cssSelector("div[data-accordion-component='Accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faqElement);

    }

    public FaqPage checkImportantQuestionsText(int paramSelect, int paramContent, String changed) {
        driver.findElement(By.xpath(".//div[@id='accordion__heading-" + paramSelect + "']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@aria-labelledby='accordion__heading-" + paramContent + "']"), changed));
        return new FaqPage(driver);
    }
}

