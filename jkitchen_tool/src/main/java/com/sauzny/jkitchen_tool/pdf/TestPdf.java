package com.sauzny.jkitchen_tool.pdf;

import java.awt.Color;
import java.io.FileOutputStream;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class TestPdf {
 
    private static final float PDF_PERCENT = 0.75f;
 
    public static void main(String[] args) throws Exception {
        float[] widths = { 144 * PDF_PERCENT, 113 * PDF_PERCENT, 91 * PDF_PERCENT,
                110 * PDF_PERCENT };
        int TOP = 36, LEFT = 36;
 
        FileOutputStream fos = new FileOutputStream("D:/line.pdf");
 
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
        document.setPageSize(PageSize.A4);
        document.open();
            
        PdfContentByte canvas = writer.getDirectContent();
        float top = document.getPageSize().getHeight() - TOP;
 
        PdfPTable table = new PdfPTable(widths);
        table.setLockedWidth(true);
        table.setTotalWidth(458 * PDF_PERCENT);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
 
        PdfPCell pdfCell = new PdfPCell();
        final String text = "                              AB\n\n\n CD";
        setBorderColor(pdfCell);
        pdfCell.setMinimumHeight(77 * PDF_PERCENT);
        pdfCell.setPhrase(new Paragraph(text, getPdfChineseFont()));
        table.addCell(pdfCell);
 
        // draw cell line
        int x1 = 61, y1 = 77;
        int x2 = 132, y2 = 76;
        int x3 = 144, y3 = 31;
        drawLine(canvas, LEFT, top, x1, y1);
        drawLine(canvas, LEFT, top, x2, y2);
        drawLine(canvas, LEFT, top, x3, y3);
 
        pdfCell = new PdfPCell();
        setBorderColor(pdfCell);
        pdfCell.setMinimumHeight(77 * PDF_PERCENT);
        table.addCell(pdfCell);
 
        pdfCell = new PdfPCell();
        setBorderColor(pdfCell);
        pdfCell.setMinimumHeight(77 * PDF_PERCENT);
        table.addCell(pdfCell);
 
        pdfCell = new PdfPCell();
        setBorderColor(pdfCell);
        pdfCell.setMinimumHeight(77 * PDF_PERCENT);
        table.addCell(pdfCell);
 
        pdfCell = new PdfPCell();
        setBorderColor(pdfCell);
        pdfCell.setMinimumHeight(83 * PDF_PERCENT);
        table.addCell(pdfCell);
 
        pdfCell = new PdfPCell();
        setBorderColor(pdfCell);
        pdfCell.setMinimumHeight(83 * PDF_PERCENT);
        table.addCell(pdfCell);
 
        pdfCell = new PdfPCell();
        setBorderColor(pdfCell);
        setBgColor(pdfCell);
        pdfCell.setPhrase(new Paragraph("                              AB\n\n CD", getPdfChineseFont()));
        pdfCell.setColspan(2);
        pdfCell.setMinimumHeight(83 * PDF_PERCENT);
        table.addCell(pdfCell);
        setBorderColor(pdfCell);
 
        document.add(table);
 
        /**
         * 画线问题记录
         * 
         * 问题：table中的cell设置背景色，背景色覆盖斜线问题
         * 
         * 调整代码解决问题：先add(table)，然后再画线
         * 
         */
        
        int cellX = (int) (widths[0] + widths[1]);
        int cellY = (int) (77 * PDF_PERCENT);
        int x = 201, y = 84;
        drawLine(canvas, LEFT + cellX, top - cellY, x, y);
        
        document.close();
    }
 
    // draw cell line
    private static void drawLine(PdfContentByte canvas, float left, float top, int x, int y) {
        canvas.saveState(); 
        canvas.moveTo(left, top);
        canvas.lineTo(left + x * PDF_PERCENT, top - y * PDF_PERCENT);
        canvas.stroke();
        canvas.restoreState();
    }
 
    // 设置边框样式
    public static void setBorderColor(PdfPCell pdfCell) {
        Color rgbColor = Color.BLACK;
        BaseColor baseColor = new BaseColor(rgbColor.getRed(), rgbColor.getGreen(), rgbColor
                .getBlue());
 
        pdfCell.setBorderWidthTop(0.1f);
        pdfCell.setBorderWidthBottom(0.1f);
        pdfCell.setBorderWidthLeft(0.1f);
        pdfCell.setBorderWidthRight(0.1f);
        pdfCell.setBorderColorBottom(baseColor);
        pdfCell.setBorderColorLeft(baseColor);
        pdfCell.setBorderColorRight(baseColor);
        pdfCell.setBorderColorTop(baseColor);
    }
 
    public static void setBgColor(PdfPCell pdfCell){
        BaseColor color = BaseColor.YELLOW;
        pdfCell.setBackgroundColor(color);
    }
    
    
    public static Font getPdfChineseFont() throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
        return fontChinese;
    }
}