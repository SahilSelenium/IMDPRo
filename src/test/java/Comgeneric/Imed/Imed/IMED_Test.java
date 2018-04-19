package Comgeneric.Imed.Imed;

//checking that updating in github again

import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Comgeneric.Imed.Imed.WaitStatement;


public class IMED_Test {

	WebDriver driver ;
    Login Loginpage;
	 WaitStatement ws;
   
		
		
		
@BeforeClass
		
		
		public void configBeforeclass(){
			
		driver = Browser.getBrowser();

			ws = PageFactory.initElements(driver,WaitStatement.class);
           Loginpage = PageFactory.initElements(driver,Login.class);
           
          // LogouttoTPL = PageFactory.initElements(driver,Logout.class);
		}
		
		@BeforeMethod
		
		public void LoginIMed() throws Exception 		{
			
	Loginpage.loginToIMED();
	
	

		
		}
	
		
		
@Test(priority=1)	
	
	public void CustomerDashboard() 
    {
	
		ws.waitForPageToLoad();
	
     Assert.assertTrue(driver.getTitle().contains("iTrack"));
     
     driver.findElement(By.id("totalAssets")).click();
     ws.waitForPageToLoad();
     
     
  String expected =driver.findElement(By.xpath("//*[text()='Assets']")).getText();
 String actual1 = "Assets";
 
  Assert.assertEquals(actual1, expected);
  
  
  WebElement wb =   driver.findElement(By.id("CustomerId"));
     
     Select customerid = new Select(wb);
     
     customerid.selectByIndex(1);
     
     
     
 WebElement Model =   driver.findElement(By.id("ModelId"));
     
     Select Modelrid = new Select(Model);
     
     Modelrid.selectByIndex(5);
     
     
     customerid.selectByIndex(0);
     
     Modelrid.selectByIndex(0);
     
     
     driver.findElement(By.id("AssetSearchString")).sendKeys("Syringe Pump");
     
     driver.findElement(By.id("btnSearchAsset")).click();
     
//     String searchexpected =driver.findElement(By.xpath("//*[@id='divAssets']//tr[1]/td[2]")).getText();
//     String actualsearch = "Syringe Pump";
//     
//      Assert.assertEquals(searchexpected,actualsearch);
      
      driver.navigate().back();
      ws.waitForPageToLoad();
      
      driver.findElement(By.id("totalWorkOrders")).click();
      
      
      
   String expectedwo =driver.findElement(By.xpath("//*[text()='Work Orders']")).getText();
  String actual1wo = "Work Orders";
  
   Assert.assertEquals(actual1wo, expectedwo);
   
   
   
   driver.navigate().back();
   ws.waitForPageToLoad();
   
   driver.findElement(By.id("totalNewWorkOrders")).click();
   
   
   
String expectednwo =driver.findElement(By.xpath("//*[text()='Work Orders']")).getText();
String actual1nwo = "Work Orders";

Assert.assertEquals(actual1nwo, expectednwo);
   
   
driver.navigate().back();
ws.waitForPageToLoad();

driver.findElement(By.id("totalCustomers")).click();



String expectcust =driver.findElement(By.xpath("//*[text()='Customers']")).getText();
String actualcust = "Customers";

Assert.assertEquals(actualcust, expectcust);
   
   
   
   
     
    }
		
	
	 
	
	
	
		
@Test(priority =2)


		
		public void CustomerSearchBox() 
            {
			
			
             Assert.assertTrue(driver.getTitle().contains("iTrack"));
	
	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Customers")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("CustomerSearchString")).sendKeys("u");
			driver.findElement(By.xpath("//*[@id='btnSearchCustomer']/i")).click();
			
		   }
		
		
		
		
		
		
		
		
		
@Test(priority =3)



		
	    public void CreateNewCustomervalidation() throws InterruptedException 
	       
	    {
	    	   
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		
		driver.findElement(By.linkText("Customers")).click();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Add Customer")).click();
	    
	    
	  ws.waitforElementPresent(driver.findElement(By.id("btnSaveCustomer")));
	  
	  driver.findElement(By.id("btnSaveCustomer")).click();
	  
	  
	    WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='customerCreateForm']//li[1]"))));
			
		
				   
	String getvalidationCustomername =	driver.findElement(By.xpath("//*[@id='customerCreateForm']//li[1]")).getText();
	
	String expectedcustomerval = "Customer Name is required";
	
	Assert.assertEquals(getvalidationCustomername, expectedcustomerval);
	
	
				   
	    driver.findElement(By.id("CustomerName")).sendKeys("Peter Parker");

	    driver.findElement(By.id("btnSaveCustomer")).click();
	    
	    
	    
	    
	    
	   
	    
	    
	   
	    WebDriverWait wait1 = new WebDriverWait(Browser.driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Primary Email is required']"))));
			
		
				   
	String getvalidationprimary =	driver.findElement(By.xpath(".//*[text()='Primary Email is required']")).getText();
	
	
	System.out.println(getvalidationprimary);
	
	
	String expectedprimary = "Primary Email is required";
	
	Assert.assertEquals(getvalidationprimary, expectedprimary);
	
	
    
				   
	driver.findElement(By.id("PrimaryEmail")).sendKeys("john7@gmail.com");

	    driver.findElement(By.id("btnSaveCustomer")).click();
	    
	    	


	    
	    
	    
	    WebDriverWait wait2 = new WebDriverWait(Browser.driver, 20);
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Primary Contact Name is required']"))));
			
		
				   
	String getvalidationprimaryname =	driver.findElement(By.xpath(".//*[text()='Primary Contact Name is required']")).getText();
	
	
	System.out.println(getvalidationprimary);
	
	
	String expectedprimaryname = "Primary Contact Name is required";
	
	Assert.assertEquals(getvalidationprimaryname, expectedprimaryname);
	
	
    
				   
	driver.findElement(By.id("PrimaryName")).sendKeys("john");

	    driver.findElement(By.id("btnSaveCustomer")).click();
	    
	    

	    
	    
	    WebDriverWait wait3 = new WebDriverWait(Browser.driver, 20);
		wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Primary Contact Phone is required']"))));
			
		
				   
	String getvalidationprimaryno =	driver.findElement(By.xpath(".//*[text()='Primary Contact Phone is required']")).getText();
	
	
	System.out.println(getvalidationprimaryno);
	
	
	String expectedprimaryno = "Primary Contact Phone is required";
	
	Assert.assertEquals(getvalidationprimaryno, expectedprimaryno);
	
	
    
				   
	driver.findElement(By.id("PrimaryPhone")).sendKeys("8054143933");

	    driver.findElement(By.id("btnSaveCustomer")).click();
	    
	    
	    
	    
	    WebDriverWait wait4 = new WebDriverWait(Browser.driver, 20);
		wait4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Address1 is required']"))));
			
		
				   
	String getvalidationaddress =	driver.findElement(By.xpath(".//*[text()='Address1 is required']")).getText();
	
	
	
	
	
	String expectedaddress = "Address1 is required";
	
	Assert.assertEquals(getvalidationaddress, expectedaddress);
	
	
    
				   
	driver.findElement(By.id("Address1")).sendKeys("New City Street 1st house no.22");

	    driver.findElement(By.id("btnSaveCustomer")).click();
	    	    
	    
	    
	    
	    
	    
	    
	    
	    
	    WebDriverWait city = new WebDriverWait(Browser.driver, 20);
		city.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='City is required']"))));
			
		
				   
	String getvalidationcity =	driver.findElement(By.xpath(".//*[text()='City is required']")).getText();
	
	
	
	
	
	String expectedcity = "City is required";
	
	Assert.assertEquals(getvalidationcity, expectedcity);
	
	
    
				   
	driver.findElement(By.id("City")).sendKeys("New York");

	    driver.findElement(By.id("btnSaveCustomer")).click();
	  

	    
	    
	    
	    WebDriverWait state = new WebDriverWait(Browser.driver, 20);
		state.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='State is required']"))));
			
		
				   
	String getvalidationstate =	driver.findElement(By.xpath(".//*[text()='State is required']")).getText();
	
	
	
	
	
	String expectedstate = "State is required";
	
	Assert.assertEquals(getvalidationstate, expectedstate);
	
	
    
				   


	    
	    
	    WebElement wu = driver.findElement(By.id("StateId"));
	    Select s2 = new Select(wu);
	    
	    s2.selectByVisibleText("ARKANSAS"); 
	    
	    driver.findElement(By.id("btnSaveCustomer")).click();
	    
	    

	    
	    WebDriverWait zip = new WebDriverWait(Browser.driver, 20);
		zip.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Zip is required']"))));
			
		
				   
	String getvalidationzip =	driver.findElement(By.xpath(".//*[text()='Zip is required']")).getText();
	
	
	
	
	
	String expectedzip = "Zip is required";
	
	Assert.assertEquals(getvalidationzip, expectedzip);
	
	
        
	driver.findElement(By.id("ZipCode")).sendKeys("75201");
	    
	    driver.findElement(By.id("btnCloseCustomer")).click();
	    

	 
	  
	    }		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		
@Test(priority =4)



		
    public void CreateNewCustomer() throws InterruptedException 
       
    {
    	   

    
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	driver.findElement(By.linkText("Customers")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Add Customer")).click();
    WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(
    driver.findElement(By.id("CustomerName")))).sendKeys("Peter Parker");

 
    	
    driver.findElement(By.id("PrimaryEmail")).sendKeys("john1@gmail.com");
    
    
    driver.findElement(By.id("PrimaryName")).sendKeys("john");
    
    driver.findElement(By.id("PrimaryPhone")).sendKeys("8054143933");
    
    driver.findElement(By.id("WorkPhone")).sendKeys("8054143933");
    driver.findElement(By.id("WorkExtn")).sendKeys("33");
    driver.findElement(By.id("ShipAcctNumber")).sendKeys("886453");
    
   WebElement wb = driver.findElement(By.id("ShipViaId"));
    Select sl = new Select(wb);
    sl.selectByVisibleText("FedEx");
    
    driver.findElement(By.id("PMRate")).sendKeys("35");
    driver.findElement(By.id("MarkUpPercentage")).sendKeys("30");
    
    driver.findElement(By.id("Labor")).sendKeys("0.5");
		
    driver.findElement(By.className("iCheck-helper")).click();
	
    driver.findElement(By.id("MarkUpPercentage")).sendKeys("30");
		
		
    driver.findElement(By.id("Address1")).sendKeys("New City Street 1st house no.22");
		
    driver.findElement(By.id("Address2")).sendKeys("Near Park Street");
		
    driver.findElement(By.id("City")).sendKeys("New York");
    
    
    WebElement wu = driver.findElement(By.id("StateId"));
    Select s2 = new Select(wu);
    
    s2.selectByVisibleText("ARKANSAS");
    
    driver.findElement(By.id("ZipCode")).sendKeys("75201");
    
    
    
    driver.findElement(By.xpath("//*[@id='customerCreateForm']/div[1]/div/div/div[5]/div[1]/div/ins")).click();
   
    driver.findElement(By.id("Notes")).sendKeys("I need in urgent basis");
  driver.findElement(By.id("btnSaveCustomer")).click();
  
  

  
  
  for (int i =38; i<=2000;i++)
  {

	  {
		  try{
	  ws.waitforElementPresent(driver.findElement(By.id("errorSpan")));
	  
	  String Expected = driver.findElement(By.id("errorSpan")).getText();
	  String actual ="User/Customer with the same email already exists.";
	  Assert.assertEquals(actual , Expected);
	  
	  
	 
	  driver.findElement(By.id("PrimaryEmail")).clear();
	  
	  
	  
 driver.findElement(By.id("PrimaryEmail")).sendKeys("john"+i+"@gmail.com");
	  
 driver.findElement(By.id("btnSaveCustomer")).click();
	 
		 ws.waitforElementPresent(driver.findElement(By.id("CustomerSearchString")));
 driver.findElement(By.id("CustomerSearchString")).clear();
 
	 
 
	 
	  }
  
  



	  catch(Exception e)
	 {
		  break; 
	 
	    }
  
 
  }}}
    

 
  
		
		
					   
		
		    
		
		
		
