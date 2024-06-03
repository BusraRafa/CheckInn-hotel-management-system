/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rodoshi
 */
public class CheckoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<CheckoutTable> tab;

    @FXML
    private TableColumn<CheckoutTable, String> col1;

    @FXML
    private TableColumn<CheckoutTable, String> col2;

    @FXML
    private TableColumn<CheckoutTable, String> col3;

    @FXML
    private TableColumn<CheckoutTable, String> col4;

    @FXML
    private TableColumn<CheckoutTable, String> col5;
    @FXML
    private Label deposit;

    ObservableList<CheckoutTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection conn = Javaconnect.ConnectDB();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM checkout");

            while (rs.next()) {
                oblist.add(new CheckoutTable(rs.getString("Name"), rs.getString("mail"), rs.getString("BookingID"), rs.getString("taka"), rs.getString("time")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setCellValueFactory(new PropertyValueFactory<>("mail"));
        col3.setCellValueFactory(new PropertyValueFactory<>("id"));
        col4.setCellValueFactory(new PropertyValueFactory<>("money"));
        col5.setCellValueFactory(new PropertyValueFactory<>("time"));

        tab.setItems(oblist);

        String qry = "Select SUM(taka) from checkout";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String mny = rs.getString("SUM(taka)");
                deposit.setText(mny + " BDT");

            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
