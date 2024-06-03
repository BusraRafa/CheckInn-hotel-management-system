/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.awt.Label;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DashboardController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private BorderPane mainpane;
    @FXML
    private MediaView mv;

    /**
     * Initializes the controller class.
     */
    public void handlecheckinbtnAction(ActionEvent event) {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Roomsinfo");
        mainpane.setCenter(view);

    }

    public void employeebtn(ActionEvent event) throws SQLException {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("RoomBooking");
        mainpane.setCenter(view);

    }

    public void roombtn(ActionEvent event) {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("B00kRoom");
        mainpane.setCenter(view);

    }

    public void foodbtn(ActionEvent event) {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("FoodItems");
        mainpane.setCenter(view);

    }

    public void checkoutbtn(ActionEvent event) {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Cart");
        mainpane.setCenter(view);

    }

    public void logoutbtn(ActionEvent event) throws IOException {
        PreparedStatement pst = null;
        Connection con;
        try {
            con = Javaconnect.ConnectDB();

            String sql = "DELETE FROM user";

            pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent root = FXMLLoader.load(getClass().getResource("LogInFXML.fxml"));

        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.centerOnScreen();
        window.show();

    }

    public void guest() {
        try {
            Connection con = Javaconnect.ConnectDB();
            PreparedStatement pst = null;

            pst = con.prepareStatement("SELECT COUNT(*)  FROM booking");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int sum = rs.getInt(1);
                //  countGuest.setText(String.valueOf(sum));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        medi();

    }
    MediaPlayer mediaplayer;

    public void medi() {
        String loc = "file:/E:/Cse/2.1/Spring-20/zLAB/SD/CheckInn/src/image/welcomFinal.mp4";
        Media media = new Media(loc);
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
        mv.setMediaPlayer(mediaplayer);

        mediaplayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaplayer.seek(Duration.ZERO);
                mediaplayer.play();
            }
        });
    }

}
