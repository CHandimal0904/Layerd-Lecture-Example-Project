package DAO.Custom;

import java.sql.SQLException;

public interface QuaryDao {
    public void searchOrderByOrderId(String id)throws SQLException,ClassNotFoundException;
}
