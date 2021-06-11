package io.github.anemone.anima.model;

public class Monster {

    private String name;
    private String race;
    private String property;
    private int hp;
    private int id;
    private int level;
    private String size;

    public Monster(String name, String race, String property, int hp, int id, int level, String size) {
        this.name = name;
        this.race = race;
        this.property = property;
        this.hp = hp;
        this.id = id;
        this.level = level;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getRace() {
        return race;
    }

    public String getProperty() {
        return property;
    }

    public int getHp() {
        return hp;
    }

    public String getSize() {
        return size;
    }
}
