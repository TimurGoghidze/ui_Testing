import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Cats {
    ChromeDriver driver; // чтобы передавался между методами и внизу ChromeDriver удаляем и имели доступ к драйверу в каждом методе

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe"); //экземляр класса
        driver = new ChromeDriver();//который позволяет нам взаимодействовать с браузером
        String BASE_URL = "https://suninjuly.github.io/cats.html"; // хорошей практикой выводить отдельной переменной
        driver.get(BASE_URL); //этот метод помогает открыть страницу в браузере
    }

    @Test
    public void checkHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //явное ожидание для конкретного элемента
        WebElement header = driver.findElement(By.className("jumbotron-heading"));  //чтобы работать с вебэлементами и находить их
        wait.until(ExpectedConditions.visibilityOf(header)); //ожидаем видимый header
        String expectedHeaderText = "Cat memes";
        assertEquals("This is not Elements does not contains text:" + expectedHeaderText, expectedHeaderText, header.getText()); // dependencies junit &
        // header.getText(); вернет текстовое значение которое внутри этого элемента
    }

    @Test
    public void checkCatsCardsQuantity() {
        List<WebElement> catsCards = driver.findElements(By.className("col-sm-4")); // нашли все карточки с котиками "s" большее кол-во
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ждем 10 секутд
        wait.until(ExpectedConditions.visibilityOf(catsCards.get(0))); //ожидаем  ожидаемые видимые карторчки с певой позиции т.е. 0
        assertEquals("Quantity of cat cads is not 6!", 6, catsCards.size()); // ожидаемо 6 штук
    }

    @Test
    public void checkDownCatText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameOfSecondCardCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(2) .card-body [class='card-text second']"));
        wait.until(ExpectedConditions.visibilityOf(nameOfSecondCardCat));
        String expectedHeaderText = "Serious cat";
        assertEquals( expectedHeaderText, nameOfSecondCardCat.getText());
    }

    @Test
    public void checkDownCatMemesText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement downCatMemesText = driver.findElement(By.cssSelector("#moto"));
        wait.until(ExpectedConditions.visibilityOf(downCatMemesText));
        String expectedText = "If there's one thing that the internet was made for, it's funny cat memes.";
        assertEquals( expectedText, downCatMemesText.getText());
    }
    @Test
    public void checkUpCatAlbum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tipUpCatsAlbum = driver.findElement(By.xpath("//strong[contains(text(),'Cats album')]"));
        wait.until(ExpectedConditions.visibilityOf(tipUpCatsAlbum));
        String expectedText = "Cats album";
        assertEquals( expectedText, tipUpCatsAlbum.getText());
    }
    //strong[contains(text(),'Cats album')]
    @Test
    public void checkEditButtonSixCat(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement editSixCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(6) .card-body [type='button']:nth-child(2)"));
        wait.until(ExpectedConditions.visibilityOf(editSixCat));
        String expectedText = "Edit";
        assertEquals(expectedText,editSixCat.getText());
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
