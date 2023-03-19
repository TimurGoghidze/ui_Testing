import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Watchable;
import java.time.Duration;

public class DragAndDrop {
    ChromeDriver driver

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://crossbrowsertesting.github.io/drag-and-drop.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDropTest(){
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
