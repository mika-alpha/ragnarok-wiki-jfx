package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.model.Song;
import io.github.anemone.anima.model.Wiki;
import io.github.anemone.anima.thread.BGMThread;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
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

    private BGMThread musicPlayer;
    private Wiki wiki;
    private Song current;

    public BGMController(Wiki wiki){
        this.wiki = wiki;
        musicPlayer = new BGMThread(wiki.getFirstSong().getSongPath());
        current = wiki.getFirstSong();
    }

    @FXML
    public void initialize(){
        updateNodes();
        musicPlayer.start();
        try {
            musicPlayer.join();
            volumeSlider.setValue(musicPlayer.getVolume() * 100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    musicPlayer.updateVolume(volumeSlider.getValue() / 100);
                }
            });
        } catch (NullPointerException | InterruptedException ignore){
        }
    }

    @FXML
    public void nextSong(ActionEvent event) {
        musicPlayer.cancel();
        musicPlayer = new BGMThread(current.getNext().getSongPath());
        musicPlayer.start();
        current = current.getNext();
        updateNodes();
    }

    @FXML
    public void pauseSong(ActionEvent event) {
        musicPlayer.pauseSong();
    }

    @FXML
    public void previousSong(ActionEvent event) {
        musicPlayer.cancel();
        musicPlayer = new BGMThread(current.getPrevious().getSongPath());
        musicPlayer.start();
        current = current.getPrevious();
        updateNodes();
    }

    @FXML
    public void resumeSong(ActionEvent event) {
        musicPlayer.resumeSong();
    }

    @FXML
    public void updateNodes(){
        authorLabel.setText(current.getAuthor());
        nameLabel.setText(current.getName());
        songImage.setImage(new Image(current.getImgPath()));
    }
}
