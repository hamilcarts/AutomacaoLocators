import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PraticandoClicks {

    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/botoes_atividade_selenium/";

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    void setupEach(){
        driver.get(URL);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


    @Test
    void clicandoComID(){
        WebElement element = driver.findElement(By.id("button1"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 1 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoComClassName(){
        WebElement element = driver.findElement(By.className("button-2"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 2 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoComName(){
        WebElement element = driver.findElement(By.name("button3"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 3 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoCSSSelector(){
        WebElement element = driver.findElement(By.cssSelector(".button-4"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 4 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoXpath(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"button5\"]"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 5 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoLivre(){
        WebElement element = driver.findElement(By.id("button6-switch"));
        element.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"button6\"]"));
        element2.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 6 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoLivreSemSelecionar(){
        fail();
        WebElement element = driver.findElement(By.id("button6-switch"));
        element.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"button6\"]"));
        element2.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O botão 6 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoLinkText(){
        WebElement element = driver.findElement(By.linkText("Link 1"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O link 1 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoPatialLinkText(){
        WebElement element = driver.findElement(By.partialLinkText("ink 2"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O link 2 foi selecionado.", alert.getText());
        alert.accept();
    }

    @Test
    void clicandoLinkLivre(){
        WebElement element = driver.findElement(By.id("link3"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("O link 3 foi selecionado.", alert.getText());
        alert.accept();
    }

}
