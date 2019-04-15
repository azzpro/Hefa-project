/*******************************************************************************
 * Project Key : CPPII Create on 2016年12月19日 下午3:02:36 Copyright (c) 2008 - 2011.深圳市齐采科技有限公司版权所有.
 * 粤ICP备16034195号 注意：本内容仅限于深圳市齐采科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.azz.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <P>excel 工具类</P>
 * @version 1.0
 * @author 黄智聪  2018年12月11日 上午11:37:00
 */
@Slf4j
public class ExcelUtils {

    /**
     * 复制Excel模板
     *
     * @param cols 列数
     * @param rows 行数
     * @param sheet 所要复制的Excel sheet
     * @param formatSheet 模板sheet
     * @throws Exception
     */
    public static void writeSheet(int cols, int rows, Sheet sheet, Sheet formatSheet)
            throws Exception {
        Workbook workbook = sheet.getWorkbook();
        Workbook wb = formatSheet.getWorkbook();
        Font workFont = workbook.createFont();

        for (int j = 0; j < rows; j++) {
            Row row = sheet.createRow(j);
            for (int i = 0; i < cols; i++) {
                if (j == 0) {
                    sheet.setColumnWidth(i, formatSheet.getColumnWidth(i));
                }

                Cell cell = null;
                Cell formatCell = formatSheet.getRow(j).getCell(i);
                CellStyle formatStyle = formatCell.getCellStyle();
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setBorderBottom(formatStyle.getBorderBottom());
                cellStyle.setBorderLeft(formatStyle.getBorderLeft());
                cellStyle.setBorderRight(formatStyle.getBorderRight());
                cellStyle.setBorderTop(formatStyle.getBorderTop());
                cellStyle.setAlignment(formatStyle.getAlignment());

                Font formatFont = wb.getFontAt(formatStyle.getFontIndex());

                // 字体
                workFont.setFontName(formatFont.getFontName());
                workFont.setFontHeightInPoints(formatFont.getFontHeightInPoints());
                workFont.setColor(formatFont.getColor());
                cellStyle.setFont(workFont);

                // 背景和前景
                cellStyle.setFillBackgroundColor(formatStyle.getFillBackgroundColor());
                cellStyle.setFillForegroundColor(formatStyle.getFillForegroundColor());

                cellStyle.setDataFormat(formatStyle.getDataFormat());
                cellStyle.setFillPattern(formatStyle.getFillPattern());

                switch (formatCell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                        cell.setCellValue(formatCell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        cell = row.createCell(i, Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(formatCell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        cell = row.createCell(i, Cell.CELL_TYPE_BLANK);
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                        break;
                    default:
                        throw new Exception("Not support celltype of the format file:"
                                + formatCell.getCellType());
                }
                cell.setCellStyle(cellStyle);
            }
        }
        writeSheetCellRange(cols, rows, sheet, formatSheet);
    }

    /**
     * <p>
     * copy模板中的合并单元格样式赋予新的sheet
     * </p>
     *
     * @param cols
     * @param rows
     * @param targetSheet
     * @param sourceSheet
     * @throws Exception
     * @author 王保旬（15996226054） 2016年8月29日 上午11:45:27
     */
    public static void writeSheetCellRange(int cols, int rows, Sheet targetSheet, Sheet sourceSheet)
            throws Exception {
        List<CellRangeAddress> oldRanges = new ArrayList<CellRangeAddress>();
        for (int i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
            oldRanges.add(sourceSheet.getMergedRegion(i));
        }

        for (int k = 0; k < oldRanges.size(); k++) {
            CellRangeAddress oldRange = oldRanges.get(k);
            CellRangeAddress newRange = new CellRangeAddress(oldRange.getFirstRow(),
                    oldRange.getLastRow(), oldRange.getFirstColumn(), oldRange.getLastColumn());

            if (oldRange.getLastColumn() <= cols && oldRange.getLastRow() <= rows) {
                targetSheet.addMergedRegion(newRange);
            }
        }
    }

    /**
     * Set the sheet head with the format file.
     *
     * @param cols - the num of column of the table
     * @param workbook - the workbook that you want to create CellStyle at
     * @param formatSheet - the format template sheet
     */
    public static List<CellStyle> getCellStylesOfFormatSheet(Workbook workbook, int cols, int row,
            Sheet formatSheet) {
        Font formatFont = setFontStyle(workbook, "Arial_9");
        List<CellStyle> cellStyles =
                getCellStylesOfFormatSheet(workbook, cols, row, formatSheet, formatFont);

        return cellStyles;
    }

    public static Font setFontStyle(Workbook wb, String font) {
        Font formatFont = wb.createFont();
        formatFont.setFontName("Arial");
        formatFont.setFontHeightInPoints((short) 11);

        return formatFont;
    }

    public static List<CellStyle> getCellStylesOfFormatSheet(Workbook workbook, int cols, int row,
            Sheet formatSheet, Font formatFont) {
        List<CellStyle> cellStyles = new ArrayList<CellStyle>();

        for (int i = 0; i < cols; i++) {
            Cell formatCell = formatSheet.getRow(row).getCell(i);
            CellStyle formatStyle = formatCell.getCellStyle();
            CellStyle cStyle = workbook.createCellStyle();
            cStyle.setBorderBottom(formatStyle.getBorderBottom());
            cStyle.setBorderLeft(formatStyle.getBorderLeft());
            cStyle.setBorderRight(formatStyle.getBorderRight());
            cStyle.setBorderTop(formatStyle.getBorderTop());
            cStyle.setAlignment(formatStyle.getAlignment());
            cStyle.setFont(formatFont);
            if (i == cols - 1) {
                cStyle.setWrapText(true);
            }
            cellStyles.add(cStyle);
        }

        return cellStyles;
    }

    public static void setCellValue(Row row, int indexOfCell, String strValue,
            List<CellStyle> cellStyles) {
        Cell cell = row.createCell(indexOfCell, Cell.CELL_TYPE_STRING);
        cell.setCellValue(strValue == null ? "" : strValue);
        cell.setCellStyle(cellStyles.get(indexOfCell));
    }

    public static void setCellValue(Row row, int indexOfCell, int i, List<CellStyle> cellStyles) {
        setCellValue(row, indexOfCell, Integer.toString(i), cellStyles);
    }

    public static String getStringValue(Cell cell) {
        if (ObjectUtils.isNotNull(cell)) {
            int cellType = cell.getCellType();
            switch (cellType) {
                case Cell.CELL_TYPE_BLANK:
                    return "";
                case Cell.CELL_TYPE_NUMERIC:
                    return String.valueOf(cell.getNumericCellValue());
                case Cell.CELL_TYPE_STRING:
                    return StringUtils.trimWhitespace(cell.getStringCellValue());
                default:
                    return "";
            }

        }
        return "";
    }


    public static Date getCellDate(Cell cell) {
        Date returnValue = null;
        if (null == cell || Cell.CELL_TYPE_BLANK == cell.getCellType()) {
            returnValue = null;
        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            returnValue = cell.getDateCellValue();

        } else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
            String dateValue = cell.getStringCellValue();
            returnValue = DateUtils.getDateFromString(dateValue);
        }

        return returnValue;
    }

    public static Double getDoubleValue(Cell cell) {
        Assert.notNull(cell, "单元格为空");
        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_BLANK:
                return null;
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_STRING:
                Double returnVal = null;
                try {
                    returnVal = NumberUtils.createDouble(cell.getStringCellValue());
                } catch (Exception e) {
                    log.error("excel 数据[{}]有误，非数字转为数字！", cell.getStringCellValue());
                }
                return returnVal;
            default:
                return null;
        }
    }

    public static void export(String downFileName, Workbook wb, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
            // firefox浏览器
            downFileName = new String(downFileName.getBytes("UTF-8"), "ISO8859-1");
        } else {
            // IE浏览器
            downFileName = URLEncoder.encode(downFileName, "UTF-8");
        }
        // 是否内联附件
        String inlineType = "attachment";
        response.setHeader("Content-Disposition",
                inlineType + ";filename=\"" + downFileName + "\"");
        response.setContentType("application/x-msdownload");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
