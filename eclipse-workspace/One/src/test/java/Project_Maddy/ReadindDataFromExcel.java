package Project_Maddy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadindDataFromExcel {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("number of rows:"+ totalRows);
		System.out.println("number of cells:"+ totalCells);
		
		for(int r=0; r<=totalRows; r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0; c<totalCells; c++)
			{
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		

	}

}
