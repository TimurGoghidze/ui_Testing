import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.google.common.base.Predicates.contains;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class InsideTracker {
    ChromeDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://qa.segterra.com/"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @Test
    public void followLink() throws InterruptedException {
        WebElement HIPPAlink = driver.findElement(By.cssSelector("[data-test-id='company-hipaa']"));
        HIPPAlink.click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles()); //из всего списка вкладок выберет нужную
        driver.switchTo().window(handles.get(1));//тут кликнет не следующую
//      WebElement messageInNewTab = driver.findElement(By.id("sampleHeading"));
//      assertTrue(messageInNewTab.isDisplayed()); // one more variant
        WebElement HippaText = driver.findElement(By.id("hs_cos_wrapper_name"));
        assertTrue(HippaText.getText().contains("HIPAA"));
        assertTrue(driver.getCurrentUrl().contains("hipaa-compliant")); // на наличие куска ссылки

        //driver.close(); // закрывает текущую вкладку
//        driver.switchTo().window(handles.get(0));// переход на нулевую вкладку
//        WebElement FAQlink = driver.findElement(By.cssSelector("[data-test-id='company-faq']"));
//        FAQlink.click();
//        driver.switchTo().window(handles.get(2)); //через одну прыжок
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
