/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class EmployeeListController implements Initializable {

    @FXML
    private TableView<EmployeeTab1> table1;
    @FXML
    private TableColumn<EmployeeTab1, String> col_name;
    @FXML
    private TableColumn<EmployeeTab1, String> col_id;
    @FXML
    private TableColumn<EmployeeTab1, String> col_gen;

    @FXML
    private TableColumn<EmployeeTab1, String> col_day;
    @FXML
    private TableColumn<EmployeeTab1, String> col_month;
    @FXML
    private TableColumn<EmployeeTab1, String> col_yr;
    @FXML
    private TableColumn<EmployeeTab1, String> col_mail;
    @FXML
    private TableColumn<EmployeeTab1, String> col_hire;

    @FXML
    private TableColumn<EmployeeTab1, String> col_dept;
    @FXML
    private TableColumn<EmployeeTab1, String> col_add;

    @FXML
    private TableColumn<EmployeeTab1, String> col_contact;
    @FXML
    private TableColumn<EmployeeTab1, String> col_salary;

    @FXML
    private TableView<EmployeeTab2> table2;
    @FXML
    private TableColumn<EmployeeTab2, String> adminName;
    @FXML
    private TableColumn<EmployeeTab2, String> adminPass;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button upbtn;
    @FXML
    private Button delbtn;

    @FXML
    private Button addbtn2;
    @FXML
    private Button upbtn2;

    @FXML
    private AnchorPane pane;
    @FXML
    private AnchorPane pane2;

    @FXML
    private JFXTextField tx;

    @FXML
    private JFXPasswordField ps;
    @FXML
    private TextField salary;
    @FXML
    private TextField id;
    @FXML
    private TextField fname;
    @FXML
    private TextField date;
    @FXML
    private TextField month;

    @FXML
    private TextField year;
    @FXML
    private TextField age;
    @FXML
    private TextField email;
    @FXML
    private TextField address;

    @FXML
    private TextField jobtitle;
    @FXML
    private TextField contact;

    @FXML
    private ComboBox<String> comb;

    int index = -1;
    Connection con = Javaconnect.ConnectDB();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comb.getItems().add("Male");
        comb.getItems().add("Female");
        comb.getItems().add("Other");

        employees();
    }

    @FXML
    void ageCal(ActionEvent event) {
        int day = Integer.parseInt(date.getText());
        int mn = Integer.parseInt(month.getText());
        int yr = Integer.parseInt(year.getText());

        LocalDate bd = LocalDate.of(yr, mn, day);
        LocalDate nowDate = LocalDate.now();
        int period = Period.between(bd, nowDate).getYears();
        age.setText(String.valueOf(period));

    }

    @FXML
    void addEmploy(ActionEvent event) throws IOException {

        table2.setVisible(false);
        table1.setVisible(false);
        pane.setVisible(false);
        pane2.setVisible(true);
        upbtn.setDisable(true);
        delbtn.setDisable(true);
        upbtn2.setDisable(true);
        addbtn2.setDisable(false);
        id.setEditable(true);
        clear();

    }

    @FXML
    private void Addrecordbtn(ActionEvent event) {
        String gen = comb.getSelectionModel().getSelectedItem().toString();

        try {
            String query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, id.getText());
            pst.setString(2, fname.getText());
            pst.setString(3, gen);
            pst.setString(4, date.getText());
            pst.setString(5, month.getText());
            pst.setString(6, year.getText());
            pst.setString(7, email.getText());
            pst.setString(8, null);
            pst.setString(9, address.getText());
            pst.setString(10, jobtitle.getText());
            pst.setString(11, contact.getText());
            pst.setString(12, salary.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Added Successfully!");
            clear();
            table2.setVisible(false);
            pane.setVisible(false);
            pane2.setVisible(false);
            table1.setVisible(true);
            b2.setVisible(false);
            b1.setVisible(true);
            upbtn.setDisable(false);
            delbtn.setDisable(false);
            employees();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    @FXML
    void updateEmploy(ActionEvent event) {

        table2.setVisible(false);
        table1.setVisible(false);
        pane.setVisible(false);
        pane2.setVisible(true);
        upbtn2.setDisable(false);
        addbtn2.setDisable(true);
        id.setEditable(false);

        updateS();
    }

    public void updateS() {
        index = table1.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        id.setText(col_id.getCellData(index));
        fname.setText(col_name.getCellData(index));
        date.setText(col_day.getCellData(index));
        month.setText(col_month.getCellData(index));
        year.setText(col_yr.getCellData(index));
        email.setText(col_mail.getCellData(index));
        address.setText(col_add.getCellData(index));
        jobtitle.setText(col_dept.getCellData(index));
        contact.setText(col_contact.getCellData(index));
        salary.setText(col_salary.getCellData(index));
    }

    @FXML
    void Updatebtn(ActionEvent event) {

        String gen = comb.getSelectionModel().getSelectedItem().toString();
        PreparedStatement pst = null;
        try {
            String query = "UPDATE `employee` SET `Name`=?,`Gender`=?,`b date`=?,`b month`=?,`b year`=?,`Email`=?,`date hired`=?,`Address`=?,`Job Title`=?,`Contact No`=?,`Salary`=? WHERE `id`=?";

            pst = con.prepareStatement(query);
            pst.setString(1, fname.getText());
            pst.setString(2, gen);
            pst.setString(3, date.getText());
            pst.setString(4, month.getText());
            pst.setString(5, year.getText());
            pst.setString(6, email.getText());
            pst.setString(7, null);
            pst.setString(8, address.getText());
            pst.setString(9, jobtitle.getText());
            pst.setString(10, contact.getText());
            pst.setString(11, salary.getText());
            pst.setString(12, id.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Updated Successfully!");
            clear();
            table2.setVisible(false);
            pane.setVisible(false);
            pane2.setVisible(false);
            table1.setVisible(true);
            b2.setVisible(false);
            b1.setVisible(true);
            upbtn.setDisable(false);
            delbtn.setDisable(false);
            employees();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    void deleteEmploy(ActionEvent event) throws SQLException {

        updateS();
        String query = "DELETE FROM `employee` where `id`=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "An employee info has been deleted.");
            clear();
            table2.setVisible(false);
            pane.setVisible(false);
            pane2.setVisible(false);
            table1.setVisible(true);
            b2.setVisible(false);
            b1.setVisible(true);
            employees();
        } catch (Exception e) {
        }
    }

    @FXML
    void addAdmin(ActionEvent event) {

        table2.setVisible(false);
        table1.setVisible(false);
        pane2.setVisible(false);
        pane.setVisible(true);
        upbtn.setDisable(true);
        delbtn.setDisable(true);
    }

    @FXML
    void adminList(ActionEvent event) {
        table1.setVisible(false);
        pane.setVisible(false);
        pane2.setVisible(false);
        table2.setVisible(true);
        b1.setVisible(false);
        b2.setVisible(true);
        upbtn.setDisable(true);
        delbtn.setDisable(true);
        admins();
    }

    @FXML
    void add(ActionEvent event) {

        try {
            String n = tx.getText();
            String p = ps.getText();
            String query = "INSERT INTO `admin` (`name`, `pass`) VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, n);
            pst.setString(2, p);
            if (n.equals("") || p.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fillup all the information");
            } else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Adding new *Admin, Confirmation Dialog");
                alert.setContentText("Do you really want to add an Admin?\nPress 'OK' to add or 'Cancel' to cancel.");
                alert.setGraphic(new ImageView(this.getClass().getResource("image11.jpg").toString()));

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Admin added successfully.");
                    admins();
                    table1.setVisible(false);
                    pane.setVisible(false);
                    b1.setVisible(false);
                    b2.setVisible(true);
                    table2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Admin is not added.");

                }

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void admins() {
        ObservableList<EmployeeTab2> oblist = FXCollections.observableArrayList();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM admin");

            while (rs.next()) {
                oblist.add(new EmployeeTab2(rs.getString("Name"), rs.getString("Pass")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        adminName.setCellValueFactory(new PropertyValueFactory<>("Aname"));
        adminPass.setCellValueFactory(new PropertyValueFactory<>("Apass"));

        table2.setItems(oblist);
    }

    @FXML
    void employList(ActionEvent event) {

        table2.setVisible(false);
        pane.setVisible(false);
        pane2.setVisible(false);
        table1.setVisible(true);
        b2.setVisible(false);
        b1.setVisible(true);
        upbtn.setDisable(false);
        delbtn.setDisable(false);
        employees();
    }

    public void employees() {
        ObservableList<EmployeeTab1> oblist = FXCollections.observableArrayList();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                oblist.add(new EmployeeTab1(rs.getString("id"), rs.getString("Name"), rs.getString("Gender"), rs.getString("b date"), rs.getString("b month"), rs.getString("b year"), rs.getString("Email"), rs.getString("date hired"), rs.getString("Address"), rs.getString("Job Title"), rs.getString("Contact No"), rs.getString("Salary")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_gen.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_day.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_month.setCellValueFactory(new PropertyValueFactory<>("month"));
        col_yr.setCellValueFactory(new PropertyValueFactory<>("year"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        col_hire.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
        col_add.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_dept.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        col_contact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        table1.setItems(oblist);
    }

    @FXML
    private void clearbtn(ActionEvent event) {
        clear();
    }

    public void clear() {
        fname.setText("");
        salary.setText("");
        contact.setText("");
        id.setText("");
        jobtitle.setText("");
        email.setText("");
        address.setText("");
        age.setText("");
        date.setText("");
        month.setText("");
        year.setText("");
    }

}
