package DAO;

import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CRUDDAO<T,ID> {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public boolean save(T dto) throws SQLException, ClassNotFoundException;
    public boolean update(T dto) throws SQLException, ClassNotFoundException;
    public T Search(ID id) throws SQLException, ClassNotFoundException;
    public boolean exist(ID id) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public String genarateNewId() throws SQLException, ClassNotFoundException;

}
