package cc.toprank.byd.util;

import cc.toprank.byd.common.mybatis.LocalDateTimeTypeHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-5-26 18:13
 */
public class DateHelper {
    public static LocalDateTime toLocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
