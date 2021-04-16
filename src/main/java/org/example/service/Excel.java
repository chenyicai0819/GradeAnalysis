package org.example.service;
/*
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.service.ExcelUtil;

import java.io.FileOutputStream;
import java.io.OutputStream;


public class Excel {

*/
/*
    /**
     *
     * @param qrListOut  要写入Excel里的二维数组
     * @param title   表格的字段数组
     */
/*
    public void exportFeedBack(String[][] qrListOut, String[] title) {
        String fileName = "反馈明细" + System.currentTimeMillis() + ".xls"; //文件名
        String sheetName = "反馈明细";//sheet名
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, qrListOut, null);

        //将文件存到指定位置
        try {
            OutputStream os = new FileOutputStream("C:\\Users\\swagg\\IdeaProjects\\GradeAnalysis\\src\\main\\OutputExcel\\" + fileName);
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
*/

