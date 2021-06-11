package io.github.anemone.anima.model;

public class Job {

    private String name;
    private String job;
    private int baseLevel;
    private int jobLevel;
    private String speciality;
    private Job next;
    private Job previous;
    private String imgPath;


    public Job(String name, String job, int baseLevel, int jobLevel, String speciality, String imgPath) {
        this.name = name;
        this.job = job;
        this.baseLevel = baseLevel;
        this.jobLevel = jobLevel;
        this.speciality = speciality;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getBaseLevel() {
        return baseLevel;
    }

    public int getJobLevel() {
        return jobLevel;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setNext(Job next) {
        this.next = next;
    }

    public void setPrevious(Job previous) {
        this.previous = previous;
    }

    public Job getNext() {
        return next;
    }

    public Job getPrevious() {
        return previous;
    }
}
