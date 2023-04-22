import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtividadeWaits {
    static WebDriver driver;
    private static final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    private WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    //Sem Waits
    @Test
    public void alertButtonTest() {
        WebElement element = driver.findElement(By.id("alert"));
        element.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("I got opened after 5 secods", alert.getText());
        alert.accept();
    }

    //Wait Explicito
    @Test
    public void titleButtonTest() {
        WebElement titulo = driver.findElement(By.className("target-text"));
        Assertions.assertEquals("site", titulo.getText());
        driver.findElement(By.id("populate-text")).click();
        wait.until(ExpectedConditions.textToBe(By.className("target-text"), "Selenium Webdriver"));
        Assertions.assertEquals("Selenium Webdriver", titulo.getText());
    }

    @Test
    public void displayButtonTest() {
        driver.findElement(By.xpath("//*[@id=\"display-other-button\"]")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"hidden\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Wait Fluente
    @Test
    public void enableButtonTest() {
        WebElement element = driver.findElement(By.id("enable-button"));
        element.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
        WebElement disable = driver.findElement(By.id("disable"));
        Assertions.assertTrue(disable.isEnabled());
    }

    @Test
    public void checkBoxButtonTest() {
        WebElement element = driver.findElement(By.id("checkbox"));
        element.click();
        WebElement checkbox = driver.findElement(By.id("ch"));
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        Assertions.assertTrue(checkbox.isSelected());
    }
}
