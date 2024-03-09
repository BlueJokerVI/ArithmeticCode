package _000000_crawer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-02-28  13:46
 * @Description: TODO
 * @Version: 1.0
 */
public class Crawer {

    @Test
    public void getInfo() throws IOException {
        String url = "https://archive.ll.mit.edu/HPEC/agendas/agenda01.html";

        Document doc = null;
        doc = Jsoup.connect(url).get();
        Elements elements = doc.select("tr>td:nth-child(2)>font");
        System.out.println(elements.size());
        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();


        for (int i = 0; i < elements.size(); i++) {

            Element element = elements.get(i);
            String title = element.select("b").text();
            String author = element.text();


            char[] chars = author.toCharArray();

            int cnt = 0;
            int end0 = 0;
            int end = author.length();
            for (int j = 0; j < chars.length; j++) {

                if (chars[j] == '/') {

                    if (cnt == 0) {
                        end0 = j;
                    }
                    cnt++;
                    if (cnt == 2) {
                        end = j;
                        break;
                    }
                }
            }
            if (end != author.length()) {
                int k = 0;
                while (k < 3) {
                    end--;
                    if (chars[end] == ' ') {
                        k++;
                    }
                }
            }
            String lab="";
            if(end0+1<end){
                lab= author.substring(end0 + 1, end);
            }

            if (title.length() < end0) {
                author = author.substring(title.length(), end0);
            }

            System.out.println("标题: " + title + " 第一作者：" + author + " 实验室：" + lab);

            //写入数据
            Row row = sheet.createRow(i + 1);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(title);
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(author);
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(lab);

        }
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\ArithmeticCode\\" + "2001new.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