@Test(priority =5)
	       
	       
	       
	       public void CustomerADDAssetValidation() throws InterruptedException
	       
	       
	  {
	       	  	
	       	driver.findElement(By.linkText("Customers")).click();
	 
	       	
	       	driver.findElement(By.linkText("Peter Parker")).click();
	       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       	driver.findElement(By.linkText("Add")).click();
	       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	       	
	       	
	       	
	       	
	       	ws.waitforElementPresent(driver.findElement(By.id("btnSaveAsset")));
	       	driver.findElement(By.id("btnSaveAsset")).click();
	       	
	       	
	        WebDriverWait Model = new WebDriverWait(Browser.driver, 20);
			Model.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Model is required']"))));
	       	
			String expectedmodel =	driver.findElement(By.xpath(".//*[text()='Model is required']")).getText();
			
			
			
			
			
			String getvalidationmodel = "Model is required";
			
			Assert.assertEquals(getvalidationmodel, expectedmodel);
			
			       	
	       	ws.waitforElementPresent(driver.findElement(By.id("ModelId")));
			 WebElement wu = driver.findElement(By.id("ModelId"));
		    Select s2 = new Select(wu);
		    
		    
		    driver.findElement(By.id("btnSaveAsset")).click();
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		  s2.selectByIndex(3);
			
		    WebElement w = driver.findElement(By.id("MakeId"));
		    Select s3 = new Select(w);
		    
		    s3.selectByIndex(3);
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    //Asset Group is required
		    
		    
	driver.findElement(By.id("btnSaveAsset")).click();
	       	
	       	
	        WebDriverWait Assset = new WebDriverWait(Browser.driver, 20);
	        Assset.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Asset Group is required']"))));
	       	
			String expectedAssset =	driver.findElement(By.xpath(".//*[text()='Asset Group is required']")).getText();
			
			
			
			
			
			String getvalidationAssset = "Asset Group is required";
			
			Assert.assertEquals(getvalidationAssset, expectedAssset);
			
			       	
	       	
			
			
		    WebElement we = driver.findElement(By.id("AssetGroupId"));
		    Select s4 = new Select(we);
		    
		    s4.selectByIndex(1);
		    
		    driver.findElement(By.id("btnSaveAsset")).click();
		    
		    
		    
		    //Customer is required
		    
		    WebDriverWait Customer = new WebDriverWait(Browser.driver, 20);
		    Customer.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Customer is required']"))));
	       	
			String expectedCustomer =	driver.findElement(By.xpath(".//*[text()='Customer is required']")).getText();
			
			
			
			
			
			String getvalidationCustomer = "Customer is required";
			
			Assert.assertEquals(getvalidationCustomer, expectedCustomer);
			
			       	
	       	
			
		    
		    WebElement wm = driver.findElement(By.id("CustomerId"));
		    Select s22 = new Select(wm);
		    
		    s22.selectByIndex(3);
		    
		    
		    driver.findElement(By.id("btnSaveAsset")).click();
		    
		    
		    //Location Type is required
		    
		    WebDriverWait Location = new WebDriverWait(Browser.driver, 20);
		    Location.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Location Type is required']"))));
	       	
			String expectedLocation =	driver.findElement(By.xpath(".//*[text()='Location Type is required']")).getText();
			
			
			
			
			
			String getvalidationLocation = "Location Type is required";
			
			Assert.assertEquals(getvalidationLocation, expectedLocation);
			
		    WebElement wz = driver.findElement(By.id("LocationTypeId"));
		    Select s6 = new Select(wz);
		    
		    s6.selectByIndex(1);
		    
		    driver.findElement(By.id("btnSaveAsset")).click();
		    
		  
               //Location is required

		    

		    
		    
		    WebDriverWait Locationid = new WebDriverWait(Browser.driver, 40);
		    Locationid.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Location is required']"))));
	       	
		    
		    
		    
			String expectedLocationid =	driver.findElement(By.xpath(".//*[text()='Location is required']")).getText();
			
			System.out.println(expectedLocationid);
			
			
			
			String getvalidationLocationid = "Location is required";
			
			Assert.assertEquals(expectedLocationid, getvalidationLocationid);
			
			Thread.sleep(4000);
			
		    WebElement wl = driver.findElement(By.id("LocationId"));
		    Select s7 = new Select(wl);
		    try{
		    s7.selectByVisibleText("Billing Address"); 
		    }
		    catch(Exception e)
		    {
		    	s7.selectByIndex(0);
		    }
			
		    driver.findElement(By.id("btnSaveAsset")).click();
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    //Serial Number is required
		    
		    WebDriverWait Serial = new WebDriverWait(Browser.driver, 20);
		    Serial.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Serial Number is required']"))));
	       	
			String expectedSerial =	driver.findElement(By.xpath(".//*[text()='Serial Number is required']")).getText();
			
			
			
			
			
			String actualSerial = "Serial Number is required";
			
			Assert.assertEquals(expectedSerial, actualSerial);
			driver.findElement(By.id("SerialNumber")).sendKeys("345344");
			
			driver.findElement(By.id("btnSaveAsset")).click();
			
			
			
			//Customer Asset Number is required
			WebDriverWait AssetNumber = new WebDriverWait(Browser.driver, 20);
			AssetNumber.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Customer Asset Number is required']"))));
	       	
			String expectedAssetNumber =	driver.findElement(By.xpath(".//*[text()='Customer Asset Number is required']")).getText();
			
			
			
			
			
			String actualAssetNumber = "Customer Asset Number is required";
			
			Assert.assertEquals(actualAssetNumber, expectedAssetNumber);
			driver.findElement(By.id("SerialNumber")).sendKeys("345344");
			
			driver.findElement(By.id("btnSaveAsset")).click();
			
	
			
			
			
			
			
			
			
			
			driver.findElement(By.id("CustomerAssetNumber")).sendKeys("6655");
			
		
			
			
			driver.findElement(By.id("Cost")).sendKeys("390.4");
			driver.findElement(By.id("CustomerAccountNumber")).sendKeys("7656453445");
			driver.findElement(By.id("btnSaveAsset")).click();
			//PM Month is required
			
			
			WebDriverWait PMMonth = new WebDriverWait(Browser.driver, 20);
			PMMonth.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='PM Month is required']"))));
	       	
			String expectedPMMonth =	driver.findElement(By.xpath(".//*[text()='PM Month is required']")).getText();
			
			
			
			
			
			String actualPMMonth = "PM Month is required";
			
			Assert.assertEquals(expectedPMMonth, actualPMMonth);
			 WebElement wc = driver.findElement(By.id("PMMonth"));
			    Select s8 = new Select(wc);
			    
			    s8.selectByVisibleText("March");
			    driver.findElement(By.id("btnSaveAsset")).click();
			    
			    
	            
			    //Frequency is required
			    
			    WebDriverWait PMFrequency = new WebDriverWait(Browser.driver, 20);
			    PMFrequency.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Frequency is required']"))));
		       	
				String expectedPMFrequency =	driver.findElement(By.xpath(".//*[text()='Frequency is required']")).getText();
				
				
				
				
				
				String actualPMFrequency = "Frequency is required";
				
				Assert.assertEquals(expectedPMFrequency, actualPMFrequency);
			    
			    WebElement ws = driver.findElement(By.id("PMFrequency"));
			    Select s9 = new Select(ws);
			    
			    s9.selectByIndex(1);
			    
			    
			   
			    
			    
			driver.findElement(By.id("Notes")).sendKeys("I need this on Urgent basis");
		    
		    driver.findElement(By.id("btnClose")).click();
		    Thread.sleep(6000);
		    driver.findElement(By.linkText("Back")).click();
			
	       }
	  
  
 

    
  
    
         
		
      
       
@Test(priority =6)
       
       
       
       public void CustomerADDAsset() throws InterruptedException
       
       
  {
       	  	
       	driver.findElement(By.linkText("Customers")).click();

       	
       	driver.findElement(By.linkText("Peter Parker")).click();
       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       	driver.findElement(By.linkText("Add")).click();
       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
       	ws.waitforElementPresent(driver.findElement(By.id("ModelId")));
		 WebElement wu = driver.findElement(By.id("ModelId"));
	    Select s2 = new Select(wu);
	    
	  s2.selectByIndex(3);
		
	    WebElement w = driver.findElement(By.id("MakeId"));
	    Select s3 = new Select(w);
	    
	    s3.selectByIndex(3);
	    
		
		
	    WebElement we = driver.findElement(By.id("AssetGroupId"));
	    Select s4 = new Select(we);
	    
	    s4.selectByIndex(1);
	    
	    
	    WebElement wm = driver.findElement(By.id("CustomerId"));
	    Select s22 = new Select(wm);
	    
	    s22.selectByIndex(3);
	    
	    

		
	    WebElement wz = driver.findElement(By.id("LocationTypeId"));
	    Select s6 = new Select(wz);
	    
	    s6.selectByIndex(1);
		
		
	    WebElement wl = driver.findElement(By.id("LocationId"));
	    Select s7 = new Select(wl);
	    
	    s7.selectByIndex(1);
		
		driver.findElement(By.id("SerialNumber")).sendKeys("345344");
		driver.findElement(By.id("CustomerAssetNumber")).sendKeys("6655");
		driver.findElement(By.id("Cost")).sendKeys("390.4");
		driver.findElement(By.id("CustomerAccountNumber")).sendKeys("7656453445");
		
		
		 WebElement wc = driver.findElement(By.id("PMMonth"));
		    Select s8 = new Select(wc);
		    
		    s8.selectByVisibleText("March");
		    
		    WebElement ws = driver.findElement(By.id("PMFrequency"));
		    Select s9 = new Select(ws);
		    
		    s9.selectByVisibleText("Semi-Annually");
		driver.findElement(By.id("Notes")).sendKeys("I need this on Urgent basis");
	    
	    driver.findElement(By.id("btnSaveAsset")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.linkText("Back")).click();
		
       }
       
