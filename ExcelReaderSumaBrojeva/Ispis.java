package ExcelReaderSumaBrojeva;

import java.io.IOException;

public class Ispis {

    public static void main(String[] args) throws IOException {
        ExcelReader excelReader = new ExcelReader("C:\\Users\\Sara\\IdeaProjects\\Selenium\\src\\test\\java\\ExcelReaderSumaBrojeva\\Brojevi.xlsx");
        int sum = 0;
        for(int i = 0; i <= excelReader.getLastRow("Brojevi"); i++){
            sum += excelReader.getIntegerData("Brojevi", i, 0);
        }
        System.out.println(sum);
    }

}
