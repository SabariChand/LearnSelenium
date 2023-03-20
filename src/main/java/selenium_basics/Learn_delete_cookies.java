package selenium_basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Learn_delete_cookies
{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		//some additional code for chromm 111 version
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ops.setAcceptInsecureCerts(true);
		
		
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.get("https://google.com");
		
		//maximize windows
		driver.manage().window().maximize();
		
		//delete the cookies
		
		driver.manage().deleteAllCookies();

		//delete the session cookie
		driver.manage().deleteCookieNamed("sessionkey");
	}
}