@Test(priority =7)
       
       
       public void CustomerADDLocationValidations() throws InterruptedException, AWTException {
       	
       	
       	driver.findElement(By.linkText("Customers")).click();
        
       	driver.findElement(By.linkText("Peter Parker")).click();
       	
        
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        
        jse.executeScript("window.scrollBy(0,390)", "");
        
      

        
       	
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	
       driver.findElement(By.xpath("//div[6]//div[1][@class='col-lg-6 col-xs-12 col-sm-12']//a/i")).click();
       
       //Location Name is required
       
       ws.waitforElementPresent(driver.findElement(By.id("btnSaveLocation")));
       driver.findElement(By.id("btnSaveLocation")).click();
             ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Location Name is required']"))));
      	
		String expectedAssetLocation =	driver.findElement(By.xpath(".//*[text()='Location Name is required']")).getText();
		
		
		
		
		
		String actualAssetLocation = "Location Name is required";
		
		Assert.assertEquals(actualAssetLocation, expectedAssetLocation);
		
		
       
       
       ws.waitforElementPresent(driver.findElement(By.id("LocationName")));
       
       driver.findElement(By.id("LocationName")).sendKeys("SanFranCisco");
       driver.findElement(By.id("btnSaveLocation")).click();
       //Address1 is required
       WebDriverWait Address1 = new WebDriverWait(Browser.driver, 20);
       Address1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Address1 is required']"))));
      	
		String expectedAssetAddress1 =	driver.findElement(By.xpath(".//*[text()='Address1 is required']")).getText();
		
		
		
		
		
		String actualAssetAddress1 = "Address1 is required";
		
		Assert.assertEquals(actualAssetAddress1, expectedAssetAddress1);
       
       driver.findElement(By.id("Address1")).sendKeys("Church Street House 232");
       
     
       
       driver.findElement(By.id("Address2")).sendKeys("Near by Big Belly Burger ");
       
       driver.findElement(By.id("btnSaveLocation")).click();
       
       //City is required
       WebDriverWait City = new WebDriverWait(Browser.driver, 20);
       City.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='City is required']"))));
      	
		String expectedAssetCity =	driver.findElement(By.xpath(".//*[text()='City is required']")).getText();
		
		
		
		
		
		String actualAssetCity = "City is required";
		
		Assert.assertEquals(actualAssetCity, expectedAssetCity);
       
       driver.findElement(By.id("City")).sendKeys("NewCity");
       driver.findElement(By.id("btnSaveLocation")).click();
       
       //State is required
       WebDriverWait StateId = new WebDriverWait(Browser.driver, 20);
       StateId.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='State is required']"))));
      	
		String expectedStateId =	driver.findElement(By.xpath(".//*[text()='State is required']")).getText();
		
		
		
		
		
		String actualStateId = "State is required";
		
		Assert.assertEquals(expectedStateId, actualStateId);
       WebElement we = driver.findElement(By.id("StateId"));
	    Select s4 = new Select(we);
	    
	    s4.selectByIndex(2);
	    
	    driver.findElement(By.id("btnSaveLocation")).click();
       
	       //ZipCode is required
	       WebDriverWait Zip = new WebDriverWait(Browser.driver, 20);
	       Zip.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='ZipCode is required']"))));
	      	
			String expectedZip =	driver.findElement(By.xpath(".//*[text()='ZipCode is required']")).getText();
			
			
			
			
			
			String actualZip = "ZipCode is required";
			
			Assert.assertEquals(expectedZip, actualZip);
			
       driver.findElement(By.id("Zip")).sendKeys("75201");
      
       driver.findElement(By.id("btnCloseLocation")).click();

    
      
     
     }      

       
       
		
		
      
@Test(priority =8)
       
       
       public void CustomerADDLocation() throws InterruptedException, AWTException {
       	
       	
       	driver.findElement(By.linkText("Customers")).click();
       
        
       	driver.findElement(By.linkText("Peter Parker")).click();
       	
        
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        
        jse.executeScript("window.scrollBy(0,390)", "");
        
      

        
       	
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	
       driver.findElement(By.xpath("//div[6]//div[1][@class='col-lg-6 col-xs-12 col-sm-12']//a/i")).click();
       Thread.sleep(3000);
       ws.waitforElementPresent(driver.findElement(By.id("LocationName")));
       driver.findElement(By.id("LocationName")).sendKeys("SanFranCisco");
       driver.findElement(By.id("Address1")).sendKeys("Church Street House 232");
       driver.findElement(By.id("Address2")).sendKeys("Near by Big Belly Burger ");
       driver.findElement(By.id("City")).sendKeys("NewCity");
       WebElement we = driver.findElement(By.id("StateId"));
	    Select s4 = new Select(we);
	    
	    s4.selectByVisibleText("AMERICAN SAMOA");
       
       
       driver.findElement(By.id("Zip")).sendKeys("75201");
      
     driver.findElement(By.id("btnSaveLocation")).click();

    
      
     
     }      



@Test(priority =9)



     public void CustomerADDWarehousevalidation() throws InterruptedException{
	
	
      driver.findElement(By.linkText("Customers")).click();
      
      
      driver.findElement(By.linkText("Peter Parker")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      JavascriptExecutor jse =(JavascriptExecutor)driver;
      
      jse.executeScript("window.scrollBy(0,390)", "");
      
      
      
      driver.findElement(By.xpath("//div[6]//div[2][@class='col-lg-6 col-xs-12 col-sm-12']//a/i")).click();
      ws.waitforElementPresent(driver.findElement(By.id("btnSaveLocation")));
      driver.findElement(By.id("btnSaveLocation")).click();
            ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Location Name is required']"))));
     	
		String expectedAssetLocation =	driver.findElement(By.xpath(".//*[text()='Location Name is required']")).getText();
		
		
		
		
		
		String actualAssetLocation = "Location Name is required";
		
		Assert.assertEquals(actualAssetLocation, expectedAssetLocation);
		
		
      
      
      ws.waitforElementPresent(driver.findElement(By.id("LocationName")));
      
      driver.findElement(By.id("LocationName")).sendKeys("SanFranCisco");
      driver.findElement(By.id("btnSaveLocation")).click();
      //Address1 is required
      WebDriverWait Address1 = new WebDriverWait(Browser.driver, 20);
      Address1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Address1 is required']"))));
     	
		String expectedAssetAddress1 =	driver.findElement(By.xpath(".//*[text()='Address1 is required']")).getText();
		
		
		
		
		
		String actualAssetAddress1 = "Address1 is required";
		
		Assert.assertEquals(actualAssetAddress1, expectedAssetAddress1);
      
      driver.findElement(By.id("Address1")).sendKeys("Church Street House 232");
      
    
      
      driver.findElement(By.id("Address2")).sendKeys("Near by Big Belly Burger ");
      
      driver.findElement(By.id("btnSaveLocation")).click();
      
      //City is required
      WebDriverWait City = new WebDriverWait(Browser.driver, 20);
      City.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='City is required']"))));
     	
		String expectedAssetCity =	driver.findElement(By.xpath(".//*[text()='City is required']")).getText();
		
		
		
		
		
		String actualAssetCity = "City is required";
		
		Assert.assertEquals(actualAssetCity, expectedAssetCity);
      
      driver.findElement(By.id("City")).sendKeys("NewCity");
      driver.findElement(By.id("btnSaveLocation")).click();
      
      //State is required
      WebDriverWait StateId = new WebDriverWait(Browser.driver, 20);
      StateId.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='State is required']"))));
     	
		String expectedStateId =	driver.findElement(By.xpath(".//*[text()='State is required']")).getText();
		
		
		
		
		
		String actualStateId = "State is required";
		
		Assert.assertEquals(expectedStateId, actualStateId);
      WebElement we = driver.findElement(By.id("StateId"));
	    Select s4 = new Select(we);
	    
	    s4.selectByIndex(2);
	    
	    driver.findElement(By.id("btnSaveLocation")).click();
      
	       //ZipCode is required
	       WebDriverWait Zip = new WebDriverWait(Browser.driver, 20);
	       Zip.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='ZipCode is required']"))));
	      	
			String expectedZip =	driver.findElement(By.xpath(".//*[text()='ZipCode is required']")).getText();
			
			
			
			
			
			String actualZip = "ZipCode is required";
			
			Assert.assertEquals(expectedZip, actualZip);
			
      driver.findElement(By.id("Zip")).sendKeys("75201");
     
      driver.findElement(By.id("btnCloseLocation")).click();
      
      
      
      
      
}


@Test(priority =10)



public void CustomerADDWareHouse() throws InterruptedException{


 driver.findElement(By.linkText("Customers")).click();

 driver.findElement(By.linkText("Peter Parker")).click();
 
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 
 JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,590)", "");
	
 driver.findElement(By.xpath("//div[6]//div[2][@class='col-lg-6 col-xs-12 col-sm-12']//a/i")).click();
 
 ws.waitforElementPresent(driver.findElement(By.id("LocationName")));
 driver.findElement(By.id("LocationName")).sendKeys("SanFranCisco");
 driver.findElement(By.id("Address1")).sendKeys("Church Street House 232");
 driver.findElement(By.id("Address2")).sendKeys("Near by Big Belly Burger ");
 driver.findElement(By.id("City")).sendKeys("NewCity");

 
 WebElement we = driver.findElement(By.id("StateId"));

 Select s4 = new Select(we);

 s4.selectByVisibleText("AMERICAN SAMOA");


driver.findElement(By.id("Zip")).sendKeys("75201");

driver.findElement(By.id("btnSaveLocation")).click();


}
@Test(priority =11)



public void CustomerUser() throws InterruptedException{
	

 driver.findElement(By.linkText("Customers")).click();

driver.findElement(By.linkText("Narmada")).click();
 
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 JavascriptExecutor jse = (JavascriptExecutor)driver;
 jse.executeScript("window.scrollBy(0,690)", "");
 
 
 
 
 
 
 driver.findElement(By.xpath("//div[7]//div[1][@class='col-lg-6 col-xs-12 col-sm-12']//*[@class='fa fa-plus']")).click();
 
 
ws.waitforElementPresent(driver.findElement(By.id("FirstName")));
 driver.findElement(By.id("FirstName")).sendKeys("Skyler");
 driver.findElement(By.id("LastName")).sendKeys("Walter");
 driver.findElement(By.id("btnSaveUser")).click();
//The Email field is required.
 WebDriverWait email = new WebDriverWait(Browser.driver, 20);
 email.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='The Email field is required.']"))));
	
	String expectedAssetCity =	driver.findElement(By.xpath(".//*[text()='The Email field is required.']")).getText();
	
	
	
	
	
	String actualAssetCity = "The Email field is required.";
	
	Assert.assertEquals(actualAssetCity, expectedAssetCity);
 
 
 
 driver.findElement(By.id("Email")).sendKeys("Sky22@gmail.com");
 
 driver.findElement(By.id("btnSaveUser")).click();
 Thread.sleep(3000);
 JavascriptExecutor js1e = (JavascriptExecutor)driver;
 js1e.executeScript("window.scrollBy(0,790)", "");
 
 ws.waitforElementPresent(driver.findElement(By.xpath("//*[@id='divCustomerUsers']//i")));
 
 driver.findElement(By.xpath("//*[@id='divCustomerUsers']//i")).click();
 
 Alert alt = driver.switchTo().alert();
 alt.accept();
 Thread.sleep(3000);
 ws.waitforElementPresent(driver.findElement(By.xpath("//*[@id='divCustomerUsers']//i")));
 
driver.findElement(By.xpath("//*[@id='divCustomerUsers']//i")).click();
 
 Alert alt1 = driver.switchTo().alert();
 alt1.accept();
}





@Test(priority =12)


              public void EditCustomer(){
	
	
	         driver.findElement(By.linkText("Customers")).click();
	         driver.findElement(By.linkText("Edit")).click();

    

    ws.waitforElementPresent(driver.findElement(By.id("PrimaryPhone")));
    driver.findElement(By.id("PrimaryPhone")).clear();
    driver.findElement(By.id("PrimaryPhone")).sendKeys("8054143999");
    driver.findElement(By.id("WorkPhone")).clear();
    driver.findElement(By.id("WorkPhone")).sendKeys("8054143939");
   
    
    
   WebElement wb = driver.findElement(By.id("ShipViaId"));
    Select sl = new Select(wb);
    sl.selectByIndex(1);    
    driver.findElement(By.id("PMRate")).clear();
    driver.findElement(By.id("PMRate")).sendKeys("36");
    
    

		
    driver.findElement(By.id("Address1")).clear();
    driver.findElement(By.id("Address1")).sendKeys("New Super City Street 1st house no.22");
		
   
    
    
    WebElement wu = driver.findElement(By.id("StateId"));
    Select s2 = new Select(wu);
    
    s2.selectByVisibleText("ARKANSAS");
    driver.findElement(By.id("ZipCode")).clear();
    driver.findElement(By.id("ZipCode")).sendKeys("75202");
	
	    driver.findElement(By.id("btnSaveCustomer")).click();
	    
}

