/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rafa5
 */
public class RoomsController implements Initializable {

    @FXML
    private TableView<AdminRoom> tableAdmin = new TableView<>();
    @FXML
    private TableColumn<AdminRoom, String> colRoomNo;
    @FXML
    private TableColumn<AdminRoom, String> colType;
    @FXML
    private TableColumn<AdminRoom, String> colRoomDetails;
    @FXML
    private TableColumn<AdminRoom, String> colPrice;
    @FXML
    private TableColumn<AdminRoom, String> colStatus;
    @FXML
    private JFXTextField txt_price;
    @FXML
    private JFXTextField txt_type;
    @FXML
    private JFXTextField txt_roomdetail;
    @FXML
    private JFXTextField txt_status;
    ObservableList<AdminRoom> oblist = FXCollections.observableArrayList();
    int index = -1;
    PreparedStatement pst = null;

    @FXML
    public void search(KeyEvent ke) {
        FilteredList<AdminRoom> filterData = new FilteredList<>(oblist, p -> true);
        txt_type.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(pers -> {

                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (pers.getType().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (pers.getRoomNo().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (pers.getRoomDetails().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getPrice().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (pers.getStatus().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }

                return false;
            });
            SortedList<AdminRoom> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(tableAdmin.comparatorProperty());
            tableAdmin.setItems(sortedList);

        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            ResultSet rs = con.createStatement().executeQuery("select * from adminroom");

            while (rs.next()) {
                oblist.add(new AdminRoom(rs.getString("roomNo"), rs.getString("type"), rs.getString("roomdetails"), rs.getString("price"), rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRoomDetails.setCellValueFactory(new PropertyValueFactory<>("roomDetails"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableAdmin.setItems(oblist);
    }

    public void isbook() {
        Connection con = Javaconnect.ConnectDB();

        String qry = "SELECT COUNT(*) FROM `booking` WHERE RoomNo=?";
    }
}
