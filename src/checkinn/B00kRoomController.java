/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rodoshi
 */
public class B00kRoomController implements Initializable {

    String s1 = "GRAND ";
    String s2 = "SUITE ";
    String s3 = "JUNIOR ";

    String r1 = "DELUX ";
    String r2 = s1.concat(r1); //grand delux
    String r3 = s1.concat(s2);  //Grand suit
    String r4 = "IMPERIAL ";
    String r5 = r4.concat(s2); //imperial suite
    String r6 = s3.concat(s2); //junior suite
    String r7 = r4.concat(r1); //imperial delux
    String r8 = "VENETO";
    String r9 = "DE VENETO";
    String r10 = "CHILDE ROOM";
    String r11 = "CHILD GUEST ROOM";

    String service = "Room service, 24-Hour";

    String s4 = "Largest ";
    String s5 = "Smaller ";

    String t1 = "Guest room";
    String t2 = "Suit";
    String t3 = s4 + t1; //larger guest room
    String t4 = s5 + t1; // smaller guest room

    String bed1 = "Bed- 1 King";
    String bed2 = "Bed- 1 Queen";
    String bed3 = "Bed- 2 Twin/Single Bed(s)";
    String bed4 = "Bed- 2 Single Bed(s)";

    @FXML
    private AnchorPane pan1;

    @FXML
    private Label room1;

    @FXML
    private Label name1;

    @FXML
    private Label pr1;

    @FXML
    private Label room2;

    @FXML
    private Label name2;

    @FXML
    private Label pr2;

    @FXML
    private Label room3;

    @FXML
    private Label name3;

    @FXML
    private Label lbl;

    @FXML
    private Label pr3, bd1, bd2, bd3;

    @FXML
    private ImageView pic1, pic2, pic3, pic4, pic5, pic6, pic7, pic8, pic9;
    @FXML
    private ImageView pic10, pic11, pic12, pic13, pic14, pic15, pic16, pic17, pic18, pic19;

    @FXML
    private JFXButton bnt1;

    @FXML
    private JFXButton morebtn1;

    @FXML
    private JFXButton morebtn2;

    @FXML
    private JFXButton morebtn3;

    @FXML
    private JFXButton morebtn4;

    @FXML
    private JFXButton morebtn5;

    @FXML
    private JFXButton morebtn6;

    @FXML
    private JFXButton prevbtn1;

    @FXML
    private JFXButton prevbtn2;

    @FXML
    private JFXButton prevbtn3;

    @FXML
    private JFXButton prevbtn4;

    @FXML
    private JFXButton prevbtn5;

    @FXML
    private JFXButton prevbtn6;

