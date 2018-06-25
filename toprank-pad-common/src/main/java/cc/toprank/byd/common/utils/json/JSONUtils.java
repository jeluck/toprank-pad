
package cc.toprank.byd.common.utils.json;

import cc.toprank.byd.common.utils.DateUtils;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springside.modules.mapper.JsonMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class JSONUtils {

    /** Field description */
    static JsonMapper mapper = new JsonMapper();

    static {
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(LocalDateTime.class,
                                     new LocalDateTimeSerializer(
                                         DateTimeFormatter.ofPattern(DateUtils.DATE_FORMAT_DATETIME)));
        javaTimeModule.addSerializer(LocalDate.class,
                                     new LocalDateSerializer(
                                         DateTimeFormatter.ofPattern(DateUtils.DATE_FORMAT_DATEONLY)));
        javaTimeModule.addSerializer(LocalTime.class,
                                     new LocalTimeSerializer(DateTimeFormatter.ofPattern(DateUtils.HMS_FORMAT)));
        mapper.getMapper().registerModule(javaTimeModule);
    }

    /**
     * Method description
     *
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     *
     * @return
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return mapper.fromJson(jsonString, clazz);
    }

    /**
     * Method description
     *
     *
     * @param jsonString
     * @param javaType
     * @param <T>
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String jsonString, JavaType javaType) {
        return (T) mapper.fromJson(jsonString, javaType);
    }

    /**
     * Method description
     *
     *
     * @param jsonString
     * @param collectionClass
     * @param elementClass
     * @param <T>
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static <T> T fromJson(String jsonString, Class<? extends Collection> collectionClass,
                                 Class<?> elementClass) {
        JavaType javaType = mapper.contructCollectionType(collectionClass, elementClass);

        return fromJson(jsonString, javaType);
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static String toJson(Object obj) {
        return mapper.toJson(obj);
    }

    /**
     * Method description
     *
     *
     * @param functionName
     * @param obj
     *
     * @return
     */
    public static String toJsonP(String functionName, Object obj) {
        return mapper.toJsonP(functionName, obj);
    }

}



