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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class IcecreamController implements Initializable {

    @FXML
    private Label food1;
    @FXML
    private Label food2;
    @FXML
    private Label food3;
    @FXML
    private Label food4;
    @FXML
    private Label pr1;
    @FXML
    private Label pr3;
    @FXML
    private Label pr2;
    @FXML
    private Label pr4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadP();
        } catch (SQLException ex) {
            Logger.getLogger(IcecreamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backbtn(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("FoodItems2.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void BLUEBERRY(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(food1.getText(), pr1.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void banana(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(food4.getText(), pr4.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void mint(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(food3.getText(), pr3.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void fruit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(food2.getText(), pr2.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    Connection conn = Javaconnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void loadP() throws SQLException {
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='58'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='59'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='60'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='61'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            pr1.setText(itm1 + " BDT");
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            pr2.setText(itm2 + " BDT");
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            pr3.setText(itm3 + " BDT");
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            pr4.setText(itm4 + " BDT");
        }

    }
}
