package cc.toprank.byd.common.mybatis;

import cc.toprank.byd.common.utils.DateUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Class description
 *
 * @author LinYN
 * @date 2017-05-31
 */
public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {
    @Override
    public void setParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter == null) {
            ps.setNull(i, Types.TIMESTAMP);
        } else {
            LocalDateTime dateTime = DateUtils.toUTCDateTime(parameter);
            ps.setTimestamp(i, Timestamp.valueOf(dateTime));
        }
    }

    @Override
    public LocalDateTime getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp timestamp = cs.getTimestamp(columnIndex);
        return timestamp == null ? null : DateUtils.toDefaultDateTime(timestamp.toLocalDateTime());
    }

    @Override
    public LocalDateTime getResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(columnIndex);
        return timestamp == null ? null : DateUtils.toDefaultDateTime(timestamp.toLocalDateTime());
    }

    @Override
    public LocalDateTime getResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(columnName);
        return timestamp == null ? null : DateUtils.toDefaultDateTime(timestamp.toLocalDateTime());
    }
}



