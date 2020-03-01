import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestRailGeneric {
WebDriver driver;
@BeforeTest
public void bm() throws InterruptedException{

	WebDriverManager.chromedriver().setup();
	//WebDriverManager.firefoxdriver().setup();
	//WebDriverManager.chromedriver().version("2.36").setup();
	 driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);

driver.get("https://pawanbel.testrail.io/index.php?/suites/view/1&group_by=cases:section_id&group_order=asc");

driver.findElement(By.id("name")).sendKeys("pawanukok@googlemail.com");//

driver.findElement(By.id("password")).sendKeys("5a2S2kBnPuFpDkz5OjtC");  

driver.findElement(By.id("button_primary")).click();//
Thread.sleep(3000);


}




@Test(dataProvider="getShipmentData", dataProviderClass=ExcelDataConfig.class)
public void NewProjectExt_SimplifySR(String  tcid, String step, String exp, String title) throws Exception
{

System.out.println(tcid +" "+step+" "+exp+" "+title);


Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Add Case']")).click();

driver.findElement(By.id("title")).sendKeys(title);
Thread.sleep(3000);
//driver.findElement(By.xpath("//label[text()='Test-caseId ']/..//input")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));
driver.findElement(By.xpath("/html//input[@id='custom_aa']")).sendKeys(tcid);

driver.findElement(By.id("custom_steps")).sendKeys(step);
driver.findElement(By.id("custom_expected")).sendKeys(exp);

WebElement ele6=driver.findElement(By.xpath("/html//button[@id='accept']"));
((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", ele6);

ele6.click();
                driver.findElement(By.xpath("//li[@class='header-menu-item header-menu-item-selected']//a[text()='Test Cases']")).click();
                

            Thread.sleep(3000);
// @AfterMethod
// public void teardown(){
// }


}
}