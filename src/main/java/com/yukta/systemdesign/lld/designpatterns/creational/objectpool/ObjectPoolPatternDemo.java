package com.yukta.systemdesign.lld.designpatterns.creational.objectpool;

import java.util.LinkedList;
import java.util.Queue;

// Expensive Object
class DatabaseConnection {

    private final String connectionId;

    public DatabaseConnection(String connectionId) {
        this.connectionId = connectionId;

        // simulate expensive object creation
        System.out.println("Creating connection: " + connectionId);
    }

    public void executeQuery(String query) {
        System.out.println(connectionId + " executing: " + query);
    }

    public String getConnectionId() {
        return connectionId;
    }
}

// Object Pool
class ConnectionPool {

    private final Queue<DatabaseConnection> availableConnections =
            new LinkedList<>();

    // initialize pool
    public ConnectionPool(int poolSize) {

        for (int i = 1; i <= poolSize; i++) {

            availableConnections.offer(
                    new DatabaseConnection("Conn-" + i)
            );
        }
    }

    // borrow object from pool
    public DatabaseConnection getConnection() {

        if (availableConnections.isEmpty()) {
            throw new RuntimeException(
                    "No available connections in pool"
            );
        }

        DatabaseConnection connection =
                availableConnections.poll();

        System.out.println(
                connection.getConnectionId()
                        + " borrowed from pool"
        );

        return connection;
    }

    // return object back to pool
    public void releaseConnection(
            DatabaseConnection connection) {

        availableConnections.offer(connection);

        System.out.println(
                connection.getConnectionId()
                        + " returned to pool"
        );
    }
}

// Client
public class ObjectPoolPatternDemo {

    public static void main(String[] args) {

        ConnectionPool pool = new ConnectionPool(2);

        // borrow connections
        DatabaseConnection c1 =
                pool.getConnection();

        c1.executeQuery("SELECT * FROM users");

        DatabaseConnection c2 =
                pool.getConnection();

        c2.executeQuery("SELECT * FROM orders");

        // return connection
        pool.releaseConnection(c1);

        // reuse same connection again
        DatabaseConnection c3 =
                pool.getConnection();

        c3.executeQuery("SELECT * FROM payments");

        // return remaining connections
        pool.releaseConnection(c2);
        pool.releaseConnection(c3);
    }
}
