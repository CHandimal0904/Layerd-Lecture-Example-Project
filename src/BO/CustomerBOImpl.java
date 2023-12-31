package BO;

import DAO.Custom.CustomerDAO;
import DAO.Custom.Impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO{
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
    return  customerDAO.getAll();
}
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
    return customerDAO.save(dto);
}
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       return customerDAO.update(dto);
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.exist(id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.delete(id);
    }
    @Override
    public String genareteNewCustomerId() throws SQLException, ClassNotFoundException {
       return customerDAO.genarateNewId();
    }

}
