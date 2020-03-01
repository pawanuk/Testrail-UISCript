import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testRailChangeExpected {

public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	//WebDriverManager.firefoxdriver().setup();
	//WebDriverManager.chromedriver().version("2.36").setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 10);

driver.get("https://pawanbel.testrail.io/index.php?/suites/view/1&group_by=cases:section_id&group_order=asc");

driver.findElement(By.id("name")).sendKeys("pawanukok@googlemail.com");//

driver.findElement(By.id("password")).sendKeys("5a2S2kBnPuFpDkz5OjtC");  

driver.findElement(By.id("button_primary")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Add Case']")).click();
//driver.findElement(By.id("addCase")).click();

// String data =ExcelUtilities.readData("Sheet2",1,0);
// System.out.println(data);
driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",1,3));
Thread.sleep(3000);
//driver.findElement(By.xpath("//label[text()='Test-caseId ']/..//input")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));
driver.findElement(By.xpath("/html//input[@id='custom_aa']")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));

driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",1,1));
driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",1,2));
//driver.findElement(By.id("accept")).click();

WebElement ele6=driver.findElement(By.xpath("/html//button[@id='accept']"));
((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", ele6);

ele6.click();
                driver.findElement(By.xpath("//li[@class='header-menu-item header-menu-item-selected']//a[text()='Test Cases']")).click();
                

            Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='Add Case']")).click();
//driver.findElement(By.id("addCase")).click();

// String data =ExcelUtilities.readData("Sheet2",1,0);
// System.out.println(data);
driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",2,3));

//driver.findElement(By.xpath("//label[text()='Test-caseId ']/..//input")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));
driver.findElement(By.xpath("/html//input[@id='custom_aa']")).sendKeys(ExcelUtilities.readData("Sheet2",2,0));
driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",2,1));
driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",2,2));
WebElement ele7=driver.findElement(By.xpath("/html//button[@id='accept']"));
((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", ele7);

ele7.click();
//driver.findElement(By.id("accept")).click();

                driver.findElement(By.xpath("//li[@class='header-menu-item header-menu-item-selected']//a[text()='Test Cases']")).click();

         

                
                
                String tcupate="100";
//td[text()='102']
                Thread.sleep(3000);             
//driver.findElement(By.xpath("//td[text()='"+tcupate+"']/..//td[3]//a")).click();
//td[text()='101']/..//td[6]
		
//td[text()='101']/..//td[3]
//td[text()='100']/..//td[3]//a
Thread.sleep(3000); 
//driver.findElement(By.xpath("//span[text()='Edit']")).click();
//driver.findElement(By.xpath("//a[@href='index.php?/cases/edit/35/1']")).click();
driver.findElement(By.xpath("//td[text()='"+tcupate+"']/..//td[6]")).click();
//td[text()='101']/..//td[6]
WebElement wbele1 = driver.findElement(By.id("custom_expected"));
//WebElement ele = driver.findElement(By.xpath("//a[text()='title1']"));
((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", wbele1);

wbele1.clear();
driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",1,4));
driver.findElement(By.id("accept")).click();

String tcupate2="101";
//td[text()='102']
              Thread.sleep(3000);             
//driver.findElement(By.xpath("//td[text()='"+tcupate+"']/..//td[3]//a")).click();
//td[text()='101']/..//td[6]
		
//td[text()='101']/..//td[3]
//td[text()='100']/..//td[3]//a
Thread.sleep(3000); 
//driver.findElement(By.xpath("//span[text()='Edit']")).click();
//driver.findElement(By.xpath("//a[@href='index.php?/cases/edit/35/1']")).click();
driver.findElement(By.xpath("//td[text()='"+tcupate2+"']/..//td[6]")).click();
//td[text()='101']/..//td[6]
WebElement wbele2 = driver.findElement(By.id("custom_expected"));
//WebElement ele = driver.findElement(By.xpath("//a[text()='title1']"));
((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", wbele2);

wbele2.clear();
driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",2,4));
driver.findElement(By.id("accept")).click();



System.out.println("Successfully created two test cases and then edited both the test cases");



//
//

}

}
