import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticandoWaitsSemWaits {
    static WebDriver driver;
    private final String URL = "https://igorsmasc.github.io/praticando_waits/";

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

    //Testando sem Wait
    @Test
    public void botaoEscondido() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-escondido"));
        Thread.sleep(5000);
        element.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Você clicou no botão escondido!", alert.getText());
    }
    @Test
    public void botaoAlertTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-alerta"));
        element.click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Alerta após 3 segundos!", alert.getText());
    }
    @Test
    public void botaoTituloTest() throws InterruptedException {
        WebElement titulo = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Título da Página", titulo.getText());
        WebElement element = driver.findElement(By.id("botao-titulo"));
        element.click();
        Thread.sleep(5000);
        Assertions.assertEquals("Novo Título da Página", titulo.getText());
    }
    @Test
    public void botaoParagrafoTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-paragrafo"));
        element.click();
        Thread.sleep(5000);
        WebElement titulo = driver.findElement(By.xpath("/html/body/p"));
        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", titulo.getText());
    }
    @Test
    public void botaoNovoTest() throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("botao-novo"));
        element.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Botão clicado!", alert.getText());
    }
}
