package tests.P3_FileExist;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C21_FileDownload extends TestBase {

    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //		- https://the-internet.herokuapp.com/download adresine gidelim.
    //		- code.txt dosyasını indirelim
    //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void isExistTesti(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='test.txt']")).click();
    }

    @Test
    public void downloadTesti() throws InterruptedException {
        String filePath = System.getProperty("user.home") + "\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
