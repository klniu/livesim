package com.klniu.livesim.entity;

import java.util.Enumeration;

/*
@author: Hugh Gao
 */
public class Tree {
    private int experience;

    public Tree(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public int getLevel() {
        if (experience <= 0) {
            return 1;
        }
        // <5000 is 1, 5000 < exp <=10000 is 2, 10000 < exp <= 20000 is 3, etc. the max level is 12
        // log2(n)
        int level = (int) (Math.ceil(Math.log(experience / 5000.0) / Math.log(2)))+1;
        if (level >= 12) {
            return 12;
        }
        return level;
    }
}
