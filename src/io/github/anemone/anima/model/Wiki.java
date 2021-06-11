package io.github.anemone.anima.model;

import io.github.anemone.anima.exception.FileAccessException;
import io.github.anemone.anima.thread.FilesThread;
import java.util.ArrayList;

public class Wiki {

    private ArrayList<Monster> monsters;
    private Skill firstSkill;
    private Job firstJob;
    private ItemTree weapons;
    private ItemTree armors;
    private boolean success;

    public Wiki() {
        monsters = new ArrayList<>();
    }

    //bubble sort
    public void sortMonstersByID() {
        boolean swapped = true;
        for (int j = 1; j < monsters.size() && swapped; j++) {
            swapped = false;
            for (int i = 0; i < monsters.size() - j; i++) {
                if (monsters.get(i).getId() > monsters.get(i + 1).getId()) {
                    Monster temp = monsters.get(i);
                    monsters.set(i, monsters.get(i + 1));
                    monsters.set(i + 1, temp);
                    swapped = true;
                }
            }
            System.out.println(monsters.toString());
        }
    }

    //selectionSort
    public void sortByLevel(){
        for (int i = 0; i < monsters.size(); i++){
            Monster min = monsters.get(i);
            for (int j = i+1; j < monsters.size(); j++){
                if (monsters.get(j).getLevel() < min.getLevel()){
                    Monster temp = monsters.get(j);
                    monsters.set(j,min);
                    min = temp;
                }
            }
            monsters.set(i,min);
            System.out.println(monsters.toString());
        }
    }

    public void sortByName(){
        monsters.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println(monsters.toString());
    }

    public void exportMonsters(String filepath) throws FileAccessException, InterruptedException {
        FilesThread exp = new FilesThread(true,this,filepath);
        exp.start();
        exp.join();
        if (!success){
            throw new FileAccessException();
        }
    }

    public void importMonsters(String filepath) throws FileAccessException, InterruptedException{
        FilesThread imp = new FilesThread(false,this,filepath);
        imp.start();
        imp.join();
        if (!success){
            throw new FileAccessException();
        }
    }


    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public Skill getFirstSkill() {
        return firstSkill;
    }

    public Job getFirstJob() {
        return firstJob;
    }

    public ItemTree getWeapons() {
        return weapons;
    }

    public ItemTree getArmors() {
        return armors;
    }

    public void setFirstSkill(Skill firstSkill) {
        this.firstSkill = firstSkill;
    }

    public void setFirstJob(Job firstJob) {
        this.firstJob = firstJob;
    }

    public void setSuccess(boolean value){
        this.success = value;
    }
}
