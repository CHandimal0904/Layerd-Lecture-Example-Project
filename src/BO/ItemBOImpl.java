package BO;

import DAO.Custom.Impl.ItemDAOImpl;
import DAO.Custom.ItemDAO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBo{
    private ItemDAO itemDAO = new ItemDAOImpl();
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
       return itemDAO.delete(code);
    }
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
       return itemDAO.save(dto);
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
       return itemDAO.update(dto);
    }
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
       return itemDAO.exist(code);
    }
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.genarateNewId();
    }
}
