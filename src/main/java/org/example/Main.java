package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {

    static WebDriver driver;
    static WebElement FullName;
    static WebElement StoreName;
    static WebElement CheckBox;
    static WebElement PhoneNumber;
    static WebElement Email;
    static WebElement Password;
    static WebElement RePassword;
    static WebElement SignUpButton;
    static WebElement LoginButton1;
    static WebElement EnglishButton;
    static WebElement ArabicButton;
    static WebElement ContactUsButton;

    static String CurrentUrl;





    @BeforeMethod
    public static void Initiate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://merchant.kashier.io/signup");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }



    @Test(priority = 0)
    public static void SignUpData() throws InterruptedException {
        FullName = driver.findElement(By.xpath("//input[@name='full_name']"));
        FullName.sendKeys("Ziad is testing");
        Thread.sleep(2000);
        StoreName = driver.findElement(By.xpath("//input[@name='store_name']"));
        StoreName.sendKeys("Ziad Store");
        Thread.sleep(2000);
        CheckBox=driver.findElement(By.xpath("//span[@class='transform-checkbox-icon']"));
        CheckBox.click();
        PhoneNumber=driver.findElement(By.xpath("//input[@name='mobile_number']"));
        PhoneNumber.sendKeys("01288890222");
        Email = driver.findElement(By.xpath("//input[@type='email']"));
        Email.sendKeys("z@xcvdddde.com");
        Password = driver.findElement(By.xpath("//input[@name='password']"));
        Password.sendKeys("Zz@123456");
        Thread.sleep(2000);
        RePassword = driver.findElement(By.xpath("//input[@name='rpassword']"));
        RePassword.sendKeys("Zz@123456");
        Thread.sleep(3000);
    }


    @Test(priority = 1)
    public static void SignUpButton() throws InterruptedException {
        Main.SignUpData();
        SignUpButton=driver.findElement(By.xpath("//span[@id='signup-span']"));
        SignUpButton.click();
        Thread.sleep(4000);
        CurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(CurrentUrl,"https://merchant.kashier.io/en/dashboard");
    }

    @Test(priority = 2)
    public static void LoginButton()
    {
        LoginButton1=driver.findElement(By.xpath("//a[@class='m-link m-login__account-link']"));
        LoginButton1.click();
        Assert.assertEquals("https://merchant.kashier.io/en/login",driver.getCurrentUrl());
    }

    @Test(priority = 3)
    public static void EnglishModeButton() throws InterruptedException {
        EnglishButton = driver.findElement(By.xpath("//a[@class='padding-change-language-en']"));
        EnglishButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("https://merchant.kashier.io/en/signup",driver.getCurrentUrl());
    }

    @Test(priority = 3)
    public static void ArabicModeButton() throws InterruptedException {
        ArabicButton = driver.findElement(By.xpath("//a[@class='padding-change-language-ar']"));
        ArabicButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("https://merchant.kashier.io/ar/signup",driver.getCurrentUrl());
    }


    @AfterMethod
    public static void TearDown()
    {
        driver.quit();
    }
}