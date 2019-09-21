package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenForSampleExcelBySP {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


	}

	public ArrayList<String> getDataByColumn(int columnIndex) throws IOException{

		ArrayList<String> columnData = new ArrayList<String>();

		//1- Get path of excel & get access to excel
		FileInputStream fis = new FileInputStream("D:\\spuranik\\Selenium\\DataDrivenDocs\\ExcelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//2- Get required sheet before that we need to get total number of sheets present
		int totalSheets = workbook.getNumberOfSheets();

		//3- Iterate with total sheets and stop when required sheets is present.
		for(int i=0; i<totalSheets; i++)
		{

			//4- First get sheet name & check whether is it required
			if(workbook.getSheetName(i).equalsIgnoreCase("sample"))
			{
				XSSFSheet requiredSheet = workbook.getSheetAt(i);
				System.out.println("Got sheet");

				Iterator<Row> rowIterator = requiredSheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						if(row.getRowNum() > 0) //To filter column headings
						{ 
							if(cell.getColumnIndex() == columnIndex) // To match column index
							{
								columnData.add(cell.getStringCellValue());
							}
						}
					}
				}
				System.out.println(columnData);
			}


		}
		return columnData;

	}

	public ArrayList<String> extractExcelContentByColumnIndex(int columnIndex){
		ArrayList<String> columndata = null;
		try {
			File f = new File("D:\\spuranik\\Selenium\\DataDrivenDocs\\ExcelData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1);
			Iterator<Row> rowIterator = sheet.iterator();
			columndata = new ArrayList<String>();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if(row.getRowNum() > 0){ //To filter column headings
						if(cell.getColumnIndex() == columnIndex){// To match column index


							columndata.add(cell.getStringCellValue());
						}
					}
				}
			}

			fis.close();
			System.out.println(columndata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columndata;
	}
}
