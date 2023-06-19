package DAO;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    private static PreparedStatement getpreparedStatement(String sql,Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i+1,args[i]);
        }
        return pstm;
    }
    public static boolean executeUpdate(String sql,Object... args) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getpreparedStatement(sql, args);
        return preparedStatement.executeUpdate()>0;
    }

    public static ResultSet executeQuery(String sql, Object... args) throws SQLException, ClassNotFoundException {
        return getpreparedStatement(sql,args).executeQuery();
    }
}
