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
import java.util.Properties;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LogInFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private AnchorPane pane1, pane2;
    @FXML
    private TextField userName, psfld, mailfld;
    @FXML
    private PasswordField password;

    @FXML
    private Label name;

    PreparedStatement pst = null;
    ResultSet rs;
    String expass;

    @FXML
    void openSingUp(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(pane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.centerOnScreen();
        window.show();

    }

    public void openAdmin(ActionEvent event) throws IOException, SQLException {
        String usname = userName.getText();
        String pass = password.getText();
        psfld.setText(DigestUtils.sha1Hex(pass));
        String pp = psfld.getText();
        name.setText(usname);

        if (usname.equals("admin") && pp.equals("12bcd2a36d48662b095e7bb7ae13754ebd7ba956")) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Admin.fxml"));
            loader.load();
            AdminController display = loader.getController();
            display.setUserName(usname);
            Parent pane = loader.getRoot();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(pane));
            stage.centerOnScreen();

            stage.show();
        } else {
            String n = userName.getText();
            String p = password.getText();
            if (n.equals("") || p.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fillup all the information");
            } else {
                String query = "SELECT * FROM `admin` WHERE name=? and pass=?";
                Connection con = Javaconnect.ConnectDB();
                pst = con.prepareStatement(query);
                pst.setString(1, n);
                pst.setString(2, p);
                rs = pst.executeQuery();
                if (rs.next()) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Admin.fxml"));
                    loader.load();
                    AdminController display = loader.getController();
                    display.setUserName(n);
                    Parent pane = loader.getRoot();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(pane));
                    stage.centerOnScreen();
                    stage.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username/email or password\nor\nYou are not belong to Admin.");
                }
            }
        }
    }

    @FXML
    void passONmail(ActionEvent event) throws IOException, SQLException {

        String mail = mailfld.getText().toString();
        if (mail.contains("@") && mail.contains(".com")) {
            String query = "SELECT * FROM logindata WHERE email_id=?";
            Connection conn = Javaconnect.ConnectDB();

            pst = conn.prepareStatement(query);
            pst.setString(1, mail);
            rs = pst.executeQuery();
            if (rs.next()) {
                expass = rs.getString("password");
                sendPass();
                pane2.setVisible(false);
                pane1.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Can't find account with this email.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a Valid Email.");
        }

    }

    @FXML
    void resetpass(ActionEvent event) {

        pane1.setVisible(false);
        pane2.setVisible(true);
    }

    @FXML
    void backtologin(ActionEvent event) {

        pane2.setVisible(false);
        pane1.setVisible(true);
    }

    public void sendPass() //method to send OTP to user 
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
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailfld.getText()));
            message.setSubject("CheckInn Password");
            message.setText("Your password is : " + expass);
            message.saveChanges();

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Check your email for password.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please check your internet connection");
        }

    }

    @FXML
    void OpenUserPanel(ActionEvent event) throws SQLException, IOException {
        PreparedStatement pst = null;
        PreparedStatement psn = null;
        Connection con = Javaconnect.ConnectDB();
        try {

            String sql = "DELETE FROM user";

            pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String name = userName.getText();
        String pass = password.getText();
        int i = 1;
        if (name.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Fillup all the information");
        } else {
            String query = "SELECT * FROM `logindata` WHERE username=? and password=? or email_id=? and password=?";

            pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, pass);
            pst.setString(3, name);
            pst.setString(4, pass);
            rs = pst.executeQuery();
            if (rs.next()) {
                String nn = rs.getString("username");
                String qname = "INSERT INTO `user`(`username`) VALUES (?)";
                psn = con.prepareStatement(qname);
                psn.setString(1, nn);

                psn.executeUpdate();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Dashboard.fxml"));
                loader.load();

                Parent pane = loader.getRoot();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(pane));
                stage.centerOnScreen();
                stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Wrong username/email or password.\nor You don't"
                        + " have any account.");
            }
        }

    }
}
