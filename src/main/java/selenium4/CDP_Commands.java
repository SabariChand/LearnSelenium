package selenium4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v110.network.Network;
import org.openqa.selenium.devtools.v110.network.model.Request;
import org.openqa.selenium.devtools.v110.network.model.Response;
import org.openqa.selenium.interactions.Coordinates;

public class CDP_Commands 

{
	//This is to change the websit r loading as mobile application
	//This is specific method instaed of selenium setdevice metrics method we can call chrome devtools protocol
	public static void mobileresolution() throws InterruptedException 
	
	{
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		//Just pass this 'ops' object to ChromeDriver() as argument

		ChromeDriver driver= new ChromeDriver(ops) ;
		//ChromeDriver driver = new ChromeDriver();
			
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		//adding the parameteres to the map
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width",600 );
		deviceMetrics.put("height",1000);
		deviceMetrics.put("deviceScaleFactor",50 );
		deviceMetrics.put("mobile",true );
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		
		
		//browse a website from a differant location
	}
		public static void setGeoLocation() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver",
					  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
			
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			ops.addArguments("start-maximized");
			ops.addArguments("test-type");
			ops.addArguments("enable-strict-powerful-feature-restrictions");
			ops.addArguments("disable-geolocation");

			//Just pass this 'ops' object to ChromeDriver() as argument

			ChromeDriver driver= new ChromeDriver(ops) ;
			
				
			DevTools devTools=driver.getDevTools();
			devTools.createSession();
			
			Map<String,Object> coordinates = new HashMap<String,Object>();
			coordinates.put("latitude", 46);
			coordinates.put("longitude",2);
			coordinates.put("longitude",1);
			driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
			driver.get("https://www.google.com/");
			driver.findElement(By.cssSelector("input.gLFyf")).sendKeys("netflix",Keys.ENTER);
			Thread.sleep(3000);
			driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
			String text = driver.findElement(By.cssSelector("h1[class='default-ltr-cache-e9r22d e1yzhtxy7']")).getText();
			System.out.println(text);
			driver.quit();
			
		}
		
		public static void networkresponse()
		{
			System.setProperty("webdriver.chrome.driver",
					  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
			
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");

			//Just pass this 'ops' object to ChromeDriver() as argument

			ChromeDriver driver= new ChromeDriver(ops) ;
			//ChromeDriver driver = new ChromeDriver();
				
			DevTools devTools=driver.getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			
			devTools.addListener(Network.requestWillBeSent(), request ->
			{
				Request req = request.getRequest();
				System.out.println(req.getUrl());
				
			});
			
			
			//event will get fired
			devTools.addListener(Network.responseReceived(), response ->
			{
				Response res = response.getResponse();
				//System.out.println(res.getUrl());
				System.out.println(res.getStatus());
				//in order to get the url which is failing
			/*	if (res.getStatus().toString().startsWith("4"))
				{
					System.out.println(res.getUrl()+"is failing with staus code"+res.getStatusText());
				}*/
			});
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.findElement(By.cssSelector(".btn.btn-primary")).click();
			driver.quit();
		}
		
		
		public static void main(String[] args) throws InterruptedException {
			//setGeoLocation();
			//mobileresolution();
			networkresponse();
		}
	
}
