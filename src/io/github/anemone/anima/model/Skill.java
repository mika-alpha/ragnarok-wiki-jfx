package io.github.anemone.anima.model;

public class Skill {

    private String name;
    private String desc;
    private String type;
    private String job;
    private int level;
    private String imgPath;
    private Skill next;
    private Skill previous;

    public Skill(String name, String desc, String type, String job, int level, String imgPath) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.job = job;
        this.level = level;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public String getJob() {
        return job;
    }

    public int getLevel() {
        return level;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Skill getNext() {
        return next;
    }

    public Skill getPrevious() {
        return previous;
    }

    public void setNext(Skill next) {
        this.next = next;
    }

    public void setPrevious(Skill previous) {
        this.previous = previous;
    }
}
