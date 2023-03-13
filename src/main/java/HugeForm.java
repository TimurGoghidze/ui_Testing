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
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class HugeForm {
    ChromeDriver driver; // чтобы передавался между методами и внизу ChromeDriver удаляем и имели доступ к драйверу в каждом методе

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "http://suninjuly.github.io/huge_form.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //не явное ожидание на всё происходящее
        driver.manage().window().maximize(); // разворачивание окна
    }

    @Test
    public void allFields() throws InterruptedException{
        List<WebElement> inputFields = driver.findElements(By.tagName("input")); // на случай если целый список с похожим указателями
        for(WebElement input: inputFields) { //конструкция for, WebElement , обзываем переменной кот. содерж в каждой коллекции и вставляем в поля
            input.sendKeys("slvnsjklvnlf"); // send some information
        }
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // явное ожидание
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); //wait until expected Alert appear
        System.out.println("Alert text: " + alert.getText());// вытянем алерт
        assertTrue(alert.getText().contains("Congrats, you've passed the task!")); //accept contains
        alert.accept(); //click ok on alert


    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

