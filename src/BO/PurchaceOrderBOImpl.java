package BO;

import DAO.Custom.*;
import DAO.Custom.Impl.*;
import db.DBConnection;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PurchaceOrderBOImpl {
    ItemDAO itemDAO = new ItemDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDAO oderDAO = new OderDAOImpl();
    OrderDetailsDao ordeDetailsDAO = new OrdeDetailsDAOImpl();
    QuaryDao quaryDao = new QuaryDaoImpl();
    public boolean purchaceOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
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
}
