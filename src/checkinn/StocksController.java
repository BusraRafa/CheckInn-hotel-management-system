/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rodoshi
 */
public class StocksController implements Initializable {

    @FXML
    private JFXButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    @FXML
    private AnchorPane pane1;
    @FXML
    private Label item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13;
    @FXML
    private JFXButton save1, save2, save3, save4, save5, save6, save7, save8, save9;
    @FXML
    private JFXButton m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13;
    @FXML
    private TextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10, tx11, tx12, tx13, title;
    @FXML
    private TextField ID;
    @FXML
    private JFXButton p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13;

    Connection conn = Javaconnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        run();
    }

    @FXML
    void housekeeping(ActionEvent event) {
        scene1();

        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void kitchen(ActionEvent event) {
        scene2();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void EngnMaint(ActionEvent event) {
        scene3();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void security(ActionEvent event) {
        scene4();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    void kidsjone(ActionEvent event) {
        scene5();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void furniture(ActionEvent event) {
        scene6();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void electronics(ActionEvent event) {
        scene7();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void firstaid(ActionEvent event) {
        scene8();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void fireequipts(ActionEvent event) {
        scene9();
        try {
            String sql = "SELECT `it1`, `it2`, `it3`, `it4`, `it5`, `it6`, `it7`, `it8`, `it9`, `it10`, `it11`, `it12` FROM `stocks` WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ID.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String itm1 = rs.getString("it1");
                tx1.setText(itm1);
                String itm2 = rs.getString("it2");
                tx2.setText(itm2);
                String itm3 = rs.getString("it3");
                tx3.setText(itm3);
                String itm4 = rs.getString("it4");
                tx4.setText(itm4);
                String itm5 = rs.getString("it5");
                tx5.setText(itm5);
                String itm6 = rs.getString("it6");
                tx6.setText(itm6);
                String itm7 = rs.getString("it7");
                tx7.setText(itm7);
                String itm8 = rs.getString("it8");
                tx8.setText(itm8);
                String itm9 = rs.getString("it9");
                tx9.setText(itm9);
                String itm10 = rs.getString("it10");
                tx10.setText(itm10);
                String itm11 = rs.getString("it11");
                tx11.setText(itm11);
                String itm12 = rs.getString("it12");
                tx12.setText(itm12);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    private void update1(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "House Keeping Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update2(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kitchen Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update3(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Engineering & Maintains Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update4(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Security Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update5(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kids Jone Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update6(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Furniture Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update7(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Electronics Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update8(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medical Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    private void update9(ActionEvent event) {
        try {
            String query = "UPDATE `stocks` SET `it1`=?,`it2`=?,`it3`=?,`it4`=?,`it5`=?,`it6`=?,`it7`=?,`it8`=?,`it9`=?,`it10`=?,`it11`=?,`it12`=? WHERE `id`=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, tx1.getText());
            pst.setString(2, tx2.getText());
            pst.setString(3, tx3.getText());
            pst.setString(4, tx4.getText());
            pst.setString(5, tx5.getText());
            pst.setString(6, tx6.getText());
            pst.setString(7, tx7.getText());
            pst.setString(8, tx8.getText());
            pst.setString(9, tx9.getText());
            pst.setString(10, tx10.getText());
            pst.setString(11, tx11.getText());
            pst.setString(12, tx12.getText());
            pst.setString(13, ID.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fire Equipments Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    void back(ActionEvent event) {

        run();
    }

    public void btnhide() {
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);
        b8.setVisible(false);
        b9.setVisible(false);
        control();
    }

    public void scene1() {
        btnhide();
        ID.setText("1");
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(true);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("House Keeping");
        item1.setText("01. Bed sheets");
        item2.setText("02. Blankets");
        item3.setText("03. Towels");
        item4.setText("04. Soaps");
        item5.setText("05. Shampoos");
        item6.setText("06. Tissues");
        item7.setText("07. Air fresheners");
        item8.setText("08. Mops");
        item9.setText("09. Buckets");
        item10.setText("10. Mugs");
        item11.setText("11. Laundry soaps");
        item12.setText("12. Shovels");
        item13.setVisible(false);
    }

    public void scene2() {
        btnhide();
        ID.setText("2");
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(true);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("Kitchen");
        item1.setText("01. Fork");
        item2.setText("02. Knife");
        item3.setText("03. Spoon");
        item4.setText("04. Plate");
        item5.setText("05. Bowl");
        item6.setText("06. Cutter");
        item7.setText("07. Pots");
        item8.setText("08. Jug");
        item9.setText("09. Bottle");
        item10.setText("10. Cup");
        item11.setText("11. Saucer");
        item12.setText("12. Stove");
        item13.setVisible(false);
    }

    public void scene3() {
        btnhide();
        ID.setText("3");
        m9.setVisible(false);
        tx9.setVisible(false);
        p9.setVisible(false);
        m10.setVisible(false);
        tx10.setVisible(false);
        p10.setVisible(false);
        m11.setVisible(false);
        tx11.setVisible(false);
        p11.setVisible(false);
        m12.setVisible(false);
        tx12.setVisible(false);
        p12.setVisible(false);
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(true);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("Engeeniering\n    &    \nMaaintenance");
        item1.setText("01. Pilers");
        item2.setText("02. Screw driver");
        item3.setText("03. Tester");
        item4.setText("04. Cutter");
        item5.setText("05. Range");
        item6.setText("06. Multimeter");
        item7.setText("07. Drill machine");
        item8.setText("08. Scotch tape");
        item9.setVisible(false);
        item10.setVisible(false);
        item11.setVisible(false);
        item12.setVisible(false);
        item13.setVisible(false);
    }

    public void scene4() {
        btnhide();
        ID.setText("4");
        m6.setVisible(false);
        tx6.setVisible(false);
        p6.setVisible(false);
        m7.setVisible(false);
        tx7.setVisible(false);
        p7.setVisible(false);
        m8.setVisible(false);
        tx8.setVisible(false);
        p8.setVisible(false);
        m9.setVisible(false);
        tx9.setVisible(false);
        p9.setVisible(false);
        m10.setVisible(false);
        tx10.setVisible(false);
        p10.setVisible(false);
        m11.setVisible(false);
        tx11.setVisible(false);
        p11.setVisible(false);
        m12.setVisible(false);
        tx12.setVisible(false);
        p12.setVisible(false);
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(true);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("Security");
        item1.setText("01. Cc camera");
        item2.setText("02. Hand metal detector");
        item3.setText("04. Metal detector gate");
        item4.setText("05. Monitors");
        item5.setText("06. Walkie talkie");
        item6.setVisible(false);
        item7.setVisible(false);
        item8.setVisible(false);
        item9.setVisible(false);
        item10.setVisible(false);
        item11.setVisible(false);
        item12.setVisible(false);
        item13.setVisible(false);
    }

    public void scene5() {
        btnhide();
        ID.setText("5");
        m7.setVisible(false);
        tx7.setVisible(false);
        p7.setVisible(false);
        m8.setVisible(false);
        tx8.setVisible(false);
        p8.setVisible(false);
        m9.setVisible(false);
        tx9.setVisible(false);
        p9.setVisible(false);
        m10.setVisible(false);
        tx10.setVisible(false);
        p10.setVisible(false);
        m11.setVisible(false);
        tx11.setVisible(false);
        p11.setVisible(false);
        m12.setVisible(false);
        tx12.setVisible(false);
        p12.setVisible(false);
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(true);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("Kids Jone");
        item1.setText("01. Swing");
        item2.setText("02. Trampoline");
        item3.setText("03. Tree House");
        item4.setText("04. Toddlers");
        item5.setText("05. Seesaws");
        item6.setText("06. Sliders");
        item7.setVisible(false);
        item8.setVisible(false);
        item9.setVisible(false);
        item10.setVisible(false);
        item11.setVisible(false);
        item12.setVisible(false);
        item13.setVisible(false);
    }

    public void scene6() {
        btnhide();
        ID.setText("6");
        p13.setVisible(false);
        m13.setVisible(false);
        tx13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(true);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("Furniturs");
        item1.setText("01. Beds");
        item2.setText("02. Coffee tables");
        item3.setText("03. End tables");
        item4.setText("04. Lounge chairs");
        item5.setText("05. Outdoor seating");
        item6.setText("06. Sofa");
        item7.setText("07. Reception desk");
        item8.setText("08. Bookshelves");
        item9.setText("09. Dining tables");
        item10.setText("10. Chairs");
        item11.setText("11. Wardrobes");
        item12.setText("12. Racks");
        item13.setVisible(false);
    }

    public void scene7() {
        btnhide();
        ID.setText("7");
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(true);
        save8.setVisible(false);
        save9.setVisible(false);
        title.setText("Electronics");
        item1.setText("01. TV");
        item2.setText("02. AC");
        item3.setText("03. Fridge");
        item4.setText("04. Oven");
        item5.setText("05. Washing Machine");
        item6.setText("06. Room Heater");
        item7.setText("07. Fans");
        item8.setText("08. Lights");
        item9.setText("09. Computers");
        item10.setText("10. Mobile");
        item11.setText("11. Camera");
        item12.setText("12. Generator");
        item13.setVisible(false);
    }

    public void scene8() {
        btnhide();
        ID.setText("8");
        m10.setVisible(false);
        tx10.setVisible(false);
        p10.setVisible(false);
        m11.setVisible(false);
        tx11.setVisible(false);
        p11.setVisible(false);
        m12.setVisible(false);
        tx12.setVisible(false);
        p12.setVisible(false);
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(true);
        save9.setVisible(false);
        title.setText("Medical");
        item1.setText("01. First Aid Box");
        item2.setText("02. Hand Sanitizer");
        item3.setText("03. Bandage");
        item4.setText("04. Gauze Roll");
        item5.setText("05. Scissors");
        item6.setText("06. Pain Killer");
        item7.setText("07. Trermometer");
        item8.setText("08. Cotton");
        item9.setText("09. Providone Iodine");
        item10.setVisible(false);
        item11.setVisible(false);
        item12.setVisible(false);
        item13.setVisible(false);

    }

    public void scene9() {
        btnhide();
        ID.setText("9");
        m9.setVisible(false);
        tx9.setVisible(false);
        p9.setVisible(false);
        m10.setVisible(false);
        tx10.setVisible(false);
        p10.setVisible(false);
        m11.setVisible(false);
        tx11.setVisible(false);
        p11.setVisible(false);
        m12.setVisible(false);
        tx12.setVisible(false);
        p12.setVisible(false);
        m13.setVisible(false);
        tx13.setVisible(false);
        p13.setVisible(false);
        pane1.setVisible(true);
        save1.setVisible(false);
        save2.setVisible(false);
        save3.setVisible(false);
        save4.setVisible(false);
        save5.setVisible(false);
        save6.setVisible(false);
        save7.setVisible(false);
        save8.setVisible(false);
        save9.setVisible(true);
        title.setText("Fire Equipments");
        item1.setText("01. Fire Doors");
        item2.setText("02. Extinguisher");
        item3.setText("03. Axe");
        item4.setText("04. Sprinkler");
        item5.setText("05. Hose");
        item6.setText("06. Fire blancket");
        item7.setText("07. Hydrant");
        item8.setText("08. Flamezorb");
        item9.setVisible(false);
        item10.setVisible(false);
        item11.setVisible(false);
        item12.setVisible(false);
        item13.setVisible(false);

    }

    public void run() {
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);
        b6.setVisible(true);
        b7.setVisible(true);
        b8.setVisible(true);
        b9.setVisible(true);
        pane1.setVisible(false);
    }

    public void control() {
        item1.setVisible(true);
        item2.setVisible(true);
        item3.setVisible(true);
        item4.setVisible(true);
        item5.setVisible(true);
        item6.setVisible(true);
        item7.setVisible(true);
        item8.setVisible(true);
        item9.setVisible(true);
        item10.setVisible(true);
        item11.setVisible(true);
        item12.setVisible(true);
        item13.setVisible(true);
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        p5.setVisible(true);
        p6.setVisible(true);
        p7.setVisible(true);
        p8.setVisible(true);
        p9.setVisible(true);
        p10.setVisible(true);
        p11.setVisible(true);
        p12.setVisible(true);
        p13.setVisible(true);
        tx1.setVisible(true);
        tx2.setVisible(true);
        tx3.setVisible(true);
        tx4.setVisible(true);
        tx5.setVisible(true);
        tx6.setVisible(true);
        tx7.setVisible(true);
        tx8.setVisible(true);
        tx9.setVisible(true);
        tx10.setVisible(true);
        tx11.setVisible(true);
        tx12.setVisible(true);
        tx13.setVisible(true);
        m1.setVisible(true);
        m2.setVisible(true);
        m3.setVisible(true);
        m4.setVisible(true);
        m5.setVisible(true);
        m6.setVisible(true);
        m7.setVisible(true);
        m8.setVisible(true);
        m9.setVisible(true);
        m10.setVisible(true);
        m11.setVisible(true);
        m12.setVisible(true);
        m13.setVisible(true);
    }

    @FXML
    private void decrement1(ActionEvent event) {
        String s = tx1.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx1.setText(String.valueOf(n));
        }

    }

    @FXML
    private void increment1(ActionEvent event) {
        String s = tx1.getText();
        int n = Integer.parseInt(s) + 1;
        tx1.setText(String.valueOf(n));
    }

    @FXML
    private void decrement2(ActionEvent event) {
        String s = tx2.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx2.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment2(ActionEvent event) {
        String s = tx2.getText();
        int n = Integer.parseInt(s) + 1;
        tx2.setText(String.valueOf(n));
    }

    @FXML
    private void decrement3(ActionEvent event) {
        String s = tx3.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx3.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment3(ActionEvent event) {
        String s = tx3.getText();
        int n = Integer.parseInt(s) + 1;
        tx3.setText(String.valueOf(n));
    }

    @FXML
    private void decrement4(ActionEvent event) {
        String s = tx4.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx4.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment4(ActionEvent event) {
        String s = tx4.getText();
        int n = Integer.parseInt(s) + 1;
        tx4.setText(String.valueOf(n));

    }

    @FXML
    private void decrement5(ActionEvent event) {
        String s = tx5.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx5.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment5(ActionEvent event) {
        String s = tx5.getText();
        int n = Integer.parseInt(s) + 1;
        tx5.setText(String.valueOf(n));
    }

    @FXML
    private void decrement6(ActionEvent event) {
        String s = tx6.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx6.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment6(ActionEvent event) {
        String s = tx6.getText();
        int n = Integer.parseInt(s) + 1;
        tx6.setText(String.valueOf(n));
    }

    @FXML
    private void decrement7(ActionEvent event) {
        String s = tx7.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx7.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment7(ActionEvent event) {
        String s = tx7.getText();
        int n = Integer.parseInt(s) + 1;
        tx7.setText(String.valueOf(n));
    }

    @FXML
    private void decrement8(ActionEvent event) {
        String s = tx8.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx8.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment8(ActionEvent event) {
        String s = tx8.getText();
        int n = Integer.parseInt(s) + 1;
        tx8.setText(String.valueOf(n));
    }

    @FXML
    private void decrement9(ActionEvent event) {
        String s = tx9.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx9.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment9(ActionEvent event) {
        String s = tx9.getText();
        int n = Integer.parseInt(s) + 1;
        tx9.setText(String.valueOf(n));
    }

    @FXML
    private void decrement10(ActionEvent event) {
        String s = tx10.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx10.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment10(ActionEvent event) {
        String s = tx10.getText();
        int n = Integer.parseInt(s) + 1;
        tx10.setText(String.valueOf(n));
    }

    @FXML
    private void decrement11(ActionEvent event) {
        String s = tx11.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx11.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment11(ActionEvent event) {
        String s = tx11.getText();
        int n = Integer.parseInt(s) + 1;
        tx11.setText(String.valueOf(n));
    }

    @FXML
    private void decrement12(ActionEvent event) {
        String s = tx12.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx12.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment12(ActionEvent event) {
        String s = tx12.getText();
        int n = Integer.parseInt(s) + 1;
        tx12.setText(String.valueOf(n));
    }

    @FXML
    private void decrement13(ActionEvent event) {
        String s = tx13.getText();
        int n = Integer.parseInt(s);
        if (n > 0) {
            n = n - 1;
            tx13.setText(String.valueOf(n));
        }
    }

    @FXML
    private void increment13(ActionEvent event) {

        String s = tx13.getText();
        int n = Integer.parseInt(s) + 1;
        tx13.setText(String.valueOf(n));
    }
}
