/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */

package com.exercises.guessthenumber;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCheck"
    private Button btnCheck; // Value injected by FXMLLoader

    @FXML // fx:id="btnStartGame"
    private Button btnStartGame; // Value injected by FXMLLoader

    @FXML // fx:id="errorNMax"
    private Label errorNMax; // Value injected by FXMLLoader

    @FXML // fx:id="errorNTest"
    private Label errorNTest; // Value injected by FXMLLoader

    @FXML // fx:id="errorTMax"
    private Label errorTMax; // Value injected by FXMLLoader

    @FXML // fx:id="lblT"
    private Label lblT; // Value injected by FXMLLoader

    @FXML // fx:id="nMax"
    private TextField nMax; // Value injected by FXMLLoader

    @FXML // fx:id="tMax"
    private TextField tMax; // Value injected by FXMLLoader

    @FXML // fx:id="nTest"
    private TextField nTest; // Value injected by FXMLLoader

    @FXML // fx:id="messageArea"
    private TextArea messageArea; // Value injected by FXMLLoader

    @FXML // fx:id="pBarT"
    private ProgressBar pBarT; // Value injected by FXMLLoader

    @FXML // fx:id="flagAssistMode"
    private CheckBox flagAssistMode; // Value injected by FXMLLoader

    @FXML // fx:id="lblAssistMode"
    private Label lblAssistMode; // Value injected by FXMLLoader

    private int maxAttempts;
    private int remaingAttempts;
    private int usedAttempts;
    private int maxNumber;
    private int minNumber = 1;
    private int checkNumber;
    private int nRand;

    @FXML
    void startGame(ActionEvent event) {
        // resetto i campi
        messageArea.setText("");
        nTest.setText("");
        usedAttempts = 0;
        errorNMax.setText("");
        errorTMax.setText("");
        errorNTest.setText("");
        pBarT.setProgress(0);
        lblAssistMode.setText("? < NUMERO < ?");

        // Prendo il numero massimo
        try {
            maxNumber = Integer.parseInt(nMax.getText());
        } catch (NumberFormatException e) {
            errorNMax.setText("Errore inserimento!");
            return;
        }

        // Prendo il numero massimo di tentativi
        try {
            maxAttempts = Integer.parseInt(tMax.getText());
            remaingAttempts = maxAttempts;
        } catch (NumberFormatException e) {
            errorTMax.setText("Errore inserimento!");
            return;
        }

        // mostro il range possibile
        lblAssistMode.setText(minNumber + " < NUMERO < " + maxNumber);

        // Genero un valore random tra 1 e nMax
        Random random = new Random();
        nRand = random.nextInt(maxNumber) + 1;
        System.out.println(nRand); //debug

        // setto i tentativi possibili
        lblT.setText("Tentativi rimanenti: " + remaingAttempts);
    }

    @FXML
    void checkNumber(ActionEvent event) {
        // resetto la scritta di errore
        errorNTest.setText("");

        // se dovessi riprovare dopo che nn hai tentativi nn fare nulla
        if (remaingAttempts == 0 || checkNumber == nRand) return;

        // controllo che venga inserito un numero valido
        try {
            // controllo ripetizione numero
            if(checkNumber == Integer.parseInt(nTest.getText())){
                errorNTest.setText("Errore ripetizione!");
                return;
            }
            checkNumber = Integer.parseInt(nTest.getText());
        } catch (NumberFormatException e) {
            errorNTest.setText("Errore inserimento!");
            return;
        }

        // a questo punto posso contare i tentativi usati
        usedAttempts++;
        pBarT.setProgress((double) usedAttempts / maxAttempts);

        // resetto il numero inserito
        nTest.setText("");

        // controllo se maggiore o minore
        if (checkNumber > nRand) {
            messageArea.appendText("T"+ usedAttempts  +": Il numero " + checkNumber + " è troppo ALTO!\n");
            maxNumber = checkNumber;
        }
        if (checkNumber < nRand) {
            messageArea.appendText("T"+ usedAttempts  +": Il numero " + checkNumber + " è troppo BASSO!\n");
            minNumber = checkNumber;
        }

        // aggiorno il range possibile
        lblAssistMode.setText(minNumber + " < NUMERO < " + maxNumber);

        // aggiorno i tentativi rimanenti
        remaingAttempts--;
        lblT.setText("Tentativi rimanenti: " + remaingAttempts);

        // controllo se hai vinto o perso
        if (checkNumber == nRand) {
            messageArea.appendText("Hai vinto. Il numero era: " + nRand + "\n");
            pBarT.setProgress(1);
            lblT.setText("Tentativi finiti");
        } else if (remaingAttempts == 0) {
            messageArea.appendText("Hai perso. Il numero era: " + nRand + "\n");
            lblT.setText("Tentativi finiti");
        }

    }

    @FXML
    void toggleAssistMode(ActionEvent event) {
        if(flagAssistMode.isSelected()){
            lblAssistMode.setVisible(true);
        }else {
            lblAssistMode.setVisible(false);
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnStartGame != null : "fx:id=\"btnStartGame\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lblT != null : "fx:id=\"lblT\" was not injected: check your FXML file 'main-view.fxml'.";
        assert nMax != null : "fx:id=\"nMax\" was not injected: check your FXML file 'main-view.fxml'.";
        assert nTest != null : "fx:id=\"nTest\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tMax != null : "fx:id=\"tMax\" was not injected: check your FXML file 'main-view.fxml'.";

    }

}
