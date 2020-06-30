package vennapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import util.Session;

/**
 * FXML Controller class
 *
 * @author CHAACHAI Youssef
 */
public class MainPageController implements Initializable {

    @FXML
    private Label close;

    @FXML
    private ComboBox<String> p1;
    @FXML
    private ComboBox<String> p2;
    @FXML
    private ComboBox<String> p3;
    @FXML
    private ComboBox<String> p4;
    @FXML
    private ComboBox<String> p5;
    @FXML
    private ComboBox<String> p6;

    @FXML
    private ComboBox<String> t1;
    @FXML
    private ComboBox<String> t2;
    @FXML
    private ComboBox<String> t3;
    @FXML
    private ComboBox<String> t4;
    @FXML
    private ComboBox<String> t5;
    @FXML
    private ComboBox<String> t6;

    @FXML
    private Text predicat1;
    @FXML
    private Text predicat2;
    @FXML
    private Text predicat3;

    @FXML
    private ImageView diagramme;

    @FXML
    private ImageView toggle_off1;
    @FXML
    private ImageView toggle_off2;
    @FXML
    private ImageView toggle_off3;

    @FXML
    private ImageView toggle_on1;
    @FXML
    private ImageView toggle_on2;
    @FXML
    private ImageView toggle_on3;

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;

    /**
     * Initializing the drop down values.
     */
    private void initCombobox_1() {
        ObservableList<String> vals = FXCollections.observableArrayList();
        vals.add(0, "--SELECT--");
        vals.add("TOUT");
        vals.add("NUL");
        vals.add("QUELQUE");
        p1.setItems(vals);
        p3.setItems(vals);
        p5.setItems(vals);

        p1.setValue(vals.get(0));
        p3.setValue(vals.get(0));
        p5.setValue(vals.get(0));
    }

    private void initCombobox_2() {
        ObservableList<String> vals = FXCollections.observableArrayList();
        vals.add(0, "--SELECT--");
        vals.add("EST");
        vals.add("N\'EST PAS");
        p2.setItems(vals);
        p4.setItems(vals);
        p6.setItems(vals);

        p2.setValue(vals.get(0));
        p4.setValue(vals.get(0));
        p6.setValue(vals.get(0));
    }

    private void initCombobox_3() {
        ObservableList<String> vals = FXCollections.observableArrayList();
        vals.add(0, "Choisir un prédicat");
        vals.add((String) Session.getAttribut("T1"));
        vals.add((String) Session.getAttribut("T2"));
        vals.add((String) Session.getAttribut("T3"));

        t1.setItems(vals);
        t2.setItems(vals);
        t3.setItems(vals);
        t4.setItems(vals);
        t5.setItems(vals);
        t6.setItems(vals);

        t1.setValue(vals.get(0));
        t2.setValue(vals.get(0));
        t3.setValue(vals.get(0));
        t4.setValue(vals.get(0));
        t5.setValue(vals.get(0));
        t6.setValue(vals.get(0));
    }

    /**
     * Actions to make when the drop down values change.
     */
    @FXML
    private void p1_change(ActionEvent event) {
        if (p1.getValue().equals("TOUT")) {
            p2.setValue("EST");
        } else if (p1.getValue().equals("NUL")) {
            p2.setValue("N\'EST PAS");
        }
    }

    @FXML
    private void p2_change(ActionEvent event) {
        if (p2.getValue().equals("EST") && p1.getValue().equals("NUL")) {
            p1.setValue("TOUT");
        } else if (p2.getValue().equals("N\'EST PAS") && p1.getValue().equals("TOUT")) {
            p1.setValue("NUL");
        }
    }

    @FXML
    private void p3_change(ActionEvent event) {
        if (p3.getValue().equals("TOUT")) {
            p4.setValue("EST");
        } else if (p3.getValue().equals("NUL")) {
            p4.setValue("N\'EST PAS");
        }
    }

    @FXML
    private void p4_change(ActionEvent event) {
        if (p4.getValue().equals("EST") && p3.getValue().equals("NUL")) {
            p3.setValue("TOUT");
        } else if (p4.getValue().equals("N\'EST PAS") && p3.getValue().equals("TOUT")) {
            p3.setValue("NUL");
        }
    }

