package _006_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-28  09:07
 * @Description: https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 * 1047. 删除字符串中的所有相邻重复项
 * @Version: 1.0
 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        char []  chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();




        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()){
                char c = stack.peekLast();
                if(c==chs[i]){
                    stack.pollLast();
                }else {
                    stack.offerLast(chs[i]);
                }

            }else {
                stack.offerLast(chs[i]);
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        stack.forEach(character -> {
            stringBuffer.append(character);
        });

        return stringBuffer.toString();

    }
}
