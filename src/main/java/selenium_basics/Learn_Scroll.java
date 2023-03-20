package selenium_basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Learn_Scroll {
public static void main(String[] args) throws InterruptedException {
	

	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	//some additional code for chromm 111 version
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");
	ChromeDriver driver= new ChromeDriver(ops) ;
	
	driver.manage().window().maximize();

	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	
	Thread.sleep(3000);
	js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
}
}
