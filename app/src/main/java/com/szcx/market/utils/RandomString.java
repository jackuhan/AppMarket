package com.szcx.market.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2015/12/22.
 */
public class RandomString {

    /**
     * 密码类型枚举
     *
     * @author ASUS
     */
    public enum TYPE {
        /**
         * 字符型
         */
        LETTER,
        /**
         * 大写字符型
         */
        CAPITAL,
        /**
         * 数字型
         */
        NUMBER,
        /**
         * 符号型
         */
        SIGN,
        /**
         * 大+小字符 型
         */
        LETTER_CAPITAL,
        /**
         * 小字符+数字 型
         */
        LETTER_NUMBER,
        /**
         * 大+小字符+数字 型
         */
        LETTER_CAPITAL_NUMBER,
        /**
         * 大+小字符+数字+符号 型
         */
        LETTER_CAPITAL_NUMBER_SIGN
    }

    private static String[] lowercase = {
            "微信", "华为", "酷狗音乐", "应用宝", "360手机助手", "百度", "淘宝", "家电", "浏览器", "时空猎人", "地图", "空间", "美颜相机", "美图秀秀", "爱帮公交",
            "QQ", "腾讯微博", "苹果", "酷我音乐", "腾讯新闻", "支付宝", "唱吧", "京东", "WIFI", "墨迹天气"};

    private static String[] capital = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private static String[] number = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    private static String[] sign = {
            "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "`", "-", "=",
            "{", "}", "|", ":", "\"", "<", ">", "?",
            "[", "]", "\\", ";", "'", ",", ".", "/"};

    /**
     * 静态随机数
     */
    private static Random random = new Random();

    /**
     * 获取随机组合码
     *
     * @param num  位数
     * @param type 类型
     * @type <br>字符型 LETTER,
     * <br>大写字符型 CAPITAL,
     * <br>数字型 NUMBER,
     * <br>符号型 SIGN,
     * <br>大+小字符型 LETTER_CAPITAL,
     * <br>小字符+数字 型 LETTER_NUMBER,
     * <br>大+小字符+数字 型 LETTER_CAPITAL_NUMBER,
     * <br>大+小字符+数字+符号 型 LETTER_CAPITAL_NUMBER_SIGN
     */
    public static String getRandom(int num, TYPE type) {
        ArrayList<String> temp = new ArrayList<String>();
        StringBuffer code = new StringBuffer();
        if (type == TYPE.LETTER) {
            temp.addAll(Arrays.asList(lowercase));
        } else if (type == TYPE.CAPITAL) {
            temp.addAll(Arrays.asList(capital));
        } else if (type == TYPE.NUMBER) {
            temp.addAll(Arrays.asList(number));
        } else if (type == TYPE.SIGN) {
            temp.addAll(Arrays.asList(sign));
        } else if (type == TYPE.LETTER_CAPITAL) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(capital));
        } else if (type == TYPE.LETTER_NUMBER) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(number));
        } else if (type == TYPE.LETTER_CAPITAL_NUMBER) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(capital));
            temp.addAll(Arrays.asList(number));
        } else if (type == TYPE.LETTER_CAPITAL_NUMBER_SIGN) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(capital));
            temp.addAll(Arrays.asList(number));
            temp.addAll(Arrays.asList(sign));
        }
        for (int i = 0; i < num; i++) {
            code.append(temp.get(random.nextInt(temp.size())));
        }
        return code.toString();
    }
}
