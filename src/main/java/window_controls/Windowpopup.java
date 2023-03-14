package window_controls;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windowpopup
{

	public static void handling_through_url(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		//Just pass this 'ops' object to ChromeDriver() as argument

		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Basic Auth")).click();
		

	}
	public static void main(String[] args) {
		handling_through_url(args);
	}
}
