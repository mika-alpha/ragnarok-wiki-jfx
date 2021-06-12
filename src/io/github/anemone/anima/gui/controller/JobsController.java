package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.model.Job;
import io.github.anemone.anima.model.Wiki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JobsController {

    @FXML
    private ImageView classImg;

    @FXML
    private Label nameLabel;

    @FXML
    private Label classLabel;

    @FXML
    private Label baseLabel;

    @FXML
    private Label jobLabel;

    @FXML
    private Label specialityLabel;

    private Wiki wiki;
    private Job current;

    public JobsController(Wiki wiki){
        this.wiki = wiki;
    }

    @FXML
    public void initialize(){
        updateNodes(wiki.getFirstJob());
        current = wiki.getFirstJob();
    }

    @FXML
    void nextClass(ActionEvent event) {
        updateNodes(current.getNext());
        current = current.getNext();
    }

    @FXML
    void previousClass(ActionEvent event) {
        updateNodes(current.getPrevious());
        current = current.getPrevious();
    }

    public void updateNodes(Job current){
        classImg.setImage(new Image(current.getImgPath()));
        nameLabel.setText(current.getName());
        jobLabel.setText(current.getJob());
        classLabel.setText(String.valueOf(current.getJobLevel()));
        baseLabel.setText(String.valueOf(current.getBaseLevel()));
        specialityLabel.setText(current.getSpeciality());
    }

}
