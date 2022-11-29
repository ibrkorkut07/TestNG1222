package P2_ClassesWithTestbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C12_Mouseactions1 extends TestBase {

    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // Cizili alan uzerinde sag click yapalim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    // Tamam diyerek alert’i kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void Test() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement alertBox = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(alertBox).contextClick().perform();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.equals("You selected a context menu"));
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Elemental Selenium")).click();
    }

}
