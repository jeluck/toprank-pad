
package cc.toprank.byd.common.mybatis;

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
public class BooleanTypeHandler implements TypeHandler<Boolean> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType)
            throws SQLException {
        if (aBoolean == null) {
            preparedStatement.setNull(i, Types.INTEGER);
        } else {
            if (aBoolean) {
                preparedStatement.setInt(i, 1);
            } else {
                preparedStatement.setInt(i, 0);
            }
        }
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getInt(i) != 0;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt(i) != 0;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String columnName) throws SQLException {
        return resultSet.getInt(columnName) != 0;
    }
}



