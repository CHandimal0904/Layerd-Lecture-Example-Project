package BO;

import DAO.Custom.*;
import DAO.Custom.Impl.*;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaceOrderBOImpl {
    ItemDAO itemDAO = new ItemDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDAO oderDAO = new OderDAOImpl();
    OrderDetailsDao ordeDetailsDAO = new OrdeDetailsDAOImpl();
    QuaryDao quaryDao = new QuaryDaoImpl();

    public boolean purchaceOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();


        /*if order id already exist*/
        if (oderDAO.exist(orderId)) {
        }
        connection.setAutoCommit(false);
        boolean save = oderDAO.save(new OrderDTO(orderId, orderDate, customerId));
        if (!save) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
        for (OrderDetailDTO detail : orderDetails) {
            boolean save1 = ordeDetailsDAO.save(detail);
            if (save1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
//                //Search & Update Item
//                ItemDTO item = findItem(detail.getItemCode());
            ItemDTO item = null;
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            boolean update = itemDAO.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

            if (update) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;

//      return false;

    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
    return customerDAO.Search(id);
    }
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
      return itemDAO.Search(code);
    }
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.exist(id);
    }
    public String genareteNewOrderId() throws SQLException, ClassNotFoundException {
       return oderDAO.genarateNewId();
    }
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
       return customerDAO.getAll();
    }
    public ArrayList<ItemDTO> loadAllItemCodes() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}

