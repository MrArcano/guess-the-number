/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */

package com.exercises.guessthenumber;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCheck"
    private Button btnCheck; // Value injected by FXMLLoader

    @FXML // fx:id="btnStartGame"
    private Button btnStartGame; // Value injected by FXMLLoader

    @FXML // fx:id="lblT"
    private Label lblT; // Value injected by FXMLLoader

    @FXML // fx:id="nMax"
    private TextField nMax; // Value injected by FXMLLoader

    @FXML // fx:id="nTest"
    private TextField nTest; // Value injected by FXMLLoader

    @FXML // fx:id="tMax"
    private TextField tMax; // Value injected by FXMLLoader

    @FXML
    void checkNumber(ActionEvent event) {

    }

    @FXML
    void startGame(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnStartGame != null : "fx:id=\"btnStartGame\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lblT != null : "fx:id=\"lblT\" was not injected: check your FXML file 'main-view.fxml'.";
        assert nMax != null : "fx:id=\"nMax\" was not injected: check your FXML file 'main-view.fxml'.";
        assert nTest != null : "fx:id=\"nTest\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tMax != null : "fx:id=\"tMax\" was not injected: check your FXML file 'main-view.fxml'.";

    }

}
