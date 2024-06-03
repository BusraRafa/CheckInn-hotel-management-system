/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CartController implements Initializable {

    @FXML
    private TableView<modeltable3> table3;
    @FXML
    private TableView<modeltable5> table4;
    @FXML
    private Label totalbill;
    @FXML
    private Label prc;
    @FXML
    private TableColumn<modeltable3, String> fdname;
    @FXML
    private TableColumn<modeltable3, String> fdqt;
    @FXML
    private TableColumn<modeltable3, String> fdprice;
    modeltable3 st;
    @FXML
    private TableColumn<modeltable5, String> fdname1;
    @FXML
    private TableColumn<modeltable5, String> fdqt1;
    @FXML
    private TableColumn<modeltable5, String> fdprice1;
    modeltable5 st1;

    ObservableList<modeltable3> oblist = FXCollections.observableArrayList();
    ObservableList<modeltable5> oblist1 = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        fdname.setCellValueFactory(new PropertyValueFactory<>("Foodname"));
        fdprice.setCellValueFactory(new PropertyValueFactory<>("FoodPrice"));
        fdqt.setCellValueFactory(new PropertyValueFactory<>("Qty"));

        try {
            Connection con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("SELECT food.Food_Name,food.Food_Price,food.Quantity\n"
                    + "FROM food,user\n"
                    + "WHERE food.CustomerID=user.username ");
            while (rs.next()) {
                oblist.add(new modeltable3(rs.getString("Food_Name"), rs.getString("Food_Price"), rs.getString("Quantity")));
            }
        } catch (SQLException ex) {

        }

        table3.setItems(oblist);
        fdname1.setCellValueFactory(new PropertyValueFactory<>("fdname"));
        fdprice1.setCellValueFactory(new PropertyValueFactory<>("fdprice"));
        fdqt1.setCellValueFactory(new PropertyValueFactory<>("fdqty"));
        try {
            Connection con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("SELECT confirmfood.FoodName,confirmfood.FoodPrice,confirmfood.Quantity\n"
                    + "FROM confirmfood,user\n"
                    + "WHERE confirmfood.CustomerId=user.username ");
            while (rs.next()) {
                oblist1.add(new modeltable5(rs.getString("FoodName"), rs.getString("FoodPrice"), rs.getString("Quantity")));
            }
        } catch (SQLException ex) {

        }
        table4.setItems(oblist1);

    }

    @FXML
    private void confirmbtn(ActionEvent event) {
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            String sql = "Select sum(Food_Price*Quantity) FROM food,user WHERE food.CustomerID=user.username ";
            PreparedStatement pst = null;

            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("sum(Food_Price*Quantity)");
                prc.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void removebtn(ActionEvent event) throws SQLException {

        PreparedStatement pst = null;
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            st = table3.getSelectionModel().getSelectedItem();
            String sql = "DELETE food\n"
                    + "FROM food\n"
                    + "JOIN user on user.username=food.CustomerID\n"
                    + "WHERE food.Food_Name=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, st.getFoodname());
            pst.executeUpdate();
            refresh();
            JOptionPane.showMessageDialog(null, "deleted");

        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void order(ActionEvent event) throws SQLException {
        PreparedStatement pst = null;
        String query = "INSERT INTO `confirmfood`(`FoodName`, `FoodPrice`, `Quantity`, `CustomerId`) \n"
                + "SELECT food.Food_Name,food.Food_Price,food.Quantity,food.CustomerID\n"
                + "from food";
        Connection con = Javaconnect.ConnectDB();
        pst = con.prepareStatement(query);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Your order has been confirmed");
        String sql = "DELETE FROM food WHERE food.CustomerID IN (SELECT user.username FROM user)";

        pst = con.prepareStatement(sql);

        pst.executeUpdate();
        refresh();
        refresh1();
    }

    public void refresh() {
        try {
            oblist.clear();
            Connection con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("SELECT food.Food_Name,food.Food_Price,food.Quantity\n"
                    + "FROM food,user\n"
                    + "WHERE food.CustomerID=user.username ");
            while (rs.next()) {
                oblist.add(new modeltable3(rs.getString("Food_Name"), rs.getString("Food_Price"), rs.getString("Quantity")));
            }
        } catch (SQLException ex) {

        }

        table3.setItems(oblist);
    }

    public void refresh1() {
        try {
            oblist1.clear();
            Connection con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("SELECT confirmfood.FoodName,confirmfood.FoodPrice,confirmfood.Quantity\n"
                    + "FROM confirmfood,user\n"
                    + "WHERE confirmfood.CustomerId=user.username");
            while (rs.next()) {
                oblist1.add(new modeltable5(rs.getString("FoodName"), rs.getString("FoodPrice"), rs.getString("Quantity")));
            }
        } catch (SQLException ex) {

        }

        table4.setItems(oblist1);
    }

}
