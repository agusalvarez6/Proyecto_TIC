package com.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;

public class DataBase {
    public static Connection connection;
    public static Statement statement;

    public static void start()throws Exception{
        // Create a H2DataSource instance
        JdbcDataSource dataSource = new JdbcDataSource();

        // Set the database URL
        dataSource.setURL("jdbc:h2:mem:my_database");

        // Set the user name and password
        dataSource.setUser("sa");
        dataSource.setPassword("");

        // Create a connection to the database
        connection = dataSource.getConnection();

        // Do some database operations
        statement = connection.createStatement();
        statement.execute("CREATE TABLE my_table (name VARCHAR(255),surname VARCHAR(255))");
        statement.execute("INSERT INTO my_table (name, surname) VALUES ('Jhon', 'Doe')");
    }
    public static void save(String nombre,String apellido) throws Exception {
        statement.execute("INSERT INTO my_table (name, surname) VALUES ('"+nombre+"','"+apellido+"')");
    }

    public static void print() throws Exception {
        
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + ", " + resultSet.getString("surname"));
        }
    }
    public static void close() throws Exception{
        connection.close();
        System.out.println("Connection closed");
    }
}