    @FXML
    private void p5_change(ActionEvent event) {
        if (p5.getValue().equals("TOUT")) {
            p6.setValue("EST");
        } else if (p5.getValue().equals("NUL")) {
            p6.setValue("N\'EST PAS");
        }
    }

    @FXML
    private void p6_change(ActionEvent event) {
        if (p6.getValue().equals("EST") && p5.getValue().equals("NUL")) {
            p5.setValue("TOUT");
        } else if (p6.getValue().equals("N\'EST PAS") && p5.getValue().equals("TOUT")) {
            p5.setValue("NUL");
        }
    }

    /**
     * Get image by name.
     */
    private Image getImage(String name) {
        return new Image(getClass().getResource("images/" + name + ".png").toString(), true);
    }

    /**
     * Verifying inputs
     */
    private boolean toggle3_off_verify_inputs() {
        if (p1.getValue().equals("--SELECT--") || p2.getValue().equals("--SELECT--")
                || p3.getValue().equals("--SELECT--") || p4.getValue().equals("--SELECT--")
                || t1.getValue().equals("Choisir un prédicat") || t2.getValue().equals("Choisir un prédicat")
                || t3.getValue().equals("Choisir un prédicat") || t4.getValue().equals("Choisir un prédicat")) {
            return false;
        } else if (t1.getValue().equals(t2.getValue()) || t3.getValue().equals(t4.getValue())) {
            return false;
        } else if ((t1.getValue() + t2.getValue()).equalsIgnoreCase(t3.getValue() + t4.getValue())
                || (t1.getValue() + t2.getValue()).equalsIgnoreCase(t4.getValue() + t3.getValue())) {
            return false;
        } else if (p1.getValue().equals("NUL") && p3.getValue().equals("NUL")) {
            return false;
        }
        return true;
    }

    private boolean toggle2_off_verify_inputs() {
        if (p1.getValue().equals("--SELECT--") || p2.getValue().equals("--SELECT--")
                || p5.getValue().equals("--SELECT--") || p6.getValue().equals("--SELECT--")
                || t1.getValue().equals("Choisir un prédicat") || t2.getValue().equals("Choisir un prédicat")
                || t5.getValue().equals("Choisir un prédicat") || t6.getValue().equals("Choisir un prédicat")) {
            return false;
        } else if (t1.getValue().equals(t2.getValue()) || t5.getValue().equals(t6.getValue())) {
            return false;
        } else if ((t1.getValue() + t2.getValue()).equalsIgnoreCase(t5.getValue() + t6.getValue())
                || (t1.getValue() + t2.getValue()).equalsIgnoreCase(t6.getValue() + t5.getValue())) {
            return false;
        } else if (p1.getValue().equals("NUL") && p5.getValue().equals("TOUT")) {
            return false;
        } else if (p1.getValue().equals("QUELQUE") && !p5.getValue().equals("QUELQUE")) {
            return false;
        }
        return true;
    }

    private boolean toggle1_off_verify_inputs() {
        if (p3.getValue().equals("--SELECT--") || p4.getValue().equals("--SELECT--")
                || p5.getValue().equals("--SELECT--") || p6.getValue().equals("--SELECT--")
                || t3.getValue().equals("Choisir un prédicat") || t4.getValue().equals("Choisir un prédicat")
                || t5.getValue().equals("Choisir un prédicat") || t6.getValue().equals("Choisir un prédicat")) {
            return false;
        } else if (t3.getValue().equals(t4.getValue()) || t5.getValue().equals(t6.getValue())) {
            return false;
        } else if ((t3.getValue() + t4.getValue()).equalsIgnoreCase(t5.getValue() + t6.getValue())
                || (t3.getValue() + t4.getValue()).equalsIgnoreCase(t6.getValue() + t5.getValue())) {
            return false;
        }
        return true;
    }

    /**
     * Show error message
     */
    private void show_error() {
        JOptionPane.showMessageDialog(
                null,
                "Ce cas est invalide !\nMerci de reformuler les prédicats et réessayer ",
                " Cas invalide ",
                JOptionPane.OK_OPTION
        );
    }

