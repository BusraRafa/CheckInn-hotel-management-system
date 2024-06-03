/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FoodItemsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addcontinental(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("Continental.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void addindian(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("Indian.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();

    }

    @FXML
    private void addchinese(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("Chinese.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void addthai(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("Thai.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void addfood(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("FoodItems2.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void backbtn(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.centerOnScreen();
        window.show();
    }

}
