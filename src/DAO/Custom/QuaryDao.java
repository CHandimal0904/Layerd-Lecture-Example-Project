package DAO.Custom;

import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDao {
     ArrayList<CustomDTO> searchOrderByOrderId(String id)throws SQLException,ClassNotFoundException;
}
