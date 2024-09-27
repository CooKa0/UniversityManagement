package com.solvd.laba.university.threads;

import java.util.concurrent.CompletableFuture;

public class ConnectionLoaderRunnable implements Runnable {
    private final ConnectionPool pool;

    public ConnectionLoaderRunnable(ConnectionPool pool) {
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