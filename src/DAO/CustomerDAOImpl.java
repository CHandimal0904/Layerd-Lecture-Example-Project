package DAO;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAOImpl  {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomer= new ArrayList<>();
        while (rst.next()){
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            allCustomer.add(new CustomerDTO(id,name,address));
        }
        return allCustomer;
    }
}
