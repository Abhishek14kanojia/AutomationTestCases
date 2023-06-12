package com.seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenTesting {

    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {

        XSSFWorkbook ExcelWBook = null;
        XSSFSheet ExcelSheet;
//        XSSFCell Cell;

        File excelFile = new File("C:\\TestDataFile.xlsx");
        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream(excelFile);

        ExcelWBook = new XSSFWorkbook(fileInputStream);
        ExcelSheet = ExcelWBook.getSheetAt(0);

        int ttlRows = ExcelSheet.getLastRowNum() + 1;
        int ttlCells = ExcelSheet.getRow(0).getLastCellNum();

        for (int currentRow = 1; currentRow < ttlRows; currentRow++) {
//            for (int currentCell = 0; currentCell < ttlCells; currentCell++) {
//
//                System.out.print(ExcelSheet.getRow(currentRow).getCell(currentCell));
//                System.out.print("\t");
//            }
//            System.out.println();

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.saucedemo.com/v1/");

            driver.findElement(By.id("user-name")).sendKeys(ExcelSheet.getRow(currentRow).getCell(0).toString());
            driver.findElement(By.id("password")).sendKeys(ExcelSheet.getRow(currentRow).getCell(1).toString());
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);
            driver.quit();
        }

        ExcelWBook.close();;
    }

}
