import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Cats {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        ChromeDriver driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://suninjuly.github.io/cats.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //открываем драйвером нужную страницу
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//не явное время ожидание т.е. для всех
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //явное ожидание для конкретного элемента
        WebElement header = driver.findElement(By.className("jumbotron-heading"));  //чтобы работать с вебэлементами и находить их
        wait.until(ExpectedConditions.visibilityOf(header)); //ожидаем видимый header
        // header.getText(); вернет текстовое значение которое внутри этого элемента
        assertEquals("Cat memes", header.getText()); // dependencies junit
        driver.quit();
    }

}
