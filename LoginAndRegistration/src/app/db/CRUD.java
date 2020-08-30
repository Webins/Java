package app.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUD  {
    static private PreparedStatement preparedStatement;

    public void Insert(String table, ArrayList<Object> values, String ...strings) throws SQLException, ClassNotFoundException {
        int length = strings.length;

        String sql = "INSERT INTO " + table + "(";
        for(int i = 0; i <= length; i++){
            if(i == strings.length) sql+=strings[i];
            else sql+= strings[i] + ",";
        }
        sql += ") VALUES (";
        for(int i = 0; i <= length; i++){
            if(i == strings.length) sql+="?";
            else sql+= "?,";
        }
        sql += ");";

       preparedStatement =  new dbHandler().getDbConnection().prepareStatement(sql);
      for(int i = 1; i <= length; i++){
          if(values.get(i--).getClass() == Integer.class){
           preparedStatement.setInt(i, (Integer) values.get(i--));
          }else if (values.get(i--).getClass() == Double.class){
              preparedStatement.setDouble(i, (Double) values.get(i--));
          }else if (values.get(i--).getClass() == String.class){
              preparedStatement.setString(i, (String) values.get(i--));
          }
      }
    preparedStatement.executeUpdate();
    }

    public ArrayList<Object> Select(String sql) throws SQLException, ClassNotFoundException {
       ArrayList<Object> list = new ArrayList<>();

       preparedStatement =  new dbHandler().getDbConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            list.add(resultSet);
        }
        return list;
    }
}
