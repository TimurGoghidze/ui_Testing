import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class JavaScript {

    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/execute_script.html";
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void calculationTest() throws InterruptedException {
        double result = 0;
        WebElement xValue = driver.findElement(By.id("input_value"));
        result = funcCalc(parseDouble(xValue.getText()));

        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));

        WebElement robotCheckbox = driver.findElement(By.id("robotCheckbox"));
        robotCheckbox.click();

        WebElement robotsRule = driver.findElement(By.id("robotsRule"));
        JavascriptExecutor js = driver; // можно теперь обращаться к джава скриптам
        js.executeScript("arguments[0].scrollIntoView(true);", robotsRule);//подкатываем к цели
        robotsRule.click();

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


    }

    private double funcCalc(double x) {
        return log(abs(12 * sin(x)));
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