@Test(priority =13)

  
public void DelCustomer(){
	  
	  
	  
          driver.findElement(By.linkText("Customers")).click();
          driver.findElement(By.linkText("Delete")).click();

           Alert alert=driver.switchTo().alert();		

   
           String alertMessage=driver.switchTo().alert().getText();		
		
	
           System.out.println(alertMessage);
           
          String expectedvalue = "This will De-Activate Customer from the system. Continue?";
          
         
           
		Assert.assertEquals(alertMessage, expectedvalue );
		
            alert.accept();	

}

		
//////////************************************************ModuleAssets*********************************************************

 
@Test(priority =14)
  
  
		public void SearchAsset() 
		
		
      {
		
	    driver.findElement(By.linkText("Assets")).click();
	
		ws.waitForPageToLoad();
	     
	     
		 String expected =driver.findElement(By.xpath("//*[text()='Assets']")).getText();
		 String actual1 = "Assets";
		 
		Assert.assertEquals(actual1, expected);
		  
		driver.findElement(By.linkText("Assets")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 
		
		driver.findElement(By.id("AssetSearchString")).sendKeys("moint",Keys.ENTER); 
		
		String expectedsearch =driver.findElement(By.xpath("//*[text()='NO ASSETS FOUND']")).getText();
		 String actuasearch = "NO ASSETS FOUND";
		 
		Assert.assertEquals(actuasearch,expectedsearch);
		
		driver.findElement(By.id("AssetSearchString")).clear();
		driver.findElement(By.id("AssetSearchString")).sendKeys("Point",Keys.ENTER);
		String expectedpoint =driver.findElement(By.xpath("//*[@id='divAssets']//tr[1]/td[2]")).getText();
		 String actual1point = "Point of Contact Unit";
		 
		Assert.assertEquals(expectedpoint, actual1point);
		

	
		
      }


@Test(priority=15)

public void searchassetbydropdown(){
	
	
	driver.findElement(By.linkText("Assets")).click();
	ws.waitForPageToLoad();
    
    
	  String expected =driver.findElement(By.xpath("//*[text()='Assets']")).getText();
	 String actual1 = "Assets";
	 
	  Assert.assertEquals(actual1, expected);
	  
	  
	  WebElement wb =   driver.findElement(By.id("CustomerId"));
	     
	     Select customerid = new Select(wb);
	     
	     customerid.selectByIndex(1);
	     
	     
	     
	 WebElement Model =   driver.findElement(By.id("ModelId"));
	     
	     Select Modelrid = new Select(Model);
	     
	     Modelrid.selectByIndex(5);
	     
	     

	
}
		
@Test  (priority =16)



public void AddAssetvalidation() throws InterruptedException 
  {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Assets")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Add Asset")).click();
	
	
	Thread.sleep(3000);
	ws.waitforElementPresent(driver.findElement(By.id("btnSaveAsset")));
	driver.findElement(By.id("btnSaveAsset")).click();
   	
   	
    WebDriverWait Assset = new WebDriverWait(Browser.driver, 20);
    Assset.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Model is required']"))));
   	
	String expectedModelId =	driver.findElement(By.xpath(".//*[text()='Model is required']")).getText();
	
	
	
	
	
	String actualModelId = "Model is required";
	
	Assert.assertEquals(expectedModelId, actualModelId);
	
	
	ws.waitforElementPresent(driver.findElement(By.id("ModelId")));
	 WebElement wu = driver.findElement(By.id("ModelId"));;
    Select s2 = new Select(wu);
    
  s2.selectByIndex(2);
  
  
    WebElement w = driver.findElement(By.id("MakeId"));
    Select s3 = new Select(w);
    
    s3.selectByIndex(3);
    
    driver.findElement(By.id("btnSaveAsset")).click();
 	
 	
    WebDriverWait Assset1 = new WebDriverWait(Browser.driver, 20);
    Assset1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Asset Group is required']"))));
   	
  	String expectedAsset =	driver.findElement(By.xpath(".//*[text()='Asset Group is required']")).getText();
  	
  	
  	
  	
  	
  	String actualMAsset = "Asset Group is required";
  	
  	Assert.assertEquals(expectedAsset, actualMAsset);
  	
	
    WebElement we = driver.findElement(By.id("AssetGroupId"));
    Select s4 = new Select(we);
    
    s4.selectByIndex(1);
    
    //Customer is required
    
driver.findElement(By.id("btnSaveAsset")).click();
 	
 	
    WebDriverWait Customer = new WebDriverWait(Browser.driver, 20);
    Customer.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Customer is required']"))));
   	
  	String expectedCustomer =	driver.findElement(By.xpath(".//*[text()='Customer is required']")).getText();
  	
  	
  	
  	
  	
  	String actualCustomer = "Customer is required";
  	
  	Assert.assertEquals(expectedCustomer, actualCustomer);
  	
    WebElement wm = driver.findElement(By.id("CustomerId"));
    Select s22 = new Select(wm);
    
    s22.selectByIndex(2);
    
    //Location Type is required

     driver.findElement(By.id("btnSaveAsset")).click();
 	
 	
    WebDriverWait LocationTypeId = new WebDriverWait(Browser.driver, 20);
    LocationTypeId.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Location Type is required']"))));
   	
  	String expectedLocationTypeId =	driver.findElement(By.xpath(".//*[text()='Location Type is required']")).getText();
  	
  	
  	
  	
  	
  	String actualLocationTypeId = "Location Type is required";
  	
  	Assert.assertEquals(expectedLocationTypeId, actualLocationTypeId);
  	
	
    WebElement wz = driver.findElement(By.id("LocationTypeId"));
    Select s6 = new Select(wz);
    
    s6.selectByIndex(1);
	//Location is required
    
driver.findElement(By.id("btnSaveAsset")).click();
 	
 	
    WebDriverWait LocationId = new WebDriverWait(Browser.driver, 20);
    LocationId.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Location is required']"))));
   	
  	String expectedLocationId =	driver.findElement(By.xpath(".//*[text()='Location is required']")).getText();
  	
  	
  	
  	
  	
  	String actualLocationId = "Location is required";
  	
  	Assert.assertEquals(expectedLocationId, actualLocationId);
  	
    WebElement wl = driver.findElement(By.id("LocationId"));
    Select s7 = new Select(wl);
    
    s7.selectByIndex(1);
	
  //Serial Number is required
    
    WebDriverWait Serial = new WebDriverWait(Browser.driver, 20);
    Serial.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Serial Number is required']"))));
   	
	String expectedSerial =	driver.findElement(By.xpath(".//*[text()='Serial Number is required']")).getText();
	
	
	
	
	
	String actualSerial = "Serial Number is required";
	
	Assert.assertEquals(expectedSerial, actualSerial);
	driver.findElement(By.id("SerialNumber")).sendKeys("345344");
	
	driver.findElement(By.id("btnSaveAsset")).click();
	
	
	
	//Customer Asset Number is required
	WebDriverWait AssetNumber = new WebDriverWait(Browser.driver, 20);
	AssetNumber.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Customer Asset Number is required']"))));
   	
	String expectedAssetNumber =	driver.findElement(By.xpath(".//*[text()='Customer Asset Number is required']")).getText();
	
	
	
	
	
	String actualAssetNumber = "Customer Asset Number is required";
	
	Assert.assertEquals(actualAssetNumber, expectedAssetNumber);
	driver.findElement(By.id("SerialNumber")).sendKeys("345344");
	
	driver.findElement(By.id("btnSaveAsset")).click();
	

	
	
	
	
	
	
	
	
	driver.findElement(By.id("CustomerAssetNumber")).sendKeys("6655");
	

	
	
	driver.findElement(By.id("Cost")).sendKeys("390.4");
	driver.findElement(By.id("CustomerAccountNumber")).sendKeys("7656453445");
	driver.findElement(By.id("btnSaveAsset")).click();
	//PM Month is required
	
	
	WebDriverWait PMMonth = new WebDriverWait(Browser.driver, 20);
	PMMonth.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='PM Month is required']"))));
   	
	String expectedPMMonth =	driver.findElement(By.xpath(".//*[text()='PM Month is required']")).getText();
	
	
	
	
	
	String actualPMMonth = "PM Month is required";
	
	Assert.assertEquals(expectedPMMonth, actualPMMonth);
	 WebElement wc = driver.findElement(By.id("PMMonth"));
	    Select s8 = new Select(wc);
	    
	    s8.selectByVisibleText("March");
	    driver.findElement(By.id("btnSaveAsset")).click();
	    
	    
        
	    //Frequency is required
	    
	    WebDriverWait PMFrequency = new WebDriverWait(Browser.driver, 20);
	    PMFrequency.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Frequency is required']"))));
       	
		String expectedPMFrequency =	driver.findElement(By.xpath(".//*[text()='Frequency is required']")).getText();
		
		
		
		
		
		String actualPMFrequency = "Frequency is required";
		
		Assert.assertEquals(expectedPMFrequency, actualPMFrequency);
	    
	    WebElement ws = driver.findElement(By.id("PMFrequency"));
	    Select s9 = new Select(ws);
	    
	    s9.selectByIndex(1);
	    
	    
	   
	    
	    
	driver.findElement(By.id("Notes")).sendKeys("I need this on Urgent basis");
    
    driver.findElement(By.id("btnClose")).click();

	
   }

	
   

		
@Test  (priority =17)
		
		
		
		public void AddAsset() throws InterruptedException 
	      {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Assets")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Add Asset")).click();
			
			
			Thread.sleep(3000);
			
			
			ws.waitforElementPresent(driver.findElement(By.id("ModelId")));
			 WebElement wu = driver.findElement(By.id("ModelId"));;
		    Select s2 = new Select(wu);
		    
		  s2.selectByIndex(2);
			
		    WebElement w = driver.findElement(By.id("MakeId"));
		    Select s3 = new Select(w);
		    
		    s3.selectByIndex(3);
		    
			
			
		    WebElement we = driver.findElement(By.id("AssetGroupId"));
		    Select s4 = new Select(we);
		    
		    s4.selectByIndex(1);
		    
		    
		    WebElement wm = driver.findElement(By.id("CustomerId"));
		    Select s22 = new Select(wm);
		    
		    s22.selectByIndex(2);
		    
		    

			
		    WebElement wz = driver.findElement(By.id("LocationTypeId"));
		    Select s6 = new Select(wz);
		    
		    s6.selectByIndex(1);
			
			
		    WebElement wl = driver.findElement(By.id("LocationId"));
		    Select s7 = new Select(wl);
		    
		    s7.selectByIndex(1);
			
			driver.findElement(By.id("SerialNumber")).sendKeys("345344");
			driver.findElement(By.id("CustomerAssetNumber")).sendKeys("6655");
			driver.findElement(By.id("Cost")).sendKeys("390.4");
			driver.findElement(By.id("CustomerAccountNumber")).sendKeys("7656453445");
			
			
			 WebElement wc = driver.findElement(By.id("PMMonth"));
			    Select s8 = new Select(wc);
			    
			    s8.selectByVisibleText("March");
			    
			    WebElement ws = driver.findElement(By.id("PMFrequency"));
			    Select s9 = new Select(ws);
			    
			    s9.selectByVisibleText("Semi-Annually");
			driver.findElement(By.id("Notes")).sendKeys("I need this on Urgent basis");
		    
		   driver.findElement(By.id("btnSaveAsset")).click();
		    Thread.sleep(4000);
		  
			
	       }
		
