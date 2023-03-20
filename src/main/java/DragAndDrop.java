import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Watchable;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class DragAndDrop {
    ChromeDriver driver;

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
    public void dragAndDropTest() throws InterruptedException {
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform(); //первый способ
        // actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().build().perform(); //второй способ
        WebElement title = driver.findElement(By.id ("Dropped"));
        assertTrue(title.getText().contains("Dropped"));




    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
