import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinhaPrimeiraAutomacao {

    WebDriver driverChrome;
    private static final String URL = "https://www.google.com.br";

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.get(URL);
    }

    @AfterEach
    public void afterEach(){
        driverChrome.quit();
    }

    @Test
    public void test_google() {
        assertEquals("Google", driverChrome.getTitle());
        assertEquals("https://www.google.com.br/", driverChrome.getCurrentUrl());
        System.out.println(driverChrome.getPageSource());
        driverChrome.quit();
    }

    @Test
    public void test_google_janela() {
        driverChrome.manage().window().setPosition(new Point(500, 500));
        driverChrome.manage().window().minimize();
        driverChrome.manage().window().maximize();
        driverChrome.quit();
    }
}