////*
//
//package org.example;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class kashiertest {
//
//    static WebDriver driver;
//    static WebElement FullName;
//    static WebElement StoreName;
//    static String TestOneName;
//
//
//
//    @BeforeTest
//    public static void Initiate() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://merchant.kashier.io/signup");
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//    }
//
//
//
//    @Test
//    public static void TestOne(String[] args) throws InterruptedException {
//        FullName = driver.findElement(By.xpath("//input[@name='full_name']"));
//        FullName.sendKeys("Ziad is testing");
//        Thread.sleep(2000);
//    }
//
//    @AfterTest
//    public static void TearDown()
//    {
//        driver.quit();
//    }
//}