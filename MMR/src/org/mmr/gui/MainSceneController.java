/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mmr.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author root
 */
public class MainSceneController implements Initializable {

    //Inject controls (names must correspond to IDs from fxml)
    //---required for indexing
    @FXML
    private CheckBox chbTXT;
    @FXML
    private CheckBox chbHTML;
    @FXML
    private CheckBox chbPDF;
    @FXML
    private CheckBox chbODT;
    @FXML
    private CheckBox chbDOC;
    @FXML
    private TextField tfDir;
    //---required for search purposes
    @FXML
    private TextField tfQuery;
    //---required for result visualisation
    @FXML
    private TextArea taResults;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //nothing required to do here
    }

    @FXML
    private void jbDirClicked(ActionEvent ae) {

    }

    @FXML
    private void jbBuildClicked(ActionEvent ae) {

    }

    @FXML
    private void jbSearchClicked(ActionEvent ae) {

    }

}
