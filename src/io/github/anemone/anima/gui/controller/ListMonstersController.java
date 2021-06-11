package io.github.anemone.anima.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListMonstersController {


    @FXML
    private TableView<?> monstersTV;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> levelCol;

    @FXML
    private TableColumn<?, ?> hpCol;

    @FXML
    private TableColumn<?, ?> raceCol;

    @FXML
    private TableColumn<?, ?> propertyCol;

    @FXML
    private TableColumn<?, ?> sizeCol;


    public ListMonstersController(){

    }

    @FXML
    public void initialize(){

    }

    @FXML
    public void sortById(ActionEvent event) {

    }

    @FXML
    public void sortByLevel(ActionEvent event) {

    }

    @FXML
    public void sortByName(ActionEvent event) {

    }

}
