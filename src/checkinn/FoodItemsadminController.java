/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rafa5
 */
public class FoodItemsadminController implements Initializable {

    @FXML
    private ImageView pic;
    @FXML
    private JFXButton btn1;
    @FXML
    private JFXButton btn2;
    @FXML
    private JFXButton btn3;
    @FXML
    private JFXButton btn4;
    @FXML
    private JFXButton btn5;
    @FXML
    private JFXButton btn6;
    @FXML
    private JFXButton btn7;
    @FXML
    private JFXButton btn8;
    @FXML
    private Label lbl1;
    @FXML
    private TextField txt1;
    @FXML
    private Label lbl2;
    @FXML
    private TextField txt2;
    @FXML
    private Label lbl3;
    @FXML
    private TextField txt3;
    @FXML
    private Label lbl4;
    @FXML
    private TextField txt4;
    @FXML
    private Label lbl5;
    @FXML
    private TextField txt5;
    @FXML
    private Label lbl6;
    @FXML
    private TextField txt6;
    @FXML
    private Label lbl7;
    @FXML
    private TextField txt7;
    @FXML
    private Label lbl8;
    @FXML
    private TextField txt8;
    @FXML
    private Label lbl9;
    @FXML
    private TextField txt9;
    @FXML
    private JFXButton backbtn;
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXButton savebtn1;
    @FXML
    private JFXButton savebtn2;
    @FXML
    private JFXButton savebtn3;
    @FXML
    private JFXButton savebtn4;
    @FXML
    private JFXButton savebtn5;
    @FXML
    private JFXButton savebtn6;
    @FXML
    private JFXButton savebtn7;
    @FXML
    private JFXButton savebtn8;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private Label lb5;
    @FXML
    private Label lb6;
    @FXML
    private Label lb7;
    @FXML
    private Label lb8;
    @FXML
    private Label lb9;

