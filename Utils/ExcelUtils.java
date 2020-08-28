package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath,String sheetName)
	{
		try
		{
			projectpath="C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\Excel\\data.xlsx";
			workbook=new XSSFWorkbook(projectpath);
			sheet=workbook.getSheet("Sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public static void main(String[] args)
	{
		getRowCount();
		getCellDataString(1,2);
		getNumericCellData(1,1);
		//getColCount();
	}

	public static void getRowCount()
	{
		try {

			int rowcount=sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows::"+rowcount);
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	public static String getCellDataString(int rownum,int colnum)
	{
		String cellData;
		try {

			cellData=sheet.getRow(rownum).getCell(colnum).getStringCellValue();


		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			return null;
		}

		return cellData;
	}


	public static void getNumericCellData(int rownum,int colnum)
	{
		try {

			double cellData=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();

			System.out.println("Numeric Cell Data is "+cellData);
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}


	public static void getColCount()
	{
		try {

			int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns:: "+colcount);
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
