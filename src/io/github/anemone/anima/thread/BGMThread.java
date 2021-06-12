package io.github.anemone.anima.thread;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BGMThread extends Thread{

    private String songPath;
    private MediaPlayer mediaPlayer;

    public BGMThread(String songPath){
        this.songPath = songPath;
    }

    public void run(){
        Media hit = new Media(new File(songPath).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void updateVolume(double volume){
        mediaPlayer.setVolume(volume);
    }

    public void pauseSong(){
        mediaPlayer.pause();
    }

    public void resumeSong(){
        mediaPlayer.play();
    }

    public void cancel(){
        mediaPlayer.stop();
        interrupt();
    }

    public double getVolume(){
        return mediaPlayer.getVolume();
    }


}
