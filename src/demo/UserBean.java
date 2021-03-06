package demo;

import database.DBConnection;
import model.User;

import javax.annotation.PostConstruct;
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




    private User novo;

    @PostConstruct
    public void init() {
        novo = new User();
    }

    public User getNovo() {
        return novo;
    }

    public void setNovo(User novo) {
        this.novo = novo;
    }



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


    public void add() throws SQLException {

        if(conn ==null)
            throw new SQLException("Can't get database connection");


        String insertTableSQL = "INSERT INTO TEESTES"
                + "(ID, NAME) VALUES"
                + "(?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, (int)this.novo.getUserID());
        preparedStatement.setString(2, this.novo.getName());

        // execute insert SQL statement
        preparedStatement .executeUpdate();


    }

    public void del() throws SQLException {


        String delete = "DELETE FROM TEESTES WHERE id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(delete);
        preparedStatement.setInt(1, (int) this.novo.getUserID());

        preparedStatement .executeUpdate();
    }

    public void update() throws SQLException {


        String delete = "UPDATE TEESTES SET NAME=? WHERE ID=?";
        PreparedStatement preparedStatement = conn.prepareStatement(delete);
        preparedStatement.setString(1, this.novo.getName());
        preparedStatement.setInt(2, (int) this.novo.getUserID());

        preparedStatement .executeUpdate();
    }
}
