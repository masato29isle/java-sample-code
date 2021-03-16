package com.github.masato29isle.sample.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Dateオブジェクト生成用Util
 */
public class DateUtil {

    /**
     * 指定した年月日時分のDateオブジェクトを生成する<br/>
     * 秒は0の固定値とする
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
        targetDateTime.clear();
        targetDateTime.set(year, month - 1, dayOfMonth, hour, minute, 0);
        return targetDateTime.getTime();
    }

    /**
     * 最小のDateオブジェクトを返す(1970-01-01T00:00:00 GMTを最小値と規定する)
     *
     * @return Dateオブジェクト
     */
    public static Date minDate() {
        return createDate(1970, 1, 1, 0, 0);
    }

}
