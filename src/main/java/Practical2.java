import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Practical2 {
    public static void main(String args[])  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chalani\\Desktop\\Practical2\\Drivers\\chromedriver.exe");

        //Creating an instance of web driver
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.navigate().to("https://demo.guru99.com/test/newtours/");

        // Maximize the window
        driver.manage().window().maximize();

        //input username and password
        driver.findElement(By.name("userName")).sendKeys("Chalani");
        driver.findElement(By.name("password")).sendKeys("chalani321");

        driver.findElement(By.name("password")).submit();

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        //Click on the "Flights"
        driver.findElement(By.xpath("//*[contains(text(),'Flights')]")).click();

        // Select the option "One way"
        driver.findElement(By.xpath("//*[@value='oneway']")).click();

        // Select the number of passengers from a dropdown,first of all we have to create an instance of the Select
        Select select1 = new Select(driver.findElement(By.name("passCount")));
        //select1.selectByIndex(3); //selects the value "4", may be because indexes are starting from "0"
        select1.selectByValue("3"); //selects the value "3"

        //Select departing airport
        Select select2 = new Select(driver.findElement(By.name("fromPort")));
        select2.selectByIndex(2); // Result must be "London"

        //Select departing month and date
        Select select3 = new Select(driver.findElement(By.name("fromMonth")));
        select3.selectByIndex(4); // Result must be "May"

        Select select4 = new Select(driver.findElement(By.name("fromDay")));
        select4.selectByIndex(30); // Result must be "31"

        //Select arriving airport
        Select select5 = new Select(driver.findElement(By.name("toPort")));
        select5.selectByIndex(0); // Result must be "Acapulco"

        //Select arriving month and date
        Select select6 = new Select(driver.findElement(By.name("toMonth")));
        select6.selectByIndex(5); // Result must be "June"

        Select select7 = new Select(driver.findElement(By.name("toDay")));
        select7.selectByIndex(5); // Result must be "6"

        //Select service class
        driver.findElement(By.xpath("//*[@value='First']")).click();

        //Select airline
        Select select8 = new Select(driver.findElement(By.name("airline")));
        select8.selectByIndex(1);


        driver.close();

    }
}
