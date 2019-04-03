package Hw30march;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NopComLogin {

    protected static WebDriver driver;

    static String getCurrentDateTime()
    {//create object for simple date format class and decide format
        DateFormat dateFormat = new SimpleDateFormat("MMDDYYYY");
        //get current date time with date
        Date date = new Date();
        //new format for date
        String date1 = dateFormat.format(date);
        System.out.println("Current date and time is " + date1);
        return date1;
    }


    public static <test> void main(String[] args){
        //open chrome driver
System.setProperty("webdriver.chrome.driver","src\\Seleniumedrivers\\chromedriver.exe");
  driver = new ChromeDriver();//getting chrome browser
        // implicit wait applied
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //asking driver to get URL
        driver.get("https://www.nopcommerce.com/register.aspx");
        //click on register button
        driver.findElement(By.xpath("a//[class=\'ico-register\']")).click();
        //enter given firstname
        driver.findElement(By.id("FirstName")).sendKeys("Set123");
        //enter given lastname
        driver.findElement(By.id("LastName")).sendKeys("pass123");
        //enter given email address
        driver.findElement(By.id("Email")).sendKeys("try123"+getCurrentDateTime()+"@test.com");
        //enter given username
        driver.findElement(By.id("UserName")).sendKeys("Set123");
        //enter given password
        driver.findElement(By.id("Password")).sendKeys("setset");
        //enter given confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("setset");
        driver.findElement(By.id("register-button")).click();
        //able to see registration successful
        String actualRegistrationSuccessMessage = driver.findElement(By.xpath("//div[@class'result']")).getText();

        Assert.assertEquals("Your registration completed",actualRegistrationSuccessMessage);

        driver.quit();
    }

}
