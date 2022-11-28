package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C2_DropdownAmazon {

    // https://www.amazon.com/ adresine gidin.
    // Test 1
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

    // Test 2
    // Kategori menusunden Books secenegini secin
    // Arama kutusuna Java yazin ve aratin
    // Bulunan sonuc sayisini yazdirin
    // Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    Select select;
    WebElement dropdownElement;
    WebElement searchboxElement;
    WebElement searchresult;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownElement);
    }

    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    @Test
    public void test1() {
        List<WebElement> dropdownOptions = select.getOptions();
        Assert.assertFalse(dropdownOptions.size()==45, "There are 45 options in Dropdown option list");
    }

    // Kategori menusunden Books secenegini secin
    // Arama kutusuna Java yazin ve aratin
    // Bulunan sonuc sayisini yazdirin
    // Sonucun Java kelimesini icerdigini test edin
    @Test
    public void test2() {
        select.selectByVisibleText("Books");
        searchboxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchboxElement.sendKeys("Java" + Keys.ENTER);
        searchresult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(searchresult.getText());
        Assert.assertTrue(searchresult.getText().contains("Java"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}