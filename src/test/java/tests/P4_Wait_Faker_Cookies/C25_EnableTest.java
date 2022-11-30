package tests.P4_Wait_Faker_Cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C25_EnableTest extends TestBase {

    // Bir metod olusturun : isEnabled()
    // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // Textbox’in etkin olmadigini(enabled) dogrulayın
    // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    // Textbox’in etkin ol dugunu (enabled)

    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableDisableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));

    }
}
