/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.*;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SignUpController implements Initializable {

    @FXML
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    @FXML
    private JFXTextField namefield, mailfield, addressfield, phonefield, OTP, enterotp;

    @FXML
    private JFXPasswordField passfield;

    @FXML
    private ToggleGroup gender;

    @FXML
    private JFXTextField genderfield;

    @FXML
    private CheckBox agree;

    @FXML
    private JFXButton signupbtn;

    @FXML
    private AnchorPane infopane, otppane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // slideshow();
    }
    @FXML
    ImageView image;
    int count;

    //function for image slide show  
    public void slideshow() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("/S2.jpg"));
        images.add(new Image("/S3.jpg"));
        images.add(new Image("/S4.jpg"));
        images.add(new Image("/S5.jpg"));
        images.add(new Image("/S6.jpg"));
        images.add(new Image("/S7.jpg"));
        images.add(new Image("/S1.jpg"));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            image.setImage(images.get(count));
            count++;
            if (count == 7) {
                count = 0;
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public SignUpController() {
        conn = Javaconnect.ConnectDB(); //connect to database

    }

    public void signup() //function to insert data into database
    {
        try {
            String sql = "insert into logindata values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, namefield.getText());
            ps.setString(2, mailfield.getText());
            ps.setString(3, passfield.getText());
            ps.setString(4, addressfield.getText());
            ps.setString(5, genderfield.getText());
            ps.setString(6, phonefield.getText());
            ps.setString(7, null);
            ps.setString(8, null);
            ps.setString(9, null);
            ps.setString(10, null);
            ps.setString(11, null);
            ps.setString(12, null);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Signup successfull");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void Random() //funtion to create random number for OTP
    {
        Random rd = new Random();
        int rannum = rd.nextInt(10000) + 1011;
        OTP.setText("" + rannum);
    }

    public void sendotp() //method to send OTP to user 
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("checkinn.cse@gmail.com", "frum ouee kqev pehj");
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom("checkinn.cse@gmail.com");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailfield.getText()));
            message.setSubject("OTP For your Account");
            message.setText("Hey " + namefield.getText() + ",\n\nWelcome to Check Inn" + "\nHere your OTP is : " + OTP.getText());
            message.saveChanges();

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "OTP has sent to your Email id");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //action for radiobutton to string
    @FXML
    void Itfemale(ActionEvent event) {

        genderfield.setText("female");

    }

    //action for radiobutton to string
    @FXML
    void Itmale(ActionEvent event) {

        genderfield.setText("male");
    }

    //action for radiobutton to string
    @FXML
    void Itother(ActionEvent event) {

        genderfield.setText("other");
    }

    //action for opening pdf of terms & condition
    @FXML
    void openPDF(ActionEvent event) {
        try {
            Desktop.getDesktop().open(new File("E:\\Cse\\2.1\\Spring-20\\zLAB\\SD\\CheckInn\\src\\checkinn\\Terms & Condition.pdf"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //singup button action & open OTP page 
    @FXML
    void singUpAction(ActionEvent event) throws SQLException {

        String name = namefield.getText();
        String mail = mailfield.getText();
        String pass = passfield.getText();
        String add = addressfield.getText();
        String gndr = genderfield.getText();
        String phn = phonefield.getText();

        if (name.equals("") || mail.equals("") || pass.equals("") || add.equals("") || gndr.equals("") || phn.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill up all.");
        } else {
            if (mail.contains("@") && mail.contains(".com")) {
                String m = mailfield.getText();
                String query = "SELECT * FROM `logindata` WHERE email_id=? ";
                Connection con = Javaconnect.ConnectDB();
                PreparedStatement pst = null;
                ResultSet rs;
                pst = con.prepareStatement(query);
                pst.setString(1, m);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "This email has already taken.\nIf you have forgotten your password press 'Forgot Password?'.");

                } else {
                    Random();                     //call random funtion for otp
                    infopane.setVisible(false);   //hide info page
                    otppane.setVisible(true);     //open otp page
                    sendotp();                    //send otp
                }

            } else {
                JOptionPane.showMessageDialog(null, "Enter a valid email.");
            }
        }

    }

    //action for agree with terms & condition to signup
    //if agree then user can signup
    @FXML
    void checkbox(ActionEvent event) {

        if (agree.isSelected()) {
            signupbtn.setDisable(false);
        } else {
            signupbtn.setDisable(true);
        }
    }

    //action of otp submition button.
    //if write correct otp then user can signup succesfully
    @FXML
    void submitAction(ActionEvent event) throws IOException {

        if (OTP.getText().equals(enterotp.getText())) {
            signup();
            Parent pane = FXMLLoader.load(getClass().getResource("LogInFXML.fxml"));
            Scene scene = new Scene(pane);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.centerOnScreen();
            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "Wrong OTP.\nPlease Enter OTP correctly.");
        }
    }

    //not implemented action for if someone has account already
    @FXML
    void openLogin(ActionEvent event) throws IOException {
        //System.out.println("Log In page");
        Parent pane = FXMLLoader.load(getClass().getResource("LogInFXML.fxml"));
        Scene scene = new Scene(pane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }
}
