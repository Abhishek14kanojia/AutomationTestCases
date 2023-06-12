package com.seleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderWithExcel{
    WebDriver driver;
    @BeforeMethod
    public void base(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "searchDataProvider")
    public void searchKeyWord(String keyword){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
    }

    @DataProvider(name = "searchDataProvider")
    public Object[][] searchDataProviderMethod() throws IOException {
          Object[][] searchData = getExcelData("C:\\SearchDataFile.xlsx","Sheet1");
//        Object[][] searchData = new Object[2][1];
//        searchData[0][0] = "Taj Mahal";
//        searchData[1][0] = "India Gate";
        return searchData;
    }


    public String [][] getExcelData(String fileName, String sheetName) throws IOException {

        String[][] data = null;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet excelSheet = workbook.getSheet(sheetName);
        int ttlRow = excelSheet.getLastRowNum() + 1;
        int ttlCell = excelSheet.getRow(0).getLastCellNum();
        data = new String[ttlRow-1][ttlCell];

        for(int currentRow = 1; currentRow < ttlRow; currentRow++){
            for (int currentCell = 0; currentCell < ttlCell; currentCell++) {
                data[currentRow-1][currentCell] = excelSheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
            }

        }
        workbook.close();
        return data;

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
