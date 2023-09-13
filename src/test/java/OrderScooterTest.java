import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.userDetailsRent;
import pageObject.deteilsRent;

import java.time.Duration;



@RunWith(JUnitParamsRunner.class)
public class OrderScooterTest {
    private WebDriver webDriver;
    private userDetailsRent userDetailsRent;
    private deteilsRent deteilsRent;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        userDetailsRent = new userDetailsRent(webDriver);
        deteilsRent = new deteilsRent(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    @Parameters({
            "Василий, Петров, Улица таганская 13А, 89187430641"

    })
    public void orderScooterTest(String name, String surname, String address, String phone) {
        userDetailsRent.orderButtonClick();
        userDetailsRent.enterOrderName(name);
        userDetailsRent.enterOrderSurname(surname);
        userDetailsRent.enterOrderAddress(address);
        userDetailsRent.enterOrderNumberPhone(phone);
        userDetailsRent.enterOrderStationMetro();
        userDetailsRent.clickFirstStation();
        userDetailsRent.buttonFurtherClick();
        deteilsRent.clickImputDate();
        deteilsRent.datePickerClick();
        deteilsRent.timeRentClick();
        deteilsRent.rentalPeriodTimeClick();
        deteilsRent.checkboxColorScooterClick();
        deteilsRent.enterCommentImput("Ждун");
        deteilsRent.buttonOrderClick();
        deteilsRent.modalWindowToOrderClick();
        deteilsRent.waitForElementToBe();
    }
    @Test
    @Parameters({
            "Мария, Сидорова, Улица Гагарина 42, 89162345678"

    })
    public void orderScooterTestFromSecondButton(String name, String surname, String address, String phone) {
        userDetailsRent.scrollToOrderButtonSecond();
        userDetailsRent.orderButtonSecond();
        userDetailsRent.enterOrderName(name);
        userDetailsRent.enterOrderSurname(surname);
        userDetailsRent.enterOrderAddress(address);
        userDetailsRent.enterOrderNumberPhone(phone);
        userDetailsRent.enterOrderStationMetro();
        userDetailsRent.clickFirstStation();
        userDetailsRent.buttonFurtherClick();
        deteilsRent.clickImputDate();
        deteilsRent.datePickerClick();
        deteilsRent.timeRentClick();
        deteilsRent.rentalPeriodTimeClick();
        deteilsRent.checkboxColorScooterClick();
        deteilsRent.enterCommentImput("Ждун");
        deteilsRent.buttonOrderClick();
        deteilsRent.modalWindowToOrderClick();
        deteilsRent.waitForElementToBe();
    }
}


