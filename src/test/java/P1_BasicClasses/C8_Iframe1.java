package P1_BasicClasses;

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

public class C8_Iframe1 {

    // https://the-internet.herokuapp.com/iframe adresine gidin.
    // Bir metod olusturun: iframeTest
    // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    // Text Box’a “Merhaba Dunya!” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” link textinin gorunur oldugunu
    // dogrulayin ve konsolda yazdirin.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement editorText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(editorText.isEnabled());
        System.out.println(editorText.getText());
        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        WebElement iframeTextBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        iframeTextBox.clear();
        iframeTextBox.sendKeys("Merhaba Dunya!");

        // TextBox’in altinda bulunan “Elemental Selenium” link textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement elementalSeleniumLink = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementalSeleniumLink.isDisplayed());
        System.out.println(elementalSeleniumLink.getText());
        String firstpageWindowhandle = driver.getWindowHandle();
        // Yeni sayfadaki "Sponsored by Sauce Labs" link textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        elementalSeleniumLink.click();
        String secondpageWindowhandle = null;
        Set<String> allWindowhandles = driver.getWindowHandles();
        // System.out.println(allWindowhandles);
        for (String each: allWindowhandles) {
            if (!each.equals(firstpageWindowhandle)) {
                secondpageWindowhandle=each;
            }
        }
        driver.switchTo().window(secondpageWindowhandle);
        WebElement newpageSaucelabsText = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(newpageSaucelabsText.isDisplayed());
        System.out.println(newpageSaucelabsText.getText());

//        WebElement frametext = driver.findElement(By.tagName("h3"));
//        Assert.assertTrue(frametext.isEnabled());
//        System.out.println(frametext.getText());
//        WebElement frameElement = driver.findElement(By.tagName("iframe"));
//        driver.switchTo().frame(frameElement);
//        WebElement textBox = driver.findElement(By.tagName("p"));
//        textBox.clear();
//        textBox.sendKeys("Hello");
//        driver.switchTo().defaultContent();
//        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
//        Assert.assertTrue(seleniumText.isDisplayed());
//        System.out.println(seleniumText.getText());
    }

    @AfterClass
    public void tearDown(){
        // driver.close();
    }
}
