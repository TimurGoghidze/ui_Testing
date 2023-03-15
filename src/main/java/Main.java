import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        WebElement buttonCancel = driver.findElement(By.cssSelector("[id='W0wltc']"));
        buttonCancel.click();


        WebElement searchBar = driver.findElement(By.cssSelector("[name='q']"));
        searchBar.sendKeys("bicycle");

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));
        WebElement searchButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));

        searchButton.click();
    }

}