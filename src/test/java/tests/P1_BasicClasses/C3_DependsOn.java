package tests.P1_BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C3_DependsOn {

    // https://www.amazon.com adresine gidin.
    // 1. Test : Amazon ana sayfaya gittiginizi test edin
    // 2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    // arama yapin ve aramanizin gerceklestigini Test edin
    // 3. Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
    }

    // 1. Test : Amazon ana sayfaya gittiginizi test edin
    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/");
    }

    // 2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    // arama yapin ve aramanizin gerceklestigini Test edin
    @Test (dependsOnMethods = "test1")
    public void test2() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        WebElement searchresultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(searchresultText.isDisplayed());
    }
    // 3. Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
    @Test (dependsOnMethods = "test2")
    public void test3() {
//        driver.findElement(By.xpath("(//div[@data-index='1'])[1]")).click();
//        WebElement searchresultPrice = driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']"));
//        String priceText = searchresultPrice.getText();
//        System.out.println(priceText);
    }



}
