package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.exception.InvalidInputException;
import io.github.anemone.anima.model.Item;
import io.github.anemone.anima.model.Wiki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

    private Wiki wiki;

    public ItemsController(Wiki wiki){
        this.wiki = wiki;
    }

    @FXML
    public void initialize(){
        typeBox.getItems().add("Armor");
        typeBox.getItems().add("Weapon");
    }

    @FXML
    public void searchByID(ActionEvent event) {
        try{
            if (typeBox.getSelectionModel().isEmpty()) {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException iie){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Empty spaces");
            alert.setContentText("You must select a type and fill an id");
            alert.show();
        }
        Item searched;
        if (typeBox.getValue().equals("Armor")){
            searched = wiki.searchArmor(Integer.parseInt(idField.getText()));
        } else {
            searched =wiki.getWeapons().searchItem(Integer.parseInt(idField.getText()));
        }
        if (searched != null){
            droppedByLabel.setText(searched.getDroppedBy());
            elementLabel.setText(searched.getElement());
            nameLabel.setText(searched.getName());
            typeLabel.setText(searched.getType());
            itemImage.setImage(new Image(searched.getImgPath()));
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Not in the wiki");
            alert.setContentText("The item couldn't be found");
            alert.show();
        }
    }

}
