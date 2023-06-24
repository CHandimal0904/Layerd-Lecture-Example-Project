package DAO.Custom.Impl;

import DAO.Custom.QuaryDao;
import DAO.SQLUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuaryDaoImpl implements QuaryDao {
    @Override
    public void searchOrderByOrderId(String id)throws SQLException,ClassNotFoundException{
        String sql ="select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?;\", id";
        ResultSet resultSet = SQLUtil.executeQuery(sql, id);
        while (resultSet.next()) {
            String oid = resultSet.getString(1);
            String date = resultSet.getString(2);
            String customerId = resultSet.getString(3);
            String itemCode = resultSet.getString(4);
            int qty = resultSet.getInt(5);
            BigDecimal unitPrice = resultSet.getBigDecimal(6);

        }

    }
}
