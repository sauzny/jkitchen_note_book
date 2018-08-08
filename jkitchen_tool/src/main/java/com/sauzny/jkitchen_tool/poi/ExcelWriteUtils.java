package com.sauzny.jkitchen_tool.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelWriteUtils {

    private ExcelWriteUtils() {}

    public final static int XLS = 97;
    public final static int XLSX = 2007;


    public static void writeDataToExcel(int type, String sheetName, String fileName, List<List<String>> objss) throws IOException {

        Workbook wb = null;
        if (type == XLSX) {
            wb = new XSSFWorkbook();
        } else {
            wb = new HSSFWorkbook();
        }
        
        Sheet sheet = wb.createSheet(sheetName);

        // 写数据部分
        for (int i = 0; i < objss.size(); i++) {
            Row row = sheet.createRow(i);
            List<String> objs = objss.get(i);

            for (int j = 0; j < objs.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(objs.get(j));
            }
        }


        File dir = new File(fileName.substring(0, fileName.lastIndexOf(File.separatorChar)));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            wb.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
