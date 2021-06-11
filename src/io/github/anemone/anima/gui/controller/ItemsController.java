package io.github.anemone.anima.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ItemsController {

    @FXML
    private ComboBox<String> typeBox;

    @FXML
    private TextField idField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label elementLabel;

    @FXML
    private Label droppedByLabel;

    @FXML
    private ImageView itemImage;

    public ItemsController(){
    }

    @FXML
    public void initialize(){
        typeBox.getItems().add("Armor");
        typeBox.getItems().add("Weapon");
    }

    @FXML
    public void searchByID(ActionEvent event) {

    }

}
