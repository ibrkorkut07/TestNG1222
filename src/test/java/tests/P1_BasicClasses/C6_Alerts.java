package tests.P1_BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C6_Alerts {

    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // Bir metod olusturun: acceptAlert
    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    // “You successfully clicked an alert” oldugunu test edin
    // Bir metod olusturun: dismissAlert
    // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    // “successfuly” icermedigini test edin
    // Bir metod olusturun: sendKeysAlert
    // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    // tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.

    WebDriver driver;
    Alert alert;
    WebElement resultText;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        resultText = driver.findElement(By.xpath("//p[@id='result']"));
    }

    // Bir metod olusturun: acceptAlert
    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    // “You successfully clicked an alert” oldugunu test edin

    @Test
    public void acceptAlert() {
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        driver.switchTo().alert().accept();
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());
    }
    // Bir metod olusturun: dismissAlert
    // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    // “successfuly” icermedigini test edin
    @Test
    public void dismissAlert() {
        WebElement jsConfirmAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirmAlert.click();
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(resultText.getText().contains("successfuly"));
    }

    // Bir metod olusturun: sendKeysAlert
    // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    // tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert() throws InterruptedException {
        WebElement jsPromptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptAlert.click();
        driver.switchTo().alert().sendKeys("ibr");
        driver.switchTo().alert().accept();
        Assert.assertTrue(resultText.getText().contains("ibr"));
    }
}
