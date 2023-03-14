package window_controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoIT

{
public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");

	//Just pass this 'ops' object to ChromeDriver() as argument

	ChromeDriver driver= new ChromeDriver(ops) ;
	
	driver.manage().window().maximize();
	
	driver.get("https://www.adobe.com/in/acrobat/online/convert-pdf.html");
	
	Thread.sleep(3000);
	
	driver.findElement(By.id("lifecycle-nativebutton")).click();
	
	Thread.sleep(3000);
	
	Runtime.getRuntime().exec("C:\\Users\\Sabari Nathan\\git\\LearnSelenium\\LearnSelenium\\AutoIT_resources\\fileUpload.exe");
	
	//
	
}
}
