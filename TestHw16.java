import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

public class TestHw16 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }
    @Test
    public void loginTest() {
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Form Authentication")).click();
        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        usernameInput.clear();
        usernameInput.sendKeys("tomsmith");

        WebElement userPasswordInput = driver.findElement(By.xpath("//input[@type='password']"));
        userPasswordInput.clear();
        userPasswordInput.sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String text = driver.findElement(By.id("flash-messages")).getText();
        if (text.contains("Secure Area"));
        {
            System.out.println("passed");
        }
        driver.quit();
    }

    }
