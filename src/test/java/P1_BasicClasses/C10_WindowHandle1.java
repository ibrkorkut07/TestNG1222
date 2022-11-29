package P1_BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C10_WindowHandle1 {

    // Amazon anasayfa adresine gidin.
    // Sayfa’nin window handle degerini String bir degiskene atayin
    // Sayfa title’nin “Amazon” icerdigini test edin
    // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    // Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
    // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    // Sayfa title’nin “Walmart” icerdigini test edin
    // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("http://www.amazon.com/");
        String amazonWindowHandle = driver.getWindowHandle();
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.techproeducation.com");
        String techproWindowhandle = driver.getWindowHandle();
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

    }

    @AfterClass
    public void tearDown() { driver.quit();}
}