    /**
     * Initializes the controller class.
     */
    Connection conn = Javaconnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void foodc1(ActionEvent event) throws SQLException {
        sceen1();
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
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }
        pst = conn.prepareStatement(sql7);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm7 = rs.getString("foodprice");
            txt7.setText(itm7);
        }
        pst = conn.prepareStatement(sql8);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm8 = rs.getString("foodprice");
            txt8.setText(itm8);
        }
        pst = conn.prepareStatement(sql9);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm9 = rs.getString("foodprice");
            txt9.setText(itm9);
        }
    }

    @FXML
    private void foodb1(ActionEvent event) throws SQLException {
        sceen5();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='37'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='38'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='39'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='40'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='41'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='42'";
        String sql7 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='43'";
        String sql8 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='44'";
        String sql9 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='45'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }
        pst = conn.prepareStatement(sql7);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm7 = rs.getString("foodprice");
            txt7.setText(itm7);
        }
        pst = conn.prepareStatement(sql8);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm8 = rs.getString("foodprice");
            txt8.setText(itm8);
        }
        pst = conn.prepareStatement(sql9);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm9 = rs.getString("foodprice");
            txt9.setText(itm9);
        }
    }

    @FXML
    private void foodi1(ActionEvent event) throws SQLException {
        sceen3();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='19'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='20'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='21'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='22'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='23'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='24'";
        String sql7 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='25'";
        String sql8 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='26'";
        String sql9 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='27'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }
        pst = conn.prepareStatement(sql7);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm7 = rs.getString("foodprice");
            txt7.setText(itm7);
        }
        pst = conn.prepareStatement(sql8);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm8 = rs.getString("foodprice");
            txt8.setText(itm8);
        }
        pst = conn.prepareStatement(sql9);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm9 = rs.getString("foodprice");
            txt9.setText(itm9);
        }
    }

    @FXML
    private void foodc2(ActionEvent event) throws SQLException {
        sceen2();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='10'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='11'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='12'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='13'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='14'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='15'";
        String sql7 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='16'";
        String sql8 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='17'";
        String sql9 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='18'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }
        pst = conn.prepareStatement(sql7);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm7 = rs.getString("foodprice");
            txt7.setText(itm7);
        }
        pst = conn.prepareStatement(sql8);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm8 = rs.getString("foodprice");
            txt8.setText(itm8);
        }
        pst = conn.prepareStatement(sql9);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm9 = rs.getString("foodprice");
            txt9.setText(itm9);
        }
    }

    @FXML
    private void foodt1(ActionEvent event) throws SQLException {
        sceen4();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='28'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='29'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='30'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='31'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='32'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='33'";
        String sql7 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='34'";
        String sql8 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='35'";
        String sql9 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='36'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }
        pst = conn.prepareStatement(sql7);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm7 = rs.getString("foodprice");
            txt7.setText(itm7);
        }
        pst = conn.prepareStatement(sql8);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm8 = rs.getString("foodprice");
            txt8.setText(itm8);
        }
        pst = conn.prepareStatement(sql9);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm9 = rs.getString("foodprice");
            txt9.setText(itm9);
        }
    }

    @FXML
    private void foodi2(ActionEvent event) throws SQLException {
        sceen7();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='46'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='47'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='48'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='49'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='50'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='51'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }

    }

    @FXML
    private void foodd1(ActionEvent event) throws SQLException {
        sceen6();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='52'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='53'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='54'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='55'";
        String sql5 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='56'";
        String sql6 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='57'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }
        pst = conn.prepareStatement(sql5);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm5 = rs.getString("foodprice");
            txt5.setText(itm5);
        }
        pst = conn.prepareStatement(sql6);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm6 = rs.getString("foodprice");
            txt6.setText(itm6);
        }

    }

    @FXML
    private void foodi3(ActionEvent event) throws SQLException {
        sceen8();
        String sql1 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='58'";
        String sql2 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='59'";
        String sql3 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='60'";
        String sql4 = "SELECT `foodprice` FROM `foodadmin` WHERE Id='61'";
        pst = conn.prepareStatement(sql1);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm1 = rs.getString("foodprice");
            txt1.setText(itm1);
        }
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm2 = rs.getString("foodprice");
            txt2.setText(itm2);
        }
        pst = conn.prepareStatement(sql3);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm3 = rs.getString("foodprice");
            txt3.setText(itm3);
        }
        pst = conn.prepareStatement(sql4);
        rs = pst.executeQuery();
        if (rs.next()) {
            String itm4 = rs.getString("foodprice");
            txt4.setText(itm4);
        }

    }

    public void sceen1() {
        hide();
        savebtn1.setVisible(true);
        lbl1.setText("Engliish breakfast :");
        lbl2.setText("Egg Cups           :");
        lbl3.setText("American breakfast :");
        lbl4.setText("Chicken Salad      :");
        lbl5.setText("Potato Pie         :");
        lbl6.setText("Stuffed Potato     :");
        lbl7.setText("Battar Fish        :");
        lbl8.setText("Roast Lamb         :");
        lbl9.setText("Pastries           :");

    }

    public void sceen2() {
        hide();
        savebtn2.setVisible(true);
        lbl1.setText("Dumpling           :");
        lbl2.setText("Hot & Sour Soup    :");
        lbl3.setText("Roasted Duck       :");
        lbl4.setText("Bubble Tea         :");
        lbl5.setText("Sichuan Shredded   :\nchicken");
        lbl6.setText("Whole steamed fish :");
        lbl7.setText("Shrimp Fried Rice  :");
        lbl8.setText("Spring Rolls       :");
        lbl9.setText("Orange Chicken     :");
    }

    public void sceen3() {
        hide();
        savebtn3.setVisible(true);
        lbl1.setText("Dum Aloo Lakhnawi     :");
        lbl2.setText("Dum Paneer Kali Mirch :");
        lbl3.setText("Malabari Prawn Curry  :");
        lbl4.setText("Samosa                :");
        lbl5.setText("Chicken Briyani       :");
        lbl6.setText("Aloo gobi             :");
        lbl7.setText("Butter Chicken        :");
        lbl8.setText("Spicy chickpea curry  :");
        lbl9.setText("Spicy onio bhajis     :");
    }

    public void sceen4() {
        hide();
        savebtn4.setVisible(true);
        lbl1.setText("Chicken pad thai noodles :");
        lbl2.setText("Tom Yum Goong            :");
        lbl3.setText("Green Chicken Curry      :");
        lbl4.setText("Green Cream Soup with    :\nshrimp");
        lbl5.setText("Fish Stew                :");
        lbl6.setText("Thai Shrimps RedCurry    :");
        lbl7.setText("Rice in pineapple with   :\nseafood");
        lbl8.setText("Chicken Satay            :");
        lbl9.setText("Chicken Wok Noodles      :");
    }

    public void sceen5() {
        hide();
        savebtn5.setVisible(true);
        lbl1.setText("Shorshe Ilish          :");
        lbl2.setText("Dal Khichadi           :");
        lbl3.setText("Rice with vorta        :");
        lbl4.setText("Oil fried Pomfret Fish :");
        lbl5.setText("Shutki Vorta           :");
        lbl6.setText("Oil fried Eggplant     :");
        lbl7.setText("Plain Riice            :");
        lbl8.setText("Beef rezala            :");
        lbl9.setText("Chicken roast          :");
    }

    public void sceen6() {
        hide();
        savebtn6.setVisible(true);
        lbl1.setText("Belgian waffles with     :\nicecream");
        lbl2.setText("Raspberry dessert        :");
        lbl3.setText("Caramel coffee cake      :");
        lbl4.setText("Red valvet cake          :");
        lbl5.setText("Oreo cheese cake         :");
        lbl6.setText("Panna cotta with berries :");
        lbl7.setVisible(false);
        lbl8.setVisible(false);
        lbl9.setVisible(false);
        lb7.setVisible(false);
        lb8.setVisible(false);
        lb9.setVisible(false);
        txt7.setVisible(false);
        txt8.setVisible(false);
        txt9.setVisible(false);
    }

    public void sceen7() {
        hide();
        savebtn7.setVisible(true);
        lbl1.setText("Pizza               :");
        lbl2.setText("Pasta               :");
        lbl3.setText("Sphagetti           :");
        lbl4.setText("Tacos               :");
        lbl5.setText("Lasanga             :");
        lbl6.setText("Salmon with Spinach :");
        lbl7.setVisible(false);
        lbl8.setVisible(false);
        lbl9.setVisible(false);
        lb7.setVisible(false);
        lb8.setVisible(false);
        lb9.setVisible(false);
        txt7.setVisible(false);
        txt8.setVisible(false);
        txt9.setVisible(false);
    }

    public void sceen8() {
        hide();
        savebtn8.setVisible(true);
        lbl1.setText("BlueBerry Ice Cream       :");
        lbl2.setText("Fruit Ice Cream           :");
        lbl3.setText("Mint,Vanilla cocoa        :\nicecream.");
        lbl4.setText("Banana split with vanilla :\n& strawberry icecream");
        lbl5.setVisible(false);
        lbl6.setVisible(false);
        lbl7.setVisible(false);
        lbl8.setVisible(false);
        lbl9.setVisible(false);
        lb5.setVisible(false);
        lb6.setVisible(false);
        lb7.setVisible(false);
        lb8.setVisible(false);
        lb9.setVisible(false);
        txt5.setVisible(false);
        txt6.setVisible(false);
        txt7.setVisible(false);
        txt8.setVisible(false);
        txt9.setVisible(false);
    }

    @FXML
    public void show() {
        pic.setVisible(true);
        pane.setVisible(false);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        btn5.setVisible(true);
        btn6.setVisible(true);
        btn7.setVisible(true);
        btn8.setVisible(true);
        backbtn.setVisible(false);
        savebtn1.setVisible(false);
        savebtn2.setVisible(false);
        savebtn3.setVisible(false);
        savebtn4.setVisible(false);
        savebtn5.setVisible(false);
        savebtn6.setVisible(false);
        savebtn7.setVisible(false);
        savebtn8.setVisible(false);
        lbl1.setVisible(false);
        lbl2.setVisible(false);
        lbl3.setVisible(false);
        lbl4.setVisible(false);
        lbl5.setVisible(false);
        lbl6.setVisible(false);
        lbl7.setVisible(false);
        lbl8.setVisible(false);
        lbl9.setVisible(false);
        lb1.setVisible(false);
        lb2.setVisible(false);
        lb3.setVisible(false);
        lb4.setVisible(false);
        lb5.setVisible(false);
        lb6.setVisible(false);
        lb7.setVisible(false);
        lb8.setVisible(false);
        lb9.setVisible(false);
        txt1.setVisible(false);
        txt2.setVisible(false);
        txt3.setVisible(false);
        txt4.setVisible(false);
        txt5.setVisible(false);
        txt6.setVisible(false);
        txt7.setVisible(false);
        txt8.setVisible(false);
        txt9.setVisible(false);

    }

    public void hide() {
        pic.setVisible(false);
        pane.setVisible(true);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        backbtn.setVisible(true);
        savebtn1.setVisible(false);
        savebtn2.setVisible(false);
        savebtn3.setVisible(false);
        savebtn4.setVisible(false);
        savebtn5.setVisible(false);
        savebtn6.setVisible(false);
        savebtn7.setVisible(false);
        savebtn8.setVisible(false);
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        lbl3.setVisible(true);
        lbl4.setVisible(true);
        lbl5.setVisible(true);
        lbl6.setVisible(true);
        lbl7.setVisible(true);
        lbl8.setVisible(true);
        lbl9.setVisible(true);
        lb1.setVisible(true);
        lb2.setVisible(true);
        lb3.setVisible(true);
        lb4.setVisible(true);
        lb5.setVisible(true);
        lb6.setVisible(true);
        lb7.setVisible(true);
        lb8.setVisible(true);
        lb9.setVisible(true);
        txt1.setVisible(true);
        txt2.setVisible(true);
        txt3.setVisible(true);
        txt4.setVisible(true);
        txt5.setVisible(true);
        txt6.setVisible(true);
        txt7.setVisible(true);
        txt8.setVisible(true);
        txt9.setVisible(true);

    }

    @FXML
    private void update1(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='1'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='2'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='3'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='4'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='5'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='6'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();
            String query7 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='7'";
            pst = conn.prepareStatement(query7);
            pst.setString(1, txt7.getText());
            pst.executeUpdate();
            String query8 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='8'";
            pst = conn.prepareStatement(query8);
            pst.setString(1, txt8.getText());
            pst.executeUpdate();
            String query9 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='9'";
            pst = conn.prepareStatement(query9);
            pst.setString(1, txt9.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update2(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='10'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='11'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='12'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='13'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='14'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='15'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();
            String query7 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='16'";
            pst = conn.prepareStatement(query7);
            pst.setString(1, txt7.getText());
            pst.executeUpdate();
            String query8 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='17'";
            pst = conn.prepareStatement(query8);
            pst.setString(1, txt8.getText());
            pst.executeUpdate();
            String query9 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='18'";
            pst = conn.prepareStatement(query9);
            pst.setString(1, txt9.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update3(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='19'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='20'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='21'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='22'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='23'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='24'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();
            String query7 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='25'";
            pst = conn.prepareStatement(query7);
            pst.setString(1, txt7.getText());
            pst.executeUpdate();
            String query8 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='26'";
            pst = conn.prepareStatement(query8);
            pst.setString(1, txt8.getText());
            pst.executeUpdate();
            String query9 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='27'";
            pst = conn.prepareStatement(query9);
            pst.setString(1, txt9.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update4(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='28'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='29'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='30'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='31'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='32'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='33'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();
            String query7 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='34'";
            pst = conn.prepareStatement(query7);
            pst.setString(1, txt7.getText());
            pst.executeUpdate();
            String query8 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='35'";
            pst = conn.prepareStatement(query8);
            pst.setString(1, txt8.getText());
            pst.executeUpdate();
            String query9 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='36'";
            pst = conn.prepareStatement(query9);
            pst.setString(1, txt9.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update5(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='37'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='38'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='39'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='40'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='41'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='42'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();
            String query7 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='43'";
            pst = conn.prepareStatement(query7);
            pst.setString(1, txt7.getText());
            pst.executeUpdate();
            String query8 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='44'";
            pst = conn.prepareStatement(query8);
            pst.setString(1, txt8.getText());
            pst.executeUpdate();
            String query9 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='45'";
            pst = conn.prepareStatement(query9);
            pst.setString(1, txt9.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update6(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='52'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='53'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='54'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='55'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='56'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='57'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update7(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='46'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='47'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='48'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='49'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();
            String query5 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='50'";
            pst = conn.prepareStatement(query5);
            pst.setString(1, txt5.getText());
            pst.executeUpdate();
            String query6 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='51'";
            pst = conn.prepareStatement(query6);
            pst.setString(1, txt6.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update8(ActionEvent event) {
        try {
            String query1 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='58'";
            pst = conn.prepareStatement(query1);
            pst.setString(1, txt1.getText());
            pst.executeUpdate();
            String query2 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='59'";
            pst = conn.prepareStatement(query2);
            pst.setString(1, txt2.getText());
            pst.executeUpdate();
            String query3 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='60'";
            pst = conn.prepareStatement(query3);
            pst.setString(1, txt3.getText());
            pst.executeUpdate();
            String query4 = "UPDATE `foodadmin` SET `foodprice`=? WHERE Id='61'";
            pst = conn.prepareStatement(query4);
            pst.setString(1, txt4.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Update Successful!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
