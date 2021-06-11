package io.github.anemone.anima.model;

import java.io.Serializable;

public class ItemTree implements Serializable {

    private Item root;
    public final static long serialVersionUID = 1;



    public ItemTree(){

    }

    public void addItem(String name, int id, String type, String element, String droppedBy, String imgPath){
        Item i = new Item(name,id,type,element,droppedBy,imgPath);
        if (root == null){
            root = i;
        } else {
            addItem(root, i);
        }
    }

    private void addItem(Item current, Item newItem){
        if (newItem.getId() > current.getId()){
            if (current.getRight() != null) {
                addItem(current.getRight(), newItem);
            } else {
                current.setRight(newItem);
            }
        } else {
            if (current.getLeft() != null){
                addItem(current.getLeft(), newItem);
            } else {
                current.setLeft(newItem);
            }
        }
    }

    public Item searchItem(int id){
        return searchItem(root, id);
    }

    private Item searchItem(Item current, int id){
        if (current == null || current.getId() == id){
            return current;
        } else if (id < current.getId()){
            return searchItem(current.getLeft(),id);
        } else {
            return searchItem(current.getRight(), id);
        }
    }

}
