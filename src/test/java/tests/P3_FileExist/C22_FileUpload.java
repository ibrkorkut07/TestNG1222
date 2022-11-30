package tests.P3_FileExist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C22_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        // 1- File secme butonunu locate edelim
        // 2- yukleyecegimiz dosyanin dinamik path'ini hazirlayalim
        // 3- sendKeys( ) ile dinamik path'i dosya sec butonuna yollayalim
        //Upload butonuna basalim.
        //“File Uploaded!” textinin goruntulendigini test edelim


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement chooseFilebutton= driver.findElement(By.xpath("//input[@id='file-upload']"));

        //Yuklemek istediginiz dosyayi secelim.     C:\Users\ibrko\OneDrive\Desktop\ödev.fprg
        String filePath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\ödev.fprg";
        // 1- File secme butonunu locate edelim
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        // 2- yukleyecegimiz dosyanin dinamik path'ini hazirlayalim
        // 3- sendKeys( ) ile dinamik path'i dosya sec butonuna yollayalim
        chooseFilebutton.sendKeys(filePath);
        //Upload butonuna basalim.
        uploadButton.click();
        //“File Uploaded!” textinin goruntulendigini test edelim


//        //https://the-internet.herokuapp.com/upload adresine gidelim
//        driver.get("https://the-internet.herokuapp.com/upload");
//        //chooseFile butonuna basalim
//        //Yuklemek istediginiz dosyayi secelim.
//        // 1- File secme butonunu locate edelim
//        WebElement filesecButonu=driver.findElement(By.id("file-upload"));
//
//        // 2- yukleyecegimiz dosyanin dinamik path'ini hazirlayalim
//
//        String dosyaYolu= System.getProperty("user.home") + "\\Desktop\\Deneme\\selenium.xlsx";
//
//        // 3- sendKeys( ) ile dinamik path'i dosya sec butonuna yollayalim
//        filesecButonu.sendKeys(dosyaYolu);
//
//        //Upload butonuna basalim.
//        driver.findElement(By.id("file-submit")).click();
//        //“File Uploaded!” textinin goruntulendigini test edelim
//
//        WebElement sonucYaziElementi=driver.findElement(By.tagName("h3"));
//        Assert.assertTrue(sonucYaziElementi.isDisplayed());
//
//        Thread.sleep(7000);
    }
}
