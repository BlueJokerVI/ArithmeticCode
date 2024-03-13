package _001_shuzu;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InitializeIntArray {
    public static void main(String[] args) {
        // 方法1：直接赋值
        int[] array1 = {1, 2, 3}; // 你要赋予的 2000 个初始值

        // 方法2：循环赋值
        int[] array2 = new int[3];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1; // 从 1 开始赋值，如果从 0 开始赋值可以是 i
        }

        // 方法3：使用 Arrays.fill()
        int[] array3 = new int[3];
        Arrays.fill(array3, 5); // 填充 2000 个值为 5 的元素

        // 方法4：使用 Streams
        int[] array4 = IntStream.rangeClosed(1, 3).toArray();

        // 打印数组，看看结果
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Array 3: " + Arrays.toString(array3));
        System.out.println("Array 4: " + Arrays.toString(array4));
    }
}
