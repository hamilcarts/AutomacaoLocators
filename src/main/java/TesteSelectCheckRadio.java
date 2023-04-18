import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TesteSelectCheckRadio {
    static WebDriver driver;
    private static final String URL = "https://igorsmasc.github.io/praticando_selects_radio_checkbox/";

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
    void selectTeste() {
        WebElement selectWebElement = driver.findElement(By.id("categoria"));
        Select selectCategoria = new Select(selectWebElement);

        selectCategoria.selectByVisibleText("Almoço e Janta");
        assertEquals("Almoço e Janta", selectCategoria.getFirstSelectedOption().getText());
    }

    @Test
    void selectMultiploTeste() {
        WebElement selectWebElement = driver.findElement(By.id("ingredientes"));
        Select selectIngredientes = new Select(selectWebElement);

        selectIngredientes.selectByVisibleText("Ovos");
        selectIngredientes.selectByVisibleText("Frango");

        List<WebElement> elemntosSelecionados = selectIngredientes.getAllSelectedOptions();

        List<String> elementosSelecionadosString = elemntosSelecionados.stream().map(WebElement::getText).collect(Collectors.toList());

        assertArrayEquals(elementosSelecionadosString.toArray(),elemntosSelecionados.toArray());
    }

    @Test
    void checkBoxTest(){
        WebElement checkForno = driver.findElement(By.id("forno"));
        WebElement checkAirFryer = driver.findElement(By.id("air-fryer"));
        WebElement checkGeladeira = driver.findElement(By.id("geladeira"));
        WebElement checkMicroondas = driver.findElement(By.id("microondas"));

        checkForno.click();
        assertTrue(checkForno.isSelected());

        checkMicroondas.click();
        assertTrue(checkMicroondas.isSelected());

        assertFalse(checkAirFryer.isSelected());
        assertFalse(checkGeladeira.isSelected());

    }

    @Test
    void radioButtonTest(){
        WebElement facil = driver.findElement(By.id("facil"));
        WebElement medio = driver.findElement(By.id("medio"));
        medio.click();
        assertFalse(facil.isSelected());
        assertTrue(medio.isSelected());

        facil.click();
        assertTrue(facil.isSelected());
        assertFalse(medio.isSelected());

    }
}
