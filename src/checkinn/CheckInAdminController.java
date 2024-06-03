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
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CheckInAdminController implements Initializable {

    @FXML
    private TableView<ModelTableUser> guestTable;

    @FXML
    private TableColumn<ModelTableUser, String> name;

    @FXML
    private TableColumn<ModelTableUser, String> contac;

    @FXML
    private TableColumn<ModelTableUser, String> Cin;

    @FXML
    private TableColumn<ModelTableUser, String> Cout;

    @FXML
    private TableColumn<ModelTableUser, String> days;

    @FXML
    private TableColumn<ModelTableUser, String> roomTyp;

    @FXML
    private TableColumn<ModelTableUser, String> roomNo;

    @FXML
    private TableColumn<ModelTableUser, String> price;

    ObservableList<ModelTableUser> oblist = FXCollections.observableArrayList();
    ModelTableUser st, upd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection conn = Javaconnect.ConnectDB();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM booking");

            while (rs.next()) {
                oblist.add(new ModelTableUser(rs.getString("Guest_Name"), rs.getString("ContactNo"), rs.getString("Rooms_Type"), rs.getString("RoomNo"), rs.getString("CheckInDate"), rs.getString("CheckOutDate"), rs.getString("Total_Days"), rs.getString("Rooms_price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        contac.setCellValueFactory(new PropertyValueFactory<>("phone"));
        roomTyp.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomNo.setCellValueFactory(new PropertyValueFactory<>("room"));
        Cin.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        Cout.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        days.setCellValueFactory(new PropertyValueFactory<>("totalDay"));

        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        guestTable.setItems(oblist);
    }

    @FXML
    void delete(ActionEvent event) {
        PreparedStatement pst = null;
        Connection con;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Deleting User data");
            alert.setContentText("Do you really want to Delete this userdata?\nPress 'OK' to add or 'Cancel' to cancel.");
            alert.setGraphic(new ImageView(this.getClass().getResource("image11.jpg").toString()));

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                con = Javaconnect.ConnectDB();
                st = guestTable.getSelectionModel().getSelectedItem();
                String query = "SELECT  `Guest_Name`  FROM `booking` WHERE `Guest_Name`=?";
                pst = con.prepareStatement(query);
                pst.setString(1, st.getName());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("Guest_name");
                    String sql = "DELETE FROM booking WHERE Guest_Name=?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.executeUpdate();
                    /*
                    String sql1 = "DELETE FROM logindata WHERE username=?";
                    pst = con.prepareStatement(sql1);
                    pst.setString(1, name);
                    pst.executeUpdate();
                     */
                    String sql2 = "DELETE FROM food WHERE CustomerId=?";
                    pst = con.prepareStatement(sql2);
                    pst.setString(1, name);
                    pst.executeUpdate();
                    refresh();
                    JOptionPane.showMessageDialog(null, "An user's data has been deleted.");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refresh() {
        try {
            oblist.clear();
            Connection con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM booking ");
            while (rs.next()) {
                oblist.add(new ModelTableUser(rs.getString("Guest_Name"), rs.getString("ContactNo"), rs.getString("Rooms_Type"), rs.getString("RoomNo"), rs.getString("CheckInDate"), rs.getString("CheckOutDate"), rs.getString("Total_Days"), rs.getString("Rooms_price")));
            }
        } catch (SQLException ex) {

        }

        guestTable.setItems(oblist);
    }

}
