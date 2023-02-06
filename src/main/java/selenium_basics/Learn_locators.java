package selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learn_locators 
{
@Test
public void locators()
{
 //Driver Setup
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
 WebDriver driver = new ChromeDriver();

 driver.manage().window().maximize();
 
//implicit wait
 
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
 driver.get("https://demowebshop.tricentis.com/");
 
 //Locator - Link Text
 driver.findElement(By.linkText("Log in")).click();
 
 //Locator - ID
 driver.findElement(By.id("Email")).sendKeys("csabarichandru@gmail.com");
 
 //Locator - Name
 driver.findElement(By.name("Password")).sendKeys("Tryme@1234");
 
//Locator - Class name
 driver.findElement(By.className("login-button")).click();
 
 //Locator - xpath
 //String err = driver.findElement(By.xpath("//span[contains(text() ,'Login was unsuccessful. Please correct the errors and try again')]")).getText();
 
 String currentUrl = driver.getCurrentUrl();
 System.out.println(currentUrl);
 //System.out.println(err);
 driver.close();
 
 
 
 
 
 
}
}
