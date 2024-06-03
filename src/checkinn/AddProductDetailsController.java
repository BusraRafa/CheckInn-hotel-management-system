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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddProductDetailsController implements Initializable {

    @FXML
    private Label Name1;
    @FXML
    private Label price;
    @FXML
    private TextField qty;
    @FXML
    private Label cusId;
    @FXML
    private TextField qty1;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection conn = Javaconnect.ConnectDB();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT `username` FROM `user`";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            if (rs.next()) {
                String name = rs.getString("username");
                qty1.setText(name);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddProductDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showInformation(String name, String price1) {
        Name1.setText(name);
        price.setText(price1);
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        PreparedStatement pst = null;
        try {
            String query = " INSERT INTO `food`( `Food_Name`, `Food_Price`, `Quantity`,`CustomerID`) VALUES(?,?,?,?)";
            Connection con = Javaconnect.ConnectDB();
            pst = con.prepareStatement(query);
            String fname = Name1.getText();
            String fprice = price.getText();
            String qt = qty.getText();
            String Id = qty1.getText();

            if (qt.equals("") || Id.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fillup all the information");

            } else {

                pst.setString(1, fname);
                pst.setString(2, fprice);
                pst.setString(3, qt);
                pst.setString(4, Id);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, " Added to Cart Successfully!");
                Stage stage = (Stage) btn.getScene().getWindow();
                stage.close();

            }

        } catch (Exception e) {

        }
    }

}
