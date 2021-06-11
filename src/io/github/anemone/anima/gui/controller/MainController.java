package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.model.Wiki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Circle circleOne;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Circle circleTwo;

    private Wiki wiki;


    public MainController(Wiki wiki){
        this.wiki = wiki;
    }

    @FXML
    void exportMonsters(ActionEvent event) {

    }

    @FXML
    void importMonsters(ActionEvent event) {

    }

    @FXML
    void openAddMonster(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addMonster.fxml"));
            loader.setController(new AddMonsterController());
            Stage stage = new Stage();
            stage.setTitle("Add monster");
            stage.setScene(new Scene(loader.load(),600,800));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openFirstJobs(ActionEvent event) {


    }

    @FXML
    void openFourthJobs(ActionEvent event) {

    }

    @FXML
    void openItems(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/items.fxml"));
            loader.setController(new ItemsController());
            Stage stage = new Stage();
            stage.setTitle("Items");
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openListMonsters(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/listMonsters.fxml"));
            loader.setController(new ListMonstersController());
            Stage stage = new Stage();
            stage.setTitle("Listed monsters");
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openMagicSkills(ActionEvent event) {

    }

    @FXML
    void openPhysicalSkills(ActionEvent event) {

    }

    @FXML
    void openSearchMonster(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/searchMonster.fxml"));
            loader.setController(new SearchMonsterController());
            Stage stage = new Stage();
            stage.setTitle("Search Monster");
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openSecondJobs(ActionEvent event) {

    }

    @FXML
    void openThirdJobs(ActionEvent event) {

    }

    @FXML
    void openUtilitySkills(ActionEvent event) {

    }

    @FXML
    void openBGM(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bgm.fxml"));
            loader.setController(new BGMController());
            Stage stage = new Stage();
            stage.setTitle("Search Monster");
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
