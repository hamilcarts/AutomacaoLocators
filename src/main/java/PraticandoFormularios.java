import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticandoFormularios {

    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/formularios_atividade_selenium/";

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
    void campoTexto(){
        WebElement element = driver.findElement(By.id("campoTexto"));
        element.sendKeys("Maria");
    }
    @Test
    void campoData(){
        WebElement element = driver.findElement(By.id("campoData"));
        element.sendKeys("17/04/2023");
    }
    @Test
    void campoSenha(){
        WebElement element = driver.findElement(By.id("campoSenha"));
        element.sendKeys("17/04/2023");
    }

    @Test
    void campoNumero(){
        WebElement element = driver.findElement(By.id("campoNumero"));
        element.sendKeys("17/04/2023");
    }
    @Test
    void campoTextoLongo(){
        WebElement element = driver.findElement(By.id("campoTextoLongo"));
        element.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
    }

    @Test
    void campoHora(){
        WebElement element = driver.findElement(By.id("campoHora"));
        element.sendKeys("2020");
    }

    @Test
    void campoEmail(){
        WebElement element = driver.findElement(By.id("campoEmail"));
        element.sendKeys("hamilcarts@hotmail.com");
    }
    @Test
    void campoURL(){
        WebElement element = driver.findElement(By.id("campoUrl"));
        element.sendKeys("https://www.google.com");
    }
    @Test
    void cadastro1(){
        WebElement texto = driver.findElement(By.id("campoTexto"));
        texto.sendKeys("Hamilcar");
        WebElement senha = driver.findElement(By.id("campoSenha"));
        senha.sendKeys("123abc");
        WebElement numero = driver.findElement(By.id("campoNumero"));
        numero.sendKeys("12345678");
        WebElement textoLongo = driver.findElement(By.id("campoTextoLongo"));
        textoLongo.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        WebElement data = driver.findElement(By.id("campoData"));
        data.sendKeys("17/04/2022");
        WebElement hora = driver.findElement(By.id("campoHora"));
        hora.sendKeys("0052");
        WebElement email = driver.findElement(By.id("campoEmail"));
        email.sendKeys("hamilcarts@hotmail.com");
        WebElement url = driver.findElement(By.id("campoUrl"));
        url.sendKeys("https://www.google.com");
        WebElement botaoEnviar = driver.findElement(By.xpath("//*[@id=\"formulario\"]/button"));
        botaoEnviar.click();
//        WebElement form = driver.findElement(By.id("formulario"));
//        form.submit();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Você preencheu tudo corretamente e é sua última resposta?", alert.getText());
        alert.accept();
        WebElement campoTexto = driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr/td[1]"));
        Assertions.assertEquals("Hamilcar", campoTexto.getText());
        WebElement campoHora = driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr/td[6]"));
        Assertions.assertEquals("00:52", campoHora.getText());

    }
    @Test
    void cadastro2(){
        WebElement texto = driver.findElement(By.id("campoTexto"));
        texto.sendKeys("Hamilcar");
        WebElement senha = driver.findElement(By.id("campoSenha"));
        senha.sendKeys("123abc");
        WebElement numero = driver.findElement(By.id("campoNumero"));
        numero.sendKeys("12345678");
        WebElement textoLongo = driver.findElement(By.id("campoTextoLongo"));
        textoLongo.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        WebElement data = driver.findElement(By.id("campoData"));
        data.sendKeys("17/04/2022");
        WebElement hora = driver.findElement(By.id("campoHora"));
        hora.sendKeys("0052");
        WebElement email = driver.findElement(By.id("campoEmail"));
        email.sendKeys("hamilcarts@hotmail.com");
        WebElement url = driver.findElement(By.id("campoUrl"));
        url.sendKeys("httpswwwgooglecom");
        WebElement botaoEnviar = driver.findElement(By.xpath("//*[@id=\"formulario\"]/button"));
        botaoEnviar.click();
        String message = url.getAttribute("validationMessage");
        Assertions.assertEquals("Insira um URL.", message);
    }
    @Test
    void cadastro3(){
        WebElement texto = driver.findElement(By.id("campoTexto"));
        texto.sendKeys("Hamilcar");
        WebElement senha = driver.findElement(By.id("campoSenha"));
        senha.sendKeys("123abc");
        WebElement numero = driver.findElement(By.id("campoNumero"));
        numero.sendKeys("12345678");
        WebElement textoLongo = driver.findElement(By.id("campoTextoLongo"));
        textoLongo.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        WebElement data = driver.findElement(By.id("campoData"));
        data.sendKeys("17/04/2022");
        WebElement hora = driver.findElement(By.id("campoHora"));
        hora.sendKeys("0052");
        WebElement email = driver.findElement(By.id("campoEmail"));
        email.sendKeys("hamilcartshotmailcom");
        WebElement url = driver.findElement(By.id("campoUrl"));
        url.sendKeys("https://www.google.com");
        WebElement botaoEnviar = driver.findElement(By.xpath("//*[@id=\"formulario\"]/button"));
        botaoEnviar.click();
        String message = email.getAttribute("validationMessage");
        Assertions.assertEquals("Inclua um \"@\" no endereço de e-mail. \"hamilcartshotmailcom\" está com um \"@\" faltando.", message);
    }
}
