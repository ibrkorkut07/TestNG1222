package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C5_SoftAssert {

    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        softAssert = new SoftAssert();
    }

    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. softassert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. softassert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    @Test
    public void test() {
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='submit']")).submit();
        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();
        WebElement currencyDropdown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");
        softAssert.assertTrue(select.getFirstSelectedOption().isSelected());
        List<WebElement> dropList = select.getOptions();
        List<String> dropListString = null;

        for (WebElement each : dropList) {
            dropListString.add(each.getText());
        }

//        List<String> expDropdownList = List.of(new String[]{"Select One", "Australia (dollar)", "Canada (dollar)",
//                "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)",
//                "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
//                "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"});


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    }
