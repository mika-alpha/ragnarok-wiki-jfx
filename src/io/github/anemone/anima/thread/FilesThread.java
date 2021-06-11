package io.github.anemone.anima.thread;

import io.github.anemone.anima.model.Monster;
import io.github.anemone.anima.model.Wiki;

import java.io.*;

public class FilesThread extends Thread{

    private boolean writeOrRead;
    private String filepath;
    private Wiki wiki;

    public FilesThread(Boolean wor, Wiki wiki, String filepath){
        this.writeOrRead = wor;
        this.wiki = wiki;
        this.filepath = filepath;
    }

    public void run(){
        if (writeOrRead){
            write();
        } else {
            read();
        }
    }

    public void write(){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filepath, true));
            for (Monster m : wiki.getMonsters()) {
                pw.println(m.getName() + "|" + m.getRace() +
                        "|" + m.getProperty() + "|" + m.getHp() + "|" + m.getId() + "|" + m.getLevel() + "|" + m.getSize());
            }
            wiki.setSuccess(true);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
            wiki.setSuccess(false);
        }
    }

    public void read(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] parts = line.split("\\|");  //FILESEPARATOR = "|"
                    wiki.getMonsters().add(new Monster(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                            parts[6]));
                    line = br.readLine();
                } catch (NumberFormatException nf) {
                    line = br.readLine();
                }
            }
            br.close();
            wiki.setSuccess(true);
        } catch (IOException io){
            io.printStackTrace();
            wiki.setSuccess(false);
        }
    }
}
