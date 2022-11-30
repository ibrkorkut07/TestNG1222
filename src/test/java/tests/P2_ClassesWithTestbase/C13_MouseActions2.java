package tests.P2_ClassesWithTestbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C13_MouseActions2 extends TestBase {

    // https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void Test() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragmeElement = driver.findElement(By.id("draggable"));
        WebElement drophereElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragmeElement, drophereElement).perform();
        System.out.println(drophereElement.getText().equals("Dropped!"));
    }

}
