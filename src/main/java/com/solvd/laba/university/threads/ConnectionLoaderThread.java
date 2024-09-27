package com.solvd.laba.university.threads;

import java.util.concurrent.CompletableFuture;

public class ConnectionLoaderThread extends Thread {
    private final ConnectionPool pool;

    public ConnectionLoaderThread(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        CompletableFuture.runAsync(() -> {
            try {
                Connection connection = pool.getConnection();
                connection.use();
                pool.releaseConnection(connection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}