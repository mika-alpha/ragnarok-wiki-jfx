package io.github.anemone.anima.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class BGMController {

    @FXML
    private ImageView songImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private Slider volumeSlider;

    public BGMController(){

    }

    @FXML
    public void initialize(){
        volumeSlider.setValue(50);
    }
    @FXML
    public void pauseResumeSong(ActionEvent event) {

    }

    @FXML
    public void pauseSong(ActionEvent event) {

    }

    @FXML
    public void previousSong(ActionEvent event) {

    }

    @FXML
    public void resumeSong(ActionEvent event) {

    }

}