    /**
     * Defining all possible cases when toggle 3 is off.
     */
    private void toggle3_off_cas_1() {
        p5.setValue("TOUT");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("1"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_2() {
        p5.setValue("TOUT");
        p6.setValue("EST");
        t5.setValue(t4.getValue());
        t6.setValue(t2.getValue());
        diagramme.setImage(getImage("2"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_3() {
        p5.setValue("TOUT");
        p6.setValue("EST");
        t5.setValue(t3.getValue());
        t6.setValue(t2.getValue());
        diagramme.setImage(getImage("3"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_4() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("4"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_5() {
        p5.setValue("NUL");
        p6.setValue("N\'EST PAS");
        t5.setValue(t4.getValue());
        t6.setValue(t1.getValue());
        diagramme.setImage(getImage("5"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_6() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("6"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_7() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("6"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_8() {
        p5.setValue("NUL");
        p6.setValue("N\'EST PAS");
        t5.setValue(t3.getValue());
        t6.setValue(t1.getValue());
        diagramme.setImage(getImage("5"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_9() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("9"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_10() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("10"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_11() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("10"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_12() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("9"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_17() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t4.getValue());
        t6.setValue(t1.getValue());
        diagramme.setImage(getImage("17"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_18() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t4.getValue());
        t6.setValue(t2.getValue());
        diagramme.setImage(getImage("18"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_19() {
        p5.setValue("NUL");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("19"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_20() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("20"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_21() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t1.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("21"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_22() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t4.getValue());
        t6.setValue(t2.getValue());
        diagramme.setImage(getImage("22"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_23() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t3.getValue());
        t6.setValue(t2.getValue());
        diagramme.setImage(getImage("22"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_24() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("21"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_29() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("29"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_30() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t2.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("30"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_31() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t2.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("31"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_32() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("32"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_33() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t1.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("33"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_34() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("34"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_35() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t2.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("34"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_36() {
        p5.setValue("QUELQUE");
        p6.setValue("N\'EST PAS");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("33"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_37() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t2.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("38"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_38() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t4.getValue());
        diagramme.setImage(getImage("37"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t4.getValue());
    }

    private void toggle3_off_cas_39() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t2.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("38"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    private void toggle3_off_cas_40() {
        p5.setValue("QUELQUE");
        p6.setValue("EST");
        t5.setValue(t1.getValue());
        t6.setValue(t3.getValue());
        diagramme.setImage(getImage("37"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t3.getValue());
    }

    /**
     * Defining all possible cases when toggle 2 is off.
     */
    private void toggle2_off_cas_1() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t2.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("1"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_3() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t5.getValue());
        t4.setValue(t1.getValue());
        diagramme.setImage(getImage("3"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle2_off_cas_4() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t6.getValue());
        t4.setValue(t2.getValue());
        diagramme.setImage(getImage("4"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_5() {
        p3.setValue("NUL");
        p4.setValue("N\'EST PAS");
        t3.setValue(t2.getValue());
        t4.setValue(t5.getValue());
        diagramme.setImage(getImage("5"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle2_off_cas_6() {
        p3.setValue("NUL");
        p4.setValue("N\'EST PAS");
        t3.setValue(t1.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("6"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_9() {
        p3.setValue("QUELQUE");
        p4.setValue("EST");
        t3.setValue(t2.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("9"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_10() {
        p3.setValue("QUELQUE");
        p4.setValue("EST");
        t3.setValue(t1.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("10"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_17() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t2.getValue());
        t4.setValue(t5.getValue());
        diagramme.setImage(getImage("17"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle2_off_cas_18() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t1.getValue());
        t4.setValue(t5.getValue());
        diagramme.setImage(getImage("18"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle2_off_cas_19() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t6.getValue());
        t4.setValue(t1.getValue());
        diagramme.setImage(getImage("19"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_20() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t6.getValue());
        t4.setValue(t2.getValue());
        diagramme.setImage(getImage("20"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_21() {
        p3.setValue("QUELQUE");
        p4.setValue("EST");
        t3.setValue(t2.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("21"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_22() {
        p3.setValue("QUELQUE");
        p4.setValue("EST");
        t3.setValue(t1.getValue());
        t4.setValue(t5.getValue());
        diagramme.setImage(getImage("22"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_29() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t2.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("29"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_30() {
        p3.setValue("TOUT");
        p4.setValue("EST");
        t3.setValue(t1.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("30"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_33() {
        p3.setValue("NUL");
        p4.setValue("N\'EST PAS");
        t3.setValue(t2.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("33"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle2_off_cas_34() {
        p3.setValue("NUL");
        p4.setValue("N\'EST PAS");
        t3.setValue(t1.getValue());
        t4.setValue(t6.getValue());
        diagramme.setImage(getImage("34"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    /**
     * Defining all possible cases when toggle 1 is off.
     */
    private void toggle1_off_cas_1() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t5.getValue());
        t2.setValue(t3.getValue());
        diagramme.setImage(getImage("1"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_3() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t4.getValue());
        t2.setValue(t6.getValue());
        diagramme.setImage(getImage("3"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle1_off_cas_4() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t5.getValue());
        t2.setValue(t4.getValue());
        diagramme.setImage(getImage("4"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_5() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t6.getValue());
        t2.setValue(t3.getValue());
        diagramme.setImage(getImage("5"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle1_off_cas_6() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t3.getValue());
        t2.setValue(t5.getValue());
        diagramme.setImage(getImage("6"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_9() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t5.getValue());
        t2.setValue(t3.getValue());
        diagramme.setImage(getImage("9"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_11() {
        p1.setValue("TOUT");
        p2.setValue("EST");
        t1.setValue(t4.getValue());
        t2.setValue(t5.getValue());
        diagramme.setImage(getImage("10"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_18() {
        p1.setValue("NUL");
        p2.setValue("N\'EST PAS");
        t1.setValue(t3.getValue());
        t2.setValue(t6.getValue());
        diagramme.setImage(getImage("18"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle1_off_cas_19() {
        p1.setValue("NUL");
        p2.setValue("N\'EST PAS");
        t1.setValue(t4.getValue());
        t2.setValue(t5.getValue());
        diagramme.setImage(getImage("19"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_20() {
        p1.setValue("NUL");
        p2.setValue("N\'EST PAS");
        t1.setValue(t5.getValue());
        t2.setValue(t4.getValue());
        diagramme.setImage(getImage("20"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_22() {
        p1.setValue("NUL");
        p2.setValue("N\'EST PAS");
        t1.setValue(t3.getValue());
        t2.setValue(t6.getValue());
        diagramme.setImage(getImage("22"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle1_off_cas_23() {
        p1.setValue("NUL");
        p2.setValue("N\'EST PAS");
        t1.setValue(t4.getValue());
        t2.setValue(t6.getValue());
        diagramme.setImage(getImage("22"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t5.getValue());
    }

    private void toggle1_off_cas_29() {
        p1.setValue("QUELQUE");
        p2.setValue("EST");
        t1.setValue(t5.getValue());
        t2.setValue(t3.getValue());
        diagramme.setImage(getImage("29"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    private void toggle1_off_cas_35() {
        p1.setValue("QUELQUE");
        p2.setValue("EST");
        t1.setValue(t4.getValue());
        t2.setValue(t5.getValue());
        diagramme.setImage(getImage("34"));
        predicat1.setText(t1.getValue());
        predicat2.setText(t2.getValue());
        predicat3.setText(t6.getValue());
    }

    /**
     * Testing the cases.
     */
    @FXML
    private void calculer(ActionEvent actionEvent) throws IOException {
        if (!isToggle3_on()) {
            if (!toggle3_off_verify_inputs()) {
                show_error();
            } else if (p1.getValue().equals("TOUT") && p3.getValue().equals("TOUT")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_1();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_2();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_3();
                } else {
                    toggle3_off_cas_4();
                }
            } else if (p1.getValue().equals("TOUT") && p3.getValue().equals("NUL")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_5();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_6();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_7();
                } else {
                    toggle3_off_cas_8();
                }
            } else if (p1.getValue().equals("TOUT") && p3.getValue().equals("QUELQUE")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_9();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_10();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_11();
                } else {
                    toggle3_off_cas_12();
                }
            } else if (p1.getValue().equals("NUL") && p3.getValue().equals("TOUT")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_17();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_18();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_19();
                } else {
                    toggle3_off_cas_20();
                }
            } else if (p1.getValue().equals("NUL") && p3.getValue().equals("QUELQUE")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_21();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_22();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_23();
                } else {
                    toggle3_off_cas_24();
                }
            } else if (p1.getValue().equals("QUELQUE") && p3.getValue().equals("TOUT")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_29();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_30();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_31();
                } else {
                    toggle3_off_cas_32();
                }
            } else if (p1.getValue().equals("QUELQUE") && p3.getValue().equals("NUL")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_33();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_34();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_35();
                } else {
                    toggle3_off_cas_36();
                }
            } else if (p1.getValue().equals("QUELQUE") && p3.getValue().equals("QUELQUE")) {
                if (t2.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_37();
                } else if (t1.getValue().equals(t3.getValue())) {
                    toggle3_off_cas_38();
                } else if (t1.getValue().equals(t4.getValue())) {
                    toggle3_off_cas_39();
                } else {
                    toggle3_off_cas_40();
                }
            } else {
                show_error();
            }

        } else if (!isToggle2_on()) {
            if (!toggle2_off_verify_inputs()) {
                show_error();
            } else if (p1.getValue().equals("TOUT") && p5.getValue().equals("TOUT")) {
                if (t1.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_1();
                } else if (t2.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_3();
                } else {
                    show_error();
                }
            } else if (p1.getValue().equals("TOUT") && p5.getValue().equals("QUELQUE")) {
                if (t1.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_9();
                } else if (t2.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_10();
                } else if (t1.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_4();
                } else if (t2.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_6();
                } else {
                    show_error();
                }
            } else if (p1.getValue().equals("TOUT") && p5.getValue().equals("NUL")) {
                if (t1.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_5();
                } else if (t1.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_5();
                } else {
                    show_error();
                }
            } else if (p1.getValue().equals("NUL") && p5.getValue().equals("QUELQUE")) {
                if (t1.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_17();
                } else if (t2.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_22();
                } else if (t1.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_21();
                } else if (t2.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_18();
                } else {
                    show_error();
                }
            } else if (p1.getValue().equals("NUL") && p5.getValue().equals("NUL")) {
                if (t2.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_19();
                } else if (t1.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_20();
                } else if (t1.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_20();
                } else if (t2.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_19();
                } else {
                    show_error();
                }
            } else if (p1.getValue().equals("QUELQUE") && p5.getValue().equals("QUELQUE")) {
                if (t1.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_33();
                } else if (t2.getValue().equals(t5.getValue())) {
                    toggle2_off_cas_34();
                } else if (t1.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_29();
                } else if (t2.getValue().equals(t6.getValue())) {
                    toggle2_off_cas_30();
                } else {
                    show_error();
                }
            } else {
                show_error();
            }

        } else if (!isToggle1_on()) {
            if (!toggle1_off_verify_inputs()) {
                show_error();
            } else if (p3.getValue().equals("TOUT") && p5.getValue().equals("TOUT")) {
                if (t4.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_1();
                } else if (t3.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_3();
                } else {
                    show_error();
                }
            } else if (p3.getValue().equals("TOUT") && p5.getValue().equals("QUELQUE")) {
                if (t3.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_4();
                } else if (t4.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_18();
                } else if (t4.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_29();
                } else if (t3.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_4();
                } else {
                    show_error();
                }
            } else if (p3.getValue().equals("NUL") && p5.getValue().equals("NUL")) {
                if (t4.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_5();
                } else if (t3.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_5();
                } else if (t3.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_5();
                } else if (t4.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_5();
                } else {
                    show_error();
                }
            } else if (p3.getValue().equals("NUL") && p5.getValue().equals("QUELQUE")) {
                if (t4.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_6();
                } else if (t3.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_35();
                } else if (t4.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_6();
                } else if (t3.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_35();
                } else {
                    show_error();
                }
            } else if (p3.getValue().equals("QUELQUE") && p5.getValue().equals("QUELQUE")) {
                if (t4.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_9();
                } else if (t3.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_11();
                } else if (t4.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_22();
                } else if (t3.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_23();
                } else {
                    show_error();
                }
            } else if (p3.getValue().equals("TOUT") && p5.getValue().equals("NUL")) {
                if (t3.getValue().equals(t6.getValue())) {
                    toggle1_off_cas_20();
                } else if (t3.getValue().equals(t5.getValue())) {
                    toggle1_off_cas_19();
                } else {
                    show_error();
                }
            } else {
                show_error();
            }
        } else {
            show_error();
        }
    }

    /**
     * Refresh the scene.
     */
    @FXML
    private void reset(ActionEvent actionEvent) throws IOException {
        VennApp.forward(actionEvent, "MainPageFXML.fxml", this.getClass());
    }

    /**
     * Go back to previous scene.
     */
    @FXML
    private void back(ActionEvent actionEvent) throws IOException {
        Session.clear();
        VennApp.forward(actionEvent, "IntroFXML.fxml", this.getClass());
    }

    /**
     * Close the application.
     */
    @FXML
    public void closeApp() {
        Stage stage = (Stage) close.getScene().getWindow();

        stage.close();
    }

    /**
     * Minimize the application.
     */
    @FXML
    public void minimizeApp(ActionEvent event
    ) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    /**
     * These function are used to reset the drop down values.
     */
    private void resetPremisse1() {
        pane1.setVisible(true);
        p1.setValue("--SELECT--");
        p2.setValue("--SELECT--");
        t1.setValue("Choisir un prédicat");
        t2.setValue("Choisir un prédicat");
    }

    private void resetPremisse2() {
        pane2.setVisible(true);
        p1.setValue("--SELECT--");
        p4.setValue("--SELECT--");
        t3.setValue("Choisir un prédicat");
        t4.setValue("Choisir un prédicat");
    }

    private void resetPremisse3() {
        pane3.setVisible(true);
        p5.setValue("--SELECT--");
        p6.setValue("--SELECT--");
        t5.setValue("Choisir un prédicat");
        t6.setValue("Choisir un prédicat");
    }

    /**
     * Verifying the toggles state.
     */
    private boolean isToggle1_on() {
        if (toggle_on1.isVisible() && !toggle_off1.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isToggle2_on() {
        if (toggle_on2.isVisible() && !toggle_off2.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isToggle3_on() {
        if (toggle_on3.isVisible() && !toggle_off3.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Setting the toggles values.
     */
    private void setToggle1(boolean val) {
        if (val) {
            toggle_on1.setVisible(true);
            toggle_off1.setVisible(false);
            pane1.setVisible(false);
        } else {
            toggle_on1.setVisible(false);
            toggle_off1.setVisible(true);
            resetPremisse1();
        }
    }

    private void setToggle2(boolean val) {
        if (val) {
            toggle_on2.setVisible(true);
            toggle_off2.setVisible(false);
            pane2.setVisible(false);
        } else {
            toggle_on2.setVisible(false);
            toggle_off2.setVisible(true);
            resetPremisse2();
        }
    }

    private void setToggle3(boolean val) {
        if (val) {
            toggle_on3.setVisible(true);
            toggle_off3.setVisible(false);
            pane3.setVisible(false);
        } else {
            toggle_on3.setVisible(false);
            toggle_off3.setVisible(true);
            resetPremisse3();
        }
    }

    /**
     * Actions to make when a toggle is clicked.
     */
    @FXML
    public void toggle1_clicked() {
        if (isToggle1_on()) {
            setToggle1(false);
            setToggle2(true);
            setToggle3(true);
        } else {
            setToggle1(true);
            setToggle2(false);
        }

    }

    @FXML
    public void toggle2_clicked() {
        if (isToggle2_on()) {
            setToggle2(false);
            setToggle3(true);
            setToggle1(true);
        } else {
            setToggle2(true);
            setToggle3(false);
        }
    }

    @FXML
    public void toggle3_clicked() {
        if (isToggle3_on()) {
            setToggle3(false);
            setToggle1(true);
            setToggle2(true);

        } else {
            setToggle3(true);
            setToggle1(false);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCombobox_1();
        initCombobox_2();
        initCombobox_3();

        predicat1.setText((String) Session.getAttribut("T1"));
        predicat2.setText((String) Session.getAttribut("T2"));
        predicat3.setText((String) Session.getAttribut("T3"));

        t1.setValue((String) Session.getAttribut("T1"));
        t1.setEditable(false);
        t2.setValue((String) Session.getAttribut("T2"));

        setToggle1(true);
        setToggle2(true);
        setToggle3(false);

    }

}
