import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.ous.jtoml.impl.Token.TokenType.Key;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BirthdayForm {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://demo.guru99.com/test/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize(); // разворачивание окна
    }

    @Test
    public void dateAndTime() throws InterruptedException {
        sleep(2000);
        driver.switchTo().frame("gdpr-consent-notice");
        WebElement acceptCoockies = driver.findElement(By.id("save"));
        acceptCoockies.click();

        WebElement dataInput = driver.findElement(By.cssSelector("[type='datetime-local']"));
        dataInput.sendKeys("03.04.1987", Keys.ARROW_RIGHT, "03.25"); //to the right

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        assertTrue(driver.getCurrentUrl().contains("birthdate"));

    }
    @Test
    public void invalidDate() throws InterruptedException{
        WebElement datepicker = driver.findElement(By.cssSelector("[name='bdaytime']"));
        datepicker.sendKeys("1010");
        WebElement submitbutton = driver.findElement(By.cssSelector("[type='submit']"));
        submitbutton.click();
        assertTrue(datepicker.getAttribute("validationMessage").contains("Введите верное значение"));
        assertFalse(driver.getCurrentUrl().contains("birthdate"));
    assertTrue(submitbutton.isDisplayed() );
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

