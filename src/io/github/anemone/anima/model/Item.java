package io.github.anemone.anima.model;

import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private int id;
    private String type;
    private String element;
    private String droppedBy;
    private String imgPath;
    private Item left;
    private Item right;

    public final static long serialVersionUID = 1;
    public Item(String name, int id, String type, String element, String droppedBy, String imgPath) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.element = element;
        this.droppedBy = droppedBy;
        this.imgPath = imgPath;
    }

    public void setLeft(Item left) {
        this.left = left;
    }

    public void setRight(Item right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getElement() {
        return element;
    }

    public String getDroppedBy() {
        return droppedBy;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Item getLeft() {
        return left;
    }

    public Item getRight() {
        return right;
    }
}
