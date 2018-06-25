
package cc.toprank.byd.common.mybatis;

import cc.toprank.byd.common.enums.StatusEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class StatusTypeHandler implements TypeHandler<StatusEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, StatusEnum statusEnum, JdbcType jdbcType)
            throws SQLException {
        if (statusEnum == null) {
            preparedStatement.setNull(i, Types.NUMERIC);
        } else {
            preparedStatement.setInt(i, statusEnum.getValue());
        }
    }

    @Override
    public StatusEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return StatusEnum.getEnum(callableStatement.getInt(i));
    }

    @Override
    public StatusEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return StatusEnum.getEnum(resultSet.getInt(i));
    }

    @Override
    public StatusEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return StatusEnum.getEnum(resultSet.getInt(s));
    }
}



