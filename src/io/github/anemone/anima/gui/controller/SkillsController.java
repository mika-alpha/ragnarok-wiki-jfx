package io.github.anemone.anima.gui.controller;

import io.github.anemone.anima.model.Skill;
import io.github.anemone.anima.model.Wiki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SkillsController {

    @FXML
    private ImageView skillImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label classLabel;

    @FXML
    private Label descLabel;

    @FXML
    private Label maxLabel;

    @FXML
    private Label typeLabel;

    private Wiki wiki;
    private Skill current;

    public SkillsController(Wiki wiki){
        this.wiki = wiki;
    }

    @FXML
    public void initialize(){
        current = wiki.getFirstSkill();
        updateNodes(current);
    }

    @FXML
    void nextSkill(ActionEvent event) {
        current = current.getNext();
        updateNodes(current);

    }

    @FXML
    void previousSkill(ActionEvent event) {
        current = current.getPrevious();
        updateNodes(current);
    }

    public void updateNodes(Skill current){
        typeLabel.setText(current.getType());
        classLabel.setText(current.getJob());
        descLabel.setText(current.getDesc());
        nameLabel.setText(current.getName());
        maxLabel.setText(String.valueOf(current.getLevel()));
        skillImage.setImage(new Image(current.getImgPath()));
    }
}
