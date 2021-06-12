package io.github.anemone.anima.thread;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BGMThread extends Thread{

    private String firstSong;
    private MediaPlayer mediaPlayer;

    public BGMThread(String firstSong){
        this.firstSong = firstSong;
    }

    public void run(){
        Media hit = new Media(new File(firstSong).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(50);
        mediaPlayer.play();
    }

    public void updateSong(String songPath, double volume){
        Media hit = new Media(new File(songPath).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public void updateVolume(double volume){
        mediaPlayer.setVolume(volume);
    }

}
