package com.example;

public class Lamp implements Observer {
    private int id;

    public Lamp(int id) {
        this.id = id;
    }

    @Override
    public void update() {
        System.out.println("Lamp " + id + " has been updated.");
    }
}
