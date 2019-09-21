package framework;

import java.io.IOException;
import java.util.ArrayList;

public class dummytestCase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*DataDriven data = new DataDriven();
		ArrayList listOfData = data.getData("Add Profile");
		
		System.out.println(listOfData.get(0));
		System.out.println(listOfData.get(1));
		System.out.println(listOfData.get(2));
		System.out.println(listOfData.get(3));*/
		
		DataDrivenForSampleExcelBySP a = new DataDrivenForSampleExcelBySP();
		ArrayList obj = a.getDataByColumn(1);
		System.out.println(obj.get(0));
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
	}

}
