package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dpClause {

	@DataProvider(name="login")
	public String[][] logindata() throws IOException{
		//C:\Users\ThirupathiAnnarapu\Desktop\RestAssured\SeleniumFrameWorkByPrachi\TestData\Data.xlsx
		String path=System.getProperty("user.dir")+"//TestData//Data.xlsx";
		
		int rowc=ReadXlsx.getRowCount(path, "Sheet1");
		int cellc=ReadXlsx.getCellCount(path, "Sheet1");
		
		String testData[][]=new String[rowc-1][cellc];
		
		for(int i=1;i<rowc;i++) {
			
			for(int j=0;j<cellc;j++) {
				testData[i-1][j]=ReadXlsx.getCellValue(path, "Sheet1", i, j);	
			}
			
		}
		return testData;
		
	}
}
