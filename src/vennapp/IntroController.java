package vennapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Session;

/**
 * FXML Controller class
 *
 * @author CHAACHAI Youssef
 */
public class IntroController implements Initializable {

    @FXML
    private Label close;

    @FXML
    private Label error;

    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;

    private boolean isOkay() {
        if (t1.getText().trim().isEmpty() || t2.getText().trim().isEmpty()
                || t3.getText().trim().isEmpty() || t1.getText().equals(t2.getText())
                || t1.getText().equals(t3.getText()) || t2.getText().equals(t3.getText())) {
            return false;
        }
        return true;
    }

    @FXML
    private void partir(ActionEvent actionEvent) throws IOException {
        if (isOkay()) {
            Session.updateAttribute(t1.getText(), "T1");
            Session.updateAttribute(t2.getText(), "T2");
            Session.updateAttribute(t3.getText(), "T3");
            error.setVisible(false);
            VennApp.forward(actionEvent, "MainPageFXML.fxml", this.getClass());
        } else {
            error.setVisible(true);
        }
    }

    @FXML
    private void reset(ActionEvent actionEvent) throws IOException {
        VennApp.forward(actionEvent, "MainPageFXML.fxml", this.getClass());
    }

    @FXML
    public void closeApp() {
        Stage stage = (Stage) close.getScene().getWindow();

        stage.close();
    }

    @FXML
    public void minimizeApp(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        error.setVisible(false);
    }

}
