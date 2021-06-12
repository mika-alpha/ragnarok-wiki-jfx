package io.github.anemone.anima.thread;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class GraphicsThread extends Thread {

    private Circle one;
    private Circle two;
    private Rectangle rect;
    private Random random;

    public GraphicsThread(Circle one, Circle two, Rectangle rect){
        this.one = one;
        this.two = two;
        this.rect = rect;
        random = new Random();
    }

    @Override
    public void run(){
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            one.setFill(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            two.setFill(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            rect.setFill(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            one.setTranslateX(random.nextInt(1281));
            two.setTranslateX(random.nextInt(1281));
            rect.setTranslateX(random.nextInt(1281));
            one.setTranslateY(random.nextInt(200));
            two.setTranslateY(random.nextInt(200));
            rect.setTranslateY(random.nextInt(200));
        }
    }
}