    @FXML
    private Label roomNOO1, roomNOO2, roomNOO3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scene1();
    }

    @FXML
    void buttonBook(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBooking.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddBookingController scene3 = fxmlLoader.getController();
        scene3.showInformation(name1.getText(), pr1.getText(), roomNOO1.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void buttonBook2(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBooking.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddBookingController scene3 = fxmlLoader.getController();
        scene3.showInformation(name2.getText(), pr2.getText(), roomNOO2.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void buttonBook3(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBooking.fxml"));
        Parent root4 = (Parent) fxmlLoader.load();
        AddBookingController scene3 = fxmlLoader.getController();
        scene3.showInformation(name3.getText(), pr3.getText(), roomNOO3.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void next2(ActionEvent event) {
        scene2();

    }

    @FXML
    void next3(ActionEvent event) {
        scene3();

    }

    @FXML
    void next4(ActionEvent event) {
        scene4();

    }

    @FXML
    void next5(ActionEvent event) {
        scene5();

    }

    @FXML
    void next6(ActionEvent event) {
        scene6();

    }

    @FXML
    void next7(ActionEvent event) {
        scene7();

    }

    @FXML
    void prev1(ActionEvent event) {
        scene1();

    }

    @FXML
    void prev2(ActionEvent event) {
        scene2();

    }

    @FXML
    void prev3(ActionEvent event) {
        scene3();

    }

    @FXML
    void prev4(ActionEvent event) {
        scene4();

    }

    @FXML
    void prev5(ActionEvent event) {
        scene5();

    }

    @FXML
    void prev6(ActionEvent event) {
        scene6();

    }

    public void scene1() {
        room1.setText(r1);
        name1.setText(t4);
        bd1.setText(bed2);
        pr1.setText("8082 BDT/Per Night");
        roomNOO1.setText("301");
        room2.setText(r1);
        name2.setText(t1);
        bd2.setText(bed1);
        pr2.setText("10090 BDT/Per Night");
        roomNOO2.setText("302");

        vble();
        room3.setText(r2);
        name3.setText(t3);
        bd3.setText(bed1);
        pr3.setText("15087 BDT/Per Night");
        roomNOO3.setText("303");

        pic1.setVisible(true);
        pic2.setVisible(true);
        pic3.setVisible(true);
        pic4.setVisible(false);
        pic5.setVisible(false);
        pic6.setVisible(false);
        pic7.setVisible(false);
        pic8.setVisible(false);
        pic9.setVisible(false);
        pic10.setVisible(false);
        pic11.setVisible(false);
        pic12.setVisible(false);
        pic13.setVisible(false);
        pic14.setVisible(false);
        pic15.setVisible(false);
        pic16.setVisible(false);
        pic17.setVisible(false);
        pic18.setVisible(false);
        pic19.setVisible(false);

        morebtn1.setVisible(true);
        morebtn2.setVisible(false);
        morebtn3.setVisible(false);
        morebtn4.setVisible(false);
        morebtn5.setVisible(false);
        morebtn6.setVisible(false);

        prevbtn1.setVisible(false);
        prevbtn2.setVisible(false);
        prevbtn3.setVisible(false);
        prevbtn4.setVisible(false);
        prevbtn5.setVisible(false);
        prevbtn6.setVisible(false);

    }

    public void scene2() {

        room1.setText(r2);
        name1.setText(t3);
        bd1.setText(bed1);
        pr1.setText("18077 BDT/Per Night");
        roomNOO1.setText("304");
        room2.setText(r1);
        name2.setText(t1);
        bd2.setText(bed1);
        pr2.setText("21090 BDT/Per Night");
        roomNOO2.setText("305");

        vble();
        room3.setText(r1);
        name3.setText(t1);
        bd3.setText(bed3);
        pr3.setText("15082 BDT/Per Night");
        roomNOO3.setText("306");

        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(true);
        pic5.setVisible(true);
        pic6.setVisible(true);
        pic7.setVisible(false);
        pic8.setVisible(false);
        pic9.setVisible(false);
        pic10.setVisible(false);
        pic11.setVisible(false);
        pic12.setVisible(false);
        pic13.setVisible(false);
        pic14.setVisible(false);
        pic15.setVisible(false);
        pic16.setVisible(false);
        pic17.setVisible(false);
        pic18.setVisible(false);
        pic19.setVisible(false);

        morebtn1.setVisible(false);
        morebtn2.setVisible(true);
        morebtn3.setVisible(false);
        morebtn4.setVisible(false);
        morebtn5.setVisible(false);
        morebtn6.setVisible(false);

        prevbtn1.setVisible(true);
        prevbtn2.setVisible(false);
        prevbtn3.setVisible(false);
        prevbtn4.setVisible(false);
        prevbtn5.setVisible(false);
        prevbtn6.setVisible(false);
    }

    public void scene3() {

        room1.setText(r2);
        name1.setText(t3);
        bd1.setText(bed3);
        pr1.setText("17063 BDT/Per Night");
        roomNOO1.setText("307");
        room2.setText(r6);
        name2.setText(t1);
        bd2.setText(bed1);
        pr2.setText("18097 BDT/Per Night");
        roomNOO2.setText("308");

        vble();
        room3.setText(r5);
        name3.setText(s2);
        bd3.setText(bed1);
        pr3.setText("22087 BDT/Per Night");
        roomNOO3.setText("309");
        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(false);
        pic5.setVisible(false);
        pic6.setVisible(false);
        pic7.setVisible(true);
        pic8.setVisible(true);
        pic9.setVisible(true);
        pic10.setVisible(false);
        pic11.setVisible(false);
        pic12.setVisible(false);
        pic13.setVisible(false);
        pic14.setVisible(false);
        pic15.setVisible(false);
        pic16.setVisible(false);
        pic17.setVisible(false);
        pic18.setVisible(false);
        pic19.setVisible(false);

        morebtn1.setVisible(false);
        morebtn2.setVisible(false);
        morebtn3.setVisible(true);
        morebtn4.setVisible(false);
        morebtn5.setVisible(false);
        morebtn6.setVisible(false);

        prevbtn1.setVisible(false);
        prevbtn2.setVisible(true);
        prevbtn3.setVisible(false);
        prevbtn4.setVisible(false);
        prevbtn5.setVisible(false);
        prevbtn6.setVisible(false);
    }

    public void scene4() {

        room1.setText(r4);
        name1.setText(s2);
        bd1.setText(bed1);
        pr1.setText("26066 BDT/Per Night");
        roomNOO1.setText("201");
        room2.setText(r3);
        name2.setText(s2);
        bd2.setText(bed1);
        pr2.setText("16082 BDT/Per Night");
        roomNOO2.setText("202");

        vble();
        room3.setText(r2);
        name3.setText(t1);
        bd3.setText(bed3);
        pr3.setText("16090 BDT/Per Night");
        roomNOO3.setText("203");

        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(false);
        pic5.setVisible(false);
        pic6.setVisible(false);
        pic7.setVisible(false);
        pic8.setVisible(false);
        pic9.setVisible(false);
        pic10.setVisible(true);
        pic11.setVisible(true);
        pic12.setVisible(true);
        pic13.setVisible(false);
        pic14.setVisible(false);
        pic15.setVisible(false);
        pic16.setVisible(false);
        pic17.setVisible(false);
        pic18.setVisible(false);
        pic19.setVisible(false);

        morebtn1.setVisible(false);
        morebtn2.setVisible(false);
        morebtn3.setVisible(false);
        morebtn4.setVisible(true);
        morebtn5.setVisible(false);
        morebtn6.setVisible(false);

        prevbtn1.setVisible(false);
        prevbtn2.setVisible(false);
        prevbtn3.setVisible(true);
        prevbtn4.setVisible(false);
        prevbtn5.setVisible(false);
        prevbtn6.setVisible(false);
    }

    public void scene5() {

        room1.setText(r7);
        name1.setText(t3);
        bd1.setText(bed2);
        pr1.setText("18087 BDT/Per Night");
        roomNOO1.setText("204");
        room2.setText(r8);
        name2.setText(s2);
        bd2.setText(bed1);
        pr2.setText("18082 BDT/Per Night");
        roomNOO2.setText("205");

        vble();
        room3.setText(r9);
        name3.setText(s2);
        bd3.setText(bed3);
        pr3.setText("18090 BDT/Per Night");
        roomNOO3.setText("206");

        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(false);
        pic5.setVisible(false);
        pic6.setVisible(false);
        pic7.setVisible(false);
        pic8.setVisible(false);
        pic9.setVisible(false);
        pic10.setVisible(false);
        pic11.setVisible(false);
        pic12.setVisible(false);
        pic13.setVisible(true);
        pic14.setVisible(true);
        pic15.setVisible(true);
        pic16.setVisible(false);
        pic17.setVisible(false);
        pic18.setVisible(false);
        pic19.setVisible(false);

        morebtn1.setVisible(false);
        morebtn2.setVisible(false);
        morebtn3.setVisible(false);
        morebtn4.setVisible(false);
        morebtn5.setVisible(true);
        morebtn6.setVisible(false);

        prevbtn1.setVisible(false);
        prevbtn2.setVisible(false);
        prevbtn3.setVisible(false);
        prevbtn4.setVisible(true);
        prevbtn5.setVisible(false);
        prevbtn6.setVisible(false);
    }

    public void scene6() {
        room1.setText(r10);
        name1.setText(t1);
        bd1.setText(bed4);
        pr1.setText("4068 BDT/Per Night");
        roomNOO1.setText("207");
        room2.setText(r10);
        name2.setText(t1);
        bd2.setText(bed4);
        pr2.setText("4068 BDT/Per Night");
        roomNOO2.setText("208");

        nvble();

        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(false);
        pic5.setVisible(false);
        pic6.setVisible(false);
        pic7.setVisible(false);
        pic8.setVisible(false);
        pic9.setVisible(false);
        pic10.setVisible(false);
        pic11.setVisible(false);
        pic12.setVisible(false);
        pic13.setVisible(false);
        pic14.setVisible(false);
        pic15.setVisible(false);
        pic16.setVisible(true);
        pic17.setVisible(true);
        pic18.setVisible(false);
        pic19.setVisible(false);

        morebtn1.setVisible(false);
        morebtn2.setVisible(false);
        morebtn3.setVisible(false);
        morebtn4.setVisible(false);
        morebtn5.setVisible(false);
        morebtn6.setVisible(true);

        prevbtn1.setVisible(false);
        prevbtn2.setVisible(false);
        prevbtn3.setVisible(false);
        prevbtn4.setVisible(false);
        prevbtn5.setVisible(true);
        prevbtn6.setVisible(false);
    }

    public void scene7() {

        room1.setText(r11);
        name1.setText(t3);
        bd1.setText(bed1);
        pr1.setText("5097 BDT/Per Night");
        roomNOO1.setText("209");
        room2.setText(r11);
        name2.setText(t1);
        bd2.setText(bed4);
        pr2.setText("5097 BDT/Per Night");
        roomNOO2.setText("210");

        nvble();

        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(false);
        pic5.setVisible(false);
        pic6.setVisible(false);
        pic7.setVisible(false);
        pic8.setVisible(false);
        pic9.setVisible(false);
        pic10.setVisible(false);
        pic11.setVisible(false);
        pic12.setVisible(false);
        pic13.setVisible(false);
        pic14.setVisible(false);
        pic15.setVisible(false);
        pic16.setVisible(false);
        pic17.setVisible(false);
        pic18.setVisible(true);
        pic19.setVisible(true);

        morebtn1.setVisible(false);
        morebtn2.setVisible(false);
        morebtn3.setVisible(false);
        morebtn4.setVisible(false);
        morebtn5.setVisible(false);
        morebtn6.setVisible(false);

        prevbtn1.setVisible(false);
        prevbtn2.setVisible(false);
        prevbtn3.setVisible(false);
        prevbtn4.setVisible(false);
        prevbtn5.setVisible(false);
        prevbtn6.setVisible(true);
    }

    public void vble() {
        room3.setVisible(true);
        name3.setVisible(true);
        pr3.setVisible(true);
        bd3.setVisible(true);
        room3.setVisible(true);
        bnt1.setVisible(true);
        lbl.setVisible(true);
    }

    public void nvble() {
        room3.setVisible(false);
        name3.setVisible(false);
        pr3.setVisible(false);
        bd3.setVisible(false);
        room3.setVisible(false);
        bnt1.setVisible(false);
        lbl.setVisible(false);
    }
}
