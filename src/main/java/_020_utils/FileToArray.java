package _020_utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileToArray {
    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("E:\\ArithmeticCode\\src\\main\\java\\_020_utils\\in.txt"))) {
            String line1 = reader.readLine(); // 读取第一行
            String line2 = reader.readLine(); // 读取第二行

            if (line1 != null) {
                array1 = parseLineToArray(line1);
            }
            if (line2 != null) {
                array2 = parseLineToArray(line2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 输出结果
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
    }

    public static int[] parseLineToArray(String line) {
        // 去掉方括号并按逗号分隔
        String[] stringNumbers = line.replace("[", "").replace("]", "").split(",");
        int[] result = new int[stringNumbers.length];
        
        for (int i = 0; i < stringNumbers.length; i++) {
            result[i] = Integer.parseInt(stringNumbers[i].trim()); // 转换为整数
        }
        
        return result;
    }
}
