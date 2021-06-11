package io.github.anemone.anima.gui.controller;


import io.github.anemone.anima.exception.InvalidInputException;
import io.github.anemone.anima.model.Monster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;


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

    private ArrayList<Monster> monsters;


    public AddMonsterController(ArrayList<Monster> monsters){
        this.monsters = monsters;
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
        try{
            if (nameField.getText().isEmpty() || idField.getText().isEmpty() || levelField.getText().isEmpty() || hpField.getText().isEmpty()){
                throw new InvalidInputException();
            } else if (sizeBox.getSelectionModel().isEmpty() || propertyBox.getSelectionModel().isEmpty() || raceBox.getSelectionModel().isEmpty()){
                throw new InvalidInputException();
            }
            else {
                monsters.add(new Monster(nameField.getText(),raceBox.getValue(),propertyBox.getValue(),
                        Integer.parseInt(hpField.getText()),
                        Integer.parseInt(idField.getText()),
                        Integer.parseInt(levelField.getText()),
                        sizeBox.getValue()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Success");
                alert.setContentText("The new monster was added succesfully into the wiki");
                alert.showAndWait();
                nameField.getScene().getWindow().hide();
            }
        } catch (InvalidInputException iie){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Empty spaces");
            alert.setContentText("You must fill all the fields");
            alert.show();
        } catch (NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Invalid input");
            alert.setContentText("Make sure that the level, id and hp are numerical values and try again");
            alert.show();
        }
    }
}
