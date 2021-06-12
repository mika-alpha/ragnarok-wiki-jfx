package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.exception.FileAccessException;
import io.github.anemone.anima.model.Wiki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    private Circle circleOne;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Circle circleTwo;

    private Wiki wiki;

    private FileChooser fileChooser;

    private Alert alert;


    public MainController(Wiki wiki){
        this.wiki = wiki;
        alert = new Alert(null);
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Plain text files", "*.txt", "*.csv"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"));
    }

    @FXML
    void exportMonsters(ActionEvent event) {
        File file = fileChooser.showSaveDialog(circleOne.getScene().getWindow());
        fileChooser.setTitle("Select the directory or file where the data will be saved");
        if (file != null) {
            try {
                wiki.exportMonsters(file.toString());
                showAlert("Success", Alert.AlertType.INFORMATION, "The data has been exported successfully");
            } catch (FileAccessException | InterruptedException fi){
                showAlert("Data Error", Alert.AlertType.ERROR, "There was an unexpected error trying to export the data into the specified file");
                fi.printStackTrace();
            }
        }

    }

    @FXML
    void importMonsters(ActionEvent event) {
        File file = fileChooser.showOpenDialog(circleOne.getScene().getWindow());
        fileChooser.setTitle("Select the file that you want to import");
        if (file != null) {
            try {
                wiki.importMonsters(file.toString());
                showAlert("Success", Alert.AlertType.INFORMATION, "The data has been imported successfully");
            } catch (FileAccessException | InterruptedException fi){
                showAlert("Data Error", Alert.AlertType.ERROR, "There was an unexpected error trying to import the data from the specified file");
                fi.printStackTrace();
            }
        }
    }

    @FXML
    void openAddMonster(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addMonster.fxml"));
            loader.setController(new AddMonsterController(wiki.getMonsters()));
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
    void openJobs(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/classes.fxml"));
            loader.setController(new JobsController(wiki));
            Stage stage = new Stage();
            stage.setTitle("Ragnarok Online Jobs");
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openItems(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/items.fxml"));
            loader.setController(new ItemsController(wiki));
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
            loader.setController(new ListMonstersController(wiki));
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
    void openSearchMonster(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/searchMonster.fxml"));
            loader.setController(new SearchMonsterController(wiki));
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
    void openSkills(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/skills.fxml"));
            loader.setController(new SkillsController(wiki));
            Stage stage = new Stage();
            stage.setTitle("Ragnarok Online Skills");
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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

    public void showAlert(String title, Alert.AlertType type, String content){
        alert.setAlertType(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
