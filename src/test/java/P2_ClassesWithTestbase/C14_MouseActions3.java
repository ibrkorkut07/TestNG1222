package P2_ClassesWithTestbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C14_MouseActions3 extends TestBase {

    // https://www.amazon.com/ adresine gidelim
    // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
    // mouse’u bu menunun ustune getirelim
    // “Create a list” butonuna basalim
    // Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    @Test
    public void Test() {
        driver.get("https://www.amazon.com/");
        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountElement).perform();
        WebElement crelistElement = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(crelistElement).perform();
        String actlistText = driver.findElement(By.xpath("//div[@role='heading']")).getText();
        String explistText = "Your Lists";
        Assert.assertTrue(actlistText.contains(explistText));
    }
}
