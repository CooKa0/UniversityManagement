package com.solvd.laba.university.threads;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static final int POOL_SIZE = 5;
    private static ConnectionPool instance;
    private BlockingQueue<Connection> pool;

    private ConnectionPool() {
        pool = new LinkedBlockingQueue<>(POOL_SIZE);
        IntStream.rangeClosed(1, POOL_SIZE)
                .mapToObj(Connection::new)
                .forEach(pool::add);
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    // Waits for a connection if none available
    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}