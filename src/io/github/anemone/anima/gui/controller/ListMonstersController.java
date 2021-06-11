package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.model.Monster;
import io.github.anemone.anima.model.Wiki;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListMonstersController {


    @FXML
    private TableView<Monster> monstersTV;

    @FXML
    private TableColumn<Monster, String> nameCol;

    @FXML
    private TableColumn<Monster, Integer> idCol;

    @FXML
    private TableColumn<Monster, Integer> levelCol;

    @FXML
    private TableColumn<Monster, Integer> hpCol;

    @FXML
    private TableColumn<Monster, String> raceCol;

    @FXML
    private TableColumn<Monster, String> propertyCol;

    @FXML
    private TableColumn<Monster, String> sizeCol;

    private Wiki wiki;


    public ListMonstersController(Wiki wiki){
        this.wiki = wiki;

    }

    @FXML
    public void initialize(){
        initializeTV();
    }

    public void initializeTV(){
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        levelCol.setCellValueFactory(new PropertyValueFactory<>("level"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        propertyCol.setCellValueFactory(new PropertyValueFactory<>("property"));
        raceCol.setCellValueFactory(new PropertyValueFactory<>("race"));
        hpCol.setCellValueFactory(new PropertyValueFactory<>("hp"));
        addItemsToTV();
    }

    @FXML
    public void sortById(ActionEvent event) {
        wiki.sortMonstersByID();
        addItemsToTV();
    }

    @FXML
    public void sortByLevel(ActionEvent event) {
        wiki.sortByLevel();
        addItemsToTV();
    }

    @FXML
    public void sortByName(ActionEvent event) {
        wiki.sortByName();
        addItemsToTV();
    }

    public void addItemsToTV(){
        ObservableList<Monster> data = FXCollections.observableArrayList();
        data.addAll(wiki.getMonsters());
        monstersTV.setItems(data);
    }

}
