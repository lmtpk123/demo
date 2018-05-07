package com.example.smm16.scancodepaydemo;

import java.text.SimpleDateFormat;

public class DataUtils {
    private static final String TimeSimple = "YY-MM-DD HH:mm:SS";

    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(TimeSimple);
        return sdf.format(System.currentTimeMillis());
    }
}
