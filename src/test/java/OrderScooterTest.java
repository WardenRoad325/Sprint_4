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
            "Василий, Петров, Улица таганская 13А, 89187430641",
            "Андрей, Васильевич, Улица Мира 122, 89282307504",
            "Елена, Сидорова, Первомайская 5, 89051234567",
            "Иван, Иванов, Ленина 25, 89998887766",
            "Ольга, Смирнова, Профсоюзная 8, 89601112233"

    })
    public void orderScooterTestFromUpButton(String name, String surname, String address, String phone) {
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
            "Мария, Сидорова, Улица Гагарина 42, 89162345678",
            "Андрей, Козлов, Пушкинская 10, 89172345678",
            "Мария, Федорова, Гагарина 7, 89993332211",
            "Сергей, Морозов, Московская 3, 89001112233",
            "Анна, Павлова, Красноармейская 12, 89199998877",
            "Дмитрий, Григорьев, Лермонтовская 15, 89005557788"

    })
    public void orderScooterTestFromDownButton(String name, String surname, String address, String phone) {
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


