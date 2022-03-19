package 字符串匹配;

public class 暴力匹配 {
    public static void main(String[] args) {
        String str1 = "abc abfdabcdfbc abcdefg";
        String str2 = "bc";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }


    // 暴力匹配算法实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0; // i 索引指向 s1
        int j = 0; // j 索引指向 s2
        while (i < s1Len && j < s2Len) {// 保证匹配时，不越界
            if(s1[i] == s2[j]) {//匹配 ok
                i++;
                j++;
            } else { //没有匹配成功
                //如果失配（即 str1[i]! = str2[j]），令 i = i - (j - 1)，j = 0。
                i = i - (j - 1);
                j = 0;
            }
        }
//判断是否匹配成功
        if(j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
