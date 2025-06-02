package testngpack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
  }
  @Test(priority=2)
  public void CreateEvent() throws InterruptedException 
  {
	  WebElement CrtEvnt=driver.findElement(By.linkText("Create Event"));
	  CrtEvnt.click();
	  WebElement EvntTtl=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/form/div[1]/input"));
	  EvntTtl.sendKeys("Demo Event");
	  Thread.sleep(1000);
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement StDatTme=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/form/div[2]/input"));
	  js.executeScript("arguments[0].setAttribute('value', '2025-05-30T09:30');", StDatTme);
	  Thread.sleep(1000);
	  WebElement EdDatTme=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/form/div[3]/input"));
	  js.executeScript("arguments[0].setAttribute('value', '2025-05-31T01:30');", EdDatTme);
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
  }
  @Test(priority=3)
  public void ViewEvents() throws InterruptedException
  {
	  WebElement VwEvnts=driver.findElement(By.linkText("View Events"));
	  VwEvnts.click();
	  Thread.sleep(2000);
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
