package org.example.repositories;

import org.example.data.interfaces.IDB;
import org.example.models.Table;
import org.example.repositories.interfaces.ITableRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TableRepository implements ITableRepository {
    private final IDB db;

    public TableRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTable(Table table) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO tables (firstName, secondName, capacity, reserved, phoneNumber) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,table.getfirstName());
            statement.setString(2,table.getSecondName());
            statement.setShort(3,table.getCapacity());
            statement.setBoolean(4, table.isReserved());
            statement.setString(5,table.getPhoneNumber());
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Table getTable(short id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,firstName,secondName,capacity,reserved,phonenumber FROM tables WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setShort(1,id);
            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()) {
                return new Table(resultSet.getShort("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getShort("capacity"),
                        resultSet.getBoolean("reserved"),
                        resultSet.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public List<Table> getAllTables() {
           Connection con = null;
           try {
               con = db.getConnection();
               String sql = "SELECT id,firstName,secondName,capacity,reserved,phonenumber FROM tables";
               Statement statement = con.createStatement();
               ResultSet resultSet = statement.executeQuery(sql);
               List<Table> tables = new LinkedList<>();
               while (resultSet.next()) {
                   Table table = new Table(resultSet.getShort("id"),
                           resultSet.getString("firstName"),
                           resultSet.getString("secondName"),
                           resultSet.getShort("capacity"),
                           resultSet.getBoolean("reserved"),
                           resultSet.getString("phoneNumber"));
                   tables.add(table);
               }
               return tables;

           } catch (SQLException e) {
               System.out.println("sql error: " + e.getMessage());
           } finally {
               try {
                   if (con != null)
                       con.close();
               } catch (SQLException e) {
                   System.out.println("sql error: " + e.getMessage());
               }
           }

        return null;
    }
}
