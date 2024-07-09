package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;


public class Main {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("web driver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        //initialize the chrome driver
        driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //Navigate to ebay website
        driver.navigate().to("https://www.ebay.com/");
    }
    //navigate to Ebay
    @Test(priority = 1)
    public void navigateEbay(){
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Page URL is not matching");
    }
    //search for mobile phone
    @Test(priority = 2)
    public void searchForMobilePhone() {
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        categoryDropdown.click();
        WebElement cellPhonesCategory = driver.findElement(By.xpath("//option[text()='Cell Phones & Accessories']"));
        cellPhonesCategory.click();
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }
    //choose the first results
    @Test(priority = 3)
    public void chooseFirstResults() throws InterruptedException {
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li/div/div[2]/a/div/span[contains(text(), 'Mobile Phone')]"));
        int resultsCount = Math.min(searchResults.size(), 5);
        for (int i = 0; i < resultsCount; i++) {
            String resultText = searchResults.get(i).getText();
            System.out.println("Search Result " + (i + 1) + ": " + resultText);
            Assert.assertTrue(resultText.contains("Mobile Phone"), "Search result " + (i + 1) + " does not contain 'Mobile Phone'");
        }
        searchResults.get(0).click();
        Thread.sleep(5000);

        for (String newTabHandle : driver.getWindowHandles()) {
            driver.switchTo().window(newTabHandle);
        }
    }



}