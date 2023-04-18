import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlerts {
    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/alertas_atividade_selenium/";

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
    void alertSimples() {
        WebElement botaoAlertSimples = driver.findElement(By.xpath("/html/body/div[1]/button[1]"));
        botaoAlertSimples.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Este é um alerta simples!", alert.getText());
        alert.accept();
    }
    @Test
    void alertConfirmacao() {
        WebElement botaoAlertConfirmacao = driver.findElement(By.xpath("/html/body/div[1]/button[2]"));
        botaoAlertConfirmacao.click();
        Alert alertConfirmacao = driver.switchTo().alert();

        Assertions.assertEquals("Tem certeza que deseja excluir este item?", alertConfirmacao.getText());

        alertConfirmacao.accept();

        Assertions.assertEquals("Item excluído com sucesso!", alertConfirmacao.getText());
        alertConfirmacao.accept();

    }

    @Test
    void alertConfirmacaoCancelar() {
        WebElement botaoAlertConfirmacao = driver.findElement(By.xpath("/html/body/div[1]/button[2]"));
        botaoAlertConfirmacao.click();
        Alert alertConfirmacao = driver.switchTo().alert();

        Assertions.assertEquals("Tem certeza que deseja excluir este item?", alertConfirmacao.getText());

        alertConfirmacao.dismiss();

        Assertions.assertEquals("A exclusão foi cancelada.", alertConfirmacao.getText());
        alertConfirmacao.accept();

    }

    @Test
    void alertEntrada() {
        WebElement botaoAlertSimples = driver.findElement(By.xpath("/html/body/div[1]/button[3]"));
        botaoAlertSimples.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, insira seu nome:", alert.getText());
        alert.sendKeys("Hamilcar");
        alert.accept();
        Assertions.assertEquals("Bem-vindo, Hamilcar!", alert.getText());
        alert.accept();
    }

    @Test
    void alertNaoFoiAberto() {

        try {
            Alert alert = driver.switchTo().alert();
            Assertions.fail();
        }catch (NoAlertPresentException e){
        }
    }

    @Test
    void naoFazNada() {
        Assertions.assertFalse(existeAlertaAberto());
    }

    private boolean existeAlertaAberto(){
        try {
            Alert alert = driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }
}
