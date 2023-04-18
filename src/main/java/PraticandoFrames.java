import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticandoFrames {

    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/praticando_frames_popups_abas/";

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    void beforeEach(){
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Test
    void clicaBotaoFrame(){
        driver.switchTo().frame("meu-frame");
        WebElement element = driver.findElement(By.id("frame-btn"));
        element.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.switchTo().defaultContent();
        WebElement titulo = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Praticando Frames, Popups e Abas", titulo.getText());
    }

    @Test
    void abrirPopupNome(){
        driver.findElement(By.id("alert-btn")).click();
        driver.switchTo().window("meu-lindo-popup");
        driver.findElement(By.xpath("/html/body/button")).click();
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
    }

    @Test
    void abrirPopupHandle(){
        driver.findElement(By.id("alert-btn")).click();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.xpath("/html/body/button")).click();
        driver.switchTo().alert().dismiss();
        driver.close();
        driver.switchTo().defaultContent();
    }

    @Test
    void abrirNovaAba(){
        driver.findElement(By.linkText("Abrir nova aba")).click();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        WebElement titulo = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Praticando Frames, Popups e Abas", titulo.getText());
    }

}
