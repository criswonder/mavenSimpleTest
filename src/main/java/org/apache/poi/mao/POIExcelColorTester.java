package org.apache.poi.mao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIExcelColorTester {

    public static void main(String args[]) throws FileNotFoundException, IOException{
        File file = new File("f00");
        file.getAbsolutePath();
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("colorTest.xls"));  
                HSSFSheet sheet = wb.getSheetAt(0);  
                for (int r = 0; r < 2; r++) {  
                    for (int c = 0;c < 2; c++) {  
                        HSSFRow row = sheet.getRow(r);  
                        HSSFCell cell = row.getCell(c);
                        //注意cell不能够没有值或颜色，否则抛空指针异常  
                        if(cell==null)continue;
                        int backgroundColor = cell.getCellStyle().getFillBackgroundColor();  
                        int foregroundColor = cell.getCellStyle().getFillForegroundColor(); // 前景色起作用  
                        int backgroundColor2 = (wb.getCellStyleAt((short) 0)).getFillBackgroundColor();//整张表背景色  
                        System.out.println((r+1)+"行"+(c+1)+"列"+":backgroundColor2"+ backgroundColor2 + ", backgroundColor" + backgroundColor + ", foregroundColor" + foregroundColor);  
                    }  
                }  
    }
}
