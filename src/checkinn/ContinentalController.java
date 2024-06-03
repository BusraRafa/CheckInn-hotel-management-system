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
public class ContinentalController implements Initializable {

    @FXML
    private Label foodname1;
    @FXML
    private Label foodname2;
    @FXML
    private Label foodname3;
    @FXML
    private Label foodname4;
    @FXML
    private Label foodname5;
    @FXML
    private Label foodname6;
    @FXML
    private Label foodname7;
    @FXML
    private Label foodname8;
    @FXML
    private Label foodname9;
    @FXML
    private Label price1;
    @FXML
    private Label price2;
    @FXML
    private Label price3;
    @FXML
    private Label price6;
    @FXML
    private Label price5;
    @FXML
    private Label price4;
    @FXML
    private Label price9;
    @FXML
    private Label price8;
    @FXML
    private Label price7;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadP();
        } catch (SQLException ex) {
            Logger.getLogger(ContinentalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backbtn(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("FoodItems.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void englishbreakfast(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname1.getText(), price1.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void eggcups(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname2.getText(), price2.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void americanbreakfast(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname3.getText(), price3.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void chickensalad(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname4.getText(), price4.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void potatopie(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname5.getText(), price5.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void stuffedpotato(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname6.getText(), price6.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void batterfish(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname7.getText(), price7.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void roastlamb(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname8.getText(), price8.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }

    @FXML
    private void pastries(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProductDetails.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddProductDetailsController scene2 = fxmlLoader.getController();
        scene2.showInformation(foodname9.getText(), price9.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
    }
    Connection conn = Javaconnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void loadP() throws SQLException {
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='1'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='2'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='3'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='4'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='5'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='6'";
        String sql7 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='7'";
        String sql8 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='8'";
        String sql9 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='9'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            price1.setText(itm1 + " BDT");
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            price2.setText(itm2 + " BDT");
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            price3.setText(itm3 + " BDT");
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            price4.setText(itm4 + " BDT");
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            price5.setText(itm5 + " BDT");
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            price6.setText(itm6 + " BDT");
        }
        pst = conn.prepareStatement(sql7);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm7 = rs.getString("foodprice");
            price7.setText(itm7 + " BDT");
        }
        pst = conn.prepareStatement(sql8);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm8 = rs.getString("foodprice");
            price8.setText(itm8 + " BDT");
        }
        pst = conn.prepareStatement(sql9);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm9 = rs.getString("foodprice");
            price9.setText(itm9 + " BDT");
        }
    }

}
