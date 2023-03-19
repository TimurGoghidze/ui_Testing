import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class HoverPage {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://crossbrowsertesting.github.io/hover-menu.html#"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void hoverOverTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//li[@class='dropdown']/a")); //a sun
        Actions actions = new Actions(driver);// class with hover over
        actions.moveToElement(dropdown).perform();// class+action+do it


        WebElement secondaryMenu = driver.findElement(By.cssSelector("[class='secondary-dropdown']>a"));
        actions.moveToElement(secondaryMenu).perform();

        WebElement secondaryAction = driver.findElement(By.cssSelector("[class='dropdown-menu secondary']"));
        secondaryAction.click();

        WebElement headerSecondMenu = driver.findElement(By.cssSelector("div.jumbotron.secondary-clicked > h1"));
        assertTrue(headerSecondMenu.getText().contains("Secondary Page"));
        sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
