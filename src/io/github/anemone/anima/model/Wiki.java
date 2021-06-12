package io.github.anemone.anima.model;
import io.github.anemone.anima.exception.FileAccessException;
import io.github.anemone.anima.thread.FilesThread;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Wiki {

    private ArrayList<Monster> monsters;
    private Skill firstSkill;
    private Job firstJob;
    private Song firstSong;
    private ItemTree weapons;
    private ArrayList<Item> armors;
    private boolean success;

    public Wiki() {
        monsters = new ArrayList<>();
        armors = new ArrayList<>();
        weapons = new ItemTree();
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
        }
    }

    public void sortByName(){
        monsters.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
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

    public void loadData() {
        try {
            File f = new File("data/monsters.bdd");
            if (f.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                monsters = (ArrayList<Monster>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException ioc){
            ioc.printStackTrace();
        }
        loadJobs();
        loadArmors();
        loadWeapons();
        loadSkills();
        loadBGM();
    }

    public void saveData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/monsters.bdd"));
            oos.writeObject(monsters);
            oos.close();
        } catch (IOException io){
            io.printStackTrace();
        }
        System.exit(0);
    }

    public void addJob(String name, String job, int baseLevel, int jobLevel, String speciality, String imgPath){
        Job newJob = new Job(name,job,baseLevel,jobLevel,speciality,imgPath);
        if (firstJob == null){
            firstJob = newJob;
            firstJob.setNext(firstJob);
            firstJob.setPrevious(firstJob);
        } else {
            addJob(firstJob,newJob);
        }
    }

    private void addJob(Job current, Job toAdd){
        if (current.getNext() != firstJob){
            addJob(current.getNext(),toAdd);
        } else {
            toAdd.setPrevious(firstJob.getPrevious());
            firstJob.getPrevious().setNext(toAdd);
            toAdd.setNext(firstJob);
            firstJob.setPrevious(toAdd);
        }
    }

    public void addSkill(String name, String desc, String type, String job, int level, String imgPath){
        Skill newSkill = new Skill(name,desc,type,job,level,imgPath);
        if (firstSkill == null){
            firstSkill = newSkill;
            firstSkill.setPrevious(firstSkill);
            firstSkill.setNext(firstSkill);
        } else {
            addSkill(firstSkill,newSkill);
        }
    }

    private void addSkill(Skill current, Skill toAdd){
        if (current.getNext() != firstSkill){
            addSkill(current.getNext(),toAdd);
        } else {
            toAdd.setPrevious(firstSkill.getPrevious());
            firstSkill.getPrevious().setNext(toAdd);
            toAdd.setNext(firstSkill);
            firstSkill.setPrevious(toAdd);
        }
    }

    public void loadSkills(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/skills.txt"));
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split("\\|");  //FILESEPARATOR = "|"
                    addSkill(parts[0],parts[1],parts[2],parts[3],Integer.parseInt(parts[4]),parts[5]);
                    line = br.readLine();
                } catch (NumberFormatException nf) {
                    line = br.readLine();
                }
            }
            br.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void loadJobs(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/jobs.txt"));
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split("\\|");  //FILESEPARATOR = "|"
                    addJob(parts[0],parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),parts[4],parts[5]);
                    line = br.readLine();
                } catch (NumberFormatException nf) {
                    line = br.readLine();
                }
            }
            br.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void loadWeapons(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/weapons.txt"));
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split("\\|");  //FILESEPARATOR = "|"
                    weapons.addItem(parts[0],Integer.parseInt(parts[1]), parts[2],parts[3],parts[4],parts[5]);
                    line = br.readLine();
                } catch (NumberFormatException nf) {
                    line = br.readLine();
                }
            }
            br.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void loadArmors(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/armors.txt"));
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split("\\|");  //FILESEPARATOR = "|"
                    armors.add(new Item(parts[0],Integer.parseInt(parts[1]), parts[2],parts[3],parts[4],parts[5]));
                    line = br.readLine();
                } catch (NumberFormatException nf) {
                    line = br.readLine();
                }
            }
            br.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public Item searchArmor(int id) {
        armors.sort(Comparator.comparing(Item::getId));
        int s = 0;
        int e = armors.size() - 1;
        while (s <= e) {
            int mp = (s + e) / 2;
            if (armors.get(mp).getId() == id) {
                return armors.get(mp);
            } else if (armors.get(mp).getId()  < id) {
                s = mp + 1;
            } else if (armors.get(mp).getId() > id){
                e = mp - 1;
            }
        }
        return null;
    }

    public Monster searchMonsterByID(int id){
        sortMonstersByID();
        int s = 0;
        int e = monsters.size() - 1;
        while (s <= e) {
            int mp = (s + e) / 2;
            if (monsters.get(mp).getId() == id) {
                return monsters.get(mp);
            } else if (monsters.get(mp).getId()  < id) {
                s = mp + 1;
            } else if (monsters.get(mp).getId() > id){
                e = mp - 1;
            }
        }
        return null;
    }

    public void loadBGM(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/ost.txt"));
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split("\\|");  //FILESEPARATOR = "|"
                    addSong(parts[0],parts[1],parts[2],parts[3]);
                    line = br.readLine();
                } catch (NumberFormatException nf) {
                    line = br.readLine();
                }
            }
            br.close();
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    public void addSong(String songPath, String name, String author, String imgPath){
        Song toAdd = new Song(songPath,name,author,imgPath);
        if (firstSong == null){
            firstSong = toAdd;
            toAdd.setNext(firstSong);
            toAdd.setPrevious(firstSong);
        } else {
            addSong(firstSong,toAdd);
        }
    }

    private void addSong(Song current, Song toAdd){
        if (current.getNext() != firstSong){
            addSong(current.getNext(),toAdd);
        } else {
            toAdd.setPrevious(firstSong.getPrevious());
            firstSong.getPrevious().setNext(toAdd);
            toAdd.setNext(firstSong);
            firstSong.setPrevious(toAdd);
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

    public void setFirstSkill(Skill firstSkill) {
        this.firstSkill = firstSkill;
    }

    public void setFirstJob(Job firstJob) {
        this.firstJob = firstJob;
    }

    public void setSuccess(boolean value){
        this.success = value;
    }

    public Song getFirstSong() {
        return firstSong;
    }
}
