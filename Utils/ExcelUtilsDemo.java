package Utils;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		
		String projectpath=System.getProperty("user.dir");
		ExcelUtils excel=new ExcelUtils(projectpath+"/Excel/data.xlsx","Sheet1");
		//excel.getRowCount();
		String jt=excel.getCellDataString(1,3);
		String bt=excel.getCellDataString(1,4);
		System.out.println(jt);
		System.out.println(bt);
		
		//excel.getNumericCellData(1,1);
	}

}
