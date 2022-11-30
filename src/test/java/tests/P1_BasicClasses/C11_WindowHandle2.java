package tests.P1_BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C11_WindowHandle2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
    }

    // https://the-internet.herokuapp.com/windows adresine gidin.
    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // Click Here butonuna basın.
    // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // Sayfadaki textin “New Window” olduğunu doğrulayın.
    // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String herokuappWindowhandle = driver.getWindowHandle();
        WebElement openingtext = driver.findElement(By.xpath("//h3"));
        String expOpeningText = "Opening a new window";
        Assert.assertTrue(openingtext.getText().equals(expOpeningText));
        Assert.assertEquals(driver.getTitle(), "The Internet");
        driver.findElement(By.linkText("Click Here")).click();
        String newwindowHandle = null;
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each: windowHandles) {
            if (!each.equals(herokuappWindowhandle)) {
                newwindowHandle = each;
            }
        }
        driver.switchTo().window(newwindowHandle);
        Assert.assertTrue(driver.getTitle().equals("New Window"));
        // System.out.println(driver.getTitle());
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("New Window"));
        driver.switchTo().window(herokuappWindowhandle);
        System.out.println(driver.getTitle());
        // Assert.assertTrue(driver.getTitle().equals("The Internet"));
    }

    @AfterClass
    public void tearDown() { driver.quit();}
}
