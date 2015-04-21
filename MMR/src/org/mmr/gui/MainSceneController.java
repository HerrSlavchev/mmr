/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mmr.gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.mmr.core.Context;
import org.mmr.core.Engine;
import org.mmr.core.MIMEEnum;

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

    private final Context context = new Context();
    private DirectoryChooser chooser = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chooser = new DirectoryChooser();
        chooser.setTitle("Choose a directory");
    }

    /**
     * Show a directory chooser. Extra: remembers the last chosen directory.
     */
    @FXML
    private void jbDirClicked(ActionEvent ae) {
        File chosenDir = chooser.showDialog(MainClass.getStage());
        if (chosenDir != null) {
            context.setChosenDirectory(chosenDir);
            //save last choice
            String dirPath = chosenDir.getAbsolutePath();
            File parentDir = chosenDir.getParentFile();
            if (parentDir != null) {
                chooser.setInitialDirectory(parentDir);
            }
            tfDir.setText(dirPath);
        }
    }

    @FXML
    private void jbBuildClicked(ActionEvent ae) {
        List<MIMEEnum> chosenMIMEs = new ArrayList<>();
        if (chbTXT.isSelected()) {
            chosenMIMEs.add(MIMEEnum.TXT);
        }
        if (chbHTML.isSelected()) {
            chosenMIMEs.add(MIMEEnum.HTML);
        }
        if (chbPDF.isSelected()) {
            chosenMIMEs.add(MIMEEnum.PDF);
        }
        if (chbODT.isSelected()) {
            chosenMIMEs.add(MIMEEnum.ODT);
        }
        if (chbDOC.isSelected()) {
            chosenMIMEs.add(MIMEEnum.DOC);
        }
        context.setAllowedMIMEs(chosenMIMEs);

        try {
            Engine.createIndexData(context);
        } catch (RuntimeException eR) {
            showDialog(eR.getMessage());
        }
    }

    @FXML
    private void jbSearchClicked(ActionEvent ae) {
        String query = tfQuery.getText();
        try {
            List<Object> results = Engine.processQuery(query, context);
            if (results != null) {
                for (Object res : results) {
                    //...magic!
                }
            }
        } catch (RuntimeException eR) {
            showDialog(eR.getMessage());
        }
    }

    /**
     * Simple utility to show dialogs.
     *
     * @param message - the text to be shown.
     */
    private void showDialog(String message) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text(message)).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        dialogStage.show();
    }
}
