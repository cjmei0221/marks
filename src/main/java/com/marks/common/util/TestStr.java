package com.marks.common.util;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStr {
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    public static void main(String[] args) throws  Exception{
        String filePath="/Users/cjmei/Desktop/白鹤滩分公司党支部积极参加四川地区党委举办新时代三峡集团精神宣讲暨“最美三峡人”事迹巡讲主题党日活动.htm";
        StringBuilder sb=new StringBuilder();
        final int[] start = {-1,-1};
        Files.lines(Paths.get(filePath)).forEach(v ->{
            if(start[0] ==-1){
                start[0] =v.indexOf("news_detail_title");
            }
            if(start[1]==-1){
                start[1]=v.indexOf("copyright_i");
            }
            if(start[0] >=0 && start[1]==-1){
                sb.append(v);
            }

        });
        String str=sb.toString();
        System.out.println(stripHtml(sb.toString()));
    }

    public static String stripHtml(String htmlStr){
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
//        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        htmlStr = htmlStr.replaceAll("&nbsp;", "");
//        htmlStr = htmlStr.replaceAll("↵", "");
        return htmlStr.trim(); // 返回文本字符串
    }
}
