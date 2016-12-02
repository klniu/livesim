package com.klniu.livesim.entity;

import java.util.ArrayList;

/**
 * Created by klniu on 16-11-17.
 */
public class Category<E extends Action> {
    private String name;
    private ArrayList<Category<E>> categories;
    private ArrayList<E> items;

    public Category(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category<E>> getCategories() {
        return categories;
    }

    public boolean addCategory(Category<E> category) {
        return categories.add(category);
    }

    public boolean removeCategory(Category<E> category) {
        return categories.remove(category);
    }

    public ArrayList<E> getItems() {
        return items;
    }

    public void addItem(E e) {
        items.add(e);
    }
}
