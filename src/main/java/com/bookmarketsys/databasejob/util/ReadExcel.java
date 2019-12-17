package com.bookmarketsys.databasejob.util;

import com.bookmarketsys.databasejob.pojo.Book;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private int totalRows;
    private int totalCells;
    private String errorMsg;

    public ReadExcel() {
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalCells() {
        return totalCells;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 读excel文件，获取信息集合
     *
     * @param mfile
     * @return
     */
    public List<Book> getExcelInfo(MultipartFile mfile) {
        String fileName = mfile.getOriginalFilename();//获取文件名
        List<Book>bookList=null;
        try {
            if (!validateExcel(fileName)) {
                return null;
            }
            boolean isExcel2003 = true;
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            bookList =createExcel(mfile.getInputStream(),isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }
    public List<Book>createExcel(InputStream inputStream,boolean isExcel2003)
    {
        Workbook wb=null;
        if(isExcel2003)
        {
            try {
                wb=new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                wb=new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Book>bookList=readExcelValue(wb);
        return bookList;
    }


    private List<Book> readExcelValue(Workbook wb) {
        //得到第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();

        }
        List<Book> bookList = new ArrayList<Book>();
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            Book book = new Book();
            //循环得到所有列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        //获取列的属性值，判断是不是数字
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String name = String.valueOf(cell.getNumericCellValue());
                            book.setName(name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1));
                        } else {
                            book.setName(cell.getStringCellValue());//name属性
                        }
                    } else if (c == 1) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String author = String.valueOf(cell.getNumericCellValue());
                            book.setAuthor(author.substring(0, author.length() - 2 > 0 ? author.length() - 2 : 1));

                        } else {
                            book.setAuthor(cell.getStringCellValue());
                        }

                    } else if (c == 2) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            book.setPrice(cell.getNumericCellValue());
                        }
                    } else if (c == 3) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String translation_author = String.valueOf(cell.getNumericCellValue());
                            book.setTranslationAuthor(translation_author.substring(0, translation_author.length() - 2 > 0 ? translation_author.length() - 2 : 1));

                        } else {
                            book.setAuthor(cell.getStringCellValue());
                        }
                    } else if (c == 4) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String type = String.valueOf(cell.getNumericCellValue());
                            book.setType(type.substring(0, type.length() - 2 > 0 ? type.length() - 2 : 1));

                        } else {
                            book.setType(cell.getStringCellValue());
                        }
                    } else if (c == 5) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            book.setMenuId((int) cell.getNumericCellValue());
                        }
                    }
                }

            }
         bookList.add(book);
        }
        return bookList;
    }



    /**
     * 验证EXCEL文件是哪个格式的
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath)
    {
        if(filePath==null||!(isExcel2003(filePath)||isExcel2007(filePath)))
        {
            errorMsg="文件名不是excel格式";
            return false;
        }
        return true;
    }
    public static boolean isExcel2003(String filePath){
        return filePath.matches("^.+\\\\.(?i)(xls)$");

    }
    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}


