package tests.P4_Wait_Faker_Cookies;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C24_ExplicitlyWait2 extends TestBase {

    @Test
    public void test01(){


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        //wait.until(ExpectedConditions.)
    }
}
