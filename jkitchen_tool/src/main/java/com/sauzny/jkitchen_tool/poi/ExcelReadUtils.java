package com.sauzny.jkitchen_tool.poi;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Lists;

public final class ExcelReadUtils {

    private ExcelReadUtils() {}

    public static List<List<Object>> read(File file) {
        return read(file, 0);
    }
    
    public static List<List<Object>> read(File file, int sheetNum) {
        List<List<Object>> objss = Lists.newArrayList();

        Sheet sheet = readSheet(file, sheetNum);

        int rowNo = sheet.getLastRowNum();

        for (int i = 0; i < rowNo + 1; i++) {
            Row row = sheet.getRow(i);
            int cellNo = row.getLastCellNum();
            List<Object> cellInfo = new ArrayList<>();
            for (int j = 0; j < cellNo; j++) {
                cellInfo.add(getCellValue(row.getCell(j)));
            }
            objss.add(cellInfo);
        }

        return objss;
    }

    public static Sheet readSheet(File file, int sheetNum) {
        return readWorkbook(file).getSheetAt(sheetNum);
    }

    public static Workbook readWorkbook(File file) {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return workbook;
    }

    public static Object getCellValue(Cell cell) {
        
        Object object = null;

        if(cell == null) return "";
        
        switch (cell.getCellTypeEnum()) {

            // 数值型
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    object = LocalDateTime.ofInstant(cell.getDateCellValue().toInstant(), ZoneId.systemDefault());
                }else{
                    object = cell.getNumericCellValue();
                }
                break;
            // 字符串
            case STRING:
                object = cell.getStringCellValue();
                break;
            // 公式型
            case FORMULA:
                try {
                    object = cell.getNumericCellValue();
                } catch (IllegalStateException e) {
                    try {
                        object = cell.getRichStringCellValue().toString();
                    } catch (IllegalStateException e2) {
                        object = cell.getErrorCellValue();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            // 空值
            case BLANK:
                object = "";
                break;
            // 布尔型
            case BOOLEAN:
                object = cell.getBooleanCellValue();
                break;
            // 错误
            case ERROR:
                object = cell.getErrorCellValue();
                break;

            default:
                object = "";
                break;
        }

        return object;
    }
    
    public static void main(String[] args) {
        System.out.println(ExcelReadUtils.read(new File("D:/d.xls"), 1));
    }
}
