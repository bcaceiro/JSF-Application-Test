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

            System.out.println(connection.getConnection().getMetaData().getSchemas());

            PreparedStatement pst = null;
            ResultSet rs = null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
