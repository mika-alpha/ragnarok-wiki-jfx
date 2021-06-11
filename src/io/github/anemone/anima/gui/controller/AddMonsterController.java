package io.github.anemone.anima.gui.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class AddMonsterController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField levelField;

    @FXML
    private TextField hpField;

    @FXML
    private ComboBox<String> raceBox;

    @FXML
    private ComboBox<String> propertyBox;

    @FXML
    private ComboBox<String> sizeBox;


    public AddMonsterController(){
    }

    @FXML
    public void initialize(){
        raceBox.getItems().add("Angel");
        raceBox.getItems().add("Brute");
        raceBox.getItems().add("Demi-human");
        raceBox.getItems().add("Dragon");
        raceBox.getItems().add("Fish");
        raceBox.getItems().add("Demon");
        raceBox.getItems().add("Plant");
        raceBox.getItems().add("Formless");
        raceBox.getItems().add("Insect");
        propertyBox.getItems().add("Fire");
        propertyBox.getItems().add("Water");
        propertyBox.getItems().add("Neutral");
        propertyBox.getItems().add("Wind");
        propertyBox.getItems().add("Earth");
        propertyBox.getItems().add("Ghost");
        propertyBox.getItems().add("Holy");
        propertyBox.getItems().add("Shadow");
        propertyBox.getItems().add("Undead");
        sizeBox.getItems().add("Small");
        sizeBox.getItems().add("Medium");
        sizeBox.getItems().add("Large");
    }

    @FXML
    public void addMonster(ActionEvent event) {
    }

}
