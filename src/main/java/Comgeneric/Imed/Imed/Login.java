package Comgeneric.Imed.Imed;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class Login extends WaitStatement{

	

		@FindBy(id="Email")
		private WebElement usreNAmEdt;
		
		@FindBy(id="Password")
		private WebElement pswEdt;
		
		@FindBy(xpath="//button[@class='btn green pull-right']")
		private WebElement loginBtn;
		
		
		
		 
		@Test
		
		public void loginToIMED() throws Exception {
			

			
			String filepath ="C:\\Users\\Aezion.Dev10\\Desktop\\Testdata.xlsx";
			
			FileInputStream fis = new FileInputStream(filepath);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);

			
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
		String Username =	sheet.getRow(0).getCell(0).getStringCellValue();
		String Password =	sheet.getRow(0).getCell(1).getStringCellValue();
		String Url =	sheet.getRow(0).getCell(2).getStringCellValue();
		
		
		
//			System.out.println(Username);
//			System.out.println(Password);
//			System.out.println(Url);
			
			
			
			
			
			
			waitForPageToLoad();
				
			Browser.driver.get(Url);
			Browser.driver.manage().window().maximize();
			usreNAmEdt.sendKeys(Username);
			pswEdt.sendKeys(Password);
			loginBtn.click();	
			}
		
		
		
//		@Test
//		public void loginToImedAsCUSTOMER(){
//			//waitForPageToLoad();
//			Browser.driver.manage().window().maximize();
//			Browser.driver.get(Constant.url);
//			Browser.driver.manage().window().maximize();
//			usreNAmEdt.sendKeys(Constant.Customerid);
//			pswEdt.sendKeys(Constant.password);
//			loginBtn.click();		
//		}

}
