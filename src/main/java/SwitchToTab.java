import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static io.qameta.allure.internal.shadowed.jackson.core.io.NumberInput.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static org.junit.Assert.assertTrue;

public class SwitchToTab {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://suninjuly.github.io/redirect_accept.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void switchToAnotherTab() {
        WebElement button = driver.findElement(By.cssSelector("[type='submit']"));
        button.click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles()); //из всего списка вкладок выберет нужную
        driver.switchTo().window(handles.get(1)); // переход на нужную по нумерации нужна вторая = 0,1,2
        WebElement xValue = driver.findElement(By.id("input_value"));
        double x = parseDouble(xValue.getText()); // преобразование xValue -> x
        double result = log(abs(sin(x) * 12)); // формула

        WebElement answerField = driver.findElement(By.id("answer"));
        answerField.sendKeys(String.valueOf(result)); // преобразование

        WebElement buttonSubmit = driver.findElement(By.cssSelector("[type='submit']"));
        buttonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
