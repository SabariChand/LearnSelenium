package selenium_basics;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Waits 
{
    public static void main( String[] args )
    {
        System.setProperty("webriver.chrome.driver","C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium-tutorial.com/courses");
        driver.manage().window().maximize();
        
       Wait<WebDriver> fw = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(10))
       .pollingEvery(Duration.ofSeconds(5))
       .ignoring(NoSuchElementException.class);
       
       fw.until(ExpectedConditions.elementToBeClickable(By.linkText("LIFETIME MEMBERSHIP TO ALL LIVE TRAININGS")));
       fw.until(ExpectedConditions.urlContains("lifetime-membership-club"));
        
    }
}
 