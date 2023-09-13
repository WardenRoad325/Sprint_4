package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaqPage {
    private WebDriver driver;

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    public void scrollToAccordion() {
        WebElement faqElement = driver.findElement(By.cssSelector(".accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faqElement);

    }

    public void clickAccordionItem(int index) {
        By accordionItemLocator = By.cssSelector(".accordion__item");
        driver.findElements(accordionItemLocator).get(index).click();
    }

    public String getAccordionItemText(int index) {
        By accordionPanelLocator = By.cssSelector(".accordion__panel");
        return driver.findElements(accordionPanelLocator).get(index).getText();
    }
}

