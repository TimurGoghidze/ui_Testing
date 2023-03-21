import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Frames {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://demoqa.com/frames";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void frameTest() {
        driver.switchTo().frame("frame1");//попадаем в первую рамку ныряем
        WebElement header1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(header1.getText()); // выводим текст

        driver.switchTo().parentFrame(); // out
        // driver.switchTo().defaultContent(); //or

        driver.switchTo().frame("frame2"); //вторая рамка
        WebElement header2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(header2.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
