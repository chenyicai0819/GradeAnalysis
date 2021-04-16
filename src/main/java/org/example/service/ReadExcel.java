package org.example.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.service.info.StudentInfoToExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public List<StudentInfoToExcel> readExcel(File file) {
        List<StudentInfoToExcel> students = new ArrayList<>();
        XSSFWorkbook xw = null;
        try {
            xw=new XSSFWorkbook(file);
            XSSFSheet sheet=xw.getSheetAt(0);
            for(int i=2;i<=sheet.getLastRowNum();i++){
                XSSFRow rows=sheet.getRow(i);
                students.add(new StudentInfoToExcel(getValue(rows.getCell(0)),getValue(rows.getCell(1)),
                        getValue(rows.getCell(2)),getValue(rows.getCell(3)),getValue(rows.getCell(4)),
                        getValue(rows.getCell(5)),getValue(rows.getCell(6)),getValue(rows.getCell(7)),
                        getValue(rows.getCell(8)),getValue(rows.getCell(9)),getValue(rows.getCell(10)),
                        getValue(rows.getCell(11)),getValue(rows.getCell(12)),getValue(rows.getCell(13)),
                        getValue(rows.getCell(14)),getValue(rows.getCell(15)),getValue(rows.getCell(16)),
                        getValue(rows.getCell(17))));
            }
            return students;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return students;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellType();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                value = cell.getNumericCellValue() + "";
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