@Test(priority =18)
		
		
		public void AssetHistory() 
      {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Assets")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("AssetSearchString")).sendKeys("Pump",Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[1]/td[1]/a")).click();
		
		
      }	
		
		
@Test(priority =19)
		
		
		
		public void AssetComments() 
      {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Assets")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("AssetSearchString")).sendKeys("Pump",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[1]/td[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("tab_2")).click();
		driver.findElement(By.id("txtComment")).sendKeys("I have to do this on immediate basis");
		driver.findElement(By.id("btnSendComment")).click();
      }	
				
		
		
		
@Test(priority =20)
		
		
		
		
		public void AssetCheckWorkOrders() 
      {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Assets")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("AssetSearchString")).sendKeys("Point of Contact Unit",Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[1]/td[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("tab_3")).click();
	
		
		
      }	
		
		
		

@Test(priority =21)

//upload code
public void AssetDocuments() throws InterruptedException, AWTException 
{
	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Assets")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("AssetSearchString")).sendKeys("Pump",Keys.ENTER);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[1]/td[1]/a")).click();
driver.findElement(By.id("tab_5")).click();
Thread.sleep(3000);
driver.findElement(By.linkText("Upload")).click();
ws.waitforElementPresent(driver.findElement(By.id("OriginalName")));
driver.findElement(By.id("OriginalName")).sendKeys("File");
driver.findElement(By.id("file")).click();
Thread.sleep(4000);	
StringSelection ss = new StringSelection("firebug issue.png");
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

//imitate mouse events like ENTER, CTRL+C, CTRL+V

Thread.sleep(4000);

Robot robot = new Robot();

robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_CONTROL);



Thread.sleep(4000);	
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);

Thread.sleep(4000);
Browser.driver.manage().timeouts().
implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("btnSaveDocument")).click();
String successmsg = driver.findElement(By.id("toast-container")).getText();


Assert.assertTrue(successmsg.contains("Saved"), "");


WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
   wait.until(ExpectedConditions.visibilityOf(
driver.findElement(By.linkText("Delete")))).click();
   
Thread.sleep(3000);
}	
		
@Test(priority =22)


public void AssetsAttribute()
{
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Assets")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("AssetSearchString")).sendKeys("Point of Contact Unit",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[1]/td[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("tab_4")).click();

}	

		
@Test(priority =23)



public void AssetCheckINforSchedule() throws InterruptedException


{

	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Assets")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("AssetSearchString")).sendKeys("Enteral Feeding Pump",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[1]/td[8]/div/a")).click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(2000);
driver.findElement(By.linkText("Check-In Asset")).click();	
Thread.sleep(2000);
driver.findElement(By.linkText("YES")).click();	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 WebElement wu = driver.findElement(By.id("WorkOrderTypeId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("Schedule");
	

driver.findElement(By.id("ReportProblemNotes")).sendKeys("update Report Problem Notes");

driver.findElement(By.id("RepairSummaryNotes")).sendKeys("update about Repair Summary Notes");

WebElement w = driver.findElement(By.id("0"));
Select s3 = new Select(w);

s3.selectByIndex(1);

WebElement w2 = driver.findElement(By.id("1"));
Select s4 = new Select(w2);

s4.selectByIndex(1);


WebElement l = driver.findElement(By.id("2"));
Select s5 = new Select(l);

s5.selectByIndex(1);

Thread.sleep(4000);
//driver.findElement(By.xpath("//*[@id='partTable']//tr[1]/td[8]//i")).click();



JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,690)", "");

try{

	

driver.findElement(By.xpath("//*[@id='btnSave']")).click();
}
catch(Exception e)
{
	driver.findElement(By.id("btnSaveAndSend")).click();
}


}	
		
		
@Test(priority =24)



public void AssetCheckINforUNSchedule() throws InterruptedException


{
	
	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Assets")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("AssetSearchString")).sendKeys("Enteral Feeding Pump",Keys.ENTER);
driver.findElement(By.linkText("123456")).click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Check-In Asset")).click();	
Thread.sleep(2000);
driver.findElement(By.linkText("YES")).click();	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 WebElement wu = driver.findElement(By.id("WorkOrderTypeId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("UnScheduled");


WebElement wm = driver.findElement(By.id("IssueTypeId"));

Select s4 = new Select(wm);

s4.selectByIndex(1);

driver.findElement(By.id("ReportProblemNotes")).sendKeys("update Report Problem Notes");

driver.findElement(By.id("RepairSummaryNotes")).sendKeys("update about Repair Summary Notes");

WebElement w = driver.findElement(By.id("0"));
Select s3 = new Select(w);

s3.selectByIndex(1);

WebElement w2 = driver.findElement(By.id("1"));
Select su4 = new Select(w2);

su4.selectByIndex(1);


WebElement l = driver.findElement(By.id("2"));
Select s5 = new Select(l);

s5.selectByIndex(1);

driver.findElement(By.xpath("//*[@id='partTable']//tr[1]/td[8]//i")).click();
JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,690)", "");
driver.findElement(By.id("btnCancel")).click();
}




//@Test(priority =11)
//
//
//public void Customerphonenumbervalidation(){
//	
//		
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}
//
//
//@Test(priority =12)
//
//
//public void CustomerADDAssset(){
//	
//		
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}
//
//@Test(priority =13)
//
//
//public void AddEmployeEmailerrmsgmising(){
//	
//		
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}
//
//
//@Test(priority =14)
//
//
//public void Delwarningmsgmising(){
//	
//		
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}
//
//
//@Test(priority =15)
//
//
//public void CustomerAcceptingDouplicateEmailidinEdit(){
//	
//		
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}
//
//@Test(priority =16)
//
//
//public void Employeemobileno(){
//	
//		
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}





	

		


		










      	
		
				
				

		




//////*************************************************work Order************************************************************
	

	
@Test(priority =25)

	
	
	
public void WorkOrderviewAsset() throws InterruptedException{

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Work Orders")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[1]/td[9]/div/a")).click();

driver.findElement(By.linkText("View Asset")).click();
}


@Test(priority =26)





public void WorkOrderCheckStatus() throws InterruptedException{

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElement(By.linkText("Work Orders")).click();

Thread.sleep(3000);

driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[1]/td[2]/a")).click();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


Thread.sleep(3000);
}



@Test(priority =27)





public void WorkOrderApprovedINRepair() throws InterruptedException{


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Work Orders")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/a")).click();


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



//driver.findElement(By.linkText("Change Status")).click();

driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/ul/li[1]/a")).click();

ws.waitforElementPresent(driver.findElement(By.id("WorkOrderStatusId")));

