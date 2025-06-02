package testngpack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class broswer 
{
	WebDriver driver;
	
  @Test(priority=1)
  public void Login() throws InterruptedException 
  {
	  
	  WebElement Usrlgn=driver.findElement(By.linkText("Login"));
	  Usrlgn.click();
	  WebElement Usrnme=driver.findElement(By.name("email"));
	  Usrnme.sendKeys("userhash@gmail.com");
	  Thread.sleep(1000);
	  WebElement Pswrd=driver.findElement(By.name("password"));
	  Pswrd.sendKeys("Abc@1234");
	  Thread.sleep(1000);
	  WebElement SubLgn=driver.findElement(By.name("login"));
	  SubLgn.click();
	  Thread.sleep(2000);
	  String ActualTitle="EventCalendar";
	  String ExpectedTitle=driver.getTitle();
	  if(ActualTitle.equalsIgnoreCase(ExpectedTitle))
	  {
		  System.out.println("Successfully Logged in");
	  }
	  else
	  {
			System.out.println("Error");
	  }
  }
  @Test(priority=2)
  public void CreateEvent() throws InterruptedException 
  {
	  WebElement CrtEvnt=driver.findElement(By.linkText("Create Event"));
	  CrtEvnt.click();
	  WebElement EvntTtl=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/form/div[1]/input"));
	  EvntTtl.sendKeys("Demo Event");
	  Thread.sleep(1000);
	  WebElement StDatTme=driver.findElement(By.name("start"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].setAttribute('value', '2025-07-01T09:30');", StDatTme);
	  Thread.sleep(1000);
	  WebElement EdDatTme=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/form/div[3]/input"));
	  js.executeScript("arguments[0].setAttribute('value', '2025-07-02T01:30');", EdDatTme);
	  Thread.sleep(1000);
	  WebElement BgClr=driver.findElement(By.name("backgroundColor"));
	  BgClr.sendKeys("#3FA646");
	  WebElement BrdrClr=driver.findElement(By.name("borderColor"));
	  BrdrClr.sendKeys("#1894C9");
	  Thread.sleep(1000);
	  WebElement Lctn=driver.findElement(By.name("location"));
	  Lctn.sendKeys("Kerala");
	  Thread.sleep(1000);
	  WebElement Dscrptn=driver.findElement(By.name("description"));
	  Dscrptn.sendKeys("Description");
	  Thread.sleep(1000);
	  WebElement SubCrtEvnt=driver.findElement(By.name("create_event"));
	  SubCrtEvnt.click();
	  Thread.sleep(3000);
	  String ActualText="Event created successfully!";
	  String ExpectedTitle=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/form/div[1]")).getText();
	  System.out.println(ExpectedTitle);
	  if(ActualText.equals(ExpectedTitle))
	  {
		  System.out.println("Event created successfully!");
	  }
	  else
	  {
			System.out.println("Error");
	  }
	  
	  
  }
  @Test(priority=3)
  public void ViewEvents() throws InterruptedException
  {
	  WebElement VwEvnts=driver.findElement(By.linkText("View Events"));
	  VwEvnts.click();
	  Thread.sleep(2000);
	  TakesScreenshot Scrnsht=(TakesScreenshot)driver;
		File fileSource=Scrnsht.getScreenshotAs(OutputType.FILE);
		String DestPth="D:\\selenium2\\Image\\screen shot\\image4.png";
		try
		{
			FileHandler.copy(fileSource, new File(DestPth));
          System.out.println("Screenshot saved to: " + DestPth);
		}
		catch(IOException e)
		{
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
  }
  @Test(priority=4)
  public void UpcomingEvents() throws InterruptedException
  {
	  WebElement UpcmgEvnts=driver.findElement(By.linkText("Upcoming Events"));
	  UpcmgEvnts.click();
	  Thread.sleep(2000);
  }
  @Test(priority=5)
  public void LogOut() throws InterruptedException
  {
	  WebElement lgout=driver.findElement(By.linkText("Logout"));
	  lgout.click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
  }
  
  @BeforeTest
  public void BrowserLaunch() throws InterruptedException 
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium2\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://campus.sicsglobal.co.in/Project/EventCalendar/index.php");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterTest
  public void QuitBrowser() throws InterruptedException 
  {
	  
	  driver.quit();
  }

}
