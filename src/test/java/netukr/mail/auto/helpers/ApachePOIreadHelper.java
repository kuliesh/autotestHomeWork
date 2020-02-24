package netukr.mail.auto.helpers;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ApachePOIreadHelper {
    private XSSFSheet excelWSheet;
    private XSSFWorkbook excelWBook;
    private XSSFCell cell;
    final static Logger logger = Logger.getLogger(netukr.mail.auto.helpers.ApachePOIreadHelper.class);

    // This method is to set the File path and to open the Excel file
    public void setExcelFile(String Path, String SheetName) {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(ExcelFile);

            excelWSheet = excelWBook.getSheet(SheetName);
            logger.info("setExcelFile");
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
    // Add all below described methods here
    public List getRowContains(String testCaseName, int colNum){
        List list = new ArrayList <>();
        int rowCount = getRowUsed();
        for (int i = 0; i <= rowCount; i++) {
            String cellData = getCellData(i, colNum);
            if (cellData.equalsIgnoreCase(testCaseName)) {
                list.add(i);
            }
        }
        return list;
    }

    private int getRowUsed(){
        return excelWSheet.getLastRowNum();
    }

    private String getCellData(int rowNum, int colNum) {
        logger.info("rowNum = " + rowNum + ", colNum = " + colNum);
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    private List[] getRowData(int rowNo) {
        List[] arr = new List[1];
        List list = new ArrayList();
        int startCol = 0;
        int totalCols = excelWSheet.getRow(rowNo)
                .getPhysicalNumberOfCells();
        logger.info("total colon = " + totalCols);
        for (int i = startCol; i < totalCols; i++) {
            String cellData = getCellData(rowNo, i);
            list.add(cellData);
        }
        arr[0] = list;
        for(List s : arr){
            for (Object st : s){
                System.out.println(st);
            }
        }
        return arr;
    }
    public Object[][] getTableArray(List<Integer> rowsNo) {
        Object[][] tabArray = new Object[rowsNo.size()][];
        for (int i = 0; i < rowsNo.size(); i++) {
            tabArray[i] = getRowData(rowsNo.get(i));
        }
        return tabArray;
    }
}

