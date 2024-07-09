package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
import java.util.Set;


public class SelectMobile extends Main {
    public String itemTitleText;

    public String quantity;

    //Select item name of the first mobile phone
    @Test(priority = 4)
    public void firstSelectItemName() {
        String itemTitleText = driver.findElement(By.cssSelector("h1.x-item-title__mainTitle")).getText().trim();
        System.out.println("Item title:" + itemTitleText);
    }
    //select item price
    @Test(priority = 5)
    public void firstSelectItemPrice() {
        String priceValue = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[3]/div/div/div[1]/span")).getText();
        System.out.println("Item price:" + priceValue);
    }
    //select quantity
    @Test(priority = 6)
    public void firstSelectItemQuantity() {
        quantity = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item Quantity: " + quantity);
    }
    //select Color
    @Test(priority = 7)
    public void setColor() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='color'],select[selectboxlabel='Manufacturer Color'],select[selectboxlabel='COLOR'],select[selectboxlabel='Color'],select[selectboxlabel='Colour"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(2);
            System.out.println("Color added");
        } catch (Exception e) {
            System.out.println("Color list not available");
        }
    }
    //set Plug
    @Test(priority = 8)
    public void setPlug() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='plug'],select[selectboxlabel='Plug']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(2);
            System.out.println("Plug is add");
        } catch (Exception e) {
            System.out.println("Plug list not available");
        }
    }
    //Set size
    @Test(priority = 9)
    public void setSize() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='size'],select[selectboxlabel='SIZE']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(2);
            System.out.println("Size is add");
        } catch (Exception e) {
            System.out.println("Size list not available");
        }
    }
    //select Carrier
    @Test(priority = 10)
    public void selectCarrier() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Carrier'],select[selectboxlabel='Phone Carrier']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(2);
            System.out.println("Carrier is add");
        } catch (Exception e) {
            System.out.println("Carrier list not available");
        }

    }
    //select Memory
    @Test(priority = 11)
    public void selectMemory() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity'],select[selectboxlabel='Memory']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
            selectBoxLabel.selectByIndex(2);
            System.out.println("Memory type is add");
        } catch (Exception e) {
            System.out.println("Memory list not available");
        }

    }
    //select network
    @Test(priority = 12)
    public void selectNetwork() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Network']"));
            Select selectBoxLabel = new Select(selectBox);

            selectBoxLabel.selectByIndex(1);

            selectBoxLabel.selectByIndex(2);

            System.out.println("Network type is add");
        } catch (Exception e) {
            System.out.println("Network list not available");
        }

    }
    //select model
    @Test(priority = 13)
    public void selectModel() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Model'],select[selectboxlabel='Phone Model']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(2);
            System.out.println("Model type is add");
        } catch (Exception e) {
            System.out.println("Model list not available");
        }

    }
    //add to cart
    @Test(priority = 14)
    public void addToCart() throws InterruptedException {
        try {
            WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[8]/ul/li[2]/div/a"));
            addtoCart.click();
            System.out.println("add to cart");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Not add to cart");
        }
        for (String newTabHandle : driver.getWindowHandles()) {
            driver.switchTo().window(newTabHandle);
        }
    }
    //check out
    @Test(priority = 15)
    public void checkOut() {

        WebElement checkout = driver.findElement(By.xpath("//button[@class='btn btn--primary btn--large']"));
        checkout.click();
        System.out.println("Check out");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            if (alert != null) {
                System.out.println("Alert is present. Dismissing...");
                alert.dismiss();
                System.out.println("Alert dismissed");
            } else {
                System.out.println("No alert present");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred while handling alert: " + e.getMessage());
        }

    }
    //guest mode
    @Test(priority = 16)
    public void guestMode () {
        WebElement guestMode = driver.findElement(By.xpath("//*[@id=\"gxo-btn\"]"));
        guestMode.click();
        System.out.println("gustMode on");

    }
    //assert Checkout
    @Test(priority = 17)
    public void assertCheckout(){
        String checkoutTitle = driver.findElement(By.cssSelector("item-title-header")).getText().trim();
        Assert.assertEquals(checkoutTitle, itemTitleText);
        System.out.println("Tile of item:"+itemTitleText);
    }
    //after test
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
    }




