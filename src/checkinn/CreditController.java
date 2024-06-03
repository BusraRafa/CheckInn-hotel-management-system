/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Rodoshi
 */
public class CreditController implements Initializable {

    @FXML
    private MediaView medi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        medi();
    }
    MediaPlayer mediaplayer;

    public void medi() {
        String loc = "file:/E:/Cse/2.1/Spring-20/zLAB/SD/CheckInn/src/image/credit.mp4";
        Media media = new Media(loc);
        mediaplayer = new MediaPlayer(media);
        medi.setMediaPlayer(mediaplayer);
        mediaplayer.play();

    }
}
