package P2_ClassesWithTestbase;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C16_KeyboardActions1 extends TestBase {

    // https://www.amazon.com sayfasina gidelim
    // Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    // aramanin gerceklestigini test edin

    @Test
    public void Test() {
        driver.get("https://www.amazon.com/");

    }
}
