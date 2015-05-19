package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jpedrom on 13/05/15.
 */
public class DBConnection {

    Connection connection = null;

    public DBConnection () throws SQLException {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@sificapdb.ipn.pt:1521:xe", "bruno",
                "sificap2015");
    }


    public Connection getConnection() {
        return this.connection;
    }

}
