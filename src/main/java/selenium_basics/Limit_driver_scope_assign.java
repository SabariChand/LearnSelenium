package selenium_basics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

import dev.failsafe.internal.util.Assert;

public class Limit_driver_scope_assign 

{

	public static void main(String[] args) throws InterruptedException {
		
		//a, every link will have the tag name a
				System.setProperty("webdriver.chrome.driver",
						  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
				//some additional code for chromm 111 version
				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--remote-allow-origins=*");
				ChromeDriver driver= new ChromeDriver(ops) ;
				
				driver.manage().window().maximize();

				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				//1.Select any check box
				driver.findElement(By.id("checkBoxOption3")).click();
				//2.grab the label of the selected check box
				String lable = driver.findElement(By.cssSelector("label[for ='honda']")).getText();
				
				//3.select option in dropdown with the label obtained from  the selected check box
				WebElement drop = driver.findElement(By.id("dropdown-class-example"));
				Select dp = new Select(drop);	
				dp.selectByVisibleText(lable);
	
				//4.enter the grabbed text in to the edit box
				driver.findElement(By.cssSelector("#name")).sendKeys(lable);
				
				driver.findElement(By.cssSelector("input[type = 'submit']")).click();
				
				
				//5.get the text form the alert and verify the lable
				Alert alt = driver.switchTo().alert();
				
				String text = alt.getText();
				
				assertTrue(text.contains(lable));
				
				alt.accept();
				
				driver.close();
				
	}
}
