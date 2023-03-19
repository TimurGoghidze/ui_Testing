import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class DropDown {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "http://suninjuly.github.io/selects1.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTest() {
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        int sum = (parseInt(num1.getText())+parseInt(num2.getText()));

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        dropDown.click();

        WebElement answerOption = driver.findElement(By.cssSelector("[value='"+sum +"']"));
        answerOption.click();

        WebElement submitButton = driver.findElement(By.cssSelector("[type='Submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Alert text:" + alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
        alert.accept();

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}



