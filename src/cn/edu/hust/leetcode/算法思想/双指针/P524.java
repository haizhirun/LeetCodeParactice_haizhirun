package cn.edu.hust.leetcode.算法思想.双指针;

import java.util.*;

/**
 * @author kaisheng
 * @create 2020-11-07 20:32
 * 通过删除字母匹配到字典里最长单词
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。
 * 如果答案不存在，则返回空字符串。
 */
public class P524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(new P524().findLongestWord(s, d));
    }

    public String findLongestWord(String s, List<String> d) {
        List<String> res = new ArrayList<>();
        for (String target : d) {
            if (isMatch(s,target)) {
                res.add(target);
            }
        }
        if (res.size() > 0) {
            Collections.sort(res, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()){
                        return -1;
                    }else if (o1.length() < o2.length()){
                        return 1;
                    }else {
                        return o1.compareTo(o2);
                    }
                }
            });
            return res.get(0);
        }else {
            return "";
        }
    }

    public boolean isMatch(String s ,String target){
        if (s == null || target == null){
            return false;
        }
        int len1 = s.length() ;
        int len2 = target.length();
        if (len1 < len2){
            return false;
        }

        int i ,j ;
        for (i = 0 , j = 0; i < len1 && j < len2 ;) {
            if (s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
       return j == len2;
    }

}
