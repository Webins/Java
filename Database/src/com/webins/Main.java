package com.webins;

import com.db.dbHandler;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    static private Connection connection;
    static private dbHandler dbHandler;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        dbHandler = new dbHandler();
        connection = dbHandler.getDbConnection();
        write();
        read();
        update("New address", "Name", 5);
        delete(6);

    }
    /**Insert**/
    public static void write() throws SQLException {

        String sql = "INSERT INTO Author (Authorid, AuthorName, AuthorAddress) VALUES (?, ?, ?)";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

        preparedStatement.setInt(1,7);
        preparedStatement.setString(2, "Gabriel Garcia Marquez");
        preparedStatement.setString(3, "905 Broad Henry St. Tuscaloosa Rapids 20191");

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    /**SELECT**/
    public static void read() throws SQLException {
        String sql = "SELECT * FROM Author";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println(String.format("%5s", "Id") + String.format("%50s", "Author Address") + String.format("%30s", "Author Name"));
        while(resultSet.next()){
            System.out.println(
                            String.format("%5s", resultSet.getString("Authorid")) +
                            String.format("%50s", resultSet.getString("AuthorAddress")) +
                            String.format("%30s", resultSet.getString("AuthorName"))
            );
        }
        preparedStatement.close();
    }
/**Update**/
    public static void update(String address, String name, Integer id) throws SQLException{
        String sql = "UPDATE Author SET AuthorAddress = ? , AuthorName=? WHERE Authorid = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

        preparedStatement.setString(1, address);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3,id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    /**Delete**/
    public static void delete(Integer id) throws SQLException{
        String sql = "DELETE Author WHERE Authorid = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }


}
