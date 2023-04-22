import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
