package com.navi;

/**
 * ReplaceBlankSpace Class
 * 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class ReplaceBlankSpace {

    public static void main(String[] args) {
        String source = "We Are Happy";
        System.out.println(source.replace(" ", "%20"));
        System.out.println(replace(source, ' '));
    }

    private static String replace(String source, char c) {
        if(null == source || "".equals(source)) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++){
            char c1 = source.charAt(i);
            if(c1 == c){
                sb.append("20%");
            }else{
                sb.append(c1);
            }
        }
        return sb.toString();
    }
}
