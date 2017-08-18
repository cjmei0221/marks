package com.marks.module.sys.system.core.filter;

import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.StringUtils;


/**
 * 请求URL匹配规则处理类
 * @author cyp
 *
 */
public class RequestRegex
{

    public RequestRegex()
    {
    }

    public static String repace(String regex, String str)
    {
        if(StringUtils.isNotBlank(str))
        {
            String rBlash = "\\\\++";
            String patternStr = "/{2,}+";
            String friStr = repaceAll(rBlash, regex, str);
            return repaceAll(patternStr, regex, friStr);
        } else
        {
            return str;
        }
    }

    public static String repaceEmpty(String str)
    {
        String leftBlash = "";
        String patternStr = "/++|\\\\++";
        return repaceAll(patternStr, leftBlash, str);
    }

    public static boolean matches(String text, String regex)
    {
        return getPattern(regex).matcher(text).find();
    }

    private static String repaceAll(String patternStr, String repaceStr, String str)
    {
        Matcher m = getPattern(patternStr).matcher(str);
        return m.replaceAll(repaceStr);
    }

    private static Pattern getPattern(String regExPattern)
    {
        Pattern pattern = (Pattern)patternMap.get(regExPattern);
        if(pattern == null)
        {
            try
            {
                pattern = Pattern.compile(regExPattern);
            }
            catch(PatternSyntaxException e)
            {
                throw new IllegalArgumentException("Invalid input regular expression. Perl 5 regular expression syntax is required. " + e);
            }
            patternMap.put(regExPattern, pattern);
        }
        return pattern;
    }

    public static final String REGEXSTR = "/";
    private static Map<String,Pattern> patternMap = new Hashtable<String,Pattern>();

}