WebElement wu = driver.findElement(By.id("WorkOrderStatusId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("Approved - In Repair");

WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
wait.until(ExpectedConditions.visibilityOf(
driver.findElement(By.id("PONumber")))).sendKeys("23412");
driver.findElement(By.id("btnChangeStatus")).click();




Thread.sleep(4000);
}


@Test(priority =28)



public void WorkOrderShippedtoVendor() throws InterruptedException {

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Work Orders")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Thread.sleep(3000);

driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/a")).click();


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/ul/li[1]/a")).click();

ws.waitforElementPresent(driver.findElement(By.id("WorkOrderStatusId")));
//driver.findElement(By.linkText("Change Status")).click();


WebElement wu = driver.findElement(By.id("WorkOrderStatusId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("Shipped to Vendor");



WebElement w = driver.findElement(By.id("VendorId"));
Select s = new Select(w);

s.selectByIndex(1);

driver.findElement(By.id("Notes")).sendKeys("Sending Asset through vendor");

driver.findElement(By.id("btnChangeStatus")).click();

Thread.sleep(4000);

}

@Test(priority =29)


public void CheckInVender() throws InterruptedException {


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Work Orders")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Thread.sleep(3000);

driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/a")).click();


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/ul/li[1]/a")).click();

ws.waitforElementPresent(driver.findElement(By.id("WorkOrderStatusId")));
//driver.findElement(By.linkText("Change Status")).click();


WebElement wu = driver.findElement(By.id("WorkOrderStatusId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("Checked in - Vendor");



driver.findElement(By.id("Notes")).sendKeys("Sending Asset through vendor");

driver.findElement(By.id("btnChangeStatus")).click();


Thread.sleep(4000);



}



@Test(priority =30)




public void WorkOrderComplete() throws InterruptedException  {


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Work Orders")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/a")).click();


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/ul/li[1]/a")).click();

ws.waitforElementPresent(driver.findElement(By.id("WorkOrderStatusId")));
//driver.findElement(By.linkText("Change Status")).click();


WebElement wu = driver.findElement(By.id("WorkOrderStatusId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("Work Order Complete");

driver.findElement(By.xpath("//*[@id='DIVCSS0']/label[1]/div/ins")).click();

driver.findElement(By.xpath("//*[@id='DIVCSS1']/label[1]/div/ins")).click();

driver.findElement(By.xpath("//*[@id='DIVCSS2']/label[1]/div/ins")).click();
driver.findElement(By.xpath("//*[@id='DIVCSS3']/label[1]/div/ins")).click();
driver.findElement(By.xpath("//*[@id='DIVCSS4']/label[1]/div/ins")).click();

driver.findElement(By.xpath("//*[@id='DIVCSS5']/label[1]/div/ins")).click();

driver.findElement(By.id("btnChangeStatus")).click();



Thread.sleep(4000);
}




@Test(priority =31)





public void Transit() throws InterruptedException  {


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.linkText("Work Orders")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Thread.sleep(3000);

driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/a")).click();


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



//driver.findElement(By.linkText("Change Status")).click();
driver.findElement(By.xpath("//*[@id='divWorkOrders']/table/tbody/tr[5]/td[9]/div/ul/li[1]/a")).click();

ws.waitforElementPresent(driver.findElement(By.id("WorkOrderStatusId")));


WebElement wu = driver.findElement(By.id("WorkOrderStatusId"));
Select s2 = new Select(wu);

s2.selectByVisibleText("Transit");

WebElement l = driver.findElement(By.id("LocationTypeId"));
Select s3 = new Select(l);

s3.selectByVisibleText("Customer");

WebElement lw = driver.findElement(By.id("LocationId"));
Select sw = new Select(lw);

sw.selectByVisibleText("Billing Address");

driver.findElement(By.id("ShipTrackingNumber")).sendKeys("23432");



try{
	ws.waitforElementPresent(driver.findElement(By.linkText("Save")));
driver.findElement(By.linkText("Save")).click();
}
catch(Exception e)
{
	ws.waitforElementPresent(driver.findElement(By.id("btnChangeStatus")));
driver.findElement(By.id("btnChangeStatus")).click();

}
Thread.sleep(4000);
}
//*********************************************************Employe**********************************************************************************



@Test(priority =32)


public void EmployeeSearch(){
	
	driver.findElement(By.linkText("Employees")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("EmployeeSearchString")).sendKeys("Cory");
	driver.findElement(By.id("btnSearchPart")).click();
    driver.findElement(By.xpath("//*[@id='btnSearchPart']/i")).click();
}
@Test(priority =33)


public void EmployeeSearchvalidation(){
	
	driver.findElement(By.linkText("Employees")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("EmployeeSearchString")).sendKeys("Xomi");
	driver.findElement(By.id("btnSearchPart")).click();
    driver.findElement(By.xpath("//*[@id='btnSearchPart']/i")).click();
    
  String actual =  driver.findElement(By.xpath("//*[text()='NO RECORDS FOUND']")).getText();
  
  String expected ="NO RECORDS FOUND";

Assert.assertEquals(actual, expected);
driver.findElement(By.id("EmployeeSearchString")).clear();
driver.findElement(By.id("EmployeeSearchString")).sendKeys("Cory");
}








@Test(priority =34)


public void AddEmployee(){
	
	driver.findElement(By.linkText("Employees")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	ws.waitforElementPresent(driver.findElement(By.linkText("Add Employee")));
	driver.findElement(By.linkText("Add Employee")).click();
	ws.waitforElementPresent(driver.findElement(By.id("FirstName")));
	driver.findElement(By.id("FirstName")).sendKeys("kim");
	driver.findElement(By.id("LastName")).sendKeys("Williams");

	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	  
	
	
	driver.findElement(By.id("MobilePhone")).sendKeys("8054133933");
			driver.findElement(By.id("WorkPhone")).sendKeys("9024133933");
			driver.findElement(By.id("Address1")).sendKeys("New YOrk First Street");
	
			driver.findElement(By.id("Address2")).sendKeys("House no. 32 near caprica road");
			
			driver.findElement(By.id("City")).sendKeys("New York");
			  
			  WebElement l = driver.findElement(By.id("StateId"));
			Select s3 = new Select(l);
			
			s3.selectByVisibleText("ALASKA");
			  
			 driver.findElement(By.id("Zip")).sendKeys("75201");
			  
			  WebElement li = driver.findElement(By.id("RoleId"));
				Select s4 = new Select(li);
				
				s4.selectByVisibleText("Manager");
			  driver.findElement(By.id("Notes")).sendKeys("Creating New Employee");
			  
			  try{
			  for (int i =10; i<=2000;i++)
			  {

				  
					  
					  wait.until(ExpectedConditions.visibilityOf(
								driver.findElement(By.id("Email")))).clear();
				  
				  
				  
			 driver.findElement(By.id("Email")).sendKeys("kim"+i+"@gmail.com");
			 
			 
			 
			 driver.findElement(By.id("btnSave")).click();
			 
			  
			  
			  }  
			  }
			     
			  catch(Exception e)
			  {
				  
			  }
			  
			  
}
	
@Test(priority =35)


public void EmployeeEdit(){
	
	driver.findElement(By.linkText("Employees")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	
	driver.findElement(By.linkText("Edit")).click();
	ws.waitforElementPresent(driver.findElement(By.id("Address2")));
	
	driver.findElement(By.id("Address2")).clear();
	driver.findElement(By.id("Address2")).sendKeys("House no. 32 near caprica road");
	driver.findElement(By.id("btnSave")).click();
}

@Test(priority =36)


public void DelEmployee() throws InterruptedException{
	  
	 
	  
       driver.findElement(By.linkText("Employees")).click();
       Thread.sleep(2000);
       
     
       driver.findElement(By.xpath("//*[@id='divEmployee']/table/tbody/tr[1]/td[5]/a[2]/i")).click();

           //        Alert alert=driver.switchTo().alert();		
          //
         //
        //        String alertMessage=driver.switchTo().alert().getText();		
        //		
       //	
      //        System.out.println(alertMessage);			
     //		
    //		
   //         alert.accept();	

}



	
//*********************************************Parts************************************************************************

@Test(priority =37)
	
	
	public void AdvancePartSearch(){
		
		driver.findElement(By.linkText("Parts")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("PartSearchString")).sendKeys("10015248");
		driver.findElement(By.id("btnSearchPart")).click();
		
}

@Test(priority =38)


public void AdvancePartSearchvalidation(){
	
	driver.findElement(By.linkText("Parts")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("PartSearchString")).sendKeys("xdfg");
	driver.findElement(By.id("btnSearchPart")).click();
	
	String actual =  driver.findElement(By.xpath("//*[text()='NO RECORDS FOUND']")).getText();
	  
	  String expected ="NO RECORDS FOUND";

	Assert.assertEquals(actual, expected);
	driver.findElement(By.id("PartSearchString")).clear();
	driver.findElement(By.id("PartSearchString")).sendKeys("10015248",Keys.ENTER);
	
}


@Test(priority =39)


public void PartSearch(){
	
	driver.findElement(By.linkText("Parts")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		 WebElement wu = driver.findElement(By.xpath("//*[@id='ModelId']"));
	    Select s2 = new Select(wu);
	    
	  s2.selectByIndex(2);
		
	    WebElement w = driver.findElement(By.id("MakeId"));
	    Select s3 = new Select(w);
	    
	    s3.selectByIndex(3);
	    
		
		
	    WebElement we = driver.findElement(By.id("PartGroupId"));
	    Select s4 = new Select(we);
	    
	    s4.selectByIndex(1);
	    
	    
	    WebElement wm = driver.findElement(By.id("PartShelfId"));
	    Select s22 = new Select(wm);
	    
	    s22.selectByIndex(2);
		
	    driver.findElement(By.xpath("//*[@id='btnSearchPart']/i")).click();
	}
	
@Test(priority =40)


public void AddPartvalidation() throws InterruptedException{
	
	driver.findElement(By.linkText("Parts")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Add Part")).click();
	
	  
	//Part Number is required
    ws.waitforElementPresent(driver.findElement(By.id("btnSavePart")));
    driver.findElement(By.id("btnSavePart")).click();
          ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Part Number is required']"))));
   	
		String expectedpartno =	driver.findElement(By.xpath(".//*[text()='Part Number is required']")).getText();
		
		
		
		
		
		String actualpartno = "Part Number is required";
		
		Assert.assertEquals(actualpartno, expectedpartno);
		
		
    
    
   
	
	driver.findElement(By.id("PartName")).sendKeys("TKP984563");
	//Make is required
	 ws.waitforElementPresent(driver.findElement(By.id("btnSavePart")));
	    driver.findElement(By.id("btnSavePart")).click();
	          ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Make is required']"))));
	   	
			String expectedMakeId =	driver.findElement(By.xpath(".//*[text()='Make is required']")).getText();
			
			
			
			
			
			String actualMakeId = "Make is required";
			
			Assert.assertEquals(actualMakeId, expectedMakeId);
			
			
	WebElement l = driver.findElement(By.id("MakeId"));
	Select s3 = new Select(l);
	
	s3.selectByIndex(3);
	//Model is required
	
	  driver.findElement(By.id("btnSavePart")).click();
      ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Model is required']"))));
	
	String expectedModelId =	driver.findElement(By.xpath(".//*[text()='Model is required']")).getText();
	
	
	
	
	
	String actualModelId = "Model is required";
	
	Assert.assertEquals(actualModelId, expectedModelId);
	
	WebElement lw = driver.findElement(By.id("ModelId"));
	Select sw = new Select(lw);
	
	sw.selectByIndex(3);
	//Part Group is required
	
	 driver.findElement(By.id("btnSavePart")).click();
     ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Part Group is required']"))));
	
	String expectedPartGroupId =	driver.findElement(By.xpath(".//*[text()='Part Group is required']")).getText();
	
	
	
	
	
	String actualPartGroupId = "Part Group is required";
	
	Assert.assertEquals(actualPartGroupId, expectedPartGroupId);
	
	
	
	WebElement lo = driver.findElement(By.id("PartGroupId"));
	Select sd = new Select(lo);
	
	sd.selectByIndex(3);		
	
	//Part Shelf is required
	
	 driver.findElement(By.id("btnSavePart")).click();
     ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Part Shelf is required']"))));
	
	String expectedPartShelfId =	driver.findElement(By.xpath(".//*[text()='Part Shelf is required']")).getText();
	
	
	
	
	
	String actualPartShelfId = "Part Shelf is required";
	
	Assert.assertEquals(expectedPartShelfId, actualPartShelfId);
	
	WebElement ro = driver.findElement(By.id("PartShelfId"));
	Select sr= new Select(ro);
	
	sr.selectByIndex(3);
	//Price is required
	driver.findElement(By.id("btnSavePart")).click();
    ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Price is required']"))));
	
	String expectedPrice =	driver.findElement(By.xpath(".//*[text()='Price is required']")).getText();
	
	
	
	
	
	String actualPrice = "Price is required";
	
	Assert.assertEquals(expectedPrice, actualPrice);
	
	
	driver.findElement(By.id("Price")).sendKeys("120");
	driver.findElement(By.id("Year")).sendKeys("1990");
	
	
	
	driver.findElement(By.xpath("//*[@id='partForm']/div[1]/div/div[1]/div[8]/div/div/ins")).click();   
	//Labor Time is required
	driver.findElement(By.id("btnSavePart")).click();
    ws.waitforElementPresent((driver.findElement(By.xpath(".//*[text()='Labor Time is required']"))));
	
	String expectedLaborTime =	driver.findElement(By.xpath(".//*[text()='Labor Time is required']")).getText();
	
	
	
	
	
	String actualLaborTime = "Labor Time is required";
	
	Assert.assertEquals(expectedLaborTime,  actualLaborTime);
	
	driver.findElement(By.id("LaborTime")).sendKeys("6.00");
	     
	     
	     driver.findElement(By.id("Description")).sendKeys("part creation");
	    
	     	
	     driver.findElement(By.id("btnClosePart")).click();
	     
	     
}	


@Test(priority =41)
	
	
	public void AddPart() throws InterruptedException{
		
		driver.findElement(By.linkText("Parts")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Add Part")).click();
		
		  
		
		ws.waitforElementPresent(driver.findElement(By.id("PartName")));
		
		driver.findElement(By.id("PartName")).sendKeys("TKP984563");
		
		WebElement l = driver.findElement(By.id("MakeId"));
		Select s3 = new Select(l);
		
		s3.selectByIndex(3);
		
		WebElement lw = driver.findElement(By.id("ModelId"));
		Select sw = new Select(lw);
		
		sw.selectByIndex(3);
		
		WebElement lo = driver.findElement(By.id("PartGroupId"));
		Select sd = new Select(lo);
		
		sd.selectByIndex(3);		
		WebElement ro = driver.findElement(By.id("PartShelfId"));
		Select sr= new Select(ro);
		
		sr.selectByIndex(3);
		
		driver.findElement(By.id("Price")).sendKeys("120");
		driver.findElement(By.id("Year")).sendKeys("1990");
		
		
		
		driver.findElement(By.xpath("//*[@id='partForm']/div[1]/div/div[1]/div[8]/div/div/ins")).click();   
		
		driver.findElement(By.id("LaborTime")).sendKeys("6.00");
		     
		     
		     driver.findElement(By.id("Description")).sendKeys("part creation");
		     
		     
		    driver.findElement(By.id("btnSavePart")).click();
		     
		
		
		    driver.navigate().refresh();
	}	
	
	
	
	
@Test(priority =42)


public void EditPart(){
	
	driver.findElement(By.linkText("Parts")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Edit")).click();
	
	ws.waitforElementPresent(driver.findElement(By.id("Description")));  
	driver.findElement(By.id("Description")).clear();
	
	driver.findElement(By.id("Description")).sendKeys("new ink part creation");
	 driver.findElement(By.id("btnSavePart")).click();
	 driver.navigate().refresh();
}
	
	
	


@Test(priority =43)


public void DelParts(){
	  
	  
	  
       driver.findElement(By.linkText("Parts")).click();
       driver.findElement(By.linkText("Delete")).click();

           //        Alert alert=driver.switchTo().alert();		
          //
         //
        //        String alertMessage=driver.switchTo().alert().getText();		
        //		
       //	
      //        System.out.println(alertMessage);			
     //		
    //		
   //         alert.accept();	

	
	
}

////*********************************************Reports********************************************************************

@Test(priority =44)


public void Report() throws InterruptedException, AWTException{
	
	driver.findElement(By.linkText("Reports")).click();
	
	   
	  driver.get("http://imed.qa.aezion.local/Report/ReceivedOrders");
	  
	   ws.waitforElementPresent(driver.findElement(By.id("FromDate")));
	   driver.findElement(By.id("FromDate")).sendKeys("01/01/2018");
	   driver.findElement(By.id("ToDate")).sendKeys("02/03/2018");
	 

	   


driver.findElement(By.id("btnExport")).click();

Robot robot = new Robot();


robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	

Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
robot.keyPress(KeyEvent.VK_TAB);	
Thread.sleep(2000);	
robot.keyPress(KeyEvent.VK_TAB);	
Thread.sleep(2000);	
robot.keyPress(KeyEvent.VK_TAB);	
Thread.sleep(2000);	
robot.keyPress(KeyEvent.VK_ENTER);	




}



@Test(priority =45)


public void ShippedReport() throws AWTException, InterruptedException{
	
	//driver.findElement(By.linkText("Reports")).click();
	
	
	
		driver.get("http://imed.qa.aezion.local/Report/ShippedOrders");
	  
		ws.waitforElementPresent(driver.findElement(By.id("FromDate")));
		   driver.findElement(By.id("FromDate")).sendKeys("01/01/2018");
		   driver.findElement(By.id("ToDate")).sendKeys("02/03/2018");
	   Thread.sleep(2000);


	   Actions ac = new Actions(driver);
		WebElement wb = driver.findElement(By.id("btnExport"));
		
		ac.moveToElement(wb).build().perform();
		wb.click();


	  // driver.findElement(By.id("btnExport")).click();

	   Robot robot = new Robot();


	   robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	

	   Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
	   robot.keyPress(KeyEvent.VK_TAB);	
	   Thread.sleep(2000);	
	   robot.keyPress(KeyEvent.VK_TAB);	
	   Thread.sleep(2000);	
	   robot.keyPress(KeyEvent.VK_TAB);	
	   Thread.sleep(2000);	
	   robot.keyPress(KeyEvent.VK_ENTER);	

	
}
@Test(priority =46)


public void CompletedOrders() throws AWTException, InterruptedException{
	
	//driver.findElement(By.linkText("Reports")).click();
	
	
	
		driver.get("http://imed.qa.aezion.local/Report/CompletedOrders");
	  
	   ws.waitforElementPresent(driver.findElement(By.id("FromDate")));
	   ws.waitforElementPresent(driver.findElement(By.id("FromDate")));
	   driver.findElement(By.id("FromDate")).sendKeys("01/01/2018");
	   driver.findElement(By.id("ToDate")).sendKeys("02/03/2018");
	   

	   Actions ac = new Actions(driver);
		WebElement wb = driver.findElement(By.id("btnExport"));
		
		ac.moveToElement(wb).build().perform();
		wb.click();

	  // driver.findElement(By.id("btnExport")).click();

	   Robot robot = new Robot();


	   robot.keyPress(KeyEvent.VK_DOWN);  
	   Thread.sleep(2000);  
	   robot.keyPress(KeyEvent.VK_TAB);	
	   Thread.sleep(2000);	
	   robot.keyPress(KeyEvent.VK_TAB);	
	   Thread.sleep(2000);	
	   robot.keyPress(KeyEvent.VK_TAB);	
	   Thread.sleep(2000);	
	   robot.keyPress(KeyEvent.VK_ENTER);	


}



////*******************************************Setting************************************************************************



@Test(priority =47)

public void SettingMODELS() throws InterruptedException
{

	driver.findElement(By.linkText("Settings")).click();
	driver.findElement(By.linkText("Add")).click();
	ws.waitforElementPresent(driver.findElement(By.id("Name")));
	driver.findElement(By.id("Name")).sendKeys("AZINGroup2");
	driver.findElement(By.id("Number")).sendKeys("RTK1000");
	WebElement l = driver.findElement(By.id("MakeId"));
	Select s3 = new Select(l);
	
	s3.selectByIndex(3);
	WebElement lw = driver.findElement(By.id("RiskLevelId"));
	Select s2 = new Select(lw);		
	
	
	s2.selectByIndex(3);
	
	driver.findElement(By.id("Description")).sendKeys("Description");
	
	driver.findElement(By.id("btnCheckListCollapse")).click();
	
	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(
	driver.findElement(By.id("txtName")))).sendKeys("pump ambulatery",Keys.TAB,Keys.ARROW_DOWN);
	
	   driver.findElement(By.id("btnAddChecklist")).click();
	   
	driver.findElement(By.id("btnSaveModel")).click();
	Thread.sleep(4000);

	
	
}


 @Test(priority =48)
        
        
         public void ModelChecklist() throws InterruptedException
{

	driver.findElement(By.linkText("Settings")).click();
	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(	driver.findElement(By.xpath("//*[@id='divModels']/table/tbody/tr[1]/td[5]/a[1]/i")))).click();
	Thread.sleep(4000);
	driver.navigate().refresh();
}

         
       @Test(priority =49)
         
         
         public void Modeldelete() throws InterruptedException
{

        	 driver.findElement(By.linkText("Settings")).click();
        		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
        		   wait.until(ExpectedConditions.visibilityOf(	driver.findElement(By.xpath("//*[@id='divModels']/table/tbody/tr[1]/td[5]/a[2]/i")))).click();
        		Thread.sleep(4000);
        		driver.navigate().refresh();
}



        @Test(priority =50)
         
         public void SettingADDMANUFACTURES() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_manufacturers")).click();
         	
         	
         	
         WebDriverWait d = new WebDriverWait(driver,50);
         d.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='tab_1_2']/div/div[1]/a"))));
         	
         	driver.findElement(By.xpath("//*[@id='tab_1_2']/div/div[1]/a")).click();
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	driver.findElement(By.id("Name")).sendKeys("Ambulatery");
         	
         	driver.findElement(By.id("btnSaveMake")).click();

             Thread.sleep(4000);
             
       }
 @Test(priority =51)
         
         public void SettingDeleteMANUFACTURES() throws InterruptedException{
         
         driver.findElement(By.linkText("Settings")).click();
 
         driver.findElement(By.id("a_manufacturers")).click();
 
 		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
 		   wait.until(ExpectedConditions.visibilityOf(	driver.findElement(By.xpath("//*[@id='divMake']/table/tbody/tr[1]/td[2]/a/i")))).click();
 		
 		  Thread.sleep(4000);
 		

 }
         
         

@Test(priority =52)
               
               public void Settingupdate() throws InterruptedException
               {

               	driver.findElement(By.linkText("Settings")).click();
               	
               	driver.findElement(By.id("a_manufacturers")).click();   
               	driver.findElement(By.linkText("Braun Medical")).click();
               	ws.waitforElementPresent(driver.findElement(By.id("Name")));
               	driver.findElement(By.id("Name")).clear();
               	ws.waitforElementPresent(driver.findElement(By.id("Name")));
               	driver.findElement(By.id("Name")).sendKeys("Braun Medical");
               	
              	driver.findElement(By.id("btnSaveMake")).click();

                   Thread.sleep(4000);
                   
             }  
         
@Test(priority =53)
         
         public void SettingADDAssetGroup() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
  		   wait.until(ExpectedConditions.visibilityOf(
         	driver.findElement(By.id("a_assetgroups")))).click();
         	
         	driver.findElement(By.xpath("//*[@id='tab_1_3']/div/div[1]/a")).click();
         	
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	
         	driver.findElement(By.id("Name")).sendKeys("Ambulatery");
         	
         	driver.findElement(By.id("btnSaveAssetGroup")).click();

         	 Thread.sleep(4000);
         }
       
       
@Test(priority =54)
         
         public void SettingAssetGroupDelete() throws InterruptedException{
         
         driver.findElement(By.linkText("Settings")).click();
         
         WebDriverWait wait1 = new WebDriverWait(Browser.driver, 20);
		 wait1.until(ExpectedConditions.visibilityOf(
       	driver.findElement(By.id("a_assetgroups")))).click();
 
 		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='divAssetGroups']/table/tbody/tr[1]/td[2]/a/i")))).click();
 		
 		  Thread.sleep(4000);
 		

 }  
@Test(priority =55)

public void SettingAssetGroup() throws InterruptedException
{

	driver.findElement(By.linkText("Settings")).click();
	
	driver.findElement(By.id("a_assetgroups")).click();   
	driver.findElement(By.linkText("Leasing")).click();
	ws.waitforElementPresent(driver.findElement(By.id("Name")));
	driver.findElement(By.id("Name")).clear();
	ws.waitforElementPresent(driver.findElement(By.id("Name")));
	driver.findElement(By.id("Name")).sendKeys("Leasing");
	
	driver.findElement(By.id("btnSaveAssetGroup")).click();

    Thread.sleep(4000);
    
}  


         
         
         
         
 @Test(priority =56)
         
         public void SettingADDpartgroups() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_partgroups")).click();
         	
         	driver.findElement(By.xpath("//*[@id='tab_1_4']/div/div[1]/a")).click();
         	
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	driver.findElement(By.id("Name")).sendKeys("Service");
         	
         	driver.findElement(By.id("btnSavePartGroup")).click();


         	 Thread.sleep(4000);
         	 
         	 
         	 
         	 
         }
      
      
 @Test(priority =57)//bug
         
 
  
         public void SettingPartgroupsDelete() throws InterruptedException{
         
         driver.findElement(By.linkText("Settings")).click();
         
         driver.findElement(By.id("a_partgroups")).click();
 
 		 WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
 		 
 		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='divPartGroups']/table/tbody/tr[1]/td[2]/a/i")))).click();
 		  
 		Thread.sleep(4000);
 		
         Assert.assertTrue(driver.getTitle().contains("dd"));
		
 		 
 		

 }                
 @Test(priority =58)
 
 public void PartGroupsupdate() throws InterruptedException
 {

 	driver.findElement(By.linkText("Settings")).click();
 	
 	driver.findElement(By.id("a_partgroups")).click();   
 	driver.findElement(By.linkText("Service")).click();
 	ws.waitforElementPresent(driver.findElement(By.id("Name")));
 	driver.findElement(By.id("Name")).clear();
 	ws.waitforElementPresent(driver.findElement(By.id("Name")));
 	driver.findElement(By.id("Name")).sendKeys("Service");
 	
	driver.findElement(By.id("btnSavePartGroup")).click();

     Thread.sleep(4000);
     
}  
 
 
 @Test(priority =59)
         
         public void SettingADDpartShelves() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_partshelves")).click();
         	
         	driver.findElement(By.xpath("//*[@id='tab_1_5']/div/div[1]/a")).click();
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	driver.findElement(By.id("Name")).sendKeys("old Parts");
         	
         	driver.findElement(By.id("btnSavePartShelf")).click();

         	 Thread.sleep(4000);
         }
 
 
@Test(priority =60)
 
 public void partShelvesupdate() throws InterruptedException
 {

 	driver.findElement(By.linkText("Settings")).click();
 	
 	driver.findElement(By.id("a_partshelves")).click();   
 	driver.findElement(By.linkText("old Parts")).click();
 	ws.waitforElementPresent(driver.findElement(By.id("Name")));
 	driver.findElement(By.id("Name")).clear();
 	ws.waitforElementPresent(driver.findElement(By.id("Name")));
 	driver.findElement(By.id("Name")).sendKeys("Certified Parts");
 	
	driver.findElement(By.id("btnSavePartShelf")).click();

     Thread.sleep(4000);
     
}  
 
 
 
 
 
 
@Test(priority =61)//Bug
         
         public void SettingPartShelvesDelete() throws InterruptedException{
         
         driver.findElement(By.linkText("Settings")).click();
         
         driver.findElement(By.id("a_partshelves")).click();
 
 		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
 		   wait.until(ExpectedConditions.visibilityOf(	driver.findElement(By.xpath("//*[@id='divPartShelfs']/table/tbody/tr[1]/td[2]/a/i")))).click();
 		
 		  Thread.sleep(4000);
 		 Assert.assertTrue(driver.getTitle().contains("dd"));

 }           
         
 
		
		
@Test(priority =62)
        
        public void SettingWOTypeDelete() throws InterruptedException{
        
        driver.findElement(By.linkText("Settings")).click();
        
        driver.findElement(By.id("a_workordertypes")).click();

		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		   wait.until(ExpectedConditions.visibilityOf(	driver.findElement(By.xpath("//*[@id='divWorkOrderTypes']/table/tbody/tr[1]/td[2]/a/i")))).click();
		
		  Thread.sleep(4000);
		

}    
             


@Test(priority =63)
         
         public void SettingADDWOType() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_workordertypes")).click();
         	
        	driver.findElement(By.xpath("//*[@id='tab_1_6']/div/div[1]/a")).click();
        	
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	
         	driver.findElement(By.id("Name")).sendKeys("Scheduled");
         	
         	driver.findElement(By.id("btnSaveWOType")).click();
         	
        
         	 Thread.sleep(4000);
         }



 @Test(priority =64)
         
         public void SettingADDWOTypeupdate() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_workordertypes")).click();   
         	driver.findElement(By.linkText("Scheduled")).click();
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	driver.findElement(By.id("Name")).clear();
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));
         	driver.findElement(By.id("Name")).sendKeys("Schedule");
         	
        	driver.findElement(By.id("btnSaveWOType")).click();

             Thread.sleep(4000);
             
        }  


         
         
		
		
