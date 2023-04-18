import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtividadeCalculadora {
    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/calculadora_atividade_selenium/";

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
    void somar() {
        clickOne();
        clickAdd();
        clickFour();
        clickEquals();
        assertEquals("5.0", displayResult());
    }

    @Test
    void subtrair() {
        clickNine();
        clickFour();
        clickSubtract();
        clickFour();
        clickTwo();
        clickEquals();
        assertEquals("52.0", displayResult());
    }

    @Test
    void dividir() {
        clickFive();
        clickZero();
        clickDivide();
        clickOne();
        clickZero();
        clickEquals();
        assertEquals("5.0", displayResult());
    }
    @Test
    void dividirPorZero() {
        clickFive();
        clickZero();
        clickDivide();
        clickZero();
        clickEquals();
        assertEquals("Infinity", displayResult());
    }
    @Test
    void multiplicar() {
        clickThree();
        clickZero();
        clickMultiply();
        clickTwo();
        clickNine();
        clickEquals();
        assertEquals("870.0", displayResult());
    }
    @Test
    void multiplicarPorZero() {
        clickThree();
        clickZero();
        clickMultiply();
        clickZero();
        clickEquals();
        assertEquals("0.0", displayResult());
    }
    @Test
    void multiplicarDividir() {
        clickThree();
        clickZero();
        clickMultiply();
        clickSix();
        clickDivide();
        clickNine();
        clickEquals();
        assertEquals("20.0", displayResult());
    }
    @Test
    void somarClearSubtrair() {
        clickEight();
        clickZero();
        clickAdd();
        clickSix();
        clickEquals();
        assertEquals("86.0", displayResult());
        clickClear();
        clickThree();
        clickSubtract();
        clickOne();
        clickEquals();
        assertEquals("2.0", displayResult());
    }




    private void clickZero(){
        WebElement button = driver.findElement(By.id("zero"));
        button.click();
    }
    private void clickOne(){
        WebElement button = driver.findElement(By.id("one"));
        button.click();
    }

    private void clickTwo(){
        WebElement button = driver.findElement(By.id("two"));
        button.click();
    }
    private void clickThree(){
        WebElement button = driver.findElement(By.id("three"));
        button.click();
    }
    private void clickFour(){
        WebElement button = driver.findElement(By.cssSelector("#four.btn.btn-primary"));
        button.click();
    }
    private void clickFive(){
        WebElement button = driver.findElement(By.cssSelector("#five.btn.btn-primary"));
        button.click();
    }
    private void clickSix(){
        WebElement button = driver.findElement(By.cssSelector("#six.btn.btn-primary"));
        button.click();
    }
    private void clickSeven(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"seven\"]"));
        button.click();
    }
    private void clickEight(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"eight\"]"));
        button.click();
    }
    private void clickNine(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"nine\"]"));
        button.click();
    }
    private void clickAdd(){
        WebElement buttonAdd = driver.findElement(By.id("add"));
        buttonAdd.click();
    }
    private void clickSubtract(){
        WebElement buttonAdd = driver.findElement(By.id("subtract"));
        buttonAdd.click();
    }
    private void clickMultiply(){
        WebElement buttonAdd = driver.findElement(By.id("multiply"));
        buttonAdd.click();
    }
    private void clickDivide(){
        WebElement buttonAdd = driver.findElement(By.id("divide"));
        buttonAdd.click();
    }
    private void clickClear(){
        WebElement buttonAdd = driver.findElement(By.id("clear"));
        buttonAdd.click();
    }
    private void clickEquals(){
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
    }
    private String displayResult(){
        WebElement display = driver.findElement(By.id("display"));
        return Double.toString(Double.parseDouble(display.getAttribute("value")));

    }

}
