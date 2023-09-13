package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class deteilsRent {
    private WebDriver driver;

    public deteilsRent(WebDriver webDriver){
        this.driver = webDriver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }
    private final By inputWhereBringScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    private final By datePicker = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]");

    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");

    private final By rentalPeriodTime = By.xpath(".//div[text()='сутки']");

    private final By checkboxColorScooter = By.xpath(".//input[@id='black']");

    private final By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

   private final By modalWindowToOrder = By.xpath(".//button[contains(text(), 'Да')]");

   private final By waitForElement = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ')]");
    // метод ожидания прогрузки данных профиля
//    public WebElement waitForElementToBe() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)); // Используем Duration
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

    public void waitForElementsToBeOrder() {
        By elementLocator = By.xpath("//div[@class='Order_Header__BZXOb']");
        WebElement element = waitForElementToBe(); // Ждем до 10 секунд
        // Теперь элемент доступен для взаимодействия

    }






    public void clickImputDate(){
        driver.findElement(inputWhereBringScooter).click();
    }
    public void datePickerClick(){
        driver.findElement(datePicker).click();
    }

    public void timeRentClick(){
        driver.findElement(rentalPeriod).click();
    }
    public void rentalPeriodTimeClick(){
        driver.findElement(rentalPeriodTime).click();
    }
    public void checkboxColorScooterClick(){
        driver.findElement(checkboxColorScooter).click();
    }
    public void enterCommentImput(String enterComment){
        driver.findElement(comment).sendKeys(enterComment);
    }
    public void buttonOrderClick(){
        driver.findElement(buttonOrder).click();
    }
    public void modalWindowToOrderClick(){
        driver.findElement(modalWindowToOrder).click();
    }
    // метод ожидания прогрузки данных профиля
    public WebElement waitForElementToBe() {
        long timeoutInSeconds = 10;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(waitForElement));
    }


}

