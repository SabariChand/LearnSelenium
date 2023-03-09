package selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
//import org.openqa.selenium.devtools.v94.emulation.Emulation;

public class mobileEmulatorTest


{
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	
	ChromeOptions ops = new ChromeOptions();

	ops.addArguments("--remote-allow-origins=*");

	//Just pass this 'ops' object to ChromeDriver() as argument

	ChromeDriver driver= new ChromeDriver(ops) ;
	//ChromeDriver driver = new ChromeDriver();
		
	DevTools devTools=driver.getDevTools();

	devTools.createSession();
	devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	//send commands to Chrome Dev tools protocol
	//devTools.send(Emulation..setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector(".navbar-toggler")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Library")).click();
	driver.close();
	
}
}
