package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\TestData\\Opencart_LoginData.xlsx";
		ExcelUtils xlutil= new ExcelUtils(path);
		 int totallRows=xlutil.getRowCount("Sheet1");
		 int totallCol=xlutil.getCellCount("Sheet1", 1);
		 String [] [] logindata=new String[totallRows] [totallCol];
		 for(int i=1;i<=totallRows;i++) {
			 for(int j=0;i<totallCol;j++) {
				 logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			 }
		 }
		return logindata;
	}
}
