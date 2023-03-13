import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class Registration {
    ChromeDriver driver; // чтобы передавался между методами и внизу ChromeDriver удаляем и имели доступ к драйверу в каждом методе

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "http://suninjuly.github.io/registration1.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //не явное ожидание на всё происходящее
        driver.manage().window().maximize(); // разворачивание окна
    }

    //(//input[@class="form-control first"])[1]
    @Test
    public void onlyRequiredField() throws InterruptedException { //sleep add exception
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        Thread.sleep(1000);

        WebElement lastInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastInputField.sendKeys("Black");
        Thread.sleep(1000);

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("John@jam.com");
        Thread.sleep(1000);



        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.tagName("h1"));
        // assertEquals("Congratulations! You have successfully registered!", header.getText());
        assertTrue(header.getText().contains("Congratulations")); //если только часть текста
    }

    @Test
    public void allFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        Thread.sleep(1000);

        WebElement lastInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastInputField.sendKeys("Black");
        Thread.sleep(1000);

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("John@jam.com");
        Thread.sleep(1000);

        WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputField.sendKeys("12345");
        Thread.sleep(1000);

        WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        addressInputField.sendKeys("Puskin, 45");
        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.tagName("h1"));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        assertEquals("Congratulations! You have successfully registered!", header.getText());
        //assertTrue(header.getText().contains("Congratulations")); //если только часть текста

    }
    @Test
    public void notAllRequiredFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");

        WebElement lastInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastInputField.sendKeys("Black");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        assertFalse(driver.getCurrentUrl().contains("result")); // значит мы перешли на новую страницу, форма успешно добавилась
        WebElement header = driver.findElement(By.tagName("h1"));
        assertTrue(header.getText().contains("Registration"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
