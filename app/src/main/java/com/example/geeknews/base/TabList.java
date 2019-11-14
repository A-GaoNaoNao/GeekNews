package com.example.geeknews.base;

public class TabList {
    private String name;

    @Override
    public String toString() {
        return "TabList{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TabList(String name) {
        this.name = name;
    }
}
