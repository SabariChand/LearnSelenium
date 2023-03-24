package selenium_basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Learn_broken_links {

	
	public static void one_broken_link() throws MalformedURLException, IOException {
		

		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		//some additional code for chromm 111 version
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		String url = driver.findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href");
		

		//opening a connectio using a java method URL
				HttpURLConnection conn  = (HttpURLConnection)new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int responseCode = conn.getResponseCode();
				
				System.out.println(responseCode);
				
	}
	
	public static void multiple_broken_links() throws IOException
	{

		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		//some additional code for chromm 111 version
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class ='gf-li'] a"));
		//
		SoftAssert a = new SoftAssert();
		
		for(WebElement link: links)
		{
			String url = link.getAttribute("href");
			
			//opening a connectio using a java method URL
			HttpURLConnection conn  = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			//Hard Assertion
			//Assert.assertTrue(responseCode<400,"The link with the text : \"+link.getText()+\", is broken with code : \"+responseCode");
			System.out.println(responseCode);
			if(responseCode>400)
				
			{
				
				System.out.println("The link with the text : "+link.getText()+", is broken with code : "+responseCode);
				//this assertion will stop the execution once it f inds the broken link and not validating other broken links
				//Assert.assertTrue(false);
				
				a.assertTrue(responseCode<400,"The link with the text : \"+link.getText()+\", is broken with code : \"+responseCode");
				
			}
		}
		//to catcha and report the all the broken links
		a.assertAll();
	}
	public static void main(String[] args) throws IOException
	{
		//one_broken_link();
				multiple_broken_links();
	}


}
