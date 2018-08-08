package com.sauzny.jkitchen_note.poi;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class DeletePoi {

    public static void main(String[] args) throws Exception {
        
        String filePath = "C:/Users/1/Desktop/del/2017年网聊资源记录表.xls";
        
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
        // 2.得到Excel工作簿对象
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        
        for(Iterator<Sheet> iteratorwb = wb.sheetIterator(); iteratorwb.hasNext();){
            Sheet sheet = iteratorwb.next();
            System.out.println(sheet.getSheetName());
            
            int rowNum=sheet.getLastRowNum();
            for(int i=1;i<rowNum;i++){
                Cell cell = sheet.getRow(i).getCell(3);
                System.out.println(cell.getStringCellValue());
            }
        }
    }
}
