import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticandoLocators {

    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/praticando_locators_selenium/";

    @BeforeAll
    public static void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterAll
    public static void afterEach(){
        driver.quit();
    }

    @Test
    public void locatorByID() {
        WebElement element = driver.findElement(By.id("locator-id"));
        Assertions.assertEquals("Achei com ID", element.getText());
    }

    @Test
    public void locatorByClassName() {
        WebElement element = driver.findElement(By.className("locator-class-name"));
        Assertions.assertEquals("Achei com Class Name", element.getText());
    }

    @Test
    public void locatorByName() {
        WebElement element = driver.findElement(By.name("locator-name"));
        Assertions.assertEquals("Achei com Name", element.getText());
    }

    @Test
    public void locatorByCSSSelector() {
        WebElement element = driver.findElement(By.cssSelector("#css-selector"));
        Assertions.assertEquals("Achei com CSS Selector", element.getText());

        WebElement element2 = driver.findElement(By.cssSelector(".css-selector-locator"));
        Assertions.assertEquals("Achei com CSS Selector", element2.getText());

        WebElement element3 = driver.findElement(By.cssSelector(".lead.css-selector-locator"));
        Assertions.assertEquals("Achei com CSS Selector", element3.getText());

        WebElement element4 = driver.findElement(By.cssSelector("p.lead.css-selector-locator"));
        Assertions.assertEquals("Achei com CSS Selector", element4.getText());

        WebElement element5 = driver.findElement(By.cssSelector("div p.lead.css-selector-locator"));
        Assertions.assertEquals("Achei com CSS Selector", element5.getText());
    }

    @Test
    public void locatorByLink() {
        WebElement element = driver.findElement(By.linkText("Achei com o link text"));
        Assertions.assertEquals("https://www.google.com/", element.getAttribute("href"));
    }

    @Test
    public void locatorByPartialLink() {
        WebElement element = driver.findElement(By.partialLinkText("Achei com o partial"));
        Assertions.assertEquals("https://github.com/", element.getAttribute("href"));
    }

    @Test
    public void locatorByTagName() {
        WebElement element = driver.findElement(By.tagName("details"));
        Assertions.assertEquals("Achei com Tag Name", element.getText());
    }

    @Test
    public void locatorByXPATH() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"locator-xpath\"]"));
        Assertions.assertEquals("Achei com o XPATH", element.getText());
    }
}
