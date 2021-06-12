package io.github.anemone.anima.gui;

import io.github.anemone.anima.gui.controller.MainController;
import io.github.anemone.anima.model.Wiki;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Wiki wiki = new Wiki();
        wiki.loadData();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setController(new MainController(wiki));
        primaryStage.setTitle("Ragnarok database - wiki");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setOnCloseRequest(event -> wiki.saveData());
        //primaryStage.getIcons().add(new Image("file:resources/icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
