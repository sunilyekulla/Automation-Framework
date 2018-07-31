package commands;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.junit.experimental.theories.Theories.TheoryAnchor;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Browser.Invokebrowser;
import Main.Methods;
import xls.xls_reader;

public class Customcommands  extends xls_reader {
	public static Logger logger =  Logger.getLogger("Customcommands");
	
	public static WebDriver d;
	public static String screenshotName = "snapshot";
	public static void Screencapture() throws IOException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		System.out.println(df);
		Date date = new Date();
		
		TakesScreenshot ts=(TakesScreenshot)d;
		  
		 File source=ts.getScreenshotAs(OutputType.FILE);
		  
		 FileUtils.copyFile(source, new File("E:\\Sunil\\AutomationFM\\Failureone\\FailureSnapshots\\"+screenshotName+"-"+df.format(date) +".png"));
		  
		 System.out.println("Screenshot taken");
	}
	
	
	public static void open(String cmd, String obj, String xpath,String input) throws IOException
	{

            logger.info("Invoking browser");
            
		System.out.println("HIIIIIIIIIIIII  " +xpath);
		//Invokebrowser.chrome();
		System.setProperty("webdriver.chrome.driver", "E:\\Sunil\\AutomationFM\\Failureone\\Drivers\\chromedriver.exe");
		d = new ChromeDriver();		
		d.manage().window().maximize();
		d.get(xpath);
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void click(String cmd, String obj, String xpath,String input) throws IOException
	{

             logger.info("..........Clicking element");
		try {
			System.out.println("*************"+xpath);
			d.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Screencapture();
			
		}
	}
	
	public static void type(String cmd, String obj, String xpath,String input) throws IOException
	{

                logger.info(".........Providing input");
		try {
			System.out.println("*************"+xpath);
			WebElement str = d.findElement(By.xpath(xpath));
			str.sendKeys(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Screencapture();
		}
	}
}
	
