package io.github.anemone.anima.model;

public class Song {

    private String songPath;
    private String name;
    private String author;
    private String imgPath;
    private Song next;
    private Song previous;

    public Song(String songPath, String name, String author, String imgPath) {
        this.songPath = songPath;
        this.name = name;
        this.author = author;
        this.imgPath = imgPath;
    }

    public void setNext(Song next) {
        this.next = next;
    }

    public void setPrevious(Song previous){
        this.previous = previous;
    }

    public String getSongPath() {
        return songPath;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Song getNext() {
        return next;
    }

    public Song getPrevious() {
        return previous;
    }
}
