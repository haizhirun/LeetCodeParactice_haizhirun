package cn.edu.hust.leetcode.算法思想.双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author kaisheng
 * @create 2020-11-07 14:57
 *
 * 345. Reverse Vowels of a String (Easy)
 *
 * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
 *
 * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 *
 * 时间复杂度为 O(N)：只需要遍历所有元素一次
 * 空间复杂度 O(1)：只需要使用两个额外变量
 */
public class P345 {

    public static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
    );


    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] c = s.toCharArray();
        int i = 0 , j = c.length - 1;
        while (i < j) {
            if (!vowels.contains(c[i])){
                i++;
                continue;
            }
            if (!vowels.contains(c[j])) {
                j--;
                continue;
            }

            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }

        return new String(c);
    }


    public String reverseVowels2(String s) {
        if (s == null) {
            return null;
        }
        char[] result = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)){
                result[i++] = ci;
            }else if (!vowels.contains(cj)){
                result[j--] = cj;
            }else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    //判断是否是元音字母
    public boolean isVowel(char c){
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

}
