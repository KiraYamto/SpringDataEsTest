package org.bobo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * 
 * @author Javen
 *
 */
public final class GetUTCTimeUtil {
    
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
    
    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     * @return
     */
    public static String getUTCTimeStr() {
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        String month = (cal.get(Calendar.MONTH)+1)>9?(cal.get(Calendar.MONTH)+1)+"":"0"+(cal.get(Calendar.MONTH)+1);
        String day = cal.get(Calendar.DAY_OF_MONTH)>9?cal.get(Calendar.DAY_OF_MONTH)+"":"0"+cal.get(Calendar.DAY_OF_MONTH);
        String hour = cal.get(Calendar.HOUR_OF_DAY)>9?""+cal.get(Calendar.HOUR_OF_DAY):"0"+cal.get(Calendar.HOUR_OF_DAY);
        String minute = cal.get(Calendar.MINUTE)>9?""+cal.get(Calendar.MINUTE):"0"+cal.get(Calendar.MINUTE);
        String second = cal.get(Calendar.SECOND)>9?""+cal.get(Calendar.SECOND):"0"+cal.get(Calendar.SECOND);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append("T").append(hour).append(":").append(minute).append(second).append("Z") ;
        return UTCTimeBuffer.toString() ;

    }
    


}