@Test(priority =65)
        
        public void SettingIssueTypeDelete() throws InterruptedException{
        
        driver.findElement(By.linkText("Settings")).click();
        
        driver.findElement(By.id("a_issuetypes")).click();

		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		   wait.until(ExpectedConditions.visibilityOf(	driver.findElement(By.xpath(".//*[@id='divIssueTypes']/table/tbody/tr/td[3]/a/i")))).click();
		
		  Thread.sleep(4000);
 
} 		
@Test(priority =66)
         
         public void SettingADDIssueType() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_issuetypes")).click();
	driver.findElement(By.xpath("//*[@id='tab_1_7']/div/div[1]/a")).click();
        	
         	ws.waitforElementPresent(driver.findElement(By.id("ParentId")));
         	
         	
         	WebElement lo = driver.findElement(By.id("ParentId"));
    		Select sd = new Select(lo);
    		
    		sd.selectByIndex(1); 	
         	
         	
    		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
    		   wait.until(ExpectedConditions.visibilityOf(
         	driver.findElement(By.id("Name")))).sendKeys("PCB-Failure");
         	
    		   	driver.findElement(By.id("btnSaveWOType")).click();
    		   
    		   
         	 Thread.sleep(4000);
         }
         
@Test(priority =67)
         
         public void SettingIssueTypeUpdate() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_issuetypes")).click();
         	
	driver.findElement(By.linkText("PCB-Failure")).click();
        	
         	ws.waitforElementPresent(driver.findElement(By.id("ParentId")));
         	
         	
         	WebElement lo = driver.findElement(By.id("ParentId"));
    		Select sd = new Select(lo);
    		
    		sd.selectByIndex(2); 	
         	
         	
    		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
    		   wait.until(ExpectedConditions.visibilityOf(
         	driver.findElement(By.id("Name")))).clear();
         	driver.findElement(By.id("Name")).sendKeys("PCB-Failure");
         	driver.findElement(By.id("btnSaveWOType")).click();
         	

         	 Thread.sleep(4000);
         }
         
 
         
         
