package database;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Connect {

    public static void main(String[] argv) {

        try {
            DBConnection connection = new DBConnection();

            PreparedStatement statement = null;
            ResultSet result = null;

            statement = connection.getConnection().prepareStatement("SELECT * FROM TEESTES");

            result = statement.executeQuery();


            while(result.next()) {
                System.out.println("RESULTADOS");
                System.out.println(result.getInt("ID"));
                System.out.println(result.getString("NAME"));
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}



