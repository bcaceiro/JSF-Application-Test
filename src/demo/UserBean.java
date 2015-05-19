package demo;

import database.DBConnection;
import model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {

    private Connection conn;
    int userID;
    String name;


    public UserBean() {




        try {
            conn = new DBConnection().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }






    //connect to DB and get customer list
    public List<User> getUserList() throws SQLException{

        if(conn ==null)
            throw new SQLException("Can't get database connection");

        PreparedStatement ps = conn.prepareStatement(
                "select * from TEESTES");

        //get customer data from database
        ResultSet result =  ps.executeQuery();

        List<User> list = new ArrayList<User>();

        while(result.next()){
            User user1 = new User();

            user1.setUserID(result.getInt("ID"));
            user1.setName(result.getString("NAME"));

            //store all data into a List
            list.add(user1);
        }

        return list;
    }


    public void addUser(int userID, String name) throws SQLException {

        if(conn ==null)
            throw new SQLException("Can't get database connection");

        System.out.println("A inserir");


        PreparedStatement ps = conn.prepareStatement("INSERT INTO TEESTES VALUES a, b");


        ps.executeUpdate();




    }
}
