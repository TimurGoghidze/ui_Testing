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

import static org.junit.Assert.assertTrue;

public class FileUpload {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://suninjuly.github.io/file_input.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void uploadFileTest() {
        WebElement firstName = driver.findElement(By.cssSelector("[name='firstname']"));
        firstName.sendKeys("John");//заполним поле firstName
        WebElement lastName = driver.findElement(By.cssSelector("[name='lastname']"));
        lastName.sendKeys("Black"); //fill field lastName
        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys("johnblack@black.com"); // fill field email
        WebElement uploadFileButton = driver.findElement(By.id("file"));
        uploadFileButton.sendKeys("D:/text.txt");
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
