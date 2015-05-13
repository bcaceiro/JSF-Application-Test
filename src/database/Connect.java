package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jpedrom on 13/05/15.
 */
public class Connect {

    public static void main(String[] argv) {

        try {
            DBConnection connection = new DBConnection();

            System.out.println(connection.getConnection());

            PreparedStatement statement = null;
            ResultSet result = null;




            statement = connection.getConnection().prepareStatement("SELECT * FROM Teste");
            result = statement.executeQuery();


            while(result.next()) {
                System.out.println(result.getInt("ID"));
                System.out.println(result.getString("NAME"));
            }


            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



