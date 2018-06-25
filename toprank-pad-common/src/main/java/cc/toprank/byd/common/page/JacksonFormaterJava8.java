
package cc.toprank.byd.common.page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import cc.toprank.byd.common.utils.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
@Component
public class JacksonFormaterJava8 {

    /**
     * Method description
     *
     *
     * @return
     */
    @Bean(name = "mapperObject")
    public ObjectMapper getObjectMapper() {
        ObjectMapper   om             = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(LocalDateTime.class,
                                     new LocalDateTimeSerializer(
                                         DateTimeFormatter.ofPattern(DateUtils.DATE_FORMAT_DATETIME)));
        javaTimeModule.addSerializer(LocalDate.class,
                                     new LocalDateSerializer(
                                         DateTimeFormatter.ofPattern(DateUtils.DATE_FORMAT_DATEONLY)));
        javaTimeModule.addSerializer(LocalTime.class,
                                     new LocalTimeSerializer(DateTimeFormatter.ofPattern(DateUtils.HMS_FORMAT)));
        javaTimeModule.addSerializer(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(value);
                gen.writeString(formattedDate);
            }
        });
        javaTimeModule.addSerializer(Timestamp.class, new JsonSerializer<Timestamp>() {
            @Override
            public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(value);
                gen.writeString(formattedDate);
            }
        });
        javaTimeModule.addSerializer(java.sql.Date.class, new JsonSerializer<java.sql.Date>() {
            @Override
            public void serialize(java.sql.Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(value);
                gen.writeString(formattedDate);
            }
        });
        javaTimeModule.addSerializer(Time.class, new JsonSerializer<Time>() {
            @Override
            public void serialize(Time value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(value);
                gen.writeString(formattedDate);
            }
        });
        om.registerModule(javaTimeModule);
        return om;
    }
}



