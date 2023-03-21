import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SwitchToTab2 {
ChromeDriver driver;
    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://demoqa.com/browser-windows"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void browserWindows(){
        WebElement buttonNewTab = driver.findElement(By.id("tabButton"));
        buttonNewTab.click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles()); //из всего списка вкладок выберет нужную
        driver.switchTo().window(handles.get(1));//тут кликнет не следующую
        WebElement messageInNewTab = driver.findElement(By.id("sampleHeading"));
        assertTrue(messageInNewTab.isDisplayed());

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
