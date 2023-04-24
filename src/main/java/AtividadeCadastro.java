import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class AtividadeCadastro {
    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/fomulario_cadastro_selenium/";

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
    void cadastroCompletoTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Você preencheu tudo corretamente e é sua última resposta?", alert.getText());
        alert.accept();
        Assertions.assertEquals("Hamilcar", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[1]")).getText());
        Assertions.assertEquals("Tortora da Silva", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[2]")).getText());
        Assertions.assertEquals("masculino", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[3]")).getText());
        Assertions.assertEquals("Backend, Testes", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[4]")).getText());
        Assertions.assertEquals("Backend", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[5]")).getText());
    }
    @Test
    void doisCadastrosCompletosTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Você preencheu tudo corretamente e é sua última resposta?", alert.getText());
        alert.accept();
        nome.sendKeys("Joana");
        sobrenome.sendKeys("Silva");
        driver.findElement(By.id("feminino")).click();
        driver.findElement(By.id("react")).click();
        driver.findElement(By.id("junit")).click();
        driver.findElement(By.id("javascript")).click();
        areasDeInteresse.selectByVisibleText("Frontend");

//        Value do Frontend esta como Drontend

        areasDeInteresse.selectByVisibleText("DevOps");
        select2.selectByVisibleText("Frontend");
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        driver.switchTo().alert();
        Assertions.assertEquals("Você preencheu tudo corretamente e é sua última resposta?", alert.getText());
        alert.accept();

        Assertions.assertEquals("Hamilcar", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[1]")).getText());
        Assertions.assertEquals("Tortora da Silva", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[2]")).getText());
        Assertions.assertEquals("masculino", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[3]")).getText());
        Assertions.assertEquals("Backend, Testes", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[4]")).getText());
        Assertions.assertEquals("Backend", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr/td[5]")).getText());

        Assertions.assertEquals("Joana", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr[2]/td[1]")).getText());
        Assertions.assertEquals("Silva", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr[2]/td[2]")).getText());
        Assertions.assertEquals("feminino", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr[2]/td[3]")).getText());
        Assertions.assertEquals("Frontend, Devops", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr[2]/td[4]")).getText());
        Assertions.assertEquals("Drontend", driver.findElement(By.xpath("//*[@id=\"table-cadastros-body\"]/tr[2]/td[5]")).getText());
    }
    @Test
    void cadastroSemNomeTest(){
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }
    @Test
    void cadastroSemSobrenomeTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }
    @Test
    void cadastroSemSexoTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }

//    Formulário está sendo enviado mesmo sem selecionar nenhum conhecimento
    @Test
    void cadastroSemConhecimentosTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }
    @Test
    void cadastroSemAreaDeInteresseTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }
    @Test
    void cadastroSemAreaPrincipalTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement porque =driver.findElement(By.id("porque"));
        porque.sendKeys("A empresa é destaque no ramo, e a caga se encaixa com os objetivos que possuo, e áres que estudo.");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }

//    Formulário está sendo enviado mesmo sem descrever Por que você quer a vaga?
    @Test
    void cadastroSemAreaPorqueTest(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        nome.sendKeys("Hamilcar");
        WebElement sobrenome = driver.findElement(By.xpath("//*[@id=\"sobrenome\"]"));
        sobrenome.sendKeys("Tortora da Silva");
        driver.findElement(By.id("masculino")).click();
        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("selenium")).click();
        WebElement select = driver.findElement(By.id("area-interesse"));
        Select areasDeInteresse = new Select(select);
        areasDeInteresse.selectByVisibleText("Backend");
        areasDeInteresse.selectByVisibleText("Testes");
        WebElement selectWebElement = driver.findElement(By.id("motivacao"));
        Select select2 = new Select(selectWebElement);
        select2.selectByValue("Backend");
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Por favor, preencha todos os campos.", alert.getText());
        alert.accept();
    }
    @Test
    void maisInformacoesTest(){
        driver.findElement(By.id("btn-info")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Este formulário é para cadastro de candidatos interessados em vagas de emprego. Por favor, preencha todos os campos obrigatórios e forneça informações precisas e atualizadas. Obrigado!", alert.getText());
        alert.accept();
    }
    @Test
    void sobreEmpresaTest(){
        driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/a")).click();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        Assertions.assertEquals("https://igorsmasc.github.io/fomulario_cadastro_selenium/sobre.html", driver.getCurrentUrl());
        Assertions.assertEquals("A melhor empresa do mundo", driver.findElement(By.xpath("/html/body/div/h1")).getText());
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        WebElement titulo = driver.findElement(By.xpath("//*[@id=\"formulario\"]/h1"));
        Assertions.assertEquals("Desafio - Cadastro", titulo.getText());
    }


}