@Test(priority =68)
         
         public void SettingAddVendor() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_vendors")).click();
         	
driver.findElement(By.xpath("//*[@id='tab_1_8']/div/div[1]/a")).click();
        	
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));  
         	
         	driver.findElement(By.id("Name")).sendKeys("Vendor4");
         	driver.findElement(By.id("Address1")).sendKeys("3278 Warnmall");
         	driver.findElement(By.id("Address2")).sendKeys("Street 2nd");
         	driver.findElement(By.id("City")).sendKeys("Texas",Keys.TAB,Keys.ARROW_DOWN);
         	driver.findElement(By.id("ZipCode")).sendKeys("75021");
         	driver.findElement(By.id("btnSaveVendor")).click();
         	
         	
         }
         
@Test(priority =69)
         
         public void SettingVendorupdate() throws InterruptedException
         {

         	driver.findElement(By.linkText("Settings")).click();
         	
         	driver.findElement(By.id("a_vendors")).click();
         	
            driver.findElement(By.linkText("Vendor4")).click();
        	
         	ws.waitforElementPresent(driver.findElement(By.id("Name")));  
         	driver.findElement(By.id("Name")).clear();
         	driver.findElement(By.id("Name")).sendKeys("Vendor4");
         	driver.findElement(By.id("Address1")).clear();
         	driver.findElement(By.id("Address1")).sendKeys("3279 Warnmall");
         	driver.findElement(By.id("Address2")).clear();
         	driver.findElement(By.id("Address2")).sendKeys("Street 3rd");
         	driver.findElement(By.id("City")).sendKeys("Texas",Keys.TAB,Keys.ARROW_DOWN);
         	driver.findElement(By.id("ZipCode")).sendKeys("75021");
         	driver.findElement(By.id("btnSaveVendor")).click();
         	
         	
         }        
         	
         	
@Test (priority =70)

      public void SettingDeleteVendor() throws InterruptedException
{

	  driver.findElement(By.linkText("Settings")).click();
	
	  driver.findElement(By.id("a_vendors")).click();    	
         
      WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='divVendors']/table/tbody/tr[1]/td[6]/a/i")))).click();

      Thread.sleep(4000);
         
}

//******************************************************MyProfile*********************************************************************
      
@Test (priority =71)

public void MyProfilefirstnamelastname() throws InterruptedException
{

	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(
	driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span")))).click();
	driver.findElement(By.linkText("My Profile")).click();
	driver.findElement(By.id("FirstName")).clear();
	driver.findElement(By.id("FirstName")).sendKeys("Chriss");
	driver.findElement(By.id("LastName")).clear();
	driver.findElement(By.id("LastName")).sendKeys("Kambalaa");
	
    driver.findElement(By.id("btnSaveProfile")).click();
    
    String successmsg = driver.findElement(By.id("toast-container")).getText();


  	Assert.assertTrue(successmsg.contains("Saved"), "");
    Thread.sleep(3000);
    
    
   
    
    String actuallname = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span")).getText();
	System.out.println(actuallname);
	String expectedname = "Chriss Kambalaa";
	Assert.assertEquals(actuallname,expectedname);
  
    driver.findElement(By.id("FirstName")).clear();
	driver.findElement(By.id("FirstName")).sendKeys("Chris");
	driver.findElement(By.id("LastName")).clear();
	driver.findElement(By.id("LastName")).sendKeys("Kambala");
    driver.findElement(By.id("btnSaveProfile")).click();
    
	
   Thread.sleep(3000);
}
      
@Test (priority =72)

public void MyProfileSuccessmessage() throws InterruptedException
{

	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(
	driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span")))).click();
	driver.findElement(By.linkText("My Profile")).click();


    
  
	
    String actuallname = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span")).getText();
	System.out.println(actuallname);
    String expectedname = "Chris Kambala";
	
    Assert.assertEquals(actuallname,expectedname);
	
   
}     



@Test (priority =73)

public void MyProfilepicture() throws InterruptedException, AWTException
{

	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(
	driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span")))).click();
	driver.findElement(By.linkText("My Profile")).click();
	
	
	driver.findElement(By.id("file")).click();
	Thread.sleep(4000);	
	StringSelection ss = new StringSelection("firebug issue.png");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	//imitate mouse events like ENTER, CTRL+C, CTRL+V

	Thread.sleep(4000);

	Robot robot = new Robot();

	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);



	Thread.sleep(4000);	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	Thread.sleep(4000);
	Browser.driver.manage().timeouts().
	implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("btnUpload")).click();
	
	String successmsg = driver.findElement(By.id("toast-container")).getText();


	Assert.assertTrue(successmsg.contains("Updated"), "");
	   
  
	driver.navigate().back();
   
}          
      
      
      

////**********************************************BUG**************************************************************************

////--------------------------------------------------------------------------------------------------------------
//
////--------------------------------------------------------------------------------------------------------------

////
////@Test(priority =36)
////
////
////public void AssetdetailWoNumber(){
////	
////		
////	String a ="t";
////	String v ="b";
////	assertEquals(a, v);
////	
////}
//@Test(priority =41)
//
//
//
//	
//	public void AssetCheckINforPreview() throws InterruptedException
//	
//	
//    {
//		
//		
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.findElement(By.linkText("Assets")).click();
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.findElement(By.id("AssetSearchString")).sendKeys("Point",Keys.ENTER);
//	driver.findElement(By.xpath("//*[@id='divAssets']/table/tbody/tr[2]/td[1]/a")).click();
//	//driver.findElement(By.linkText("Ambulatory Infusion Pump")).click();//pre con*******************
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.findElement(By.linkText("Check-In Asset")).click();	
//	Thread.sleep(2000);
//	driver.findElement(By.linkText("YES")).click();	
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//	 WebElement wu = driver.findElement(By.id("WorkOrderTypeId"));
//   Select s2 = new Select(wu);
//   
//   s2.selectByVisibleText("Scheduled");
//		
//   
//   driver.findElement(By.id("ReportProblemNotes")).sendKeys("update Report Problem Notes");
//   
//   driver.findElement(By.id("RepairSummaryNotes")).sendKeys("update about Repair Summary Notes");
//   
//   WebElement w = driver.findElement(By.id("0"));
//   Select s3 = new Select(w);
//   
//   s3.selectByVisibleText("RK000912");
//   
//   WebElement w2 = driver.findElement(By.id("1"));
//   Select s4 = new Select(w2);
//   
//   s4.selectByVisibleText("TC10003750");
//   
//   
//   WebElement l = driver.findElement(By.id("2"));
//   Select s5 = new Select(l);
//   
//   s5.selectByVisibleText("RK000912");
//   
//   	
//	String a ="t";
//	String v ="b";
//	assertEquals(a, v);
//	
//}


@AfterMethod
 

         public void Logout() throws InterruptedException {
	
	Thread.sleep(4000);
	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(
	driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span")))).click();
	driver.findElement(By.linkText("Log Out")).click();
	
	
}
   
@AfterClass


	   public void Close(){
	
	
		   driver.close();
	   }
   }




