import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PraticandoSelects {
    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/praticando_selects_radio_checkbox/";

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
    void testeSelectIndividual(){
        WebElement selectWebElement = driver.findElement(By.id("categoria"));
        Select select = new Select(selectWebElement);
        select.selectByValue("lanche");
        select.selectByIndex(2);
        select.selectByVisibleText("Almoço e Janta");
        Assertions.assertEquals("Almoço e Janta",select.getFirstSelectedOption().getText());
    }

    @Test
    void testeSelectMultiploValidaTamanho(){
        WebElement selectMultipploWebElement = driver.findElement(By.id("ingredientes"));
        Select select = new Select(selectMultipploWebElement);
                Assertions.assertEquals(7, select.getOptions().size());
    }

    @Test
    void testeSelectMultiploValidavalor(){
        WebElement selectMultipploWebElement = driver.findElement(By.id("ingredientes"));
        Select select = new Select(selectMultipploWebElement);

        List<String> listaRetornada = select.getOptions().stream().map(e -> e.getText()).collect(Collectors.toList());
        List<String> listaEsperada = Arrays.asList("Ovos", "Chocolate", "Frango", "Manteiga", "Leite", "Farinha", "Açucar");
        Assertions.assertArrayEquals(listaEsperada.toArray(), listaRetornada.toArray());
    }

    @Test
    void testeSelectsMultiplos(){
        WebElement select = driver.findElement(By.id("ingredientes"));
        Select ingredientes = new Select(select);
        ingredientes.selectByVisibleText("Frango");
        ingredientes.selectByVisibleText("Farinha");

        List<String> ingredientesText = ingredientes.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> ingredietesEsperados = Arrays.asList("Frango", "Farinha");

        Assertions.assertEquals(2, ingredientes.getAllSelectedOptions().size());
        Assertions.assertArrayEquals(ingredientesText.toArray(), ingredietesEsperados.toArray());
    }

}
