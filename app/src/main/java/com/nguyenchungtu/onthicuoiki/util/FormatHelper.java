package com.nguyenchungtu.onthicuoiki.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatHelper {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static String formatNgay(Date ngay){
        return sdf.format(ngay);
    }

    public static Date formatstring (String ngay) throws Exception
    {
        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(ngay);
        return date;
    }
}
