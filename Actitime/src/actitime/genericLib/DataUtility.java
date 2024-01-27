package actitime.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility{
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\girij\\OneDrive\\Desktop");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	public String getDataFromExcelSheet(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\girij\\Downloads\\Book12.xlsx");
	    Workbook wb= WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheetname);
	    DataFormatter format=new DataFormatter();
	    String value=format.formatCellValue(sh.getRow(rownum). getCell(cellnum));
	    return value;
	}

}
//FileInputStream fis=new FileInputStream("C:\\Users\\girij\\OneDrive\\Desktop\\acti.properties");
//FileInputStream fis=new FileInputStream("C:\\Users\\girij\\Downloads\\Book12.xlsx");