package com.solvd.laba.university.threads;

public class Connection {
    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void use() throws InterruptedException {
        // simulating work
        Thread.sleep(200);
    }
}