import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataConfig {

XSSFWorkbook wb;
XSSFSheet sheet1;

public ExcelDataConfig(String excelpath){
try{
File src = new File(excelpath);
FileInputStream fis=new FileInputStream(src);
wb=new XSSFWorkbook(fis);
}
catch(Exception e){
System.out.println(e.getMessage());
}
}


public String getData(int sheeNumber, int row, int column){

sheet1=wb.getSheetAt(sheeNumber);
String data =sheet1.getRow(row).getCell(column).getStringCellValue();
return data;
}


public int getRowCount(int sheetIndex){
int row= wb.getSheetAt(sheetIndex).getLastRowNum();
row=row+1;
return row;
}

@DataProvider
     public static Object[][] getShipmentData() throws Exception{
 //ExcelDataConfig config =new ExcelDataConfig("D:\\Learning_protractor\\NCR-Automation\\pawanTestRail\\exefiles\\Book3.xlsx");
 ExcelDataConfig config =new ExcelDataConfig("/Users/bhavanigirish/Documents/workspace/Copy of TestRailNew/target/exefiles/Book3.xlsx");
	//ExcelDataConfig config =new ExcelDataConfig(".\\exefiles\\chromedriver.exe");  
	
//\\Users\\bhavanigirish\\Documents\\workspace\\Copy of TestRailNew\\target.        

int rows=config.getRowCount(1);
Object[][] data=new Object[rows][4];
for(int i=0; i<rows; i++){
data[i][0]=config.getData(1,i,0);
data[i][1]=config.getData(1,i,1);
data[i][2]=config.getData(1,i,2);
data[i][3]=config.getData(1,i,3);
//data[i][4]=config.getData(1,i,4);
}
         return data;        
         
 
 
 }





}
