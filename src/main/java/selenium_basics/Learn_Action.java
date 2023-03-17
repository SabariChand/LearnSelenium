package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Learn_Action {

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		//Just pass this 'ops' object to ChromeDriver() as argument

		ChromeDriver driver= new ChromeDriver(ops) ;
		//ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		
		Actions a = new Actions(driver);
		
		//Moves to the specific Element
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
		WebElement textbox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		
		//Moves to the specific element and  press shift KEY and enter text
		a.moveToElement(textbox).click().keyDown(Keys.SHIFT).sendKeys("Iphone").build().perform();
		
		//doubleclick() for selecting text
		
		a.moveToElement(textbox).click().keyDown(Keys.SHIFT).sendKeys("Iphone").doubleClick().build().perform();
		
		//Right click on the web page or element
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build().perform();
	}
	
}
