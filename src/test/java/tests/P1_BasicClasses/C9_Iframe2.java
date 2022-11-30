package tests.P1_BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C9_Iframe2 {

    // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    // sayfadaki iframe sayısını bulunuz.
    // ilk iframe'deki (Youtube) play butonuna tıklayınız.
    // ilk iframe'den çıkıp ana sayfaya dönünüz
    // ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html) tıklayınız

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement cookieIframe = driver.findElement(By.xpath("(//iframe)[7]"));
        driver.switchTo().frame(cookieIframe);
        driver.findElement(By.xpath("(//div[@style='font-size: 14px;'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[6]")).click();
    }

    @Test
    public void test() {

    }

    @AfterClass
    public void tearDown() {driver.quit();}
}
