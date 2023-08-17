package tests;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.ExpressionSteps;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseTest {
    @Getter
    static WebDriver driver = null;
    Properties properties;

    ExpressionSteps steps;

    @BeforeClass
    @SneakyThrows
    public void beforeClass() {
        properties = new Properties();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("config.properties"))) {
            properties.load(reader);
            String driverName = properties.getProperty("driver");
            File file = new File(properties.getProperty("path"));
            System.setProperty(driverName, file.getAbsolutePath());
            if (driverName.contains("chrome")) {
                driver = new ChromeDriver();
            } else if (driverName.contains("edge")) {
                driver = new EdgeDriver();
            } else {
                driver = new FirefoxDriver();
            }
            assertThat(driver).isNotNull();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

            steps = new ExpressionSteps();
        }
    }

    public void visit(String path) {
        driver.navigate().to(properties.getProperty("host")+path);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @DataProvider(name = "incorrectData")
    public Object[][] incorrectData() {
        return new Object[][] {
                {"2+"},
                {"+"},
                {"x+y"}
        };
    }
}
