/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RoomsinfoController implements Initializable {

    @FXML
    private Label txt1;
    @FXML
    private Label txt2;
    @FXML
    private Label txt3;
    @FXML
    private Label txt4;
    @FXML
    private TextField tf1, mail;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user();
        user2();
        user3();
        user4();
        try {
            getMail();
        } catch (SQLException ex) {
            Logger.getLogger(RoomsinfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.setDisable(true);

    }

    public void show() {
        int s1 = Integer.parseInt(dd);
        int s2 = Integer.parseInt(df);
        int s3 = s1 + s2;
        String sum6 = String.valueOf(s3);
        tf1.setText(sum6 + " BDT");
    }

    String sum;

    public void download(ActionEvent event) {

        show();
        btn.setDisable(false);
    }

    public void user() {
        Connection con;
        try {

            con = Javaconnect.ConnectDB();
            String sql = "SELECT Guest_Name FROM booking,user WHERE booking.Guest_Name=user.username";
            PreparedStatement pst = null;
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sum = rs.getString("Guest_Name");
                txt1.setText(sum);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void user2() {
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            String sql = "SELECT CONCAT(Booking_No) FROM booking,user WHERE booking.Guest_Name=user.username";
            PreparedStatement pst = null;

            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String sum22 = rs.getString("CONCAT(Booking_No)");
                txt2.setText(sum22);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String df;

    public void user3() {
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            String sql = "Select sum(FoodPrice*Quantity) FROM confirmfood,user WHERE confirmfood.CustomerId=user.username";
            PreparedStatement pst = null;

            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String sum3 = rs.getString("sum(FoodPrice*Quantity)");
                if (sum3 != null) {
                    int f2 = sum3.indexOf(".");
                    df = sum3.substring(0, f2);
                    txt4.setText(df + "/- BDT");
                } else {
                    txt4.setText("00.00 /- BDT");
                    df = "0";
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String dd;

    public void user4() {
        Connection con;
        try {
            con = Javaconnect.ConnectDB();
            String sql = "Select sum(Total_Days*Rooms_price)FROM booking,user WHERE booking.Guest_Name=user.username";
            PreparedStatement pst = null;

            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String sum1 = rs.getString("sum(Total_Days*Rooms_price)");
                if (sum1 != null) {
                    int f1 = sum1.indexOf(".");
                    dd = sum1.substring(0, f1);
                    txt3.setText(dd + "/- BDT");
                } else {
                    txt3.setText("00.00 /- BDT");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkout(ActionEvent event) throws SQLException {
        try {

            Connection con = Javaconnect.ConnectDB();
            PreparedStatement pstt = null;
            PreparedStatement pst = null;

            String query = "DELETE FROM booking where Guest_Name=?";
            String qry = "DELETE FROM confirmfood where CustomerId=?";

            pstt = con.prepareStatement(query);
            pst = con.prepareStatement(qry);

            pstt.setString(1, sum);
            pst.setString(1, sum);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Cheking Out from \"Check Inn\"");
            alert.setContentText("Do you really want to Checking Out?\n"
                    + "We are going to let you know that, "
                    + "It will deduct your money from your accout to pay the cost.\n"
                    + "\nPress 'OK' to complete payment or 'Cancel' to cancel.");
            alert.setGraphic(new ImageView(this.getClass().getResource("image11.jpg").toString()));

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {

                pstt.execute();
                pst.execute();
                setRoomfree();
                sendmail();
                save();

                JOptionPane.showMessageDialog(null, "Dear " + txt1.getText()
                        + ",\n\nThank you for coming to our hotel.\n"
                        + "\n\nSorry if there was"
                        + " any inconvenience caused.\nLet us inforrm."
                        + "\n\nThank you,\nCheckInn.");

                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                tf1.setText("");
            }

        } catch (Exception e) {

        }

    }

    public void sendmail() //method to send OTP to user 
    {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);

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
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getText()));
            message.setSubject("Thank You Letter from CheckInn");
            message.setText("Dear " + txt1.getText() + ",\n\nOur respected guest, on behalf of our hotel Check Inn"
                    + ", would like to thank you for choosing us to stay in Check Inn"
                    + "\nWe also want to inform you that,your payment " + tf1.getText() + " has been completed at "
                    + time + ".\nStay good, stay safe and lead a happy healthy life."
                    + "\n\nThank you,\nCheck Inn.");

            message.saveChanges();

            Transport.send(message);

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null,"Please check your internet connection");  
        }

    }

    public void getMail() throws SQLException {

        Connection con = Javaconnect.ConnectDB();
        con = Javaconnect.ConnectDB();
        String sql = "Select email_id FROM logindata,user WHERE logindata.username=user.username LIMIT 1";
        PreparedStatement pst = null;

        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String sum1 = rs.getString("email_id");
            mail.setText(sum1);
        }

    }

    public void save() throws SQLException {

        Connection con = Javaconnect.ConnectDB();
        PreparedStatement ps = null;
        String qry = "INSERT INTO `checkout`(`Name`, `BookingID`, `mail`, `taka`) VALUES (?,?,?,?)";
        ps = con.prepareStatement(qry);
        ps.setString(1, txt1.getText());
        ps.setString(2, txt2.getText());
        ps.setString(3, mail.getText());
        ps.setString(4, tf1.getText());
        ps.execute();

    }

    public void setRoomfree() throws SQLException {
        //String fr = "free";
        String query = "UPDATE `adminroom` SET status=\"free\"";

        Connection conn = Javaconnect.ConnectDB();
        PreparedStatement pst = null;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        String qry = "UPDATE `adminroom` INNER JOIN booking SET `status`='booked' WHERE booking.RoomNo=adminroom.roomNo";
        pst = conn.prepareStatement(qry);
        pst.executeUpdate();

    }

}
