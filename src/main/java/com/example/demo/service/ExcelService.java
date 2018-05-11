package com.example.demo.service;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;

/**
 * Excel
 *
 * @author LiuYJ
 * @since 18/04/2018
 */
@Service
public class ExcelService {

    public HSSFWorkbook exportExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("导出");
        return workbook;
    }
}
