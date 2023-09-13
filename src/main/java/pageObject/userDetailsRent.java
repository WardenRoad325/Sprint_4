package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userDetailsRent {
    WebDriver webDriver;

    public userDetailsRent(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("https://qa-scooter.praktikum-services.ru");

    }

    // нажимаем на кнопку заказать в шапке странице
    private final By orderButtonfirst = By.className("Button_Button__ra12g");
    private final By orderButtonSecond = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM')][text()='Заказать']");
    // Вводим в поле имя значение
    private final By orderNameImput = By.xpath("//input[@placeholder='* Имя']");
    // вводим в поля фамилие значение
    private final By orderSurnameImput = By.xpath("//input[@placeholder='* Фамилия']");
    //Вводим адресс
    private final By orderAddressImput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //нажимаем на плейсхолдер станции метро выпадает список
    private final By orderStationMetroImput = By.xpath("//input[@class='select-search__input']");
    //выбираем станцию метро
    private final By selectStation = By.xpath("//div[@class='select-search__select']//li[@class='select-search__row']");
    private final By orderNumberPhoneImput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By orderButtonFurther = By.xpath("//button[contains(text(), 'Далее')]");


    public void orderButtonSecond() {
        webDriver.findElement(orderButtonSecond).click();
    }

    public void orderButtonClick() {
        webDriver.findElement(orderButtonfirst).click();
    }

    public void enterOrderName(String orderName) {
        webDriver.findElement(orderNameImput).sendKeys(orderName);
    }

    public void enterOrderSurname(String orderSurname) {
        webDriver.findElement(orderSurnameImput).sendKeys(orderSurname);
    }

    public void enterOrderAddress(String orderAddress) {
        webDriver.findElement(orderAddressImput).sendKeys(orderAddress);
    }

    public void enterOrderStationMetro() {
        webDriver.findElement(orderStationMetroImput).click();
    }

    public void clickFirstStation() {
        webDriver.findElements(selectStation).stream().findFirst().get().click();
    }

    public void enterOrderNumberPhone(String orderNumberPhone) {
        webDriver.findElement(orderNumberPhoneImput).sendKeys(orderNumberPhone);
    }

    public void buttonFurtherClick() {
        webDriver.findElement(orderButtonFurther).click();
    }

    public void scrollToOrderButtonSecond() {
        WebElement faqElement = webDriver.findElement(By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM')][text()='Заказать']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", faqElement);

    }
}
