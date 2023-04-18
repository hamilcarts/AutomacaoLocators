import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtividadeDesafio {

    static WebDriver driver;
    private static final String URL = "https://rachacuca.com.br/logica/problemas/show-de-talentos/";

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
//        driver.quit();
    }
    @Test
    void selectTeste() {
        WebElement selecCamisa1 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[1]/select"));
        Select selectCamisa11 = new Select(selecCamisa1);
        selectCamisa11.selectByVisibleText("azul");

        WebElement selectNome1 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[2]/select"));
        Select selectNome11 = new Select(selectNome1);
        selectNome11.selectByVisibleText("Alexander");

        WebElement selectTalento1 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[3]/select"));
        Select selectTalento11 = new Select(selectTalento1);
        selectTalento11.selectByVisibleText("imitação");

        WebElement selectIdade1 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[4]/select"));
        Select selectIdade11 = new Select(selectIdade1);
        selectIdade11.selectByVisibleText("22");

        WebElement selectFruta1 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[5]/select"));
        Select selectFruta11 = new Select(selectFruta1);
        selectFruta11.selectByVisibleText("morango");

        WebElement selectEsporte1 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[6]/select"));
        Select selectEsporte11 = new Select(selectEsporte1);
        selectEsporte11.selectByVisibleText("natação");

        WebElement selecCamisa2 = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[3]/ul/li[1]/select"));
        Select selectCamisa22 = new Select(selecCamisa2);
        selectCamisa22.selectByVisibleText("branca");

    }
}
