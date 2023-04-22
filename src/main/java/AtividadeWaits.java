import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtividadeWaits {
    static WebDriver driver;
    private static final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    private WebDriverWait wait;
    private Wait<WebDriver> waitFluente;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @BeforeEach
//    void beforeEach(){
//    utilizado através dos métodos, para testar ambos na mesma classe
//    }


    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    //Sem Waits
    @Test
    public void alertButtonTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("alert"));
        element.click();
        Thread.sleep(5500);
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("I got opened after 5 secods", alert.getText());
        alert.accept();
    }

    //Wait Explicito
    @Test
    public void titleButtonTest() {
        beforWaitExplicito();
        WebElement titulo = driver.findElement(By.className("target-text"));
        Assertions.assertEquals("site", titulo.getText());
        driver.findElement(By.id("populate-text")).click();
        wait.until(ExpectedConditions.textToBe(By.className("target-text"), "Selenium Webdriver"));
        Assertions.assertEquals("Selenium Webdriver", titulo.getText());
    }

    @Test
    public void displayButtonTest() {
        beforWaitExplicito();
        driver.findElement(By.xpath("//*[@id=\"display-other-button\"]")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"hidden\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Wait Fluente
    @Test
    public void enableButtonTest() {
        beforWaitFluente();
        WebElement element = driver.findElement(By.id("enable-button"));
        element.click();
        waitFluente.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
        WebElement disable = driver.findElement(By.id("disable"));
        Assertions.assertTrue(disable.isEnabled());
    }

    @Test
    public void checkBoxButtonTest() {
        beforWaitFluente();
        WebElement element = driver.findElement(By.id("checkbox"));
        element.click();
        WebElement checkbox = driver.findElement(By.id("ch"));
        waitFluente.until(ExpectedConditions.elementToBeSelected(checkbox));
        Assertions.assertTrue(checkbox.isSelected());
    }

    private void beforWaitExplicito() {
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void beforWaitFluente() {
        waitFluente = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        driver.get(URL);
    }
}
