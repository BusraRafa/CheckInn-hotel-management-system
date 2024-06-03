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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.mail.internet.ParseException;
import javax.swing.JOptionPane;

public class AddBookingController implements Initializable {

    @FXML
    private TextField guestname, d1, d2, m1, m2, y1, y2;
    @FXML
    private TextField value;
    @FXML
    private TextField bookno;
    @FXML
    private TextField roomno;
    @FXML
    private DatePicker inDate;
    @FXML
    private DatePicker outDate;
    @FXML
    private TextField contact;
    @FXML
    private TextField type;
    @FXML
    private TextField total;
    @FXML
    private Label roomprice;
    @FXML
    private Label yes;
    @FXML
    private Label no, lt1, lt2, lblin;
    @FXML
    private ImageView pic;
    @FXML
    private Button confirmbtn;

    public BorderPane mainpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        on();
        random();
        Connection conn = Javaconnect.ConnectDB();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT `username` FROM `user`";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            if (rs.next()) {
                String name = rs.getString("username");
                String sq = "SELECT `username`, `phoneno` FROM `logindata` WHERE username=?  ";
                pst = conn.prepareStatement(sq);
                pst.setString(1, name);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String itm1 = rs.getString("username");
                    guestname.setText(itm1);
                    String itm2 = rs.getString("phoneno");
                    contact.setText(itm2);
                }
            }
        } catch (Exception e) {

        }
    }

    public void showInformation(String ty, String price1, String rNO) {
        type.setText(ty);
        roomprice.setText(price1);
        roomno.setText(rNO);
    }

    @FXML
    private void registerbtn(ActionEvent event) throws SQLException {
        booked();
        setBookstatus();
        clean();
        Stage stage = (Stage) confirmbtn.getScene().getWindow();
        stage.close();
    }

    public void booked() {
        PreparedStatement pst = null;
        PreparedStatement ps = null;
        PreparedStatement psl = null;
        PreparedStatement pc = null;
        PreparedStatement pf = null;
        ResultSet rs = null;
        ResultSet rn = null;

        try {
            String query = "INSERT INTO `booking`(`Booking_No`, `Guest_Name`, `RoomNo`, `CheckInDate`, `CheckOutDate`, `ContactNo`,`Rooms_type`, `Rooms_price`,`Total_Days`) VALUES (?,?,?,?,?,?,?,?,?)";
            String qry = "SELECT * FROM `logindata` WHERE bookingID is null AND username=?  ";
            String q = "UPDATE `logindata` SET `checkin`=?,`checkout`=?,`Cost`=?,`roomno`=?,`bookingID`=? WHERE username=? ";
            String ql = "UPDATE `logindata` SET `checkin`=?,`checkout`=?,`Cost`=?,`roomno`=?,`bookingID`=? WHERE username=?  AND `bookingID` is null";

            Connection con = Javaconnect.ConnectDB();
            pst = con.prepareStatement(query);
            psl = con.prepareStatement(qry);
            ps = con.prepareStatement(q);
            pf = con.prepareStatement(ql);

            String book = bookno.getText();
            String guestn = guestname.getText();
            String room = roomno.getText();
            LocalDate in = inDate.getValue();
            String In = in.toString();
            LocalDate out = outDate.getValue();
            String Out = out.toString();
            String conn = contact.getText();
            String type1 = type.getText();
            String roomp = roomprice.getText();
            calDay();
            String t = total.getText();

            if (book.equals("") || guestn.equals("") || room.equals("") || In.equals(null) || Out.equals(null) || conn.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fillup all the information");
            } else {
                pst.setString(1, book);
                pst.setString(2, guestn);
                pst.setString(3, room);
                pst.setString(4, In);
                pst.setString(5, Out);
                pst.setString(6, conn);
                pst.setString(7, type1);
                pst.setString(8, roomp);
                pst.setString(9, t);

                pst.executeUpdate();

                psl.setString(1, guestn);
                rs = psl.executeQuery();
                if (rs.next()) {

                    ps.setString(1, In);
                    ps.setString(2, Out);
                    ps.setString(3, roomp);
                    ps.setString(4, room);
                    ps.setString(5, book);
                    ps.setString(6, guestn);

                    ps.executeUpdate();
                } else {
                    String qn = "INSERT INTO `logindata`(`username`, `email_id`, `password`, `address`, `gender`, `phoneno`, `sign_in_date`) SELECT `username`, `email_id`, `password`, `address`, `gender`, `phoneno`, `sign_in_date` FROM `logindata` WHERE username=? LIMIT 1";
                    pc = con.prepareStatement(qn);
                    pc.setString(1, guestn);
                    pc.executeUpdate();
                    psl.setString(1, guestn);
                    rs = psl.executeQuery();
                    if (rs.next()) {

                        pf.setString(1, In);
                        pf.setString(2, Out);
                        pf.setString(3, roomp);
                        pf.setString(4, room);
                        pf.setString(5, book);
                        pf.setString(6, guestn);

                        pf.executeUpdate();
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Record Added Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void clearbtn(ActionEvent event) {
        clean();

    }

    public void clean() {
        guestname.clear();
        bookno.clear();
        roomno.clear();
        contact.clear();
        inDate.setValue(null);
        outDate.setValue(null);
        total.clear();
        roomprice.setText("");
        type.clear();;
    }

    public void random() {
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 10;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        bookno.setText(randomString);

    }

    public void calDay() {

        //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDate in = inDate.getValue();
        String inputString1 = in.toString();
        LocalDate out = outDate.getValue();
        String inputString2 = out.toString();

        LocalDate date1 = LocalDate.parse(inputString1);
        LocalDate date2 = LocalDate.parse(inputString2);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        total.setText(String.valueOf(daysBetween));
    }

    @FXML
    void loading(ActionEvent event) {
        on();
        pic.setVisible(true);
        lt1.setVisible(true);
        lt2.setVisible(true);
    }

    public void RMavble() throws SQLException {
        on();
        lblin.setVisible(false);
        pic.setVisible(false);
        lt1.setVisible(false);
        lt2.setVisible(false);
        DateTimeFormatter dtfll = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtfll.format(now);
        String[] valuest = today.split("-");
        int yrt = Integer.parseInt(valuest[0]);
        int mntht = Integer.parseInt(valuest[1]);
        int dayt = Integer.parseInt(valuest[2]);

        String date = inDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String[] values = date.split("-");
        int yr2 = Integer.parseInt(values[0]);
        int mnth2 = Integer.parseInt(values[1]);
        int day2 = Integer.parseInt(values[2]);
        d2.setText(String.valueOf(day2));
        m2.setText(String.valueOf(mnth2));
        y2.setText(String.valueOf(yr2));
        String date2 = outDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String[] values12 = date2.split("-");
        int yr3 = Integer.parseInt(values12[0]);
        int mnth3 = Integer.parseInt(values12[1]);
        int day3 = Integer.parseInt(values12[2]);

        if (yr3 < yr2 || yr2 < yrt) {
            lblin.setVisible(true);
        } else if (yr2 == yr3 && mnth3 < mnth2 || yrt == yr2 && mnth2 < mntht) {
            lblin.setVisible(true);
        } else if (yr2 == yr3 && mnth3 == mnth2 && day3 <= day2 || yrt == yr2 && mntht == mnth2 && day2 < dayt) {
            lblin.setVisible(true);
        } else {
            PreparedStatement pst = null;
            ResultSet rs;
            String q = "SELECT COUNT(*) FROM `booking` WHERE RoomNo=?";
            Connection con = Javaconnect.ConnectDB();
            pst = con.prepareStatement(q);
            pst.setString(1, roomno.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String ttday = rs.getString("COUNT(*)");
                value.setText(ttday);
                int n = Integer.parseInt(value.getText());
                if (n == 0) {
                    yes.setVisible(true);
                    no.setVisible(false);
                    confirmbtn.setDisable(false);
                    calDay();
                } else {
                    String ql = "SELECT MAX(CheckOutDate) FROM `booking` WHERE  RoomNo=?";

                    pst = con.prepareStatement(ql);
                    pst.setString(1, roomno.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String tday = rs.getString("MAX(CheckOutDate)");
                        value.setText(tday);
                        String[] values1 = tday.split("-");
                        int yr1 = Integer.parseInt(values1[0]);
                        int mnth1 = Integer.parseInt(values1[1]);
                        int day1 = Integer.parseInt(values1[2]);
                        d1.setText(String.valueOf(day1));
                        m1.setText(String.valueOf(mnth1));
                        y1.setText(String.valueOf(yr1));

                        if (yr1 < yr2) {
                            yess();
                        } else if (yr1 == yr2) {
                            if (mnth1 < mnth2) {
                                yess();
                            } else if (mnth1 == mnth2) {
                                if (day1 <= day2) {
                                    yess();
                                } else {
                                    nos();
                                }
                            } else {
                                nos();
                            }
                        } else {
                            nos();
                        }
                    }
                }
            }
        }

    }

    public void on() {
        yes.setVisible(false);
        no.setVisible(false);
        confirmbtn.setDisable(true);
        pic.setVisible(false);
        lt1.setVisible(false);
        lt2.setVisible(false);
        lblin.setVisible(false);
        total.clear();
    }

    public void yess() {
        yes.setVisible(true);
        no.setVisible(false);
        confirmbtn.setDisable(false);
        calDay();

    }

    public void nos() {
        yes.setVisible(false);
        no.setVisible(true);
        confirmbtn.setDisable(true);

    }

    public void setBookstatus() throws SQLException {
        //String fr = "free";
        String query = "UPDATE `adminroom` SET `status`=\"free\"";

        Connection conn = Javaconnect.ConnectDB();
        PreparedStatement pst = null;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        String qry = "UPDATE `adminroom` INNER JOIN booking SET `status`='booked' WHERE booking.RoomNo=adminroom.roomNo";
        pst = conn.prepareStatement(qry);
        pst.executeUpdate();
    }

}
