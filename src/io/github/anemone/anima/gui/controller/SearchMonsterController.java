package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.model.Monster;
import io.github.anemone.anima.model.Wiki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class SearchMonsterController {


    @FXML
    private TextField idField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label raceLabel;

    @FXML
    private Label hpLabel;

    @FXML
    private Label propertyLabel;

    @FXML
    private Label sizeLabel;

    private Wiki wiki;

    public SearchMonsterController(Wiki wiki){
        this.wiki = wiki;
    }

    @FXML
    public void initialize(){
    }

    @FXML
    public void searchById(ActionEvent event) {
        Monster m = null;
        try {
            if (!idField.getText().isEmpty()) {
                m = wiki.searchMonsterByID(Integer.parseInt(idField.getText()));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if (m != null){
            levelLabel.setText(String.valueOf(m.getLevel()));
            hpLabel.setText(String.valueOf(m.getHp()));
            propertyLabel.setText(m.getProperty());
            raceLabel.setText(m.getRace());
            sizeLabel.setText(m.getSize());
            resultLabel.setText(m.getName() + " ( " + m.getId() + " )");
        }
    }

}
