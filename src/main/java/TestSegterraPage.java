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

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;

import static org.junit.Assert.assertTrue;

public class TestSegterraPage {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "http://suninjuly.github.io/get_attribute.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
    }

    public double funCalc(double x) {
        return log(abs(12 * sin(x)));
    }

//    @Test
//    public void calculationTest() throws InterruptedException { // для "http://suninjuly.github.io/math.html"
//        WebElement x = driver.findElement(By.id("input_value"));
//        double result = funCalc(parseDouble(x.getText())); //переменная
//        WebElement answerInputField = driver.findElement(By.id("answer"));
//        answerInputField.sendKeys(String.valueOf(result)); // преобразование в строке с double
//
//        WebElement clickImRobot = driver.findElement(By.id("robotCheckbox"));
//        clickImRobot.click();
//
//        WebElement clickRobotRule = driver.findElement(By.id("robotsRule"));
//        clickRobotRule.click();
//
//        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@class ='btn btn-default']"));
//        buttonSubmit.click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//        System.out.println("Alert text:" + alert.getText());
//        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
//        alert.accept();
//        sleep(10000);
//
//    }

    @Test
    public void calculationTest2() throws InterruptedException { //в сундучке
        WebElement x = driver.findElement(By.id("treasure"));
        double result; //переменная
        result = funCalc(parseDouble(x.getAttribute("valuex")));
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result)); // преобразование в строке с double

        WebElement clickImRobot = driver.findElement(By.id("robotCheckbox"));
        clickImRobot.click();

        WebElement clickRobotRule = driver.findElement(By.id("robotsRule"));
        clickRobotRule.click();

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@class ='btn btn-default']"));
        sleep(5000);
        buttonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Alert text:" + alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
        alert.accept();
        sleep(10000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
