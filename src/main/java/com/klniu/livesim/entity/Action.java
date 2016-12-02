package com.klniu.livesim.entity;

/**
 * Created by klniu on 16-11-16.
 */
public class Action {
    private int id;
    private String name;
    private String desc;
    private Category category;

    public Action(Category<? extends Action> category, String name, String desc, int score) {
        this.category = category;
        this.name = name;
        this.desc = desc;
        this.score = score;
    }

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}
