package tests.P5_Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C29_ProductScreenshot extends TestBase {

    // amazon anasayfaya gidin
    // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
    // Nutella icin arama yapin
    // sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu (or result text) alin

    @Test
    public void test() throws IOException {
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        TakesScreenshot tss = (TakesScreenshot) driver;
        String filePath = "target/amazonLogo.jpg";
        File wholePageSS = new File(filePath);
        File tempFile = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempFile, wholePageSS);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        WebElement resultTextElement = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String resultText = resultTextElement.getText();
        Assert.assertTrue(resultText.contains("Nutella"));
        File resultSS = new File("target/resultPhoto.jpg");
        File tempPhoto = resultTextElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempPhoto, resultSS);

    }

}
