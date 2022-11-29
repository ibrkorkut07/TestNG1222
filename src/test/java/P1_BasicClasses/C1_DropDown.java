package P1_BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C1_DropDown {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // Tüm dropdown değerleri(value) yazdırın
    // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın

    WebDriver driver;
    Select select;
    WebElement dropdown;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        select = new Select(dropdown);
    }

    // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void selectIndex () {
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
    }

    // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    @Test
    public void selectValue () {
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    // Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void selectVisibleText () {
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    // Tüm dropdown değerleri(value) yazdırın
    @Test
    public void dropDownValue () {
        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList) {
            System.out.println(each.getAttribute("value"));
        }
    }

    // Tüm dropdown seceneklerini (options) yazdırın
    @Test
    public void dropDownOptionlist () {
        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList) {
            System.out.println(each.getText());
        }
    }

    // Dropdown’un boyutunu bulup Dropdown’da 4 öğe oldugunu test edin
    @Test
    public void dropDownSize () {
        int dropdownSize = select.getOptions().size();
        Assert.assertEquals(dropdownSize, 4, "The number of options does not meet the requirement");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
