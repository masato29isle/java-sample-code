package com.github.masato29isle.sample.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Dateオブジェクト生成用Util
 */
public class DateUtil {

    /**
     * 指定した年月日時分秒のDateオブジェクトを生成する
     *
     * @param year       年
     * @param month      月(1〜12)
     * @param dayOfMonth 日
     * @param hour       時
     * @param minute     分
     * @return Dateオブジェクト
     */
    public static Date createDate(int year, int month, int dayOfMonth, int hour, int minute) {
        Calendar targetDateTime = Calendar.getInstance();
        targetDateTime.set(year, month - 1, dayOfMonth, hour, minute, 0);
        return targetDateTime.getTime();
    }

    /**
     * 最小のDateオブジェクトを返す
     *
     * @return Dateオブジェクト
     */
    public static Date minDate() {
        return createDate(0, 1, 1, 0, 0);
    }

}
