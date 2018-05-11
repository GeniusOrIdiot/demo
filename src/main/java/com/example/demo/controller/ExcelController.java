package com.example.demo.controller;

import com.example.demo.annotation.Animation;
import com.example.demo.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author LiuYJ
 * @since 18/04/2018
 */
@RestController
@Animation
public class ExcelController {
    private ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @RequestMapping(value = "/excel/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("导出.xls", "gbk"));
        HSSFWorkbook workbook = excelService.exportExcel();
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
}
