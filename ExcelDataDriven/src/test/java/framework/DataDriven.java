package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException{

		ArrayList<String> a = new ArrayList<String>();

		//1- To create object of XSSFWorkBook class and pas argument where file stored using FileInputStream
		FileInputStream fis = new FileInputStream("D:\\spuranik\\Selenium\\DataDrivenDocs\\ExcelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//2- Now we got the excel, search for desired sheet where we want to work by getting total sheets & iterate through them.
		int totalSheets = workbook.getNumberOfSheets();
		for(int i=0; i<totalSheets; i++)
		{
			//If entered sheet name matches with the sheet name entered, then get into that sheet using XSSFSheet.
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);

				//3- As we are now at sheet, we need to get into rows to identify the testcases column by scanning entire first row.
				//Using java collections.iterator method, need to get total rows and using next() need to compare each cell
				//NOTE: Sheet is collection of rows.
				Iterator<Row> totalRows = sheet.iterator();
				Row firstRow = totalRows.next();

				//4- We got first row, now we need to check the cell of that row where testcases is written using that row which is identified
				// in above step.
				//NOTE: Row is collection of cells.
				Iterator<Cell> cells = firstRow.cellIterator();

				//For first time, it will not be in first cell, entire row is selected. If it founds as cell value is present, then go to it.
				//If testcases column is in between we need to get count and store it in one variable.
				int k=0;
				int column =0;
				while(cells.hasNext())
				{
					Cell value =cells.next();

					//compare value of cell
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						column=k;
					}

					//Here bfore ending while, increment k
					k++;
				}
				//System.out.println(column);

				//5- Once testcases column is identified then scan entire column to identify specific test case for ex: HomePage
				//However in step 3 we have already got entire rows of sheet and found iterated first row. Now we need to get specific row
				// from test cases column.

				//as of now we are at 1st row, if there are any other check & get into it where HomePage is located.
				while(totalRows.hasNext())
				{
					Row desiredRow = totalRows.next();

					//in Testcases column if desired row has testcase as HomePage, then pull all data of row.
					if(desiredRow.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						//Now we are at HomePage testcase row, pull all data, check if data present in next cell then iterate.
						Iterator<Cell> requiredRowData = desiredRow.cellIterator();
						while(requiredRowData.hasNext())
						{
							//Data can be string or integer, so for that we need to check & convert into string.
							//a.add((requiredRowData.next().getStringCellValue())); -- This works only for String.
							
							Cell rowCellData = requiredRowData.next();
							
							//check if data types of data using enum, if string then pass directly else convert into string.
							if(rowCellData.getCellType()==CellType.STRING){
								a.add(rowCellData.getStringCellValue());
							}
							else
							{
								//Converted into string using numberToTestConverter class with toText method.
								a.add(NumberToTextConverter.toText(rowCellData.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return a;
	}
}
