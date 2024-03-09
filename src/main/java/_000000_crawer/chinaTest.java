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

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-02-28  13:46
 * @Description: TODO
 * @Version: 1.0
 */
public class chinaTest {

    @Test
    public void getInfo() throws IOException {
        String url = "http://localhost:63342/ArithmeticCode/2001%20%E5%B9%B4%20HPEC%20%E8%AE%AE%E7%A8%8B.html?_ijt=okidi7jtad6tmuepdl6mkniqlo&_ij_reload=RELOAD_ON_SAVE";
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("tr>td:nth-child(2)>font");
//        System.out.println(elements);
        System.out.println(elements.size());
//        tr>td:nth-child(2)>font>font:nth-child(1)
        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();

        for (int i = 0; i < elements.size(); i++) {

            Element element = elements.get(i);
            String title = element.select("font>b").text();
            String author = element.select("font>font:nth-child(1)").text();
            author = author.substring(title.length(),author.length());
            System.out.println("标题: " + title + " 第一作者：" + author);
            char[] chars = author.toCharArray();

            int cnt = 0;
            int cnt1 = 0;


            for (int i1 = 0; i1 < chars.length; i1++) {
                if(chars[i1]=='/'){
                    cnt = i1;
                    break;
                }
            }
            for (int j = chars.length-1; j >=0 ; j--) {
                if(chars[j]=='/'){
                    cnt1 = j;
                    break;
                }
            }

            String lab ="";
            if(cnt+1<author.length()){
                if(cnt==cnt1){
                    lab = author.substring(cnt + 1, author.length());
                }else {
                    lab = author.substring(cnt1+1, author.length());
                }
            }



            author = author.substring(0, cnt);
            System.out.println("标题: " + title + " 第一作者：" + author + " 实验室：" + lab);
            //写入数据
            Row row = sheet.createRow(i+1);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(title);
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(author);
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(lab);

        }
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\ArithmeticCode\\" + "2001chain.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
