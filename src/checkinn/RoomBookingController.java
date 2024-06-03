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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RoomBookingController implements Initializable {

    @FXML
    private TableView<modeltable4> table4;
    @FXML
    private TableColumn<modeltable4, String> bookid;
    @FXML
    private TableColumn<modeltable4, String> cindate;
    @FXML
    private TableColumn<modeltable4, String> coutdate;
    @FXML
    private TableColumn<modeltable4, String> type;
    @FXML
    private TableColumn<modeltable4, String> no;
    @FXML
    private TableColumn<modeltable4, String> roomprice;
    @FXML
    private TableColumn<modeltable4, String> night;

    @FXML
    private Label bill;

    /**
     * Initializes the controller class.
     */
    ObservableList<modeltable4> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bookid.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        cindate.setCellValueFactory(new PropertyValueFactory<>("Checkin"));
        coutdate.setCellValueFactory(new PropertyValueFactory<>("CheckOut"));
        type.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
        no.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        roomprice.setCellValueFactory(new PropertyValueFactory<>("roomprice"));
        night.setCellValueFactory(new PropertyValueFactory<>("tnight"));

        try {
            Connection con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("SELECT booking.Booking_No,booking.CheckInDate,booking.CheckOutDate,booking.RoomNo,booking.Rooms_type,booking.Rooms_price,booking.Total_Days\n"
                    + "FROM booking,user\n"
                    + "WHERE booking.Guest_Name=user.username");

            while (rs.next()) {
                oblist.add(new modeltable4(rs.getString("Booking_No"), rs.getString("CheckInDate"), rs.getString("CheckOutDate"), rs.getString("Rooms_type"), rs.getString("RoomNo"), rs.getString("Rooms_price"), rs.getString("Total_Days")));
            }
        } catch (SQLException ex) {

        }

        table4.setItems(oblist);

    }

    @FXML
    private void checkout(ActionEvent event) {
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            String sql = "Select sum(Total_Days*Rooms_price)FROM booking,user WHERE booking.Guest_Name=user.username  ";
            PreparedStatement pst = null;

            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("sum(Total_Days*Rooms_price)");
                bill.setText(sum + " BDT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
