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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class DashboardAdminController implements Initializable {

    @FXML
    private Label date;

    @FXML
    private Label lblcin;

    @FXML
    private Label lblroom;

    @FXML
    private Label lblcout;

    @FXML
    private Label currentGuest;

    @FXML
    private TableView<ModelTableDashAdmin> table;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> bookID;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> room;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> cin;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> cout;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> name;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> mail;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> regdate;

    @FXML
    private TableColumn<ModelTableDashAdmin, String> price;

    ObservableList<ModelTableDashAdmin> oblist = FXCollections.observableArrayList();

    Connection conn = Javaconnect.ConnectDB();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        time();

        try {

            checkIn();
            chckOut();
            gusetCount();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        roomCount();

        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM logindata");

            while (rs.next()) {
                oblist.add(new ModelTableDashAdmin(rs.getString("bookingID"), rs.getString("username"), rs.getString("email_id"), rs.getString("sign_in_date"), rs.getString("roomno"), rs.getString("checkin"), rs.getString("checkout"), rs.getString("Cost")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        bookID.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        cin.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        cout.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        regdate.setCellValueFactory(new PropertyValueFactory<>("reg"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.setItems(oblist);
    }

    public void time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yy   hh:mm");
        LocalDateTime now = LocalDateTime.now();
        date.setText(dtf.format(now));
    }

    public void checkIn() throws SQLException {
        DateTimeFormatter dtfn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtfn.format(now);

        PreparedStatement pst = null;
        ResultSet rs;
        String query = "SELECT COUNT(*) FROM `booking` WHERE CheckInDate=?";
        Connection con = Javaconnect.ConnectDB();
        pst = con.prepareStatement(query);
        pst.setString(1, today);
        rs = pst.executeQuery();
        if (rs.next()) {
            String tday = rs.getString("COUNT(*)");
            lblcin.setText(tday);

        }

    }

    public void chckOut() throws SQLException {
        DateTimeFormatter dtfl = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtfl.format(now);

        PreparedStatement pst = null;
        ResultSet rs;
        String qury = "SELECT COUNT(*) FROM `booking` WHERE CheckOutDate=?";
        Connection con = Javaconnect.ConnectDB();
        pst = con.prepareStatement(qury);
        pst.setString(1, today);
        rs = pst.executeQuery();
        if (rs.next()) {
            String ttday = rs.getString("COUNT(*)");
            lblcout.setText(ttday);

        }

    }

    public void gusetCount() throws SQLException {

        DateTimeFormatter dtfll = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtfll.format(now);

        PreparedStatement pst = null;
        ResultSet rs;
        String qurye = "SELECT COUNT(*) FROM `booking` WHERE CheckOutDate>? and CheckInDate<=?";
        Connection con = Javaconnect.ConnectDB();
        pst = con.prepareStatement(qurye);
        pst.setString(1, today);
        pst.setString(2, today);
        rs = pst.executeQuery();
        if (rs.next()) {
            String ttday = rs.getString("COUNT(*)");
            currentGuest.setText(ttday);

        }
    }

    public void roomCount() {

        int i = Integer.parseInt(currentGuest.getText());
        int sum = 19 - i;
        lblroom.setText(String.valueOf(sum));
    }

}
